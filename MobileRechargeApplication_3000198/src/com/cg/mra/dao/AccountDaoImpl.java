package com.cg.mra.dao;

import java.util.HashMap;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	HashMap <String,Account> accountEntry=new HashMap<>();
	public AccountDaoImpl() {
		accountEntry=new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid","Vaishali",200));
		accountEntry.put("9823920123", new Account("Prepaid","Megha",453));
		accountEntry.put("9832012345", new Account("Prepaid","Vikas",631));
		accountEntry.put("9010210132", new Account("Prepaid","Anju",521));
		accountEntry.put("9010210133", new Account("Prepaid","Tushar",200));
	}

	@Override
	public Account getAccountDetails(String mobileNo) {
		
		return accountEntry.get(mobileNo);
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {

		double totalBalance=accountEntry.get(mobileNo).getAccountBalance()+rechargeAmount;
		accountEntry.get(mobileNo).setAccountBalance(totalBalance);
		return accountEntry.get(mobileNo).getAccountBalance();
	}

}
