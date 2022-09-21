package basic;

//다차원 배열 : 배열의 모임 - 2차원 배열 : 1차원 배열의 모임
public class DoubleArrayApp {
	public static void main(String[] args) {
		//형식)자료형[][] 참조변수=new 자료형[행갯수][열갯수];
		// => 행갯수 : 2차원 배열에 저장되는 1차원 배열의 갯수
		// => 열갯수 : 1차원 배열에 저장되는 요소(Element)의 갯수
		int[][] num=new int[2][3];
		
		System.out.println("num = "+num);
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1] = "+num[1]);
		System.out.println("========================================================");
		System.out.println("num[0][0] = "+num[0][0]);
		System.out.println("num[0][1] = "+num[0][1]);
		System.out.println("num[0][2] = "+num[0][2]);
		
		System.out.println("num[1][0] = "+num[1][0]);
		System.out.println("num[1][1] = "+num[1][1]);
		System.out.println("num[1][2] = "+num[1][2]);
		System.out.println("========================================================");
		System.out.println("num.length = "+num.length); //1차원 배열의 갯수
		System.out.println("num.length[0] = "+num[0].length); //1차원 배열의 요소 갯수
		System.out.println("num.length[1] = "+num[1].length);
		System.out.println("========================================================");
		for(int i=0;i<num.length;i++) {//행처리 : 1차원 배열의 갯수만큼 반복 처리
			for(int j=0;j<num[i].length;j++) {
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		//int[][] su=new int[][] {{10,20,30},{40,50,60},{70,80,90}}
		int[][] su= {{10,20,30},{40,50,60},{70,80,90}};
		
		for(int[] array:su) {
			for(int number:array) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		//1차원 배열이 없는 2차원 배열 생성
		// => 1차원 배열의 메모리 주소를 저장할 수 있는 참조요소만 생성
		int[][] value=new int[3][];
		
		System.out.println("value = "+value);
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
		
		System.out.println("========================================================");
		//2차원 배열의 참조요소에 1차원 배열을 생성하여 저장
		// => 1차원 배열의 요소의 갯수를 다르게 생성하여 저장 가능 - 가변배열
		value[0]=new int[3];
		value[1]=new int[2];
		value[2]=new int[4];
		
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
		System.out.println("========================================================");
		int[][] doubleArray= {{10,20,30},{40,50,60},{70,80,90}};//가변배열
		
		for(int[] array:doubleArray) {
			for(int number:array) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		
		
	}
}
