/*
 * Module and purpose: Representar o nome e a posição inicial de um jogador.
 * Student name/number and implemented contributions: Bernardo Gonçalves.
 * Collaborator/reviewer and contribution: Bernardo Gonçalves.
 * AI assistance: Codex - implementation assistance; see AI_USE.md.
 */
package crystalrace.model;

/**
 * Representa um participante. Nesta etapa, permite apenas criar e consultar
 * o jogador; as alterações de posição serão tratadas numa etapa posterior.
 */
public class Player {
    private final String name;
    private int position;


    public Player(String name) {
        // Verificação responsável pelo nome do jogador
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome do jogador não pode estar vazio.");
        }

        // Responsável por retirar os espaços em branco do nome introduzido pelo utilizador
        this.name = name.strip();
        // Atribuição da posição inicial a cada jogador
        this.position = 1;
    }

    public String getName()
    {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // Method responsável por atualizar a posição do jogador
    void moveTo(int position) {
        this.position = position;
    }
}
