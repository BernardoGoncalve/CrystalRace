# Utilização de IA

## Etapa 1 — Preparação técnica
Codex auxiliou a configuração Maven para Java 21, a adaptação do ponto de entrada e a refatoração do package para `crystalrace` com OpenRewrite. A configuração do projeto IntelliJ passou a indicar Java 21. Não foram implementadas regras do jogo ou classes do modelo nesta etapa.

O exemplo inicial do IntelliJ foi substituído por uma mensagem de arranque compatível com Java 21. O Main contém o método de entrada da aplicação; `static` permite à JVM executá-lo sem criar uma instância. Nesta etapa ainda não se demonstram encapsulamento ou composição.

Identificações dos alunos:
    Bernardo Gonçalves - 30017311
    Francisco Albuquerque - 30016911
    Mauro de Campos - 30016638. 
Contribuições e revisões humanas efetivamente realizadas: Bernardo Gonçalves. Não se atribui a estudantes a autoria do código gerado por IA. Não foram criados commits ou tags.

O projeto de backup não foi consultado nem utilizado. Os resultados de validação desta etapa serão registados após execução real. Não existem testes de funcionalidades nesta etapa.

## IntelliJ
A máquina dispõe de um JDK 21, mas apenas o SDK openjdk-27 estava registado no IntelliJ. A configuração local referencia o SDK `21`; no IDE será necessário adicionar/selecionar o JDK 21 instalado em `C:\Program Files\Eclipse Adoptium\jdk-21.0.12.101-hotspot`. Não foram alteradas configurações globais do IDE.

## Validação efetivamente executada nesta etapa
- Maven 3.9.9 externo ao projeto, já disponível no ambiente; não foi incluído Maven Wrapper.
- `mvn -o clean compile`, com JDK 21.0.12.1 e repositório local previamente disponível: BUILD SUCCESS, um ficheiro de produção compilado com release 21.
- `java -cp target/classes crystalrace.Main`: execução concluída com a mensagem inicial prevista.
- Não foram criados nem executados testes automatizados, pois ainda não existe lógica funcional.
- OpenRewrite aplicou o novo package e o caminho de Main.java, mas terminou com AccessDeniedException na limpeza do diretório antigo vazio do OneDrive. A compilação posterior confirmou o novo package. Os diretórios antigos vazios não afetam o build.
- Confirmado que Main.java é o único ficheiro Java existente nesta etapa. Player, Board e Game não foram implementados.

## Etapa 2 — Classe Player
Implementação de `src/main/java/crystalrace/model/Player.java` assistida por Codex e autorizada pelo utilizador. A classe representa apenas um jogador: nome e posição privados, construtor que rejeita nomes nulos ou em branco, remoção de espaços exteriores e posição inicial na casa 1. Inclui apenas métodos de consulta; não foram adicionados setters, movimentos ou regras de turnos.

Conceitos: encapsulamento através de atributos privados; construtor para garantir um estado inicial válido; `final` no nome para impedir a sua reatribuição; métodos públicos de consulta. A posição é um atributo de instância, reservado para futura evolução das regras. Cada objeto tem o seu próprio estado. Não é necessária herança nesta etapa.

Não foram implementadas Board, Game ou interface gráfica. Main e pom.xml foram preservados. Contribuições e revisão efetiva dos alunos: Bernardo Gonçalves.

Validação efetivamente executada por Codex: `mvn -o clean compile` com Java 21, BUILD SUCCESS (dois ficheiros de produção). Verificação programática temporária, executada com Java 21: nome válido, posição inicial 1, remoção de espaços exteriores, rejeição de null, vazio e espaços em branco, e criação de dois jogadores com nomes independentes. Resultado: PLAYER_CHECK_OK. O ficheiro auxiliar foi criado em target/ e removido após a execução. Não foram adicionados ou executados testes JUnit, nem atribuídas estas verificações a alunos. Não foram criados commits ou tags.
