import java.util.Scanner;

public class Main {
    public static void Input(int[][] a) {
        Scanner ip = new Scanner(System.in);
        
        int i = 0, j = 0;
        while (true) {
            System.out.print("Input Row (0-8): ");
            i = ip.nextInt();
            System.out.print("Input Column (0-8): ");
            j = ip.nextInt();

            if (i < 0 || i > 8 || j < 0 || j > 8) {
                System.out.print("Invalid coordinates\n");
                continue;
            }

            if (a[i][j] != 0) {
                System.out.print("Cell already has a number!\n");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Input value (1-9): ");
            int x = ip.nextInt();

            if (x < 1 || x > 9) {
                System.out.print("Invalid value!\n");
                continue;
            }
            if (!Check.CheckRows(x, a, i) || !Check.CheckCols(x, a, j) || !Check.CheckZone(x, a, i, j)) {
                System.out.print("Wrong value!\n");
                continue;
            }
            a[i][j] = x;
            break;
        }
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);

        System.out.print("Choose dificulty (1-Easy, 2-Normal, 3-Hard, 4-Hell): ");
        int level = ip.nextInt();

        long startTime = System.currentTimeMillis();

        Game.GenerateFullBoard();
        Game.RemoveNumbers(level);
        Game.OutputLevel();

        long endTime = System.currentTimeMillis();
        System.out.println("Generate time: " + (endTime - startTime) + "ms");

        while (true) {
            System.out.print("Continue playing? (y/n): ");
            String choice = ip.next();
            if (choice.equalsIgnoreCase("n")) break;

            Input(Game.getBoard());
            Game.OutputLevel();
        }

        System.out.println("Game Over!");
    }
}