package xyz.itwill.utill;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map 인터페이스를 상속받은 자료구조 클래스 - HashMap, Hashtable, TreeMap, Properties 등
// => 이름(Key - 식별자)과 값(Value - 객체)을 하나로 묶어 자료구조 클래스의 객체에 저장하여 사용
// => 엔트리(Entry) : 이름과 값을 하나로 묶어 사용하는 처리 단위
// => 이름을 이용하여 값을 빠르게 검색하여 사용하기 위한 자료구조 클래스

public class MapApp {
	public static void main(String[] args) {
		//Map 인터페이스를 상속받은 자식클래스는 이름과 값에 대한 제네릭을 2개 전달하여 사용
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		//Map.put(K key, V value) : Map 객체에 엔트리를 추가하는 메소드
		// => Map 객체의 이름(Key)은 Set 객체로 저장되므로 중복 저장할 수 없으며 순서 없이 저장
		map.put(1000, "Gildong");
		map.put(2000, "Gguckjeong");
		map.put(3000, "Wuchi");
		map.put(4000, "Jimae");
		map.put(5000, "Gilsan");
		
		//Map.toString() : Map 객체에 저장된 모든 엔트리를 문자열로 변환하여 반환하는 메소드
		//System.out.println("map.toString = "+map.toString());
		System.out.println("map = "+map);
		System.out.println("===========================================================================");
		//Map.put(K key, V value) 메소드 호출시 이름(Key)가 중복될 경우 기존값 대신 새로운 값으로 
		map.put(2000, "Gguckjeong");
		System.out.println("map = "+map);
		System.out.println("===========================================================================");
		//Map.remove(K key) : Map 객체에 저장된 엔트리를 이름(Key)를 이용하여 제거하는 메소드
		map.remove(4000);
		System.out.println("map = "+map);
		System.out.println("===========================================================================");
		//Map.get(K key) : Map 객체에 저장된 엔트리에서 이름(Key)을 이용하여 값(Value)을
		//검색하여 반환하는 메소드 - 이름으로 저장된 값이 없는 경우 [NULL] 반환
		String name=map.get(1000);
		System.out.println("name = "+name);
		System.out.println("===========================================================================");
		//Map 객체에 저장된 엔트리에 대한 일괄 처리 - Iterator 객체 사용
		//Map.keySet() : Map객체에 저장된 모든 엔트리의 이름(Key)를 Set 객체로 반환하는 메소드
		Iterator<Integer> iteratorKey=map.keySet().iterator();
		
		while (iteratorKey.hasNext()) {
			Integer key=iteratorKey.next(); //Set 객체에 저장된 이름(Key)을 반환받아 저장
			System.out.println(key+" = "+map.get(key));
		}
		System.out.println("===========================================================================");
		//Map.values() : Map 객체에 저장된 모든 엔트리의 값(Value)을 Collection 객체로 반환하는 메소드
		Iterator<String> iteratorValue=map.values().iterator();
		
		while(iteratorValue.hasNext()) {
			System.out.println(iteratorValue.next()+" ");
		}
		System.out.println();
		System.out.println("===========================================================================");
		//Map 객체에 저장된 엔트리에 대한 일괄 처리 - 향상된 for 구문 사용
		for(Integer key:map.keySet()) {
			System.out.println(key+" = "+map.get(key));
		}
		System.out.println("===========================================================================");
		for(String value:map.values()) {
			System.out.println(value+" ");
		}
		System.out.println();
		System.out.println("===========================================================================");
		
		
		
	}
}
