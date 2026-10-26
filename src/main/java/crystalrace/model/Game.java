/*
 * Module and purpose: model/Game.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */

package crystalrace.model;

import java.util.List;
import java.util.Locale;

public class Game {
    // Variável responsável por o número máximo de turnos
    public static final int MAX_TURNS = 100;
    //Criação de uma lista do tipo Players
    private final List<Player> players;
    private Board board;
    /* Index 0 - Primeiro Jogador
    * Index 1 - Segundo Jogador
    * Index 2 - Terceiro Jogador
    * Index 3 - Quarto Jogador
    */
    private int currentIndex;
    // Variável responsável para terminar o jogo caso chegue aos 100;
    private int turnCount;
    private boolean finished;

    public Game(List<String> names) {
        if (names == null || names.size() < 2 || names.size() > 4) {
            throw new IllegalArgumentException("Escolha entre 2 a 4 jogadores.");
        }
        //Criação de players por cada nome
        players = names.stream().map(Player::new).toList();
        if (players.stream().map(p -> p.getName().toLowerCase(Locale.ROOT)).distinct().count() != players.size()) {
            throw new IllegalArgumentException("Os nomes dos players devem de ser diferentes");
        }
    }

    // Responsável pelo retorno do Tabuleiro
    public Board getBoard() {
        return board;
    }

    // Responsável pelo retorno da lista de Players
    public List<Player> getPlayers() {
        return players;
    }

    // Responsável pelo retorno do player
    public Player getCurrentPlayer() {
        return players.get(currentIndex);
    }

    // Responsável pelo retorno do número de turnos já realizados
    public int getTurnCount() {
        return turnCount;
    }

    // Responsável por finalizar o jogo.
    public boolean isFinished() {
        return finished;
    }

    // Responsável por verificar se o jogo já terminou
    private void ensureActive() {
        if (finished) throw new IllegalArgumentException("O jogo já terminou.");
    }

    // Responsável por realizar o restart do jogo, atribuir a casa nº 1 a todos os jogadores
    public void restart() {
        players.forEach(p -> p.moveTo(1));
        currentIndex = 0;
        turnCount = 0;
        finished = false;
    }

}
