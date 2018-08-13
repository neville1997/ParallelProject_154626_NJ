package com.cg.pp.dao;

import java.util.HashMap;
import com.cg.pp.beans.Customer;
import com.cg.pp.beans.History;

public class WalletDaoImpl implements WalletDao{
	HashMap<String, Customer> database = new HashMap<>(); 
	HashMap<String, History> historydb = new HashMap<>();
 	
	public boolean findOne(String mobileNo){
		return database.containsKey(mobileNo);
		}

	//@Override
	//public History addToHistory(String index, History history) {
	//	String index1 = history.getHistmobileno() + "-" + "history.getSerial()";
	//	historydb.put(index1, history);
	//	return historydb.get(index1);	
	//	}
	
//	@Override
	//public History showHistory(String mobileno) {
		//String index1 = history.getHistmobileno() + history.getSerial();
		//return historydb.get(index1);
//	}
	
	@Override
	public Customer createAccount(Customer customer) {
		database.put(customer.getMobileNo(), customer);
		return customer;	
		}
	
	@Override
	public Customer findAccount(String mobileno) {
		return database.get(mobileno);
		}
	
	@Override
	public float showBalance(String mobileno){
			float curbal = ((Customer)database.get(mobileno)).getBalance();
			System.out.println("Your available balance is: " + curbal);
			return curbal;
			}

	@Override
	public Customer depositAmount(String mobileNo, float amount) {
		float curbal = ((Customer)database.get(mobileNo)).getBalance();
		float newbal = curbal + amount;
		String name = ((Customer)database.get(mobileNo)).getName();
		String mobileno = ((Customer)database.get(mobileNo)).getMobileNo();
		database.put(mobileno, new Customer(mobileno, name, newbal));
		System.out.println("Account recharged succesfully for " 
				+ amount + " The available balance is " 
				+ newbal );
		return null;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, float amount) {
		float curbal = ((Customer)database.get(mobileNo)).getBalance();
		float newbal = curbal - amount;
		String name = ((Customer)database.get(mobileNo)).getName();
		String mobileno = ((Customer)database.get(mobileNo)).getMobileNo();
		database.put(mobileno, new Customer(mobileno, name, newbal));
		System.out.println("Account recharged succesfully for " 
				+ amount + " The available balance is " 
				+ newbal );		
		return null;
	}
	
	@Override
	public Customer fundTransfer(String acfrom, String acto, float amount) {
		float acfrombal = ((Customer)database.get(acfrom)).getBalance();
		float actobal = ((Customer)database.get(acto)).getBalance();
		float acfrombalnew = acfrombal - amount;
		float actobalnew = actobal + amount;
		String namefrom = ((Customer)database.get(acfrom)).getName();
		String nameto = ((Customer)database.get(acto)).getName();
		database.put(acfrom, new Customer(acfrom, namefrom, acfrombalnew));
		database.put(acto, new Customer(acto, nameto, actobalnew));
		System.out.println("Transaction succesful!");
		System.out.println("Amount " + amount + " withdrawn from account " 
							+ acfrom + " and deposited in account " + acto );
		System.out.println("Avaliable balances are " + acfrombalnew + " in " 
							+ acfrom + " and " + actobalnew + " in " + acto);
		return null;
	}

}
