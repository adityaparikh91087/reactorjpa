package com.reactor.jpa.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Flux<Customer> getCustomers(String firstNameContaining){
        return Flux.fromStream(repository.streamAllByFirstNameContaining(firstNameContaining))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
