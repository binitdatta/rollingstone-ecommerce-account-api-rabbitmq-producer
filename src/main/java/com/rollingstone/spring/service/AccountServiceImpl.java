package com.rollingstone.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.AccountDaoRepository;
import com.rollingstone.spring.model.Account;
import com.rollingstone.spring.model.AccountDTO;

@Service
public class AccountServiceImpl implements AccountService {

	  final static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

   @Autowired
   private AccountDaoRepository accountDao;  
  
   @Override
   public Account save(Account account) {
      return accountDao.save(account);
   }
   
   @Override
   public    AccountDTO getAccount(long id) {
	   logger.info("Inside getAccount");
	   if (accountDao == null) {
		   logger.info("Inside accountDao null");
	   }
	   AccountDTO accountDto = accountDao.getAccountByID(id);
	   if (accountDto == null) {
		   logger.info("Inside getAccount null");
		   logger.info("Inside getAccount null id "+id);

	   }
	   return accountDto;
   }

 

   @Override
   public Page<Account> getAccountsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("accountNumber").descending());
	   return accountDao.findAll(pageable);
   }

   @Override
   public void update(long id, Account account) {
      accountDao.save(account);
   }

   
   @Override
   public void delete(long id) {
      accountDao.deleteById(id);
   }

}
