# UML inicial

## Classes existentes e relações atualmente utilizadas
```mermaid
classDiagram
    Main ..> Game : executa demonstração
    Game *-- Board : limites
    Game *-- "2..4" Player : jogadores
    Game ..> TurnResult : produz
    Cell <|-- NormalCell
    Cell <|-- AdvanceCell
    Cell <|-- ReturnCell
    class Player {
        -String name
        -int position
        +Player(String name)
        +getName() String
        +getPosition() int
        ~moveTo(int position)
    }
    class Board {
        -int totalCells
        +getTotalCells() int
        +isValidPosition(int position) boolean
    }
    class Game {
        -List~Player~ players
        -Board board
        -int currentIndex
        -int turnCount
        -boolean finished
        +Game(List~String~ names)
        +play(int diceValue) TurnResult
        +getPlayers() List~Player~
        +getCurrentPlayer() Player
        +getWinners() List~Player~
        +restart()
    }
    class TurnResult {
        <<record>>
        +String playerName
        +int diceValue
        +int previousPosition
        +int finalPosition
        +int turnNumber
        +boolean finished
    }
    class Cell {
        <<abstract>>
        -int number
        +getNumber() int
        +destination() int
        +description() String
    }
```

Cell e subclasses existem, mas Board ainda não agrega casas. Essa ligação não é apresentada como implementada.

## Evolução proposta para novembro — ainda não implementada
```mermaid
classDiagram
    Board *-- "30" Cell
    Dice <|.. RandomDice
    Game ..> Dice
    GameFrame --> Game
    GameFrame --> SetupPanel
    GameFrame --> BoardPanel
    BoardPanel --> Board
    class Dice {
        <<interface>>
        +roll() int
    }
```
A futura interface Swing chama o modelo sem conter regras. Dice permitirá substituir lançamentos aleatórios por sequências controladas nos testes. Um possível overload play(Dice), delegando em play(int), será justificado nessa etapa.
