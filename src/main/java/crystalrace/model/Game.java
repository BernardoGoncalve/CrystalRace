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
    // Armazena o valor máximo de turnos globais permitidos antes de o jogo acabar
    public static final int MAX_TURNS = 100;

    // Lista de players que armazena a informação de cada player
    private final List<Player> players;

    private final Board board = new Board();
    // Armazena o index do jogador que irá realizar um turno
    private int currentIndex;
    // Armazena o número de turnos globais já jogados
    private int turnCount;
    // Finaliza o jogo
    private boolean finished;

    public Game(List<String> names) {
        // Verifica se algum nome está vazio, ou se existe menos de 2 ou mais de 4 jogadores
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
        names.clear();
    }

    // Retorna o tabuleiro
    public Board getBoard() {
        return board;
    }

    // Retorna a lista dos players
    public List<Player> getPlayers() {
        return players;
    }

    // Retorna o player que está a jogar de momento
    public Player getCurrentPlayer() {
        return players.get(currentIndex);
    }

    // Retorna o número de turnos globais já jogados
    public int getTurnCount() {
        return turnCount;
    }

    // Retorna se o jogo terminou
    public boolean isFinished() {
        return finished;
    }

    /**
     * Executa um movimento normal. O valor é fornecido pelo chamador;
     * entrada manual e aleatoriedade serão ligadas numa etapa posterior.
     */
    public TurnResult play(int diceValue) {
        //Verifica se o jogo terminou
        ensureActive();


        // Verificação do valor do dado
        if (diceValue < 1 || diceValue > 6) {
            System.out.println("O dado deve estar entre 1 e 6.");
            //throw new IllegalArgumentException("O dado deve estar entre 1 e 6.");
        }

        // Vai buscar o player atual
        Player player = getCurrentPlayer();
        // Armazena a posição atual do jogador
        int previousPosition = player.getPosition();
        // Armazena a posição do jogador depois da jogada
        int landedPosition = previousPosition + diceValue;

        //Default, não há efeito especial
        int finalPosition = previousPosition;
        String effectDescription = "Sem efeito especial";

        // Verifica com o board se é uma posição válida
        if (board.isValidPosition(landedPosition)) {

            //Obtem a casa em que o jogador caiu
            Cell cell = board.getCell(landedPosition);

            //Aplicar o comportamento da casa
            finalPosition = cell.destination();

            effectDescription = cell.description();

        } else  {
            //Ultrapassou a última casa do tabuleiro
            landedPosition = previousPosition;
            effectDescription = "Ultrapassagem da meta: permanece na casa " + previousPosition;
        }

        //Atualiza a posição do jogador
        player.moveTo(finalPosition);
        // Uma ultrapassagem mantém a posição, mas consome a jogada.
        turnCount++;
        // Verifica se chegou ao máximo de turnos ou se o jogador já chegou ao fim
        finished = player.getPosition() == board.getTotalCells()
                || turnCount >= MAX_TURNS;


        TurnResult result = new TurnResult(
                player.getName(),
                diceValue,
                previousPosition,
                landedPosition,
                finalPosition,
                effectDescription,
                turnCount,
                finished
        );
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

    // Verifica se o jogo já terminou
    private void ensureActive() {
        if (finished) {
            throw new IllegalStateException("O jogo já terminou.");
        }
    }

    // Responsável pelo reset do jogo
    /* Colocação de todos os jogadores à casa 1, reset da variável currentIndex, turnCount e finished */
    public void restart() {
        //players.forEach(player -> player.moveTo(1));
        players.clear();
        currentIndex = 0;
        turnCount = 0;
        finished = false;
    }
}
