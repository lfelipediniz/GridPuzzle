import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read initial state and moves
        String[] input = scanner.nextLine().split(" ");

        int[] initialState = new int[input.length];

        // convert input to int array
        for (int i = 0; i < input.length; i++) {
            initialState[i] = Integer.parseInt(input[i]);
        }

        Board board = new Board(initialState);
        String moves = scanner.nextLine();
        scanner.close();

        // print initial position
        board.printBoard();

        for (char move : moves.toCharArray()) {
            board.move(move);
            // print position after each move
            board.printBoard();
        }

        System.out.println("Posicao final: " + board.verifyPosition());
    }
}
