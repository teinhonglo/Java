import java.util.Scanner;
import java.util.LinkedList;
public class Polynomial_list{
/**main function*/
	public static void main(String[]args){
		//first poly
		LinkedList<Integer> polyList=new LinkedList<Integer>() ;			//storage coefficient of polynomial
		LinkedList<Integer> powerList=new LinkedList<Integer>() ;			//storage power of polynomial
		
		System.out.println("please input first Polynomial: ");
		int firstPolyLength=0;					//record the wall between the two polynomial
		Scanner input=new Scanner(System.in);
		//fill first polynomial
		while(true){
			int power=input.nextInt(); 			//power of polynomial
			int coef=input.nextInt();	 		// coefficient of polynomial
			powerList.addLast(power) ;
			polyList.addLast(coef);
			firstPolyLength++;
			if(power==0)
				break;					//power=0,break
		}
		//fill second polynomial
		System.out.println("please input second Polynomial: ");
		while(true){
			int power=input.nextInt(); 		//power of polynomial
			int coef=input.nextInt();	 	// coefficient of polynomial
			powerList.addLast(power) ;
			polyList.addLast(coef);
			if(power==0)
				break;						//power=0,break
		}
		//input x=?
		System.out.println("please input number for x=?");
		int answer=input.nextInt();						
		int tail=powerList.size();						//record two polynomial last index
		//call three method		my list(power and coefficient):firstPoly+secondPoly+summation+subtraction+multiply
		sumOfpoly(polyList,powerList,firstPolyLength,answer,tail);
		subOfpoly(polyList,powerList,firstPolyLength,answer,tail);
		mulOfpoly(polyList,powerList,firstPolyLength,answer,tail);
	}
	
	/**The sum of two Polynomial*/
	public static void sumOfpoly(LinkedList <Integer> polyList,LinkedList<Integer> powerList,int firstPolyLength,int answer,int tail){
		//add first in summation section
		polyList.addLast(polyList.getFirst());
		powerList.addLast(powerList.getFirst());
		//summation
		for(int i=1;i<tail;i++){
			for(int j=tail;j<powerList.size();j++){
				if(powerList.get(i)<powerList.get(j)){
					//if nothing above your power until up to summation tail,then add the last of summation section
					if(j==powerList.size()-1){
						polyList.addLast(polyList.get(i));
						powerList.addLast(powerList.get(i));
						break;
					}
					else
						continue;
				}
				//if power equal,then coefficient adding together
				else if(powerList.get(i)==powerList.get(j)){
					polyList.set(j,polyList.get(i)+polyList.get(j));
					break;
				}
				//if power larger than current power,then coefficient adding before current index
				else if(powerList.get(i)>powerList.get(j)){
					polyList.add(j,polyList.get(i));
					powerList.add(j,powerList.get(i));
					break;
				}
			}
		}
		//print the summation of polynomial
		int sum=0;
		System.out.println("The summation of polynomail is :");
		for(int i=tail;i<powerList.size();i++){
			if(polyList.get(i)!=0){
				if(powerList.get(i)>0)
				System.out.print("("+polyList.get(i)+"X^"+powerList.get(i)+")+");
			}
			if(powerList.get(i)==0)
				System.out.print("("+polyList.get(i)+")");
			
			sum+=polyList.get(i)*Math.pow(answer, powerList.get(i));
		}
		System.out.println();
		System.out.println("The answer is: "+sum);
		System.out.println();
	}
	
	/**The subtraction of two Polynomial*/
	public static void subOfpoly(LinkedList <Integer> polyList,LinkedList<Integer> powerList,int firstPolyLength,int answer,int tail){
		int subTail=powerList.size();	//get first index of subtraction section
		//add first in subtraction section
		polyList.addLast(polyList.getFirst());
		powerList.addLast(powerList.getFirst());
		//subtraction
		for(int i=1;i<tail;i++){
			for(int j=subTail;j<powerList.size();j++){
				if(powerList.get(i)<powerList.get(j)){
					//if nothing above your power until up to subtraction tail,then add the last of subtraction section
					if(j==powerList.size()-1){
						if(i<firstPolyLength){					
							polyList.addLast(polyList.get(i));
							powerList.addLast(powerList.get(i));
							break;
						}
						//second have,first nothing
						else{									
							polyList.addLast(-polyList.get(i));
							powerList.addLast(powerList.get(i));
							break;
						}	
					}
					else
						continue;
				}
				//if power equal,then coefficient subtracting together
				else if(powerList.get(i)==powerList.get(j)){
					polyList.set(j,polyList.get(j)-polyList.get(i));
					break;
					}
				//if power larger than current power,then coefficient adding before current index
				else if(powerList.get(i)>powerList.get(j)){
					if(i<firstPolyLength){
						polyList.add(j,polyList.get(i));
						powerList.add(j,powerList.get(i));
						break;
					}
					//second have,first nothing
					else{									
						polyList.add(j,-polyList.get(i));
						powerList.add(j,powerList.get(i));
						break;
					}	
				}
			}
		}
		//print the subtraction of polynomial
		int sub=0;
		System.out.println("The subtraction of polynomail is :");
		for(int i=subTail;i<powerList.size();i++){
			if(polyList.get(i)!=0){
				if(powerList.get(i)>0)
				System.out.print("("+polyList.get(i)+"X^"+powerList.get(i)+")+");
			}
			
			if(powerList.get(i)==0)
				System.out.print("("+polyList.get(i)+")");
			
			sub+=polyList.get(i)*Math.pow(answer, powerList.get(i));
		}
		System.out.println();
		System.out.println("The answer is: "+sub);
		System.out.println();
	}
	
	/**The multiply of two Polynomial*/
	public static void mulOfpoly(LinkedList <Integer> polyList,LinkedList<Integer> powerList,int firstPolyLength,int answer,int tail){		
		int mulTail=powerList.size();		//get index of multiply section
		//add first in multiply section
		powerList.addLast(powerList.get(0)+powerList.get(firstPolyLength));
		polyList.addLast(polyList.get(0)*polyList.get(firstPolyLength));
		//multiply
		for(int i=0;i<firstPolyLength;i++){
			for(int j=firstPolyLength;j<tail;j++){
				if(i==0&&j==firstPolyLength)
					j++;								//out of first step
				for(int z=mulTail;z<powerList.size();z++){
					if((powerList.get(i)+powerList.get(j))<powerList.get(z)){
						//if nothing above your power until up to multiply tail,then add the last of multiply section
						if(z==powerList.size()-1){
							powerList.addLast(powerList.get(i)+powerList.get(j));
							polyList.addLast(polyList.get(i)*polyList.get(j));
							break;
						}
						else
							continue;
					}
					//if power equal,then coefficient multiplying together and adding together
					else if((powerList.get(i)+powerList.get(j))==powerList.get(z)){
						polyList.set(z, polyList.get(i)*polyList.get(j)+polyList.get(z));
						break;
					}
					//if power larger than current power,then coefficient adding before current index
					else if((powerList.get(i)+powerList.get(j))>powerList.get(z)){
						powerList.add(z, powerList.get(i)+powerList.get(j));
						polyList.add(z,polyList.get(i)*polyList.get(j));
						break;
					}
						
				}
			}
		}
		
		//print the multiply of polynomial
		int mul=0;
		System.out.println("The multiply of polynomail is :");
		for(int i=mulTail;i<powerList.size();i++){
			if(polyList.get(i)!=0){
				if(powerList.get(i)>0)
					System.out.print("("+polyList.get(i)+"X^"+powerList.get(i)+")+");
			}
			if(powerList.get(i)==0)
				System.out.print("("+polyList.get(i)+")");
			mul+=polyList.get(i)*Math.pow(answer, powerList.get(i));
		}
		System.out.println();
		System.out.println("The answer is: "+mul);
	}
}