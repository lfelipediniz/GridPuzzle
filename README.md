# GridPuzzle

## Project Description

This project implements an 8 Puzzle game with a graphical interface in Java, using arrays (vectors) to represent the game board. The goal is to provide an interactive and educational experience for understanding the mechanics of the 8 Puzzle game, as well as to demonstrate the implementation of a graphical user interface using Java Swing.

## Classes and Subclasses

### Main Class: BoardGUI

The `BoardGUI` class represents the graphical user interface for the 8 Puzzle game, implemented using Java Swing. It initializes the game board based on user input and allows for interactive play.

#### Public Interface

- `BoardGUI(Board board)`: Constructor that initializes the game board and sets up the GUI.
- `static void main(String[] args)`: The main method that starts the application, prompting the user for the board size and initial state.

#### Methods

- `void initializeBoard()`: Initializes the board with JLabels representing each tile.
- `void updateBoard()`: Updates the board display based on the current state of the game board.

### Supporting Class: Board

The `Board` class represents the state of the 8 Puzzle game board and includes methods for manipulating the board.

#### Public Interface

- `Board(int[] initialState)`: Constructor that initializes the game board from a one-dimensional array.
- `int[] findZeroIndex()`: Finds the position of the empty tile (zero).
- `void swap(int row1, int col1, int row2, int col2)`: Swaps two tiles on the board.
- `void move(char direction)`: Moves the empty tile in the specified direction.
- `boolean verifyPosition()`: Checks if the board is in the solved state.
- `int[][] getBoard()`: Returns the current state of the board.

### Example of GUI Interaction

The GUI allows the user to click on tiles adjacent to the empty tile to move them. When the board is in the solved state, a congratulatory message is displayed.

## Example Usage

### Entry

When the application starts, it prompts the user to enter the size of the board (n for an n x n board) and the values for each position on the board.

### Exit

The application displays the initial state of the board and allows the user to interact with it by clicking on the tiles. The board updates in real-time, and a message is displayed when the puzzle is solved.

## Usage

1. Compile and run the program using the Makefile:

    ```bash
    make
    make run
    ```

2. To clean the generated files:

    ```bash
    make clean
    ```

Project developed for the [Object Oriented Programming](https://uspdigital.usp.br/jupiterweb/obterDisciplina?sgldis=SSC0103&codcur=55041&codhab=0) course at the Institute of Mathematics and Computing, University of São Paulo.