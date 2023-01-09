package com.reactor.jpa.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Stream<Customer> streamAllByFirstNameContaining(String firstNameContains);
}
