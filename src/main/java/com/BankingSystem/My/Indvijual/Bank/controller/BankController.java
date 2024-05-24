package com.BankingSystem.My.Indvijual.Bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingSystem.My.Indvijual.Bank.entity.BankEntity;
import com.BankingSystem.My.Indvijual.Bank.service.ServiceImplement;

@RestController
@RequestMapping("/Account")
public class BankController {
	
	@Autowired
	ServiceImplement implement;
	
	
	@PostMapping("/create")
	public BankEntity createAccount(@RequestBody BankEntity bankEntity) {
		return implement.createAccount(bankEntity);
		
	}
	@GetMapping("/getaccount/{acNumber}")
	public BankEntity getaccountbyaccountnumber(@PathVariable long acNumber) {
		return implement.getaccountbyaccountnumber(acNumber);
		
	}
	@GetMapping("allAccount")
	public List<BankEntity>allAccount(){
		List<BankEntity>allaccountdeatil= implement.allAccount();
		return allaccountdeatil;
	}
	@PutMapping("/depopsite/{acNumber}/{amount}")
	public BankEntity AccountDeposit(@PathVariable long acNumber,@PathVariable int amount) {
		return implement.AccountDeposit(acNumber,amount);
		
	}
	@PutMapping("/withdraw/{acNumber}/{amount}")
	public BankEntity withdrawAccount(@PathVariable long acNumber, @PathVariable int amount) {
		return implement.withdrawAccount(acNumber,amount);
		
	}
	
	@DeleteMapping("/delete/{acNumber}")
	public String closeAccount(@PathVariable long acNumber) {
		implement.closeAccount(acNumber);
		return "Succesfully Deleted";
		
	}
	

}
