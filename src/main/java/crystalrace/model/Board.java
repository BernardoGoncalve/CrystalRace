/*
 * Module and purpose: Representar os limites do tabuleiro.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

public class Board {
    private final int totalCells;

    public Board(int totalCells) {
        this.totalCells = totalCells;
    }

    /* Method responsável pelo retorno do número total de casas*/
    public int getTotalCells() {
        return totalCells;
    }

    /* Verificar se a posição do jogador é válida.
    *  Se a posição for inferior ou se for superior a totalCells retorna false.
    */
    public boolean isValidPosition(int position) {
        return position >= 1 && position <= totalCells;
    }
}
