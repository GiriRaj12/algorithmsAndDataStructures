package dataStructures.Algorithms;


public class MazeRunner {
    public static void main(String[] args) {
        String [][] arr = new String[][]{{"X","-","-","-"},
                {"X","X","X","X"},
                {"-","X","-","X"},
                {"-","X","X","X"}};
        int [][] result = new int[4][4];
        mazeUp(arr, 0,0,3,3,result);
    }
    static void mazeUp(String[][] arr, int x, int y, int destinationRow, int destinationCol,int [][]result){
        if(x == destinationRow && y == destinationCol) {
            result[x][y] = 1;
            print(result);
            return;
        }

        if(x== arr.length || y==arr[0].length || arr[x][y].equals("-")) {
            return;
        }

        else{
            if(arr[x][y].equals("X")) {
                System.out.println(x+","+y);
                result[x][y] = 1;
                mazeUp(arr,x,y+1,3,3,result);
                mazeUp(arr,x+1,y,3,3,result);
                result[x][y] = 0;
            }
        }
    }

    private static void print(int[][] result) {
        System.out.println("Into print");
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

}
