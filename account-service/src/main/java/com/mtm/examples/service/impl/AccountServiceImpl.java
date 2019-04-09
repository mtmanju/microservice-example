package com.mtm.examples.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mtm.examples.domain.Account;
import com.mtm.examples.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	public List<Account> getAccounts() {
		List<Account> accounts = new ArrayList<>();
		accounts.add(Account.builder().id(1).customerId(1).number("111111").build());
		accounts.add(Account.builder().id(2).customerId(2).number("222222").build());
		accounts.add(Account.builder().id(3).customerId(3).number("333333").build());
		accounts.add(Account.builder().id(4).customerId(4).number("444444").build());
		accounts.add(Account.builder().id(5).customerId(1).number("555555").build());
		accounts.add(Account.builder().id(6).customerId(2).number("666666").build());
		accounts.add(Account.builder().id(7).customerId(2).number("777777").build());
		return accounts;
	}

	@Override
	public Account findByAccountNumber(String accountNumber) {
		return getAccounts().parallelStream().filter(account -> account.getNumber().equals(accountNumber)).findFirst()
				.get();
	}

	@Override
	public List<Account> findByCustomerId(Integer customerId) {
		return getAccounts().stream().filter(account -> account.getCustomerId().intValue() == customerId.intValue())
				.collect(Collectors.toList());
	}

	@Override
	public List<Account> findAllAccounts() {
		return getAccounts();
	}

}