package dataStructures.Tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class LevelOrderTraversal {
    static Node root;

    public static void main(String[] args) {
        Node node = root;
        node = new Node(1);
        System.out.println("InOrder Traversal");
        TreeImplementation.printInorderTraversal(node);
        System.out.println("Level Order Traversal");
        Node node1 = node;
        levelOrderTraversal(node1);
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        Node tempNode = node;
        int left = 0;
        int right = 0;
        while(tempNode != null){
            System.out.print(tempNode.data);
            if(tempNode.left != null){
                queue.add(tempNode.left);
                left++;
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
                right++;
            }
            tempNode = queue.poll();
        }
        System.out.println("Left :"+left+"right:"+right);
        System.out.println(Math.max(left,right));
    }

}