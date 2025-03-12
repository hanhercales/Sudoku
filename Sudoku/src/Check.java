public class Check {
    public static boolean CheckRows(int x, int a[][], int i){
        for(int j = 0; j < 9; ++j)
                if(x == a[i][j] && a[i][j] != 0)
                    return false;
        return true;
    }

    public static boolean CheckCols(int x, int a[][], int j){
        for(int i = 0; i < 9; ++i)
                if(x == a[i][j] && a[i][j] != 0)
                    return false;
        return true;
    }

    public static boolean CheckZone(int x, int a[][], int i, int j) {
        int startRow = (i / 3) * 3;
        int startCol = (j / 3) * 3;
    
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (a[row][col] == x)
                    return false;
            }
        }
        return true;
    }
    
}
