# Validação do checkpoint de outubro — 26/10/2026

## Ambiente e comandos efetivamente executados
- JDK: Eclipse Temurin 21.0.12.1.
- Apache Maven 3.9.9 já disponível externamente à pasta do projeto; Maven não foi instalado globalmente e não foi incluído Wrapper.
- JAVA_HOME selecionado apenas no processo de compilação, sem alteração de variáveis globais.
- Comando Maven: `mvn -o -B -ntp -Dmaven.repo.local=<cache disponível no ambiente> clean test package`.
- Resultado: BUILD SUCCESS; nove ficheiros Java de produção e um ficheiro de testes compilados com release 21.
- JUnit: **24 testes, 0 falhas, 0 erros, 0 ignorados**. Fonte: target/surefire-reports/TEST-crystalrace.model.GameTest.xml.
- JAR gerado: target/CrystalRace-1.0-SNAPSHOT.jar, classe principal crystalrace.Main.
- Executado o JAR com Java 21. Seis jogadas predefinidas: 3,2,6,4,1,2; posições finais verificadas (8,4,9), próximo jogador Jogador 1. Saída real em PROTOTYPE_TRANSCRIPT.txt.
- A primeira captura da saída em Windows encontrou diferença de encoding da consola; a repetição com stdout.encoding=UTF-8 foi concluída. Não foi alterada a lógica para capturar a saída.
- Confirmados os cabeçalhos de autoria/IA e os caminhos de package nos dez ficheiros Java.

## Alcance dos testes
Inicialização e ordem com 2, 3 e 4 jogadores; nomes; movimentos normais; valores de dado inválidos sem mutação; fronteiras; ocupação partilhada; chegada exata; rejeição após o fim; limite global de 100 jogadas; empate; reinício e uma partida normal com sequência predeterminada. Os resultados foram obtidos por Codex, não se atribuem aos alunos.

## Limitações reais
- As classes de efeitos existem, mas não são aplicadas por Game; Board ainda não contém coleção de Cell.
- Os lançamentos são valores fornecidos ao modelo; não há entrada manual textual, aleatoriedade, interface Dice ou modo interativo.
- Não existe GUI Swing executável nem inspeção visual. GUI_SKETCH.md é apenas um desenho.
- Os testes da partida completa representam o protótipo sem efeitos, não o jogo final.
- Overload e interface/polimorfismo integrado ainda por concluir; não se declaram todos os requisitos de POO cumpridos.

## Git e entrega
Remoto origin lido: https://github.com/BernardoGoncalve/CrystalRace. HEAD consultado antes do checkpoint: dc70dcc20167da1587387cbdd75751696660167f, commit já existente de 26/10/2026. **Esse commit não contém as alterações agora preparadas e não deve ser usado como referência deste protótipo sem nova revisão/commit.**

`git status` simples encontrou um problema de contexto de árvore de trabalho nesta sessão; `git --work-tree=. status --short` funcionou e mostrou alterações e documentos novos. Não foi modificada a configuração do repositório. Foi confirmado por check-ignore que o JAR em target/ está excluído. Não foram criados commits/tags, feito push, concedido acesso ao docente nem submetido o Moodle. A proposta de tarefas e as reflexões/contribuições humanas precisam de revisão e preenchimento.
