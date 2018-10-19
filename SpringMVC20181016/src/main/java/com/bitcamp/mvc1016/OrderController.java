package com.bitcamp.mvc1016;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/order")
public class OrderController {
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "order/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String order(OrderCommand orderCommand) {
		
		/*for (OrderItem item : orderCommand.getOrderItems()) {
			System.out.println("---------------------");
			System.out.print(item.getItemId() + item.getNumber() + item.getRemark());			
		}*/
		
		System.out.println(orderCommand.getOrderItems());
		System.out.println("---------------------");
		System.out.println(orderCommand.getAddress());
		
		return "order/orderOk";
	}
}
