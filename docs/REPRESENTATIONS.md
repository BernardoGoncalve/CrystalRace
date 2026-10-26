# Ligações entre níveis de representação — plano inicial

| Conceito | GUI final planeada | Modelo | Mockup artístico planeado |
|---|---|---|---|
| Explorador | Peão numerado e colorido | Player, name e position | Personagem da mesma cor |
| Posição | Peão numa casa numerada | Player.getPosition(); por exemplo (22,24) | Exploradores nas casas 22 e 24 |
| Percurso | Grelha com 30 casas | Board; coleção de Cell ainda por integrar | Caminho com 30 etapas |
| Avanço/recuo | Seta e destino escrito | AdvanceCell/ReturnCell, ainda desligadas das jogadas | Pontes/atalhos e obstáculos coerentes com o mapa |
| Jogada | Jogador atual, dado e feedback | Game, currentIndex, turnCount, TurnResult | Área reservada ao dado e estado |
| Meta | Casa 30 e mensagem de resultado | finished e getWinners() | Cristal na casa 30 |

A saída em PROTOTYPE_TRANSCRIPT.txt é apenas evidência técnica do modelo de outubro. Para o grupo de três, o projeto final utiliza GUI e screenshots, não uma aplicação de consola.
