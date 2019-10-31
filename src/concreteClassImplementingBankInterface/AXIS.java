package concreteClassImplementingBankInterface;

import bankInterface.Bank;

public class AXIS implements Bank {
	private final String BNAME;
	
	public AXIS() {
		BNAME = "AXIS";
	}
	@Override
	public String getBankName() {
		return BNAME;
	}

	
}
