//Paramveer Singh
//O(n^3)

import java.util.*;

public class cmsc401 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rodSize = sc.nextInt();
		int j = 0;
		int counter = 0;
		int numCuts = sc.nextInt();
		numCuts += 2;
		int[] cuts = new int[numCuts];
		int[][] m = new int [numCuts][numCuts];
		cuts[0] = 0;
		for(int i = 1; i < cuts.length-1;i++) {
			cuts[i] = sc.nextInt();
		}
		cuts[numCuts-1] = rodSize;
		int p1,p2,min = 0;
		int n = cuts.length -1;
		//		for(int i = 0; i < cuts.length; i++) {	
		//			m[i][i] = 0;
		//		}
		for(int k = 2; k <= n; k++) {
			int i = 0;
			//	System.out.println("k " + k);
			for(j = k; j<= n ; j++) {
				int e = Integer.MAX_VALUE;
				for(int z = (j-1); z >(j-k); z--) {
					//	System.out.println("i " + i);
					//		System.out.println("j " + j);
					//		System.out.println("z " + z);
					p1 = m[i][z];
					p2 = m[z][j];
					int thisRod = (Math.abs(cuts[j]-cuts[i]));
					min = p1 + p2 + thisRod;
					if(min < e) {
						e = min;
					}
				}
				m[i][j] = e;
				i++;
			}
		}	

		//		for(int i = 0; i <m.length; i++) {
		//			for(j = 0; j<m.length; j++) {
		//			//	System.out.printf("%4d" , m[i][j]);
		//			}
		//		//	System.out.println("\n");
		//		}

		System.out.println(m[0][cuts.length-1]);
		//sc.close();
	}
}