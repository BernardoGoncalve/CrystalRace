# Crystal Race — regras definidas pelo grupo

## Objetivo e participantes
Corrida de exploradores até ao cristal na casa 30. Participam 2 a 4 jogadores, com nomes personalizados, todos na casa 1. A ordem de entrada determina a ordem dos turnos. Podem partilhar casas.

## Jogada e limites
Em cada jogada lança-se um dado entre 1 e 6. Os modos manual e aleatório deverão usar a mesma lógica. Um lançamento válido soma-se à posição atual. Se ultrapassar 30, o jogador permanece na posição anterior e a jogada é consumida. Um input inválido não altera posições, jogador atual, contador ou resultado.

## Efeitos especiais da versão final
Avanços: 4→8, 12→16, 20→24. Recuos: 9→6, 17→13, 25→21. Aplica-se uma única casa por jogada, sem encadeamento. Ultrapassar o limite não reaplica o efeito da posição anterior. Restantes casas são normais.

## Fim
Vence quem chega exatamente à casa 30. A partida termina também ao concluir 100 jogadas globais, não 100 rondas por jogador. Nesse limite, vence a maior posição; vários líderes originam empate. Não é permitida nova jogada após o fim. Reiniciar repõe posições em 1, contador em 0, primeiro jogador e estado ativo.

## Validação de nomes
A aplicação rejeita nomes nulos ou em branco, remove espaços exteriores e rejeita duplicados sem distinguir maiúsculas/minúsculas.

## Situação em outubro
O protótipo implementa apenas movimentos normais com valores fornecidos pelo chamador, além do controlo de turnos, limites, fim e reinício. Efeitos especiais, modos de dado interativos e GUI não estão ligados. Este documento define o jogo final; não constitui uma afirmação de que todos os requisitos já foram implementados.
