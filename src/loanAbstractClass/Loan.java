package loanAbstractClass;

abstract class Loan {
	protected double rate;
	abstract void getInterestRate(double rate);
	public void calculateLoanAmount(double loanAmount, int years) {
		int n;
		double EMI;
		
		n = years * 12;
		rate = rate/1200;
		EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;
		
	System.out.println("Your monthly EMI is: "+EMI+" for the loan amount: "+loanAmount+" you have borrowed");
	}	
}
