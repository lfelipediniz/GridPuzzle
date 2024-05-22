public class Board {
    private int[][] board;
    private int size;

    public Board(int[] initialState) {
        // assuming the input is always a square
        size = (int) Math.sqrt(initialState.length);
        board = new int[size][size];

        int initialStateIndex = 0; // index for the initial state array for to convert it to a 2D array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = initialState[initialStateIndex++];
            }
        }
    }

    public int[] findZeroIndex() {
        int[] index = new int[2];
        int i, j;

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }

        return null;
    }

    public void swap(int row1, int col1, int row2, int col2) {
        int aux = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = aux;
    }

    // move the zero tile in the direction specified
    public void move(char direction) {
        int[] zeroIndex = findZeroIndex();
        int newRow = zeroIndex[0];
        int newCol = zeroIndex[1];

        switch (direction) {
            case 'd':
                newRow--;
                break;
            case 'u':
                newRow++;
                break;
            case 'r':
                newCol--;
                break;
            case 'l':
                newCol++;
                break;
        }

        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
            swap(zeroIndex[0], zeroIndex[1], newRow, newCol);
        }
    }

    public boolean verifyPosition() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != count && !(i == size - 1 && j == size - 1)) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    public void printBoard() {
        // print superior line
        System.out.print("+");
        for (int i = 0; i < size; i++) {
            System.out.print("------+");
        }
        System.out.println();

        // print lines board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("|%4d  ", board[i][j]);
            }
            System.out.println("|");

            // print intermediate line between board
            System.out.print("+");
            for (int j = 0; j < size; j++) {
                System.out.print("------+");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getBoard() {
        return board;
    }
}
