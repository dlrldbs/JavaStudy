package basic;

//1~45 범위의 난수를 6개 제공받아 출력하는 프로그램
// => 6개 난수는 서로 중복되지 않도록 작성하며 오름차순 정렬하여 출력
//정렬(Sort) : 값을 순서대로 나열하는 기능 - 오름차순 정렬(AscendingSort), 내림차순 정렬(DescendingSort)
public class LottoApp {
	public static void main(String[] args) {
		//6개의 정수난수를 저장하기 위한 배열 선언
		int[] lotto=new int[6];
		
		//1~45 범위의 정수난수를 6개 제공받아 배열 요소에 차례대로 저장
		// => 중복된 난수값이 아닌 경우에만 배열 요소에 저장
		for(int i=0;i<lotto.length;i++) {//새로운 난수값을 저장하는 배열 요소의 첨자 표현
			//요소에 저장된 새로운 난수값을 기존 요소의 난수값과 모두 비교하여 같은 값이 있는
			//반복문을 이용하여 새로운 난수값을 제공받아 배열 요소에 저장
			// => 새로운 난수값이 기존 요소의 난수값과 다른 경우 반복문 종료
			while(true) {//정상적인 값이 입력된 경우 반복문 종료 - 입력값 검증
				//1~45범위의 난수를 제공받아 배열 요소에 저장
				lotto[i]=(int)(Math.random()*45)+1;
					
				//중복상태를 저장하기 위한 변수
				// => false : 미중복, true : 중복
				boolean result=false;
				
				//새로운 난수값을 기존 배열 요소의 난수값과 비교
				for(int j=0;j<i;j++) {//기존 난수값이 저장된 배열 요소의 첨자 표현 
					if(lotto[i]==lotto[j]) {//lotto[i] : 새로운 난수값, lotto[j] : 기존 난수값
						result=true;
						break;
					}
				}
				
				//새로운 난수값이 기존 난수값과 비교하여 중복되지 않은 경우 반복문 종료
				if(!result) break;
			}
		}
		
		//배열의 모든 요소값을 서로 비교하여 오름차순 정렬되도록 배열 요소값을 바꾸어 저장
		// => 선택 정렬 알고리즘(Selection Sorting Algorithm) 사용
		for(int i=0;i<lotto.length-1;i++) { //비교 요소의 첨자 표현: 처음 ~ 끝-1
			for(int j=i+1;j<lotto.length;j++) { //피비교 요소의 첨자 표현 ; 비교+1 ~ 끝
				if(lotto[i]>lotto[j]) { //lotto[i] : 비교 요소, lotto[j] : 피비교 요소
					//비교한 요소의 값을 서로 바꾸어 저장
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//배열의 모든 요소값 출력
		System.out.print("행운의 숫자 >> ");
		for(int number:lotto) {
			System.out.print(number+" ");
		}
		System.out.println();
	}
}
