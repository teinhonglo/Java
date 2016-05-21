/**Binary Search Tree in recursive*/
import java.util.Scanner;
public class BinaryTree {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("How many number do you want?");
		int size=input.nextInt();
		int numTree []=new int[(int)Math.pow(2, size)];
		boolean storage []=new boolean[(int)Math.pow(2, size)];
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
		inorder (storage,numTree,1);
		System.out.print("\n");
		System.out.print("Preorder:");
		preorder (storage,numTree,1);
		System.out.print("\n");
		System.out.print("Postorder:");
		postorder (storage,numTree,1);
	}
	static void inorder (boolean storage[],int numTree[],int curIndex){
		if(curIndex*2+1<storage.length){
			if(storage[curIndex*2]==false&&storage[curIndex*2+1]==false){
					if(storage[curIndex])
						System.out.print(numTree[curIndex]+" ");
			}	
			else {
				inorder(storage,numTree,curIndex*2);
				System.out.print(numTree[curIndex]+" ");
				inorder(storage,numTree,curIndex*2+1);
			}
		}
		else{
			if(storage[curIndex])
				System.out.print(numTree[curIndex]+" ");
		}
	}
	
	static void preorder (boolean storage[],int numTree[],int curIndex){
		if(curIndex*2+1<storage.length){
			if(storage[curIndex*2]==false&&storage[curIndex*2+1]==false){
					if(storage[curIndex])
						System.out.print(numTree[curIndex]+" ");
			}	
			else {
				System.out.print(numTree[curIndex]+" ");
				preorder(storage,numTree,curIndex*2);
				preorder(storage,numTree,curIndex*2+1);
			}
		}
		else{
			if(storage[curIndex])
				System.out.print(numTree[curIndex]+" ");
		}
	}
	
	static void postorder (boolean storage[],int numTree[],int curIndex){
		if(curIndex*2+1<storage.length){
			if(storage[curIndex*2]==false&&storage[curIndex*2+1]==false){
					if(storage[curIndex])
						System.out.print(numTree[curIndex]+" ");
			}	
			else {
				postorder(storage,numTree,curIndex*2);
				postorder(storage,numTree,curIndex*2+1);
				System.out.print(numTree[curIndex]+" ");
			}
		}
		else{
			if(storage[curIndex])
				System.out.print(numTree[curIndex]+" ");
		}
	}
}