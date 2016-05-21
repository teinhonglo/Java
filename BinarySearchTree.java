import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearchTree {
    private static Node<Integer> creatLink() {
    	Scanner input=new Scanner(System.in);
	System.out.println("Please input 15 number: ");
        Node<Integer> [] Tnode =new Node [15];
        //initialize Object array
        for(int i=0;i<15;i++){
        	int usrnode=input.nextInt();
        	Tnode[i]=new Node (usrnode);
        }
        for(int i=1;i<15;i++){
        	Node parent=Tnode[0];
        	linkMethod(Tnode[0],Tnode[i]);
        }
        return Tnode[0];
    }
    /**link function*/
    public static void linkMethod(Node<Integer> Tnode,Node <Integer>compare){
    	if(compare.data>=Tnode.data){
    		if(Tnode.right==null)
    			Tnode.right=compare;
    		else
    			linkMethod(Tnode.right,compare);
    	}
    	else if(compare.data<Tnode.data){
    		if(Tnode.left==null)
    			Tnode.left=compare;
    		else
    			linkMethod(Tnode.left,compare);
    	}
    }
    //Three Traversal of tree 
    public static <T extends Comparable<?>> void inorder(Node<T> root){
    	if(root.left!=null) inorder(root.left);
    	System.out.print(root.data+" ");
    	if(root.right!=null) inorder(root.right);
    }
    public static <T extends Comparable<?>> void preorder(Node<T> root){
    	System.out.print(root.data+" ");
    	if(root.left!=null) preorder(root.left);
		if(root.right!=null) preorder(root.right);
    }
    public static <T extends Comparable<?>> void postorder(Node<T> root){
    	if(root.left!=null) postorder(root.left);
		if(root.right!=null) postorder(root.right);
		System.out.print(root.data+" ");
    }
  
    /**main function*/
    public static void main(String[] args) {
    	Node <Integer> root=creatLink();
    	BTreePrinter.printNode(root);
    	System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
    }
}
/**Node data class*/
class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;
    public Node(T data) {
        this.data = data;
    }
}
/**Print binary search tree*/
class BTreePrinter {
    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}