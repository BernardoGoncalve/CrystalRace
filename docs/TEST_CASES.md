# Verificações do protótipo de outubro

JUnit 5; src/test/java/crystalrace/model/GameTest.java. Lançamentos inteiros predefinidos, sem aleatoriedade real. Cada nome de teste e asserções identifica o estado, input e resultado.

| Estado inicial | Input | Resultado esperado |
|---|---|---|
| Lista de 2, 3 ou 4 nomes | Construção | Tabuleiro não nulo, todos em 1, zero jogadas |
| 2, 3 ou 4 jogadores | Um lançamento 1 por jogador | Ordem de entrada, regresso ao primeiro |
| Primeiro jogador em 1 | 3 | Fica em 4, sem efeito especial nesta versão |
| Partida nova | -1, 0, 7 ou máximo inteiro | Exceção sem mutação de estado |
| Jogador em 29 | 2 | Permanece em 29, consome jogada e passa a vez |
| Dois jogadores em 1 | 2, 2 | Ambos na casa 3 |
| Jogador em 29 | 1; depois nova jogada | Vitória em 30; nova jogada rejeitada sem mutação |
| Jogadores em 29 e 28 | 100 lançamentos de 6 | Só termina na jogada 100; ganha posição 29 |
| Ambos em 29 | 100 lançamentos de 6 | Empate |
| Partida terminada | restart() | Posições 1, contador 0, primeiro jogador, ativa |
| Partida nova com dois jogadores | 6,1,6,1,6,1,6,1,5 | Primeiro vence em 9 jogadas; posições (30,5) |
| Nomes inválidos | null, vazio, espaços, tabulação | Rejeição |
| Construção | Nomes repetidos ou número inválido | Rejeição |
| Lista pública de jogadores | clear() | Alteração estrutural rejeitada |
| Tabuleiro | 1,30,0,31 | Aceita extremos; rejeita valores exteriores |
| Jogador | moveTo(0) | Rejeição |

Cenários de fronteira preparam posições com acesso de package a moveTo; não existe setter público. Estas verificações cobrem apenas o protótipo de movimento, não os requisitos finais completos. Efeitos especiais, modos manual/aleatório interativos, interface Dice e GUI deverão ter testes numa etapa posterior.

Resultado real da execução: consultar VALIDATION.md. Não atribuir os testes gerados por Codex a alunos sem revisão e contribuição humana documentadas.
