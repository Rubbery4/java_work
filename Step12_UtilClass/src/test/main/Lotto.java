package test.main;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int[] lottonum = new int[6];
		
		System.out.print("로또를 몇개 구입하시겠어요 :");
		int num1 = scan.nextInt();
		for (int n=0; n<num1; n++) {	
		for(int i=0; i<lottonum.length; i++) {
			lottonum[i] = ran.nextInt(45)+1;
			for(int j=0; i<j; j++) {
				if(lottonum[i]==lottonum[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<lottonum.length; i++) {
			for(int j=i+1; j<lottonum.length; j++) {
				if(lottonum[i] > lottonum[j]) {
					int tmp = lottonum[i];
					lottonum[i] = lottonum[j];
					lottonum[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(lottonum));
		}
	}
}
