package com.BankingSystem.My.Indvijual.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankingSystem.My.Indvijual.Bank.entity.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Long>{

}
