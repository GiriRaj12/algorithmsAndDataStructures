package dataStructures.LinkedList;

class Node{
    int data;
    Node next;

    Node(int d){
        this.data = d;
        this.next = null;
    }
}

public class HackerankTest {
     static Node head = new Node(1);
    public static void main(String[] args) {
       createLinkedList();
       createDuplicate();
       Node node = head;
       while(node != null){
           Node node2 = node.next;
           while(node2 != null){
               if(node.data == node2.data){
                   System.out.print(node.data+"->");
               }
               node2 = node2.next;
           }
           node = node.next;
        }
        System.out.println();
       printAfter();
    }

    private static void printAfter() {
        Node node = head;
        while(node != null){
            System.out.print(node.data);
            System.out.print("->");
            node = node.next;
        }
    }


    private static void createDuplicate() {
        Node node = head;
        for(int i=0;i<=3;i++){
            node = node.next;
            if(i == 3){
                Node node1 = new Node(2);
                node1.next = node.next;
                node.next = node1;
            }
        }
    }

    public static void createLinkedList(){
        Node node = head;
        for(int i=1;i<=5;i++){
            Node node1 = new Node(i);
            node.next = node1;
            node = node.next;
        }
    }
}
