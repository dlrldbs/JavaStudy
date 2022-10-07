package xyz.itwill.utill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet=new HashSet<Integer>();
		Random random=new Random();
		
		while (true) {
			//1~45 범위의 난수값을 Set 객체의 요소로 추가하여 저장
			// => Set 객체에 동일한 값의 요소 중복 저장 불가능
			lottoSet.add(random.nextInt(45)+1);
			
			//Set 객체에 저장된 요소의 갯수가 6인 경우 반복문 종료
			if(lottoSet.size()==6) break;
		}
		
		//Set.toArray(E[] a) : Set 객체를 배열로 변환하여 반환하는 메소드
		// => Set 객체에 저장된 모든 요소의 배열을 생성하여 배열 요소에 모두 저장
		Integer[] lotto=lottoSet.toArray(new Integer[0]);
		
		//Arrays.sort(Object[] O) : 매개변수로 배열을 전달받아 배열 요소를 오름차순 정렬하는 메소드
		Arrays.sort(lotto);
		
		//Arrays.toString(Object[] O) : 매개변수로 전달받은 배열의 요소를 문자열로 반환하는 메소드
		System.out.println("행운의 숫자 = "+Arrays.toString(lotto));
		
	}
}
