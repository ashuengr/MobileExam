package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {
	
	AccountServiceImpl serv= new AccountServiceImpl();
	public void getDetails()
	{Scanner sc= new Scanner(System.in);
	System.out.println("Enter your mobile number");
	
	try {
		String mobileNo=sc.next();
		
		Account account=new Account();
			System.out.println(serv.getAccountDetails(mobileNo));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void recharge()
	{System.out.println("Enter mobile number again");
	Scanner sc = null;
	String mobileNo = null;
	try {
		sc = new Scanner(System.in);
		mobileNo = sc.next();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Enter amount to be recharged");
	try {
		double rechargeAmount=sc.nextDouble();

			serv.rechargeAccount(mobileNo, rechargeAmount);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MainUI m=new MainUI();

boolean flag=true;
while(flag) {
System.out.println("Enter 1 for Account Balance Enquiry"+
"Enter 2 for recharge account"+
		"Enter 3 for exit from account");
Scanner sc= new Scanner(System.in);
int ch=sc.nextInt();
switch(ch) {
case 1:
	m.getDetails();
	break;
case 2:
	m.recharge();
	break;
case 3:
	System.exit(ch);
	flag=false;
	break;
	default:
		System.out.println("  ");
	
}
	}

}}
