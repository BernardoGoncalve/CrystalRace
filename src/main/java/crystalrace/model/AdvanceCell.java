/*
 * Module and purpose: Representar os limites do tabuleiro.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */

package crystalrace.model;

public class AdvanceCell extends Cell{
    private final int target;

    public AdvanceCell(int number, int target) {
        super(number);
        if (target < 1 || target > 30 || target <= number) throw new IllegalArgumentException("Destino Inválido.");
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
