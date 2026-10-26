/*
 * Module and purpose: Guardar o resultado imutável de uma jogada do protótipo.
 * Student name/number and implemented contributions: [contribuições humanas por confirmar].
 * Collaborator/reviewer and contribution: [revisão humana por realizar].
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

public record TurnResult(String playerName, int diceValue, int previousPosition,
                         int finalPosition, int turnNumber, boolean finished) {
}
