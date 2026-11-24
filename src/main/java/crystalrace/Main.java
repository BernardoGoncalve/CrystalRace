/*
 * Module and purpose: Demonstrar movimentos predefinidos do modelo, sem entrada interativa.
 * Student name/number and implemented contributions: [contribuições humanas por confirmar].
 * Collaborator/reviewer and contribution: [revisão humana por realizar].
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace;

import crystalrace.dice.RandomDice;
import crystalrace.model.Game;
import crystalrace.model.TurnResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Demonstração técnica temporária; não substitui a futura interface Swing. */
public class Main {
    private static List<String> playersUsername = new ArrayList<>();
    private static int numberOfPlayers = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = "";
        int roll = 0;
        do {
            game:
            {

                System.out.println("Welcome to Crystal Race!");
                System.out.print("Number of players: ");
                numberOfPlayers = scanner.nextInt();
                if (numberOfPlayers < 2 || numberOfPlayers > 4) {
                    System.out.println("Only 2, 3 or 4 players are allowed");
                } else {

                    for (int i = 0; i < numberOfPlayers; i++) {
                        System.out.print("Enter player " + (i + 1) + " username: ");
                        String username = scanner.next().trim();
                        playersUsername.add(username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase());
                    }
                    //Criação do Objeto Game com os nomes dos players introduzidos
                    Game game = new Game(playersUsername);
                    //System.out.println("CRYSTAL RACE — protótipo de movimento de outubro");
                    System.out.println("1 - Dados Automáticos | 2 - Dados Manuais");
                    int diceOption = scanner.nextInt();
                    if (diceOption > 2 || diceOption < 1) {
                        System.out.println("Opção inválida");
                        break game;
                    }
                    System.out.println("Sem modos de dado interativos nesta versão.");
                    printBoard(game);
                    System.out.println();
                    do {

                        switch (diceOption) {
                            case 1:
                                RandomDice dice = new RandomDice();
                                roll = dice.roll();
                                play(game, roll);
                                break;
                            case 2:
                                System.out.println("Jogador: " + game.getCurrentPlayer().getName());
                                System.out.println("Enter dice value: ");
                                roll = scanner.nextInt();
                                play(game, roll);
                                break;
                        }
                    } while (!game.isFinished());
                }
            }
            System.out.print("Would you like to play again? (y/n): ");
            option = scanner.next().trim().toLowerCase(Locale.ROOT);
        } while (option.equals("y"));
    }

    private static void play(Game game, int roll) {
        TurnResult result = game.play(roll);
        System.out.printf(
                "Jogada %d | %s | dado %d | casa %d -> %d -> %d%n",
                result.turnNumber(),
                result.playerName(),
                result.diceValue(),
                result.previousPosition(),
                result.landedPosition(),
                result.finalPosition()
        );

        // Apresentar o efeito apenas quando existe uma casa especial
        if (result.landedPosition() != result.finalPosition()) {
            System.out.println("Efeito: " + result.effectDescription());
        }
        printPositions(game);

        if(!game.isFinished()){
            System.out.println("Próximo jogador: " + game.getCurrentPlayer().getName());
            System.out.println();
        } else {
            System.out.println("Jogo Finalizado");
            System.out.println("Vencedor: " + game.getWinners().getFirst().getName());
        }
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
