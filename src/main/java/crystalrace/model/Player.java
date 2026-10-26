/*
 * Module and purpose: Representar o nome e a posição inicial de um jogador.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

/**
 * Representa um participante. Game coordena os movimentos; moveTo tem acesso
 * de package para impedir alterações diretas pela futura interface.
 */
public class Player {
    private final String name;
    private int position;


    public Player(String name) {
        // Verificação responsável pelo nome do jogador
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome do jogador é obrigatório.");
        }

        // Responsável por retirar os espaços em branco do nome introduzido pelo utilizador
        this.name = name.strip();
        // Atribuição da posição inicial a cada jogador
        this.position = 1;
    }

    // Responsável por retornar o nome do player
    public String getName() {
        return name;
    }

    // Responsável por retornar a posição do Player
    public int getPosition() {
        return position;
    }

    // Responsável por atualizar a posição do jogador
    void moveTo(int position) {
        if (position < 1) {
            throw new IllegalArgumentException("A posição deve ser igual ou superior a 1.");
        }
        this.position = position;
    }

}
