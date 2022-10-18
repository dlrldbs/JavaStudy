package xyz.itwill.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//네트워크(Network) : 두 대이상의 컴퓨터에서 값을 송수신하기 위한 기능

//인터넷(Internet) : 네트워크 기능을 제공하기 위한 가상의 공간 -  네트워크 관련 약속

//프로토콜(Protocol) : 인터넷을 사용하기 위한 네트워크 관련 통신규약

//프로토콜 구조 : 네트워크 계층 > 인터넷 계층(IP) > 전송 계층(TCP, UDP) > 응용 계층(FTP, HTTP, SMTP 등)
//호스트(Host) : 네트워크를 사용하기 위한 컴퓨터(프로그램)

//네트워크 계층 - 이더넷, 라우터, 스위치허브 등의 네트워크 관련 장비
// => 이더넷(Ethernet) : 호스트에서 사용하기 위한 통신 장비
// => 라우터(Router) : 네트워크 그룹과 네트워크 그룹을 연결하기 위한 통신 장비
// => 스위치허브(Switch Hub) :  호스트와 호스트 및 호스트와 네트워크 그룹을 연결하기 위한 통신 장비

//IP(Internet Protocol) : 인터넷을 사용하기 위한 네트워크 주소(IP 주소)에 대한 통신규약 - IPV4, IPV6

//TCP(Transmission Control Protocol) : 연결형 프로토콜(연결 설정 후 통신 가능)로 신뢰할 수 있는  
//데이타 전송에 대한 통신규약 - 전송 제어 프로토콜  >> 소켓(Socket) 통신 - 1:1 연결
//UDP(User Datagram Protocol) : 비연결형 프로토콜(연결 설정 없이 통신 가능)로 신뢰할 수 없는  
//데이타 전송에 대한 통신규약 - 사용자 데이타그램 프로토콜 >> 고속 통신 - 1:Many 연결

//응용 계층 : 전송계층을 기반으로 생성된 다수의 프로토콜 또는 응용 프로그램 포함

//IP Address : 인터넷을 사용하기 위해 컴퓨터에 부여하는 네트워크 식별자
// => 32Bit를 이용하여 IP 주소 표현 : 10진수 0~255 범위의 정수값 4개를 [.]으로 구분하여 표현  - IPV4
// => 128Bit를 이용하여 IP 주소 표현 : 16진수 0000~FFFF 범위의 정수값 8개로 [:]으로 구분하여 표현  - IPV6
// => 공인 IP 주소와 사설 IP 주소( A Class : 10.0.0.0~10.255.255.255,  B Class : 172.16.0.0~172.31.255.255
//, C Class : 192.168.0.0~192.168.255.255)로 구분

//Netmask Address : 네트워크 그룹(SubNet)을 표현하기 위한 주소
// => C Class(255.255.255.0 - 256 : 192.X.X.X~233.X.X.X), B Class(255.255.0.0 - 65,536 : 128.X.X.X~191.X.X.X)
//, A Class(255.0.0.0 - 16,777,216 : 0.X.X.X~127.X.X.X) 등

//Gateway Address : 라우터에 부여된 IP 주소

//DNS Server : 도메인을 IP 주소로 변환하는 기능을 제공하는 컴퓨터

//도메인(Domain) : 인터넷을 사용하기 위해 네트워크 그룹 또는 호스트에게 부여하는 문자화된 네트워크 식별자
// => 도메인 그룹에 등록되어야 호스트 사용 가능 - 도메인 호스트

//포트번호(Port Number) : 네트워크를 이용하여 데이타를 전송하기 위한 고유의 통신 경로
// => 네트워크는 반드시 0~65535 범위의 포트 중 하나를 선택하여 데이타 전송
// => 0 ~ 1023 : Well-Known Port(HTTP : 80, HTTPS : 443, SMTP : 25, POP3 : 110 등) - 시스템에서 사용하기 위해 약속 되어진 포트  
// => 1024 ~ 49151 : 네트워크 프로그램 작성시 사용 가능한 포트
// => 49152 ~ 65535 : 일시적으로 사용하는 임시 포트 - Private Port

//패킷(Packet) : 네트워크에서 데이타를 전송하기 위한 단위 - Java에서는 byte 배열로 표현 가능

//방화벽(Firewall) : 네트워크를 이용한 접속 및 데이타 전송 차단 또는 허용을 위해 사용하는 시스템

public class InetAddressApp {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : 네트워크 정보(IP Address와 HostName)를 저장하기 위한 클래스
		//InetAddress.getLocalHost() : 로컬 컴퓨터의 네트워크 정보가 저장된 InetAddress 객체를 반환하는 메소드
		// => UnknownHostException 발생(일반 예외) : 네트워크 컴퓨터 이름(HostName)의 컴퓨터를 검색할 수 없는 경우 발생되는 예외
		//로컬 컴퓨터의 이더넷에는 기본적으로 [127.0.0.1]의 IP Address와 [localhost] 이름으로 HostName 설정 
		InetAddress myComputer=InetAddress.getLocalHost();
		
		//InetAddress.toString() : InetAddress 객체에 저장된 네트워크 정보를 문자열로 반환하는 메소드
		System.out.println("myComputer = "+myComputer);
		
		//InetAddress.getHostName() : InetAddress 객체에 저장된 네트워크 정보에서 HostName을 문자열로 반환하는 메소드
		System.out.println("myComputer = "+myComputer.getHostName());
		
		//InetAddress.getHostAddress() : InetAddress 객체에 저장된 네트워크 정보에서 IP Address을 문자열로 반환하는 메소드
		System.out.println("myComputer = "+myComputer.getHostAddress());
		System.out.println("===============================================================");
		//InetAddress.getByName(String host) : 전달받은 컴퓨터 이름에 대한 네트워크 정보가
		//저장된 InetAddress 객체를 반환하는 메소드
		InetAddress itwill=InetAddress.getByName("www.itwill.xyz");
		System.out.println("[www.itwill.xyz]의 IP Address = "+itwill.getHostAddress());
		System.out.println("===============================================================");
		//InetAddress.getAllByName(String host) : 전달받은 컴퓨터 이름에 대한 모든 네트워크 
		//정보가 저장된 InetAddress 객체 배열을 반환하는 메소드
		InetAddress[] naver=InetAddress.getAllByName("www.naver.com");
		
		for(InetAddress address:naver) {
			System.out.println("[www.naver.com]의 IP Address = "+address.getHostAddress());
		}
		System.out.println("===============================================================");
	}
}