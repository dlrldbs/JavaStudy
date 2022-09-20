package basic;

//continue : 반복문에서 명령을 처음부터 다시 실행하기 위한 반복문
// => continue 명령 아래에 작성된 명령을 실행하지 않고 처음부터 다시 실행

public class ContinueApp {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			if(i==3) continue; //for(int i=1;i<=5;i++) 반복문 재실행
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("===========================================");
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) continue loop; //for(int i=1;i<=5;i++) 반복문 재실행
				System.out.println("i = "+i+", j = "+j);
			}			
		}		
		System.out.println("===========================================");
		
		
	}
}
