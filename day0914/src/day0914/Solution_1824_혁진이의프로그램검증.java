package day0914;

import java.util.Scanner;

public class Solution_1824_혁진이의프로그램검증 {
	static int memory;
	static int R, C;
	static char[][] command;
	static int[][] memmap;
	static boolean finish;
	static int dx[]= {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static int x,y;
	static int dir;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0;  t<= T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			command = new char [R][C];
			memmap = new int [R][C]; // save the memory value that moment 
			sc.next();
		for (int i = 0; i < R; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < C; j++) {
				command[i][j]=s.charAt(j);
			}
		}
		
		finish = false;
		memory =0; 
		x=0; y=0;
		dir = 0;
		while(true) {
			order(x,y); // do the command .	
			if(finish) break;
			else if(memmap[x][y]!=0 && memmap[x][y]==memory) {
				break;
			}
			else {
				memmap[x][y]=memory;
			}
			x=(x + dx[dir])%16;//16 -> 0 
			y=(y + dy[dir])%16;
			if(x==-1) 
				x= 15;
			if(y==-1)
				y=15;	
			
			
		}		
		String ans = "NO";
		if(finish) { //if command is finished well,, 
			ans = "YES";
		}
		System.out.println("#"+t+" "+ans);
		}
	}// main 

	private static void order(int x,int y) {		
		char order = command[x][y];
		switch(order){
		case '^':
			dir=1;
			break;
		case '>':
			dir =0;
			break;
		case 'V':
			dir = 3;
			break;
		case '<':
			dir = 2;
			break;
		case '?': // how can I handle it ? 
			break;
		case '_':
			if(memory==0)
				dir =0;
			else
				dir=2;
			break;
		case '|':
			if(memory==0)
				dir =3;
			else
				dir=1;
			break;
		case '.': //pass
			break;
		case '+':
			memory++;
			if(memory==16)
				memory=0;
			break;
		case '-':
			memory--;
			if(memory==-1)
				memory=15;
			break;
		case '@':
			finish = true;
			break;		
		default : // the case it is number, save the num
			memory = order;
			break;		
		}
		
	}
}
