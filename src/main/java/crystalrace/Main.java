/*
 * Module and purpose: Demonstrar movimentos predefinidos do modelo, sem entrada interativa.
 * Student name/number and implemented contributions: [contribuições humanas por confirmar].
 * Collaborator/reviewer and contribution: [revisão humana por realizar].
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace;

import crystalrace.model.Game;
import crystalrace.model.TurnResult;
import java.util.List;
import java.util.stream.Collectors;

/** Demonstração técnica temporária; não substitui a futura interface Swing. */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(List.of("Jogador 1", "Jogador 2", "Jogador 3"));
        System.out.println("CRYSTAL RACE — protótipo de movimento de outubro");
        System.out.println("Sem efeitos especiais e sem modos de dado interativos nesta versão.");
        printBoard(game);

        int[] rolls = {3, 2, 6, 4, 1, 2};
        for (int roll : rolls) {
            TurnResult result = game.play(roll);
            System.out.printf("Jogada %d | %s | dado %d | casa %d -> %d%n",
                    result.turnNumber(), result.playerName(), result.diceValue(),
                    result.previousPosition(), result.finalPosition());
            printPositions(game);
        }
        System.out.println("Próximo jogador: " + game.getCurrentPlayer().getName());
        System.out.println("Fim da demonstração; a partida ainda está em curso.");
    }

    private static void printBoard(Game game) {
        for (int cell = 1; cell <= game.getBoard().getTotalCells(); cell++) {
            System.out.printf("[%02d] ", cell);
            if (cell % 10 == 0) {
                System.out.println();
            }
        }
        printPositions(game);
    }

    private static void printPositions(Game game) {
        String positions = game.getPlayers().stream()
                .map(player -> player.getName() + "=" + player.getPosition())
                .collect(Collectors.joining(" | "));
        System.out.println(positions);
    }
}
