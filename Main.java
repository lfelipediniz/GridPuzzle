import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // ask the user for the size of the board
        String sizeInput = JOptionPane.showInputDialog("Enter the size of the board (n for an n x n board):");
        int size = Integer.parseInt(sizeInput);

        // ask the user for the initial state of the board
        int[] initialState = new int[size * size];
        for (int i = 0; i < size * size; i++) {
            String valueInput = JOptionPane.showInputDialog("Enter the value for position " + i + ":");
            initialState[i] = Integer.parseInt(valueInput);
        }

        Board board = new Board(initialState);
        new BoardGUI(board);
    }
}
