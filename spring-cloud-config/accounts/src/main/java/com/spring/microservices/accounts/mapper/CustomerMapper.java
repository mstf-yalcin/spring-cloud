package com.spring.microservices.accounts.mapper;

import com.spring.microservices.accounts.dto.CustomerDto;
import com.spring.microservices.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setAccountsDto(AccountsMapper.toDto(customer.getAccounts()));
        return customerDto;
    }

    public static Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        if (customerDto.getAccountsDto() != null)
            customer.setAccounts(AccountsMapper.toEntity(customerDto.getAccountsDto()));
        return customer;
    }

}
