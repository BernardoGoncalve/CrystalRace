/*
 * Module and purpose: model/Cell.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */

package crystalrace.model;

public abstract class Cell {
   private final int number;

   protected Cell(int number) {
       if (number < 1 || number > 30) throw new IllegalArgumentException("Casa Inválida.");
       this.number = number;
   }

   // Responsável por retornar o número da casa
   public final int getNumber() {
       return number;
   }

   public abstract int destination();
   public abstract String description();
}
