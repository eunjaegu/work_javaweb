package util;

import java.util.ArrayList;
import java.util.Random;

import model.FullCalendarRevVO;
import model.RevVO;

public class CalendarForm {
	private final static String[] color = {"red", "blue", "green", "yellow", "orange", 
			"purple", "gray", "cyan", "magenta", "lime", "teal", "gold", "indigo"};
	
	public static ArrayList<FullCalendarRevVO> FullCalendar(ArrayList<RevVO> revList) {
		ArrayList<FullCalendarRevVO> resultList = new ArrayList<FullCalendarRevVO>();
		Random random = new Random();
		
		for (RevVO revVO : revList) {
			FullCalendarRevVO calendarRevVO = new FullCalendarRevVO();
			int randomIndex = random.nextInt(13);
			
			calendarRevVO.setBookNo(revVO.getBookNo());
			calendarRevVO.setRoomNo(revVO.getRoomNo());
			calendarRevVO.setBookCheck(revVO.getBookCheck());
			calendarRevVO.setBookCheckOut(revVO.getBookCheckOut());
			calendarRevVO.setBackgroundColor(color[randomIndex]);
			resultList.add(calendarRevVO);
		}
		return resultList;
	}
}
