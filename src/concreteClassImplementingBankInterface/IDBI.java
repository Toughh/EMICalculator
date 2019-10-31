package concreteClassImplementingBankInterface;

import bankInterface.Bank;

public class IDBI implements Bank {
	private final String BNAME;
	
	public IDBI() {
		BNAME = "IDBI";
	}
	@Override
	public String getBankName() {
		return BNAME;
	}

	
}
