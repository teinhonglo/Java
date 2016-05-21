import java.util.Scanner;
import java.util.Stack;
public class MazingProblem {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Array Size ?");
		int arrHeight=input.nextInt();
		int arrWidth=input.nextInt();
		int maze [][]=new int [arrHeight+2][arrWidth+2];
		System.out.println("Start and End?");
		int startX=input.nextInt();
		int startY=input.nextInt();
		int endX=input.nextInt();
		int endY=input.nextInt();
		
		for(int row=0;row<maze.length;row++)
			for(int column=0;column<maze[row].length;column++){
				if(row==0||row==maze.length-1||column==0||column==maze[row].length-1)
					maze[row][column]=1;
				else
					maze[row][column]=(int)(Math.random()*2);
			}
		maze [startX][startY]=0;
		maze [endX][endY]=0;
		
		printArray(maze);
		path(startX,startY,endX,endY,maze);
		printArray(maze);
	}
	// height
	static void printArray(int maze[][]){
		
		for(int row=0;row<maze.length;row++){
			System.out.println();
			for(int column=0;column<maze[row].length;column++){
				switch (maze[row][column]){
					case 0 : System.out.print(0+" ");break;
					case 1 : System.out.print(1+" ");break;
					case 3 : System.out.print('M'+" ");break;
					case 4 : System.out.print('X'+" ");
				}
			}	
		}
		System.out.println();
	}
	
	static void path(int startX,int startY,int endX,int endY,int maze[][]){
		//best path
		Stack<Integer> beforeRows=new Stack<Integer>();
		Stack<Integer> beforeCols=new Stack<Integer>();
		Stack<String> beforeDir=new Stack<String>();
		//try path
		Stack<Integer>pathRows=new Stack<Integer>();
		Stack<Integer> pathCols=new Stack<Integer>();
		Stack<String> pathDir=new Stack<String>();
		
		int nextX=0;
		int nextY=0;
		int count=0;
		//creat eight direction
		direction [] dirs;
		dirs=new direction [8];
		
		for(int i=0;i<8;i++){
			 dirs[i]=new direction();
		}
		//North
		dirs[0].vert=-1;
		dirs[0].horiz=0;
		dirs[0].dir="N";
		//Northeast
		dirs[1].vert=-1;
		dirs[1].horiz=1;
		dirs[1].dir="NE";
		//East
		dirs[2].vert=0;
		dirs[2].horiz=1;
		dirs[2].dir="E";
		//Southeast
		dirs[3].vert=1;
		dirs[3].horiz=1;
		dirs[3].dir="SE";
		//South
		dirs[4].vert=1;
		dirs[4].horiz=0;
		dirs[4].dir="S";
		//Southwest
		dirs[5].vert=1;
		dirs[5].horiz=-1;
		dirs[5].dir="SW";
		//West
		dirs[6].vert=0;
		dirs[6].horiz=-1;
		dirs[6].dir="W";
		//Northwest
		dirs[7].vert=-1;
		dirs[7].horiz=-1;
		dirs[7].dir="NW";
		
		int startDir=0;
		
		if(endX-startX==0&&endY-startY>0)
			startDir=2;
		else if (endX-startX>0&&endY-startY>0)
			startDir=3;
		else if (endX-startX>0&&endY-startY==0)
			startDir=4;
		else if (endX-startX>0&&endY-startY<0)
			startDir=5;
		else if (endX-startX==0&&endY-startY<0)
			startDir=6;
		else if (endX-startX<0&&endY-startY<0)
			startDir=7;
		else if (endX-startX<0&&endY-startY==0)
			startDir=0;
		else if (endX-startX<0&&endY-startY>0)
			startDir=1;
		
		int row=startX;
		int column=startY;
		maze[row][column]=3;
		while(count!=9){
			if(row==endX&&column==endY)
				break;
				for(int a=startDir;a<startDir+8;a++){
					int i=a%8;
					if(row==endX&&column==endY){
						maze[row][column]=3;
						break;
					}	
					if(maze[row+dirs[i].vert][column+dirs[i].horiz]==0){
						row+=dirs[i].vert;
						column+=dirs[i].horiz;
						maze[row][column]=3;
						beforeRows.push(row);
						beforeCols.push(column);
						beforeDir.push(dirs[i].dir);
						pathRows.push(row);
						pathCols.push(column);
						pathDir.push(dirs[i].dir);
						count=0;
						break;
					}
					else if(maze[row+dirs[i].vert][column+dirs[i].horiz]!=0){
						count++;
					}
					if(count==9&&!beforeRows.isEmpty()){
						maze[row][column]=4;
						row=beforeRows.pop();
						column=beforeCols.pop();
						pathDir.push(beforeDir.pop());
						pathRows.push(row);
						pathCols.push(column);
						//maze[row][column]=4;
						i=0;
						count=0;
					}
					if(count==9&&beforeRows.isEmpty()){
						break;
					}
				}
		}
		System.out.println();
		System.out.println("The best path:");
		printStack(beforeRows,beforeCols,beforeDir);
		System.out.println("Try path:");
		printStack(pathRows,pathCols,pathDir);
		
	} 
	static void printStack(Stack<Integer> rows,Stack<Integer> cols,Stack<String> dirs){
		String pathString=" ";
		while(!dirs.isEmpty()){
			pathString="("+dirs.pop()+","+rows.pop()+","+cols.pop()+")"+" "+pathString;
		}
		System.out.println(pathString);
	}
}
class direction{
	public int vert=0;
	public int horiz=0;
	public String dir;
}
