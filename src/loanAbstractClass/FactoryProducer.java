package loanAbstractClass;

/*
 * Create a FactoryCreator class to get the factories 
 * by passing an information such as Bank or Loan
 */
public class FactoryProducer {
	public static AbstractFactory getAbstractFactory(String choice) {
		if(choice.equalsIgnoreCase("Bank")) {
			return new BankFactory();
		}
		if(choice.equalsIgnoreCase("Loan")) {
			return new LoanFactory();
		}
		return null;
	}

}
