/*
 * Module and purpose: Representar uma casa de avanço.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */

package crystalrace.model;

public class AdvanceCell extends Cell{
    private final int target;

    public AdvanceCell(int number, int target) {
        super(number);
        // Impede que a casa de destino seja fora do tabuleiro
        if (target < 1 || target > 30 || target <= number) throw new IllegalArgumentException("Destino Inválido.");
        // Atribuição da casa como destino
        this.target = target;
    }

    @Override
    public int destination() {
        return target;
    }

    @Override
    public String description() {
        return "Avançar até à casa " + target;
    }
}
