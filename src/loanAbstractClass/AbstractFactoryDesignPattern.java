package loanAbstractClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bankInterface.Bank;

public class AbstractFactoryDesignPattern {
	
	static JLabel bankSelectLbl, bankLoanLbl, bankRateLbl, bankLoanAmtLbl, tenureLbl;
	static JTextField bankSelectTxt, bankLoanTxt, bankRateTxt, bankLoanAmtTxt, tenureTxt;
	static JButton submitBtn;
	
	public static void main(String args[]) throws IOException {
		JFrame frame = new JFrame();
		
		bankSelectLbl = new JLabel("Select Bank: ");
		bankLoanLbl = new JLabel("Type of Loan: ");
		bankRateLbl = new JLabel("Interest Rate: ");
		bankLoanAmtLbl = new JLabel("Loan amount: ");
		tenureLbl = new JLabel("Tenure: ");
		submitBtn = new JButton();
		
		bankSelectTxt = new JTextField();
		bankLoanTxt = new JTextField();
		bankRateTxt = new JTextField();
		bankLoanAmtTxt = new JTextField();
		tenureTxt = new JTextField();
		submitBtn = new JButton("Submit");
		
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
		
		submitBtn.setBounds(270, 270, 100, 30);
		
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
		
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setTitle("EMI Calculator");
		frame.setVisible(true);
		
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String bank = bankSelectTxt.getText();
				String loanName = bankLoanTxt.getText();
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
		        l.calculateLoanAmount(loanAmount, years);  				
			}
		});
	}
}
