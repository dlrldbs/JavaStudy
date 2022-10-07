package xyz.itwill.utill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List 인터페이스를 상속받은 자료구조 클래스 - ArrayList, Vector, LinkedList 등
// => List 객체는 요소를 차례대로 저장 - 첨자(Index)를 이용하여 요소를 구분하여 처리
public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : List 객체에 요소를 추가하는 메소드
		list.add("Gildong");
		list.add("Gguckjeong");
		list.add("Wuchi");
		list.add("Jimae");
		
		//List.toString() : List 객체에 저장된 모든 요소를 문자열로 변환하여 반환하는 메소드
		//System.out.println("list.String()"+list.String());
		System.out.println("list = "+list);
		System.out.println("===============================================================");
		//List 객체에는 동일한 값의 객체 요소 저장
		list.add("Gguckjeong");
		System.out.println("list = "+list);
		System.out.println("===============================================================");
		//List.size() : list 객체에 저장된 요소의 갯수를 반환하는 메소드
		System.out.println("요소의 갯수 = "+list.size());
		System.out.println("===============================================================");
		//List.get(int index) : list 객체에 저장된 요소 중 첨자 위치의 요소를 반환하는 메소드
		System.out.println("list = "+list.get(2));
		System.out.println("===============================================================");
		//List.add(int index, E element) : List 객체에 원하는 첨자 위치에 요소를 삽입하는 메소드
		list.add(4,"Gilsan");
		System.out.println("list = "+list);
		System.out.println("===============================================================");
		//List.remove(E element) : List 객체에 저장된 요소를 제거하는 메소드
		// => 매개변수로 전달받은 객체와 같은 요소가 여러개인 경우 첫번째 요소만 제거
		//list.remove("Gguckjeong");
		
		//List.remove(int index) : List 객체에서 원하는 첨자 위치의 요소를 제거하는 메소드
		list.remove(5);
		System.out.println("list = "+list);
		System.out.println("===============================================================");
		//List.set(int index, E element) : List 객체에서 원하는 첨자 위치의 요소를 변경하는 메소드
		list.set(1,"Guckjeong");
		System.out.println("list = "+list);
		System.out.println("===============================================================");
		//List 객체에 저장된 요소에 대한 일괄 처리 - 일반 for 구문 사용
		// => IndexOutOfBoundsException 발생 가능
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("===============================================================");
		//List 객체에 저장된 요소에 대한 일괄 처리 - Iterator 객체 사용
		//List.Iterator() : List 객체에 저장된 요소를 반복 처리할 수 있는 Iterator 객체를 반환
		Iterator<String> iterator=list.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("===============================================================");
		//List 객체에 저장된 요소에 대한 일괄 처리 - 향상된 for 구문 사용 **
		for(String str:list) {
			System.out.print(str+" ");
		}
		System.out.println();
		System.out.println("===============================================================");
		//Collections 클래스 : 자료구조 관련 클래스의 객체 요소에 대한 처리 기능을 메소드로 제공하는 클래스
		//Collections.sort(List<E> list) : List 객체의 요소를 정렬하는 메소드
		Collections.sort(list); 
		
		System.out.println("list = "+list);
		System.out.println("===============================================================");
		//List.clear() : List 객체에 저장된 모든 요소를 제거하는 메소드
		list.clear();
		
		//List.isEmpty() : List 객체에 저장된 요소가 하나도 없는 경우 [true]를 반환하는 메소드
		if(list.isEmpty()) {
			System.out.println("List 객체에 저장된 요소가 없습니다.");
		}
		System.out.println("===============================================================");
		//Array.asList(E... element) : 0개 이상의 요소가 저장된 List 객체를 생성하여 반환하는 메소드 
		List<Integer> numberList=Arrays.asList(10,20,30,40,50);
		System.out.println("numberList = "+numberList);
		System.out.println("===============================================================");
		
	}
}
