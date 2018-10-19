package aop;

public class AopMain {
	public static void main(String[] args) {
		RecCalculator recCalculator = new RecCalculator();
		CalculatorImpe calculatorImpe = new CalculatorImpe();
		
		System.out.println("플록시를 이용한 처리");
		System.out.println("-------------------------");
		System.out.println("1. factorial(10) 결과 : " + new ExeTimeCalcurator(recCalculator).factorial(10));
		System.out.println("-------------------------");
		System.out.println("2. factorial(10) 결과 : " + new ExeTimeCalcurator(calculatorImpe).factorial(10));
	}
}
