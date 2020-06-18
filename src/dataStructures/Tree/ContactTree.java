package dataStructures.Tree;


import java.util.Scanner;

class ContactNode{
    int data;
    Node right;
    Node left;
    ContactNode(int data){
        this.data = data;
        right = null;
        left = null;
    }
}
public class ContactTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for(int i=0;i<name.length();i++){
            for (int j=i+1;j<=name.length();j++){
                String str = name.substring(i,j);

            }
        }
    }
}
