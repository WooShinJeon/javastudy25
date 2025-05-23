package ch04;

import java.util.Calendar;

public class EnumWeekExam {

	public static void main(String[] args) {
		// Week today = Week. -> Week이늄에서 만든 변수들의 목록이 뜬다.
		
		Week today1 = Week.SUNDAY;
		System.out.println(today1==Week.SUNDAY);
		
		Week Week1 = Week.SATURDAY;
		Week Week2 = Week.SATURDAY;
		System.out.println(Week1==Week2);
		
		System.out.println(today1);
		System.out.println(Week.SUNDAY);
		
		
		
		
		
		Week today = null; // week타입에 today변수를 선언하고 연결은 나중에 하겠다.
		
		Calendar cal = Calendar.getInstance(); // 캘린더 인스턴스 생성
		int year = cal.get(Calendar.YEAR); // 년도를 얻어온다.
		int month = cal.get(Calendar.MONTH)+1; // 컴퓨터는 0부터 시작이라 +1을 진행
		int day = cal.get(Calendar.DAY_OF_MONTH); // 1달의 일수가 계산
		int week = cal.get(Calendar.DAY_OF_WEEK); // 요일을 숫자로 출력(일요일=1~토요일=7)
		
		switch(week) {
		case 1 :
			today = Week.SUNDAY; break;
		case 2 :
			today = Week.MONDAY; break;
		case 3 :
			today = Week.TUESDAY; break;
		case 4 :
			today = Week.WEDNESDAY; break;
		case 5 :
			today = Week.THURSDAY; break;
		case 6 :
			today = Week.FRIDAY; break;
		case 7 :
			today = Week.SATURDAY; break;
		}
		System.out.println("현재 날짜는 "+year+"년 "+month+"월 "+day+"일("+today+")");
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		if(hour==0) {
			hour = 12;
		}
		System.out.println("현재 시간은 "+hour+"시 "+minute+"분 "+second+"초 입니다.");
		
		// 요일별 스케줄(일일 학습목표)
		if(today==Week.SUNDAY) {
			System.out.println("오늘은 일요일입니다. 열심히 쉽니다.");
		}else if(today==Week.MONDAY) {
			System.out.println("오늘은 월요일입니다. 열심히 java공부를 합니다.");
		}else if(today==Week.TUESDAY) {
			System.out.println("오늘은 화요일입니다. 열심히 java공부를 합니다.");
		}else if(today==Week.WEDNESDAY) {
			System.out.println("오늘은 수요일입니다. 열심히 java공부를 합니다.");
		}else if(today==Week.THURSDAY) {
			System.out.println("오늘은 목요일입니다. 열심히 java공부를 합니다.");
		}else if(today==Week.FRIDAY) {
			System.out.println("오늘은 금요일입니다. 열심히 java공부를 합니다.");
		}else if(today==Week.SATURDAY) {
			System.out.println("오늘은 토요일입니다. 열심히 쉽니다.");
		}
		
		
		
		
		


	}

}
