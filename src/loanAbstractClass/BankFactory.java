package loanAbstractClass;

import bankInterface.Bank;
import concreteClassImplementingBankInterface.*;

public class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		if(bank.equalsIgnoreCase("HDFC")) {
			return new HDFC();
		} else if(bank.equalsIgnoreCase("SBI")) {
			return new SBI();
			} else if(bank.equalsIgnoreCase("ICICI")) {
				return new ICICI();
				} else if(bank.equalsIgnoreCase("AXIS")) {
					return new AXIS();
				} else if(bank.equalsIgnoreCase("IDBI")) {
					return new IDBI();
				}
		return null;
		}

	@Override
	public Loan getLoan(String loan) {
		return null;
	}

}
