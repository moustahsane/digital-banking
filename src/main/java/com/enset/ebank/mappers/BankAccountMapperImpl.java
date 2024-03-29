package com.enset.ebank.mappers;

import com.enset.ebank.DTO.*;
import com.enset.ebank.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapperImpl implements  BankAccountMapper{
    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDto);
        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        return customer;
    }

    @Override
    public SavingAccountDTO savingBankAccountToSavingBankAccountDTO(SavingAccount bankAccount) {

        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        BeanUtils.copyProperties(bankAccount, savingAccountDTO);
        savingAccountDTO.setCustomer(customerToCustomerDTO(bankAccount.getCustomer()));
        savingAccountDTO.setType(bankAccount.getClass().getSimpleName());
        return savingAccountDTO;
    }

    @Override
    public SavingAccount savingBankAccountDTOToSavingBankAccount(SavingAccountDTO bankAccountDTO) {

        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(bankAccountDTO, savingAccount);
        savingAccount.setCustomer(customerDtoToCustomer(bankAccountDTO.getCustomer()));
        return savingAccount;

    }

    @Override
    public CurrentAccountDTO currentBankAccountToCurrentBankAccountDTO(CurrentAccount bankAccount) {
        CurrentAccountDTO savingAccountDTO = new CurrentAccountDTO();
        BeanUtils.copyProperties(bankAccount, savingAccountDTO);
        savingAccountDTO.setCustomer(customerToCustomerDTO(bankAccount.getCustomer()));
        savingAccountDTO.setType(bankAccount.getClass().getSimpleName());
        return savingAccountDTO;

    }

    @Override
    public CurrentAccount currentBankAccountDTOToCurrentBankAccount(CurrentAccountDTO bankAccountDTO) {

        CurrentAccount savingAccount = new CurrentAccount();
        BeanUtils.copyProperties(bankAccountDTO, savingAccount);
        savingAccount.setCustomer(customerDtoToCustomer(bankAccountDTO.getCustomer()));
        return savingAccount;
    }


    @Override
    public BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountDTO);
        return bankAccountDTO;
    }

    @Override
    public BankAccount bankAccountDTOToBankAccount(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount= new BankAccount();
        BeanUtils.copyProperties(bankAccountDTO,bankAccount);
        return bankAccount;
    }

    @Override
    public AccountOperationDTO accountOperationToAccountOperationDTO(AccountOperation accountOperation) {

        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;


    }
}
