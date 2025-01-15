
import java.util.Scanner;

public class Game {
    public static int[][] GenGame(int a[][]){
        for(int i = 0; i < 9; ++i)
            for(int j = 0; j < 9; ++j)
                a[i][j] = 0;

        Scanner ip = new Scanner(System.in);

        System.out.print("Nhap so o hien thi so: ");
        int n = ip.nextInt();
        
        for(int i = 0; i < n; ++i){
            int x = RandomInt(0, 8);
            int y = RandomInt(0, 8);
            if(a[x][y] != 0){
                i--;
                continue;
            }
            
            boolean c = true;
            while(c){
                int z = RandomInt(1, 9);
                if(!Check.CheckRows(z, a, x) || !Check.CheckCols(z, a, y) || !Check.CheckAllZone(z, a))
                    continue;
                a[x][y] = z;
                c = false;
            }
        }

        return a;
    }

    private static int RandomInt(int a, int b){
        int x = (int) (Math.random() * (b - a + 1)) + a;
        return x;
    }

    public static void OutputLevel(int a[][]){
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j)
                if(a[i][j] == 0)
                    System.out.print(" * ");
                else 
                    System.out.print(" " + a[i][j] + " ");
            System.out.print('\n');
        }
    }
}
