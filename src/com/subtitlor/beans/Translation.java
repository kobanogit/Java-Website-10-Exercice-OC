package com.subtitlor.beans;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Translation {
	ArrayList<Line> traductions = new ArrayList();
	
	
	public void setTradArray(HttpServletRequest request) {
//		System.out.println(request.toString());

		Map<String, String[]> parameters = request.getParameterMap();
//		System.out.println(parameters.toString());
		
		for(String parameter : parameters.keySet()) {
			if(request.getParameter(parameter) != "") {
				System.out.println("Traduction 20 : " + parameter.toString() + " - " + request.getParameter(parameter));
				Line line = new Line();
				// Suppression des 4 premiers charactères "line"
				line.setLineNb(parameter.substring(3));
				line.setTranslat(request.getParameter(parameter));
				System.out.println("Traduction 25 : " + line.toString());
				traductions.add(line);
		   }
		}	
//		for(Line li:traductions) {
//			System.out.println(li.getLineNb() + " : " + li.getTrad());
//		}
		
	}
	public ArrayList<Line> getTradArray(){
		for(Line li:traductions) {
			System.out.println("Traduction 36 : " + li.getLineNb() + " : " + li.getTranslat());
		}
		return traductions;
	}
}
