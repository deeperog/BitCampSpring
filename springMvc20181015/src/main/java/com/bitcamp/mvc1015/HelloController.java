package com.bitcamp.mvc1015;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		
		// view name 반환
		modelAndView.setViewName("hello");
		modelAndView.addObject("greeting", getGreeting());
		
		
		return modelAndView;
	}

	private Object getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String str = "";
		
		if(hour >= 6 && hour <= 10) {
			str = "좋은 아침입니다.";
		} else if (hour > 12 && hour <=15) {
			str = "밥 먹으러 가세요.";
		} else {
			str = "빨리 집에 들어가세요";
		}
		
		return str;
	}
	
}
