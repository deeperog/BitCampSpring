package aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAopMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopConfig.xml");	//설정 참조
		RecCalculator recCalculator = ctx.getBean("cal1", RecCalculator.class);
		long calResult1 = recCalculator.factorial(5);
		System.out.println("factorial(10) 의 결과 = " + calResult1);
		CalculatorImpe calculatorImpe = ctx.getBean("cal2", CalculatorImpe.class);
		long calResult2 = calculatorImpe.factorial(5);
		System.out.println("factorial(10) 의 결과 = " + calResult2);
	}
}
