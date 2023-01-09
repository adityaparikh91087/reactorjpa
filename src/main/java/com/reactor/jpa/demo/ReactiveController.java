package com.reactor.jpa.demo;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@ResponseBody
@Transactional
public class ReactiveController {

    private final CustomerService customerService;

    public ReactiveController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public Flux<Customer> getCustomers(){
        return customerService.getCustomers("a");
    }

}
