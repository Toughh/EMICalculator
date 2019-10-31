package concreteClassImplementingBankInterface;

import bankInterface.Bank;

public class SBI implements Bank {
	private final String BNAME;
	
	public SBI() {
		BNAME = "SBI";
	}
	@Override
	public String getBankName() {
		return BNAME;
	}

	
}
