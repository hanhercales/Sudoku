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

    public static boolean CheckZone(int x, int a[][], int i, int j){
        for(; i < i + 3 && i < 9; ++i)
            for(; j < j + 3 && j < 9; ++j)
                    if(x == a[i][j] && a[i][j] != 0)
                        return false;
        return true;
    }

    public static boolean CheckAllZone(int x, int a[][]){
        for(int i = 0; i < 7; i += 3)
            for(int j = 0; j < 7; j += 3)
                if(!CheckZone(x, a, i ,j))
                    return false;
        return true;
    }
}
