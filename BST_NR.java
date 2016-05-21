import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BST_NR {
    private static Node<Integer> creatLink() {
	System.out.println("Please input 15 number:");
    	Scanner input=new Scanner(System.in);
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
    	Stack <Node>inorder=new Stack();
    	inorder.push(root);
    	Node cur;
    	while(!inorder.isEmpty()){
    		cur=inorder.pop();
    		if(cur.right!=null)
    			inorder.push(cur.right);
    		if(cur.left!=null){
    			Node tem=new Node(cur.data);
    			inorder.push(tem);
    			inorder.push(cur.left);
    		}
    		else
    			System.out.print(cur.data+" ");
    	}
    }
    public static <T extends Comparable<?>> void preorder(Node<T> root){
    	Stack <Node>preorder=new Stack();
    	preorder.push(root);
    	Node cur;
    	while(!preorder.isEmpty()){
    		cur=preorder.pop();
    		System.out.print(cur.data+" ");
    		if(cur.right!=null)
    			preorder.push(cur.right);
    		if(cur.left!=null)
    			preorder.push(cur.left);	
    	}
    }
    public static <T extends Comparable<?>> void postorder(Node<T> root){
    	Stack <Node>postorder=new Stack();
    	postorder.push(root);
    	Node cur;
    	while(!postorder.isEmpty()){
    		cur=postorder.pop();
    		
    		if(cur.right==null&&cur.left==null){
    			System.out.print(cur.data+" ");
    		}
    		else{
    			Node tem=new Node(cur.data);
    			postorder.push(tem);
	    		if(cur.right!=null)
	    			postorder.push(cur.right);
	    			
	    		if(cur.left!=null)
	    			postorder.push(cur.left);
    		}
    	}
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