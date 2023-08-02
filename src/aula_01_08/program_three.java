package aula_01_08;

public class program_three {
    public static void main(String[] args) {
        int[][] rectangle;
        int row = 10;
        int column = 40;

        rectangle = new int[row][column];

        // Filling the "A" on the sides
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                    System.out.print("A ");
                } else {
                    System.out.print(" ");
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
