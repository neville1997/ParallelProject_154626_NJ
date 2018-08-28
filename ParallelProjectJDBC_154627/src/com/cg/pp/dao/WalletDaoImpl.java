package com.cg.pp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.pp.beans.Customer;
import com.cg.pp.beans.History;

public class WalletDaoImpl implements WalletDao{
	
	private EntityManager entityManager;
	
	public WalletDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	@Override
	public History addToHistory(History history) {
		entityManager.getTransaction().begin();
		entityManager.persist(history);
		entityManager.getTransaction().commit();
		System.out.println("Transaction history added succesfully");
		return null;
	}

	@Override
	public History showHistory(String mobileNo) {
//		ArrayList<History> sHistory = new ArrayList<History>();
//		for (History history : historydb) {
//		    if ((((History) entityManager).getHistmobileno()).matches(mobileno)) {
//		        sHistory.add(history);
//		    }
//		}
//		System.out.println("Operation 3 - Deposit");
//		System.out.println("Operation 4 - Withdrawal");
//		System.out.println("Operation 5 - Fund Transfer");
//        System.out.println(sHistory);
		return null;
	}
	
	public boolean findOne(String mobileNo){
		String sql = "SELECT customer FROM Customer customer WHERE mobileNo = :qMobileNo";
		TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class);
		query.setParameter("qMobileNo", mobileNo);
		Customer customer = query.getSingleResult();
		if(customer.equals(null)) {
			return false;
		}else
			return true;
		}

	@Override
	public Customer createAccount(Customer customer) {
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		System.out.println(customer + " added succesfully");
		return customer;
		}
	
	@Override
	public Customer findAccount(String mobileNo) {
		String sql = "SELECT customer FROM Customer customer WHERE mobileNo = :qMobileNo";
		TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class);
		query.setParameter("qMobileNo", mobileNo);
		Customer customer = query.getSingleResult();
	    return customer;
	}
	
	
//	
	@Override
	public float showBalance(String mobileNo){
	    String sql = "SELECT customer FROM Customer customer WHERE mobileno = :qMobileNo";
		TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class);
		query.setParameter("qMobileNo", mobileNo);
		Customer customer = query.getSingleResult();
		System.out.println(" Balance available in your account is: " +customer.getBalance());
	    return customer.getBalance();
	}

	@Override
	public Customer depositAmount(String mobileNo, float amount) {
		String sql = "SELECT customer FROM Customer customer WHERE mobileno = :qMobileNo";
		TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class);
		query.setParameter("qMobileNo", mobileNo);
		float oldBal = query.getSingleResult().getBalance();
		return null;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, float amount) {
//		float curbal = ((Customer)database.get(mobileNo)).getBalance();
//		float newbal = curbal - amount;
//		String name = ((Customer)database.get(mobileNo)).getName();
//		String mobileno = ((Customer)database.get(mobileNo)).getMobileNo();
//		database.put(mobileno, new Customer(mobileno, name, newbal));
//		System.out.println("Amount " 
//				+ amount + " withdrawn succesfully!" + " The available balance is " 
//				+ newbal );		
		return null;
	}
	
	@Override
	public Customer fundTransfer(String acfrom, String acto, float amount) {
//		float acfrombal = ((Customer)database.get(acfrom)).getBalance();
//		float actobal = ((Customer)database.get(acto)).getBalance();
//		float acfrombalnew = acfrombal - amount;
//		float actobalnew = actobal + amount;
//		String namefrom = ((Customer)database.get(acfrom)).getName();
//		String nameto = ((Customer)database.get(acto)).getName();
//		database.put(acfrom, new Customer(acfrom, namefrom, acfrombalnew));
//		database.put(acto, new Customer(acto, nameto, actobalnew));
//		System.out.println("Transaction succesful!");
//		System.out.println("Amount " + amount + " withdrawn from account " 
//							+ acfrom + " and deposited in account " + acto );
//		System.out.println("Avaliable balances are " + acfrombalnew + " in " 
//							+ acfrom + " and " + actobalnew + " in " + acto);
		return null;
	}
	
}
