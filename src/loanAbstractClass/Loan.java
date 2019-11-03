package loanAbstractClass;

abstract class Loan {
	double EMI, TotalInterestPay;
	int n;
	protected double rate;
	abstract void getInterestRate(double rate);
	public double calculateLoanAmount(double loanAmount, int years) {
		
		n = years * 12;
		rate = rate/1200;
		EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;
		
		return EMI;
	}
	
	public double calculateTotalInterestPayble(double loanAmount, int years) {
		
		n = years * 12;
		TotalInterestPay = ((EMI*n) - loanAmount);
		
		return TotalInterestPay;		
	}
}
