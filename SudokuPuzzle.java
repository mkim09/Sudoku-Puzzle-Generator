import java.util.*;

public class SudokuPuzzle {
    public static void main(String[] args) {
        int[][] board = board();
        print(board);
    }

    public static int[][] board() {
        int[][] board = new int[9][9];
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= 9; i++) { // fill list
            nums.add(i);
            Collections.shuffle(nums); // shuffles while filling list
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
               board[r][c] = nums.get((r * 3 + r / 3 + c) % 9);
          }
        }
            makeRows(board);
            makeCols(board);
             return board;
    }

    public static void makeRows(int[][] board) {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // picks 2 random rows, swaps them
                int r1 = (int)(Math.random() * 3);
                int r2 = (int)(Math.random() * 3);
                int[] temp = board[r1];
                 board[r1] =board[r2];
                board[r2] = temp;
            }
        }
    }

    public static void makeCols(int[][] board){
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //picks 2 random columns, swaps them
                int c1 = (int)(Math.random() * 3);
                int c2 = (int)(Math.random() * 3);
                for (int x = 0; x < 9; x++) {
                    int temp = board[x][c1];
                    board[x][c1] = board[x][c2];
                    board[x][c2] = temp;
                }
            }
        }
    }

    public static void print(int[][] board) {
        // prints the sudoku board with the borders
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 &&i != 0) {
                System.out.println("---------------------"); // horizontal
            }
            
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| "); // vertical
                }
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}