import java.util.Scanner;
public class Polynomial{
	public static void main(String[]args){
		//first poly
		Scanner input=new Scanner(System.in);
		System.out.println("please input the highlest power:");
		int firstP=input.nextInt();
		int aPoly[]=new int[firstP+1];
		System.out.println("please input the power and number:");
		//fill first polynomial
		while(true){
			int i=input.nextInt();
			int element=input.nextInt();
			aPoly[i]=element;
			if(i==0)
				break;
		}
		
		//second poly
		System.out.println("please input the highlest power:");
		int secP=input.nextInt();
		int bPoly[]=new int[secP+1];
		System.out.println("please input the power and number:");
		//fill second polynomial
		while(true){
			int i=input.nextInt();
			int element=input.nextInt();
			bPoly[i]=element;
			if(i==0)
				break;
		}
		System.out.println("please input number for x=?");
		int answer=input.nextInt();
		
		//call three method
		sumOfpoly(firstP,secP,aPoly,bPoly,answer);
		subOfpoly(firstP,secP,aPoly,bPoly,answer);
		mulOfpoly(firstP,secP,aPoly,bPoly,answer);
	}
	
	/**The sum of two Polynomial*/
	public static void sumOfpoly(int firstP,int secP,int aPoly[],int [] bPoly,int answer){
		int maxTerm=Math.max(firstP,secP);
		int sumC []=new int [maxTerm+1];
		
		for(int i=0;i<maxTerm+1;i++){
			//aPoly is larger
			if(firstP>secP){
				if(i<=secP){
					sumC[i]=aPoly[i]+bPoly[i];
				}
				else if(i>secP){
					sumC[i]=aPoly[i];
				}
			}
			//bPoly is larger
			else if(firstP<secP){
				if(i<=firstP){
					sumC[i]=aPoly[i]+bPoly[i];
				}
				else if(i>firstP){
					sumC[i]=bPoly[i];
				}
			}
			else{
				sumC[i]=aPoly[i]+bPoly[i];
			}
		}
		//summation of polynomial
		System.out.println("The sum of two Polynomial:");
		for(int i=sumC.length-1;i>-1;i--){
			if(sumC[i]!=0){
				if(i>0)
					System.out.print("("+sumC[i]+")x^"+i+"+");
				else
					System.out.println("("+sumC[i]+")");
			}
		}
		//the answer of summation
		int sumAnswer=0;
		for(int i=0;i<sumC.length;i++){
			sumAnswer+=sumC[i]*(int)Math.pow(answer,i);
		}
		System.out.println("The answer is:"+sumAnswer);
		System.out.println();
	}
	
	/**The subtraction of two Polynomial*/
	public static void subOfpoly(int firstP,int secP,int aPoly[],int [] bPoly,int answer){
		int maxTerm=Math.max(firstP,secP);
		int subC []=new int [maxTerm+1];
		
		for(int i=0;i<maxTerm+1;i++){
			//aPoly is larger
			if(firstP>secP){
				if(i<=secP){
					subC[i]=aPoly[i]-bPoly[i];
				}
				else if(i>secP){
					subC[i]=aPoly[i];
				}
			}
			//bPoly is larger
			else if(firstP<secP){
				if(i<=firstP){
					subC[i]=aPoly[i]-bPoly[i];
				}
				else if(i>firstP){
					subC[i]=-bPoly[i];
				}
			}
			else{
				subC[i]=aPoly[i]+bPoly[i];
			}
		}
		//The subtraction of polynomial
		System.out.println("The subtraction of two Polynomial:");
		for(int i=subC.length-1;i>-1;i--){
			if(subC[i]!=0){
				if(i>0)
					System.out.print("("+subC[i]+")x^"+i+"+");
				else
					System.out.println("("+subC[i]+")");
			}
		}
		//The answer of subtraction
		int subAnswer=0;
		for(int i=0;i<subC.length;i++){
			subAnswer+=subC[i]*(int)Math.pow(answer,i);
		}
		System.out.println("The answer is:"+subAnswer);
		System.out.println();
	}
	
	/**The multiple of two Polynomial*/
	public static void mulOfpoly(int firstP,int secP,int aPoly[],int [] bPoly,int answer){
		int maxTerm=firstP+secP;
		int mulC []=new int [maxTerm+1];
		//let every element multiple
		for(int i=0;i<aPoly.length;i++){
			for(int j=0;j<bPoly.length;j++){
				mulC[i+j]+=aPoly[i]*bPoly[j];
			}
		}
		//The multiple of polynomial
		System.out.println("The multiple of two Polynomial:");
		for(int i=mulC.length-1;i>-1;i--){
			if(mulC[i]!=0){
				if(i>0)
					System.out.print("("+mulC[i]+")x^"+i+"+");
				else
					System.out.println("("+mulC[i]+")");
			}
		}
		//The answer of multiple
		int mulAnswer=0;
		for(int i=0;i<mulC.length;i++){
			mulAnswer+=mulC[i]*(int)Math.pow(answer,i);
		}
		System.out.println("The answer is:"+mulAnswer);
		System.out.println();
	}
}