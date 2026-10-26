/*
 * Module and purpose: model/Game.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

import java.util.List;
import java.util.Locale;

/**
 * Protótipo de outubro: movimentos normais, sem efeitos especiais ou interface.
 * Integração e métodos de jogada assistidos por Codex; revisão humana pendente.
 */
public class Game {
    public static final int MAX_TURNS = 100;

    private final List<Player> players;
    private final Board board = new Board();
    private int currentIndex;
    private int turnCount;
    private boolean finished;

    public Game(List<String> names) {
        if (names == null || names.size() < 2 || names.size() > 4) {
            throw new IllegalArgumentException("Escolha entre 2 e 4 jogadores.");
        }
        players = names.stream().map(Player::new).toList();
        long uniqueNames = players.stream()
                .map(player -> player.getName().toLowerCase(Locale.ROOT))
                .distinct()
                .count();
        if (uniqueNames != players.size()) {
            throw new IllegalArgumentException("Os nomes dos jogadores devem ser diferentes.");
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentIndex);
    }

    public int getTurnCount() {
        return turnCount;
    }

    public boolean isFinished() {
        return finished;
    }

    /**
     * Executa um movimento normal. O valor é fornecido pelo chamador;
     * entrada manual e aleatoriedade serão ligadas numa etapa posterior.
     */
    public TurnResult play(int diceValue) {
        ensureActive();
        if (diceValue < 1 || diceValue > 6) {
            throw new IllegalArgumentException("O dado deve estar entre 1 e 6.");
        }

        Player player = getCurrentPlayer();
        int previousPosition = player.getPosition();
        int candidatePosition = previousPosition + diceValue;
        if (board.isValidPosition(candidatePosition)) {
            player.moveTo(candidatePosition);
        }
        // Uma ultrapassagem mantém a posição, mas consome a jogada.
        turnCount++;
        finished = player.getPosition() == board.getTotalCells()
                || turnCount >= MAX_TURNS;

        TurnResult result = new TurnResult(player.getName(), diceValue,
                previousPosition, player.getPosition(), turnCount, finished);
        if (!finished) {
            currentIndex = (currentIndex + 1) % players.size();
        }
        return result;
    }

    /** Devolve os líderes apenas após o fim; vários líderes representam empate. */
    public List<Player> getWinners() {
        if (!finished) {
            return List.of();
        }
        int bestPosition = players.stream()
                .mapToInt(Player::getPosition)
                .max()
                .orElseThrow();
        return players.stream()
                .filter(player -> player.getPosition() == bestPosition)
                .toList();
    }

    private void ensureActive() {
        if (finished) {
            throw new IllegalStateException("O jogo já terminou.");
        }
    }

    public void restart() {
        players.forEach(player -> player.moveTo(1));
        currentIndex = 0;
        turnCount = 0;
        finished = false;
    }
}
