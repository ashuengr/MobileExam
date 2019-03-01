package com.cg.mra.service;

import javax.security.auth.login.AccountNotFoundException;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.InvalidMobileNumberexception;
import com.cg.mra.exception.MobileNumberNotFoundException;

public class AccountServiceImpl  implements AccountService{
AccountDao dao=new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo){
		
		
		
		if(mobileNo.length()!=10)
		{
			throw new InvalidMobileNumberexception("mobile number is incorrect");// TODO Auto-generated method stub
		}
		if(!(mobileNo.equals("9010210131")||mobileNo.equals("9010210132")||mobileNo.equals("9010210133")||mobileNo.equals("9823920123")||mobileNo.equals("9932012345")))
		{
			throw new MobileNumberNotFoundException("mobile number not found");
		}
		return 	dao.getAccountDetails(mobileNo);
		
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		if(mobileNo.length()!=10)
		{
			throw new InvalidMobileNumberexception("entered mobile number is incorrect");
		}
		if(!(mobileNo=="9010210131"||mobileNo=="9010210132"||mobileNo=="9010210133"||mobileNo=="9823920123"||mobileNo=="9932012345"))
		{
			throw new MobileNumberNotFoundException("mobile number not found");
		}
		double totalbal=dao.getAccountDetails(mobileNo).getAccountBalance()+rechargeAmount;
		 dao.getAccountDetails(mobileNo).setAccountBalance(totalbal);
		return dao.getAccountDetails(mobileNo).getAccountBalance();
	}

}
