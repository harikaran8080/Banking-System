package com.BankingSystem.My.Indvijual.Bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystem.My.Indvijual.Bank.entity.BankEntity;
import com.BankingSystem.My.Indvijual.Bank.repository.BankRepository;

@Service
public class BankService implements ServiceImplement{
	@Autowired
	BankRepository bankRepository;

	@Override
	public BankEntity createAccount(BankEntity bankEntity) {
		return bankRepository.save(bankEntity);
	}

	@Override
	public BankEntity getaccountbyaccountnumber(long acNumber) {
	    Optional<BankEntity> acount=  bankRepository.findById(acNumber);
	    if(acount.isEmpty()) {
	    	throw new RuntimeException("account is not present");
	    }
	    BankEntity acount1=acount.get();
	    return acount1;
			
	}

	@Override
	public List<BankEntity> allAccount() {
		return bankRepository.findAll();	}

	@Override
	public BankEntity AccountDeposit(long acNumber, int amount) {
		Optional<BankEntity> optional= bankRepository.findById(acNumber);
		if(optional.isEmpty()) {
			throw new RuntimeException("account is not pressent");
		}
		BankEntity optionalEntity=optional.get();
		int totalbalance =optionalEntity.getBalance()+amount;
		optionalEntity.setBalance(totalbalance);
		bankRepository.save(optionalEntity);
		
		return optionalEntity;
	}

	@Override
	public BankEntity withdrawAccount(long acNumber, int amount) {
		Optional<BankEntity>withdraw=bankRepository.findById(acNumber);
		if(withdraw.isEmpty()) {
			throw new RuntimeException("Account Is Not Present");
			}
		BankEntity withdraw1=withdraw.get();
		int balance =withdraw1.getBalance()+amount;
		withdraw1.setBalance(balance);
		bankRepository.save(withdraw1);
	    return withdraw1;
	}

	@Override
	public void closeAccount(long acNumber) {
		bankRepository.deleteById(acNumber);
		
		
	}

	


}
