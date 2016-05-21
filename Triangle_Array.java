import java.util.Scanner;

public class Triangle_Array {
	public static void main (String[] args) {
		System.out.println("please enter the number of the row ");
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();//decide the volume of array
				
		int list[][]=new int[num][num];
		list[0][0]=1;//define initial value
		
		for(int i=1;i<num;i++)
			for(int j=0;j<=i;j++){
				if(j==0)
					list[i][j]=list[i-1][i-1];//changle line first number
				else
					list[i][j]=list[i][j-1]+list[i-1][j-1];//add left and the upper left
			}
		
		int recordNum=-1;//record satisfy requre of changle line of print
		
		for(int i=0;i<num;i++)
			for(int j=0;j<num;j++){
				if(list[i][j]==0)
					continue;//just not print zero
				
				if(list[i][j]==recordNum)
					System.out.println("");//changle line
				
				System.out.print(+list[i][j]+" ");
				recordNum=list[i][j];//record requre num
			}
	}
}