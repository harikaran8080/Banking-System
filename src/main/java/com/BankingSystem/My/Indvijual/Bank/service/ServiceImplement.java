package com.BankingSystem.My.Indvijual.Bank.service;

import java.util.List;

import com.BankingSystem.My.Indvijual.Bank.entity.BankEntity;

public interface ServiceImplement {

	BankEntity createAccount(BankEntity bankEntity);

	BankEntity getaccountbyaccountnumber(long acNumber);

	List<BankEntity> allAccount();

	BankEntity AccountDeposit(long acNumber, int amount);

	BankEntity withdrawAccount(long acNumber, int amount);

	void closeAccount(long acNumber);

}
