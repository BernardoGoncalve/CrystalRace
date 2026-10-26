/*
 * Module and purpose: Representar uma casa sem efeito; ainda não integrada nas jogadas.
 * Student name/number and implemented contributions: [contribuições humanas por confirmar].
 * Collaborator/reviewer and contribution: [revisão humana por realizar].
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

public class NormalCell extends Cell{

    public NormalCell(int number) {
        super(number);
    }

    @Override
    public int destination() {
        return getNumber();
    }

    @Override
    public String description() {
        return "Casa normal";
    }
}
