package edu.example.controller;

import edu.example.model.Customer;
import edu.example.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {
    final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer, HttpServletRequest request) {
        if(Boolean.TRUE.equals(customerService.saveCustomer(customer))) {
            String os = request.getRemoteAddr();
            log.info("request received IP: {} | added customer detail: {}", os,customer);
            return ResponseEntity.ok("customer added successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added customer");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer( @RequestBody Customer customer,
                                                 HttpServletRequest request){
        if(Boolean.TRUE.equals(customerService.updateCustomer(customer))) {
            String os = request.getRemoteAddr();
            log.info("request received IP: {} | update customer detail: {}", os, customer);
            return ResponseEntity.ok("product update successful");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't update customercustomer");
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        Customer customer = customerService.getCustomerById(id);
        if (customer != null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable String id,HttpServletRequest request){
        if (customerService.deleteCustomer(id)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | delete customer id: {}", os,id );
            return ResponseEntity.ok("product customer successfully");
        }else{
            return ResponseEntity.internalServerError().body("try again! , can't delete customer");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> list = customerService.getAllCustomers();
        if (list!=null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
