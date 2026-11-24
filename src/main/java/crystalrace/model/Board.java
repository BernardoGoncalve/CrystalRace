/*
 * Module and purpose: Representar os limites do tabuleiro.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int totalCells = 30;

    //Armazena todas as casas do tabuleiro
    private final List<Cell> cells = new ArrayList<>();

    public Board(){

        //Cria as casas normais
        for (int i = 1; i <= totalCells; i++ ){
            cells.add(new NormalCell(i));
        }

        cells.set(3, new AdvanceCell(4, 8));
        cells.set(8, new ReturnCell(9, 6));

        cells.set(11, new AdvanceCell(12, 16));
        cells.set(16, new ReturnCell(17,13));

        cells.set(19, new AdvanceCell(20, 24));
        cells.set(24, new ReturnCell(25, 21));
    }

    /* Responsável pelo retorno do número total de casas*/
    public int getTotalCells() {
        return totalCells;
    }

    /* Verificar se a posição do jogador é válida.
    *  Se a posição for inferior ou se for superior a totalCells retorna false.
    */
    public boolean isValidPosition(int position) {
        return position >= 1 && position <= totalCells;
    }

    //Retorna a casa correspondente à posição final
    public Cell getCell(int position) {
        if (!isValidPosition(position))
            throw new IllegalArgumentException("A posição não existe no tabuleiro");
        return cells.get(position - 1);
    }
}
