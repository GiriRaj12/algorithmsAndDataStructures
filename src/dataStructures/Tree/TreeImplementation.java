package dataStructures.Tree;

import java.sql.SQLOutput;

class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data = data;
        right = null;
        left = null;
    }
}
public class TreeImplementation {
    static Node root;
    public static void main(String[] args) {
        Node node = root;
        for(int i=1;i<=10;i++){
            Node temp = node;
            createNodes(temp,i);
        }
    }

    public static void createNodes(Node node,int data){
        if(node == null){
            node = new Node(data);
        }
        else
        {
            createChildElements(node,data);
        }
    }

    private static void createChildElements(Node node, int data) {
        if(node.data > data){
            insertRight(node.right,data);
        }
        if(node.data < data){
            insertLeft(node,data);
        }
    }

    public static void insertRight (Node node, int data){
        if (node == null)
            node = new Node(data);
        else
            if(node.data > data){
                insertRight(node.right,data);
            }
    }
    public static void insertLeft (Node node, int data){
       node.left = new Node(data);
    }

    public static void printInorderTraversal(Node root) {
            if (root == null){
                return;
            }
            printInorderTraversal(root.left);

            System.out.print(root.data+"->");

            printInorderTraversal(root.right);
    }

    public static void printPostOrderTraversal(Node root){
        if(root == null)
            return;
        printPostOrderTraversal(root.left);

        printPostOrderTraversal(root.right);

        System.out.print(root.data+"->");
    }

    public static void printPreOrderTraversal(Node root){
        if(root == null)
            return;
        System.out.print(root.data+"->");

        printPostOrderTraversal(root.left);

        printPostOrderTraversal(root.right);
    }
}
