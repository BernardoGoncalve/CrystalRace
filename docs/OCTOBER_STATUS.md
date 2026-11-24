# Crystal Race — relatório de outubro
**UAL · POO · 2026/2027 · Entrega: 29/10/2026**  
Grupo: Bernardo Gonçalves (30017311), Francisco Albuquerque (30016911) e Mauro de Campos (30016638). Grupo de três aprovado pelo docente.

**Repositório:** https://github.com/BernardoGoncalve/CrystalRace  
**Versão do código:** `6c3f72b0386206463210fef9afd8526328c35c2d` — Last Details and Demonstration Movement.

## Estado e evidência
O projeto Maven utiliza Java 21 e dispõe de um protótipo de movimento separado da apresentação. Player guarda nome e posição; Board define os limites de 1 a 30; Game gere 2–4 jogadores, valida nomes e lançamentos inteiros de 1 a 6, alterna turnos e conta jogadas globais. Estão implementadas posições partilhadas, permanência na casa atual quando o movimento ultrapassa 30, vitória por chegada exata, limite de 100 jogadas, empate e reinício. TurnResult transporta o resultado imutável de cada jogada.

O Main apresenta o tabuleiro na consola e executa seis lançamentos predefinidos (3, 2, 6, 4, 1, 2), com três jogadores e posições finais (8, 4, 9). Trata-se de uma demonstração técnica, sem interação. Cell, NormalCell, AdvanceCell e ReturnCell existem, mas ainda não estão integradas nos movimentos. Existem regras, mapa, UML inicial, esboço da futura GUI e proposta de tarefas em docs/.

A execução de 26/10/2026 registou BUILD SUCCESS e 24 testes JUnit 5 sem falhas, erros ou testes ignorados. Os cenários abrangem inicialização e ordem com 2–4 jogadores, validação, movimentos, fronteiras, fim, empate e reinício. Os resultados constam de docs/VALIDATION.md e dos relatórios Surefire. A revisão de 27/10 foi apenas de leitura; não foram repetidos testes nem alterado código.

## Contribuições e organização
A integração e a documentação desta etapa tiveram assistência de IA, registada em AI_USE.md. Contribuições humanas efetivas: Bernardo, Francisco e Mauro. A distribuição não estava acordada à data da preparação; existe proposta em docs/TASK_ALLOCATION.md, que precisa da aprovação dos três.

## Trabalho em falta e próximos passos
Até ao checkpoint de 26/11, integrar as casas e os efeitos em Board/Game, implementar ambos os modos de dado e os testes correspondentes, e desenvolver Swing para 2–4 jogadores, mostrando o tabuleiro e processando uma jogada. Preparar o conceito artístico, concretizar a distribuição de tarefas e completar os registos individuais. A interface Dice e o overload justificado permanecem por implementar. O esboço da GUI não é uma aplicação gráfica executável.

## Reflexões 
Existiu uma grande dificuldade na compreensão e divisão lógica necessária para a estrutura do projeto, tornou-se mais simples depois de um pedido de auxilio à AI. Outra dificuldade encontrada foi na interligação entre as classes já criadas e na demonstração de movimento, e posteriormente o Java Swing, após o aparecimento da dificuldade foi realizado um pedido à AI para auxiliar neste trabalho. (Verificar AI_USE.md)
