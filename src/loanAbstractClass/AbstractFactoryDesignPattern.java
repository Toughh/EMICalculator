package loanAbstractClass;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bankInterface.Bank;

public class AbstractFactoryDesignPattern {
	
	static JLabel bankSelectLbl, bankLoanLbl, bankRateLbl, bankLoanAmtLbl, tenureLbl, calculatedEMILbl, totalInterestLbl, totalPaymentLbl;
	static JTextField bankRateTxt, bankLoanAmtTxt, tenureTxt;
	static String bankSelect[] = {"AXIS", "IDBI", "ICICI", "HDFC", "SBI"};
	static String loanSelect[] = {"Home", "Education", "Business"};
	static String EMI, TotalInterestPaid, TotalPayment; 
	static JButton submitBtn, resetBtn;

	private static void reset() {
		bankRateTxt.setText("");
        bankLoanAmtTxt.setText("");
        tenureTxt.setText("");				
	}
	
	public static void main(String args[]) throws IOException {
		JFrame frame = new JFrame();
		
		bankSelectLbl = new JLabel("Select Bank: ");
		bankLoanLbl = new JLabel("Type of Loan: ");
		bankRateLbl = new JLabel("Interest Rate: ");
		bankLoanAmtLbl = new JLabel("Loan amount: ");
		tenureLbl = new JLabel("Tenure: ");
		submitBtn = new JButton();
		calculatedEMILbl = new JLabel();
		totalInterestLbl = new JLabel();
		totalPaymentLbl = new JLabel();
		
		JComboBox<String> bankSelectTxt = new JComboBox<String>(bankSelect);
		JComboBox<String> bankLoanTxt = new JComboBox<String>(loanSelect);

		bankRateTxt = new JTextField();
		bankLoanAmtTxt = new JTextField();
		tenureTxt = new JTextField();
		submitBtn = new JButton("Submit");
		resetBtn = new JButton("Reset");
		
		bankSelectLbl.setBounds(80, 70, 200, 30);
		bankLoanLbl.setBounds(80, 110, 200, 30);
		bankRateLbl.setBounds(80, 150, 200, 30);
		bankLoanAmtLbl.setBounds(80, 190, 200, 30);
		tenureLbl.setBounds(80, 230, 200, 30);
		
		bankSelectTxt.setBounds(300, 70, 200, 30);
		bankLoanTxt.setBounds(300, 110, 200, 30);
		bankRateTxt.setBounds(300, 150, 200, 30);
		bankLoanAmtTxt.setBounds(300, 190, 200, 30);
		tenureTxt.setBounds(300, 230, 200, 30);
		
		submitBtn.setBounds(230, 290, 100, 30);
		resetBtn.setBounds(350, 290, 100, 30);
		calculatedEMILbl.setBounds(130, 330, 500, 30);
		calculatedEMILbl.setForeground(Color.MAGENTA);
		totalInterestLbl.setBounds(130, 350, 500, 30);
		totalInterestLbl.setForeground(Color.MAGENTA);
		totalPaymentLbl.setBounds(130, 370, 500, 30);
		totalPaymentLbl.setForeground(Color.MAGENTA);
		
		frame.add(bankSelectLbl);
		frame.add(bankSelectTxt);
		frame.add(bankLoanLbl);
		frame.add(bankLoanTxt);
		frame.add(bankRateLbl);
		frame.add(bankRateTxt);
		frame.add(bankLoanAmtLbl);
		frame.add(bankLoanAmtTxt);
		frame.add(tenureLbl);
		frame.add(tenureTxt);
		frame.add(submitBtn);
		frame.add(resetBtn);
		
		frame.add(calculatedEMILbl);
		frame.add(totalInterestLbl);
		frame.add(totalPaymentLbl);
		
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setTitle("EMI Calculator");
		frame.setVisible(true);
		
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String bank = bankSelectTxt.getItemAt(bankSelectTxt.getSelectedIndex());
				String loanName = bankLoanTxt.getItemAt(bankLoanTxt.getSelectedIndex());
				String rateTxt = bankRateTxt.getText();
				double rate = Double.parseDouble(rateTxt); 
				String loanTxt = bankLoanAmtTxt.getText();
				int loanAmount = Integer.parseInt(loanTxt);
				String yearsTxt = tenureTxt.getText();
				int years = Integer.parseInt(yearsTxt);
				
				AbstractFactory bankFactory = FactoryProducer.getAbstractFactory("Bank");
				Bank b = bankFactory.getBank(bank);
				
				AbstractFactory loanFactory = FactoryProducer.getAbstractFactory("Loan");  
		        Loan l=loanFactory.getLoan(loanName);  
		        l.getInterestRate(rate);  
		        EMI = "EMI would be " +l.calculateLoanAmount(loanAmount, years)+ " that need to be paid by "+years+" years.";
		        calculatedEMILbl.setText(EMI);
		        
		        TotalInterestPaid = "Total Interest Paid: "+l.calculateTotalInterestPayble(loanAmount, years);
		        totalInterestLbl.setText(TotalInterestPaid);
		        
		        TotalPayment = "Total Payment in "+years+" years: "+l.calculateTotalPayment(loanAmount);
		        totalPaymentLbl.setText(TotalPayment);
		        reset();
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				if(calculatedEMILbl.isVisible() || totalInterestLbl.isVisible() || totalPaymentLbl.isVisible()) {
					calculatedEMILbl.setText("");
					totalInterestLbl.setText("");
					totalPaymentLbl.setText("");
				}
			}
		});
	}
}
