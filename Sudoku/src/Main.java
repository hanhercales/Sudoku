import java.util.Scanner;

public interface Main {
    public static void Input(int a[][]){
        Scanner ip = new Scanner(System.in);
    
        boolean c = true;
        int i = 0, j = 0;
        while(c){
            System.out.print("Nhap hang: ");
            i = ip.nextInt();
            if(i < 0 || i > 8){
                System.out.print("Nhap lai!\n");
                continue;
            }

            System.out.print("Nhap cot: ");
            j = ip.nextInt();
            if(j < 0 || j > 8){
                System.out.print("Nhap lai!\n");
                continue;
            }

            if(a[i][j] != 0)
                System.out.print("O da co so, nhap lai!\n");
            c = false;
        }

        c = true;
        while(c){
            System.out.print("Nhap gia tri vao o: ");
            int x = ip.nextInt();
            if(!Check.CheckRows(x, a, i) || !Check.CheckCols(x, a, j) || !Check.CheckAllZone(x, a)){
                System.out.print("Gia tri sai, nhap lai!\n");
                continue;
            }
            a[i][j] = x;
            c = false;
        }
        
    }
    public static void main(String[] args){
        int a[][] = new int[9][9];

        Game.GenGame(a);
        Game.OutputLevel(a);

        Input(a);
    }
}
