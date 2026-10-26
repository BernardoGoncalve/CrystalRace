/*
 * Module and purpose: Verificações determinísticas do protótipo de movimento de outubro.
 * Student name/number and implemented contributions: [contribuições humanas por confirmar].
 * Collaborator/reviewer and contribution: [revisão humana por realizar].
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game newGame() {
        return new Game(List.of("Ana", "Rui"));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void initializesTwoToFourPlayersAtCellOne(int count) {
        Game game = new Game(List.of("A", "B", "C", "D").subList(0, count));
        assertNotNull(game.getBoard());
        assertEquals(30, game.getBoard().getTotalCells());
        assertEquals(count, game.getPlayers().size());
        assertTrue(game.getPlayers().stream().allMatch(player -> player.getPosition() == 1));
        assertEquals(0, game.getTurnCount());
        assertFalse(game.isFinished());
        assertTrue(game.getWinners().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void followsEntryOrderAndWrapsForEachPlayerCount(int count) {
        Game game = new Game(List.of("A", "B", "C", "D").subList(0, count));
        for (int i = 0; i < count; i++) {
            assertEquals(game.getPlayers().get(i).getName(), game.play(1).playerName());
        }
        assertSame(game.getPlayers().get(0), game.getCurrentPlayer());
        assertEquals(count, game.getTurnCount());
    }

    @Test
    void rollThreeMovesFromOneToFourWithoutSpecialEffectsInPrototype() {
        Game game = newGame();
        TurnResult result = game.play(3);
        assertEquals("Ana", result.playerName());
        assertEquals(3, result.diceValue());
        assertEquals(1, result.previousPosition());
        assertEquals(4, result.finalPosition());
        assertEquals(1, result.turnNumber());
        assertFalse(result.finished());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, Integer.MAX_VALUE})
    void invalidRollDoesNotChangePositionsTurnOrCounter(int roll) {
        Game game = newGame();
        Player current = game.getCurrentPlayer();
        assertThrows(IllegalArgumentException.class, () -> game.play(roll));
        assertSame(current, game.getCurrentPlayer());
        assertEquals(0, game.getTurnCount());
        assertTrue(game.getPlayers().stream().allMatch(player -> player.getPosition() == 1));
        assertFalse(game.isFinished());
    }

    @Test
    void rollTwoAtTwentyNineStaysPutButConsumesTurn() {
        Game game = newGame();
        game.getCurrentPlayer().moveTo(29);
        assertEquals(29, game.play(2).finalPosition());
        assertEquals(1, game.getTurnCount());
        assertEquals("Rui", game.getCurrentPlayer().getName());
        assertFalse(game.isFinished());
    }

    @Test
    void bothPlayersMayOccupyTheSameCell() {
        Game game = newGame();
        game.play(2);
        game.play(2);
        assertTrue(game.getPlayers().stream().allMatch(player -> player.getPosition() == 3));
    }

    @Test
    void exactThirtyFinishesAndRejectsAnotherRollWithoutMutation() {
        Game game = newGame();
        game.getCurrentPlayer().moveTo(29);
        game.play(1);
        assertTrue(game.isFinished());
        assertEquals("Ana", game.getWinners().get(0).getName());
        assertThrows(IllegalStateException.class, () -> game.play(1));
        assertEquals(1, game.getTurnCount());
        assertEquals(30, game.getPlayers().get(0).getPosition());
    }

    @Test
    void hundredGlobalTurnsEndWithTheLeadingPlayer() {
        Game game = newGame();
        game.getPlayers().get(0).moveTo(29);
        game.getPlayers().get(1).moveTo(28);
        for (int i = 0; i < 99; i++) {
            game.play(6);
        }
        assertFalse(game.isFinished());
        game.play(6);
        assertTrue(game.isFinished());
        assertEquals(100, game.getTurnCount());
        assertEquals(List.of(game.getPlayers().get(0)), game.getWinners());
    }

    @Test
    void equalLeadingPositionsAtHundredTurnsAreATie() {
        Game game = newGame();
        game.getPlayers().forEach(player -> player.moveTo(29));
        for (int i = 0; i < 100; i++) {
            game.play(6);
        }
        assertEquals(game.getPlayers(), game.getWinners());
    }

    @Test
    void restartRestoresPositionsCounterTurnAndActiveState() {
        Game game = newGame();
        game.getCurrentPlayer().moveTo(29);
        game.play(1);
        game.restart();
        assertTrue(game.getPlayers().stream().allMatch(player -> player.getPosition() == 1));
        assertEquals(0, game.getTurnCount());
        assertEquals("Ana", game.getCurrentPlayer().getName());
        assertFalse(game.isFinished());
        assertTrue(game.getWinners().isEmpty());
        assertEquals(2, game.play(1).finalPosition());
    }

    @Test
    void predeterminedSequenceCompletesANormalMovementGame() {
        Game game = newGame();
        int[] rolls = {6, 1, 6, 1, 6, 1, 6, 1, 5};
        for (int roll : rolls) {
            game.play(roll);
        }
        assertTrue(game.isFinished());
        assertEquals(9, game.getTurnCount());
        assertEquals(30, game.getPlayers().get(0).getPosition());
        assertEquals(5, game.getPlayers().get(1).getPosition());
        assertEquals("Ana", game.getWinners().get(0).getName());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t"})
    void rejectsMissingPlayerName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Game(Arrays.asList(name, "Rui")));
    }

    @Test
    void trimsNamesAndRejectsDuplicatesOrInvalidCounts() {
        assertEquals("Ana", new Player(" Ana ").getName());
        assertThrows(IllegalArgumentException.class, () -> new Game(List.of("Ana", " ana ")));
        assertThrows(IllegalArgumentException.class, () -> new Game(null));
        assertThrows(IllegalArgumentException.class, () -> new Game(List.of("A")));
        assertThrows(IllegalArgumentException.class, () -> new Game(List.of("A", "B", "C", "D", "E")));
        assertThrows(UnsupportedOperationException.class, () -> newGame().getPlayers().clear());
    }

    @Test
    void boardIncludesOneAndThirtyAndExcludesZeroAndThirtyOne() {
        Board board = new Board();
        assertTrue(board.isValidPosition(1));
        assertTrue(board.isValidPosition(30));
        assertFalse(board.isValidPosition(0));
        assertFalse(board.isValidPosition(31));
        assertThrows(IllegalArgumentException.class, () -> new Player("Ana").moveTo(0));
    }
}
