package loanAbstractClass;

import javax.swing.JTextField;

import bankInterface.Bank;

abstract class AbstractFactory {
	public abstract Bank getBank(String bank);
	public abstract Loan getLoan(String loan);

}
