# Crystal Race — checkpoint de outubro

Projeto de POO da UAL, 2026/2027. Grupo de três, aprovado pelo docente segundo confirmação do grupo. A versão final será Java Swing; esta versão é apenas um protótipo técnico de movimento, demonstrado na consola.

## Estado desta versão
Implementado: 2–4 jogadores, nomes validados, posições iniciais, tabuleiro com 30 posições, movimentos normais com valores fornecidos entre 1 e 6, alternância, contador global, ultrapassagem, casas partilhadas, chegada exata, limite de 100 jogadas, líderes/empate e reinício. São disponibilizados testes determinísticos do modelo.

**Ainda não implementado:** aplicação dos efeitos especiais às jogadas, modos de dado interativos manual/aleatório, interface gráfica, comandos interativos de sair/reiniciar e arte final. As classes Cell, NormalCell, AdvanceCell e ReturnCell já existem, mas ainda não estão integradas em Board/Game. Por exemplo, no protótipo chegar à casa 4 termina na casa 4; nas regras finais deverá avançar até 8. Esta limitação é intencional e identificada nos testes.

## Requisitos
- JDK 21.
- Maven 3.9 ou superior; não existe Maven Wrapper nesta versão.
- Primeira resolução das dependências requer Internet, se não estiverem em cache.

## Compilar, testar e executar
Na pasta que contém pom.xml:
```powershell
mvn clean test
mvn package
java -jar target/CrystalRace-1.0-SNAPSHOT.jar
```
Alternativa após compilação: `java -cp target/classes crystalrace.Main`.

No IntelliJ: abrir pom.xml, selecionar/adicionar o JDK 21, recarregar Maven e executar crystalrace.Main. Se mvn não estiver no PATH, utilizar o Maven integrado do IntelliJ. Se JAVA_HOME apontar para outro JDK, corrigir apenas na sessão ou configurar o JDK do Maven no IDE.

O Main executa uma demonstração não interativa com três jogadores e a sequência 3, 2, 6, 4, 1, 2. Posições finais esperadas: (8, 4, 9), seis jogadas; próximo jogador: Jogador 1. Não é um jogo completo nem a GUI final.

## Organização e conceitos de POO
- Player: estado de cada jogador, atributos privados; nome final, posição alterável apenas dentro do package do modelo.
- Board: limites do tabuleiro. Game compõe um Board e uma List<Player>.
- Game: valida e coordena as jogadas; não lê teclado nem escreve na consola.
- TurnResult: record imutável que transporta os dados de uma jogada para a apresentação.
- Main: apresentação temporária e sequência de demonstração; não implementa regras de movimento.
- Cell abstrata e subclasses: herança e overriding já presentes; integração do polimorfismo no jogo ainda por fazer.
- Interface Dice e overload justificado: planeados para a etapa dos modos de dado; não se apresentam como concluídos.

## Documentação
- docs/RULES.md — regras finais e limites do protótipo.
- docs/BOARD_MAP.md — mapa completo planeado.
- docs/UML.md — diagrama inicial e evolução prevista.
- docs/GUI_SKETCH.md — desenho da interface para o grupo de três.
- docs/REPRESENTATIONS.md — correspondência entre jogo, GUI, modelo e mockup.
- docs/TASK_ALLOCATION.md — proposta de tarefas, ainda por aprovar pelo grupo.
- docs/TEST_CASES.md e docs/VALIDATION.md — cenários e evidência real.
- docs/PROTOTYPE_TRANSCRIPT.txt — saída real da demonstração técnica.
- docs/OCTOBER_STATUS.md — rascunho do relatório a rever antes do Moodle.
- docs/DELIVERY_CHECKLIST.md — passos restantes para a entrega.
- AI_USE.md — utilização de IA, alterações assistidas e revisão humana pendente.

Não foram criados commits/tags nem enviado qualquer ficheiro ao GitHub ou Moodle por esta assistência.
