package com.cg.mra.junittesting;

import static org.junit.Assert.*;

import java.util.HashMap;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.InvalidMobileNumberexception;
import com.cg.mra.exception.MobileNumberNotFoundException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;



import com.cg.mra.dao.AccountDaoImpl;;

public class JUnit {
	private static AccountService serv;
	
	@BeforeClass
	public  static void setUpTestEnv()
	{
		serv=new AccountServiceImpl();
	}



	@Before
	public void setUpTestData()
	{Account acc= new Account("pr","anj", 200);
	Account acc1= new Account("pra","anja", 2000);

	}
	
	@Test(expected=InvalidMobileNumberexception.class)
	public void InvalidMobileNumberExceptio() throws InvalidMobileNumberexception{
		serv.getAccountDetails("1233");
		
	}
	@Test
	public void validname()
	{
		//Account acc= new Account("Prepaid","Vaishali",200);
	String expected="Vaishali";
		String actual=serv.getAccountDetails("9010210131").getCustomerName();
		Assert.assertEquals(expected, actual);
	}
	@Test(expected=MobileNumberNotFoundException.class)
	public void checkAccountNotFoundException() throws MobileNumberNotFoundException{
		serv.getAccountDetails("1234567890");
		
	}
	@After

		//after is used for clear those value which is not required after performing all the methods
		public void tearDownData() {
		Account	acc=null;
		
		}
		@AfterClass
		//afterclass is used for releasing the external which are used in before class
		public static void tearDownEnv() {
			AccountService serv=null;
		}
	}
	


