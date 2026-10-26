# Desenho inicial da GUI — outubro

Este é um esboço, não uma interface implementada. Grupo de três aprovado pelo docente segundo confirmação do grupo. A GUI executável é objetivo de novembro.

## Configuração
```text
+-----------------------------------------------------+
| CRYSTAL RACE — corrida pelo cristal                  |
| Jogadores: [2 / 3 / 4]                               |
| Nome 1: [____________] Nome 2: [____________]          |
| Nome 3: [____________] Nome 4: [____________]          |
| Dado: [Manual / Aleatório]                           |
| [Começar partida]                         [Sair]     |
+-----------------------------------------------------+
```
Ativar apenas os campos correspondentes ao número selecionado. Mostrar erro claro em nomes inválidos, mantendo a configuração.

## Partida
```text
+-----------------------------------------------------+
| Vez de: Nome                 Jogadas globais: 0/100   |
| [01][02][03][04→08][05][06]                           |
| [07][08][09→06][10][11][12→16]                        |
| [13][14][15][16][17→13][18]                           |
| [19][20→24][21][22][23][24]                           |
| [25→21][26][27][28][29][30: cristal]                  |
| Cada casa mostra os peões presentes.                |
| Posições: Nome 1=... | Nome 2=... | ...              |
| Dado [1–6] [Jogar] OU [Lançar dado aleatório]         |
| Última jogada: origem → chegada → efeito → final     |
| Resultado: [partida em curso / vencedor / empate]    |
| [Reiniciar]                              [Sair]     |
+-----------------------------------------------------+
```

Peões com cores e números para não depender apenas da cor. Casas de avanço e recuo com símbolos e destino escrito. Permitir vários peões na mesma casa. Após o fim, desativar jogadas e manter reinício/saída. GUI criada e atualizada na Event Dispatch Thread; regras mantidas em Game/Board.

Sem animações, áudio ou persistência. O mockup artístico e as screenshots da GUI executável serão produzidos posteriormente; este desenho não é apresentado como screenshot.
