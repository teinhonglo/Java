/**Binary Search Tree in non-recursive*/
import java.util.Scanner;
import java.util.Stack;
public class BinaryTree_NR {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("How many number do you want?");
		int size=input.nextInt();
		int numTree []=new int[(int)Math.pow(2, size)];
		boolean storage []=new boolean[(int)Math.pow(2, size+1)];
		System.out.println("Please input number:");
		//input number
		for(int i=0;i<size;i++){
			int num=input.nextInt();
			for(int j=1;j<numTree.length;){
				int temp=j;
				if(!storage[j]){
					numTree[j]=num;
					storage[j]=true;
					break;
				}
				else if (storage[j]){
					if(num<numTree[j])
						j*=2;
					else if(num>numTree[j])
						j=j*2+1;
					else
						j*=2;
				}
			}
		}
		//print tree
		int chLine=1;
		int tab=15;
		int countPrNum=0;
		boolean space=true;
		int i=1;
		for(;i<numTree.length;i++){
			if(space){
				for(int j=0;j<tab;j++){
					System.out.print("  ");
				}
				space=false;
			}
			if(storage[i]){
				System.out.print(numTree[i]+" ");
				countPrNum++;
			}	
			else
				System.out.print("x");
			
			
			if(i==(int)Math.pow(2,chLine)-1){
				System.out.println();
				chLine++;
				tab--;
				space=true;
				if(countPrNum==size)
					break;
			}
		}
		System.out.print("\n");
		System.out.print("Inorder:");
		inorder (storage,numTree,size,1);
		System.out.print("\n");
		System.out.print("Preorder:");
		preorder (storage,numTree,size,1);
		System.out.print("\n");
		System.out.print("Postorder:");
		postorder (storage,numTree,size,1);
	}
	//LVR
	static void inorder (boolean storage[],int numTree[],int size,int curIndex){
		Stack <Integer> inorder=new Stack<Integer>();
		boolean stoInorder []=new boolean[storage.length];
		for(int i=1;i<storage.length;i++){
			stoInorder[i]=storage[i];
		}
		inorder.push(curIndex);
		int prCount=0;
		int lfChild;
		while(true){
			if(prCount==size)
				break;
			lfChild=inorder.pop();
				if(stoInorder[lfChild*2]){
					inorder.push(lfChild);
					inorder.push(lfChild*2);
					continue;
				}
				else{
					if(stoInorder[lfChild]){
						System.out.print(numTree[lfChild]+" ");
						stoInorder[lfChild]=false;
						prCount++;
						if(stoInorder[lfChild*2+1])
							inorder.push(lfChild*2+1);
					}
				}
		}
	}
	//VLR
	static void preorder (boolean storage[],int numTree[],int size,int curIndex){
		Stack <Integer> preorder=new Stack<Integer>();
		boolean stoPreorder []=new boolean[storage.length];
		for(int i=1;i<storage.length;i++){
			stoPreorder[i]=storage[i];
		}
		preorder.push(curIndex);
		int prCount=0;
		int lfChild;
		while(true){
			if(prCount==size)
				break;
			lfChild=preorder.pop();
				if(stoPreorder[lfChild*2]==false&&stoPreorder[lfChild*2+1]==false){
					System.out.print(numTree[lfChild]+" ");
					stoPreorder[lfChild]=false;
					prCount++;
					continue;
				}
				else{
					System.out.print(numTree[lfChild]+" ");
						prCount++;
					if(stoPreorder[lfChild*2+1])
						preorder.push(lfChild*2+1);
					if(stoPreorder[lfChild*2])
						preorder.push(lfChild*2);
				}
		}
	}
	//RVL
	static void postorder (boolean storage[],int numTree[],int size,int curIndex){
		Stack <Integer> postorder=new Stack<Integer>();
		boolean stoPostorder []=new boolean[storage.length];
		for(int i=1;i<storage.length;i++){
			stoPostorder[i]=storage[i];
		}
		postorder.push(curIndex);
		int prCount=0;
		int lfChild;
		while(true){
			if(prCount==size)
				break;
			lfChild=postorder.pop();
				if(stoPostorder[lfChild*2]==false&&stoPostorder[lfChild*2+1]==false){
					System.out.print(numTree[lfChild]+" ");
					stoPostorder[lfChild]=false;
					prCount++;
					continue;
				}
				else{
					postorder.push(lfChild);
					if(stoPostorder[lfChild*2+1]){
						postorder.push(lfChild*2+1);
					}
					if(stoPostorder[lfChild*2]){
						postorder.push(lfChild*2);
					}
				}
		}
	}
}
