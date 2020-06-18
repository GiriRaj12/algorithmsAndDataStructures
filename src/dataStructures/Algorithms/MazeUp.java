package dataStructures.Algorithms;


public class MazeUp {
    static int count ;
    public static void main(String[] args) {
        String arr[][] = new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(j%2 == 0)
                    arr[i][j] = "A";
                else
                    arr[i][j] = "B";
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        mazeUp(arr);

    }

    private static void mazeUp(String[][] arr) {
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                checkRow(i,j,arr);
//                checkDiagonal(i,j,arr);
//            }
//        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                checkRow(i, j, arr);
                checkDiagonal(i,j,arr);
            }
        }
        checkDiagonal(0,0,arr);
        System.out.println(count);
    }

    private static void checkDiagonal(int row, int col, String[][] arr) {
        String str = "";
        for(int i=0;i<arr.length;i++){
            if((row +1 < arr.length) && (col + i < arr.length))
                str = str + arr[row+i][col+i];
        }
        System.out.println(str);
        if(str.equals("ABA"))
            count++;
    }

    private static void checkRow(int row, int col, String[][] arr) {
       String str = "";
        for(int i=row;i<arr.length;i++){
            str = str + arr[i][col];
        }
        System.out.println(str);
        if(str.equals("ABA")) {
            count++;
            System.out.println(str);
        }
        str = "";
        for(int j=col;j<arr[0].length;j++){
            str = str + arr[row][j];
        }
        System.out.println(str);
        if(str.equals("ABA")) {
            count++;
        }
    }
}
