import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardGUI extends JFrame {
    private JPanel boardPanel;
    private int tileSize;
    private int gridSize;
    private Board board;
    private JLabel[][] labels;

    public BoardGUI(Board board) {
        this.board = board;
        this.gridSize = board.getBoard().length;
        this.tileSize = 100; // tamanho de cada quadrado

        setTitle("8 Puzzle Game");
        setSize(gridSize * tileSize, gridSize * tileSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(gridSize, gridSize));
        labels = new JLabel[gridSize][gridSize];

        initializeBoard();

        add(boardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void initializeBoard() {
        int[][] currentBoard = board.getBoard();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                labels[i][j] = new JLabel(String.valueOf(currentBoard[i][j]), SwingConstants.CENTER);
                labels[i][j].setPreferredSize(new Dimension(tileSize, tileSize));
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                labels[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                labels[i][j].setOpaque(true);
                labels[i][j].setBackground(currentBoard[i][j] == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                labels[i][j].addMouseListener(new TileMouseListener(i, j));
                boardPanel.add(labels[i][j]);
            }
        }
    }

    private void updateBoard() {
        int[][] currentBoard = board.getBoard();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                labels[i][j].setText(String.valueOf(currentBoard[i][j]));
                labels[i][j].setBackground(currentBoard[i][j] == 0 ? Color.LIGHT_GRAY : Color.WHITE);
            }
        }
    }

    private class TileMouseListener extends MouseAdapter {
        private int row, col;

        public TileMouseListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int[] zeroIndex = board.findZeroIndex();
            int zeroRow = zeroIndex[0];
            int zeroCol = zeroIndex[1];

            if ((Math.abs(zeroRow - row) == 1 && zeroCol == col) || (Math.abs(zeroCol - col) == 1 && zeroRow == row)) {
                board.swap(zeroRow, zeroCol, row, col);
                updateBoard();
                if (board.verifyPosition()) {
                    JOptionPane.showMessageDialog(boardPanel, "Congratulations! You solved the puzzle!");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] initialState = { 8, 6, 5, 4, 0, 1, 7, 3, 2 };
        Board board = new Board(initialState);
        new BoardGUI(board);
    }
}
