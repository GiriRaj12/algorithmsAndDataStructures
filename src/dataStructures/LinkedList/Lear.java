package dataStructures.LinkedList;

import java.util.Scanner;

public class Lear {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int q = in.nextInt();
        for(int i=0;i<q+1;i++){
            String query = in.nextLine();
            processQuery(query, arr);
        }
    }
    static void processQuery(String query, int[] arr){
        String [] queryStr = query.split(" ");

        if("Increment".equals(queryStr[0])){
            System.out.println(query);
            int num =  Integer.parseInt(queryStr[1]);
            arr[num-1]++;
        }
        else if("Left".equals(queryStr[0])){
            System.out.println(query);
            arr = rotateLeft(arr);
        }
        else if("Right".equals(queryStr[0])){
            System.out.println(query);
            arr = rotateRight(arr);
        }
        else if("?".equals(queryStr[0])){
            int num =  Integer.parseInt(queryStr[1]);
            System.out.println(query);
            System.out.println(arr[num-1]);
        }
        if("Update".equals(queryStr[0])){
            System.out.println(query);
            int pos = Integer.parseInt(queryStr[1]);
            int val = Integer.parseInt(queryStr[2]);
            arr[pos-1] = val;
        }
    }

    static int[] rotateLeft(int[] arr){
        int n = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = n;
        print(arr);
        return arr;
    }

    static int[] rotateRight(int[] arr){
        int n = arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = n;
        print(arr);
        return arr;
    }

    static  void  print(int []arr){
        for(int a : arr){
            System.out.print(a+",");
        }
        System.out.println();
    }


}
