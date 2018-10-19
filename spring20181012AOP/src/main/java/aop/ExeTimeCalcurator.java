package aop;

public class ExeTimeCalcurator implements Calculator {
	// 실행을 대행한다.
	// 대행하기 위한 객체가 필요
	private Calculator delegate;
	public ExeTimeCalcurator(Calculator delegate) {
		this.delegate = delegate;
	}

	@Override
	public long factorial(long num) {
		// 가상머신의 기준 시점에서 경과 시간을 측정하는데 사용(ns 단위)
		// 시스템 시간과 무관
		long start = System.nanoTime();
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.println("factorial("+num+") 실행시간 :"+(end-start));
		return result;
		}
}
