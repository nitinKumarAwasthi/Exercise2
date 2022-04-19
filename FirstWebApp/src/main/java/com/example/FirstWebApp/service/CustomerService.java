package com.example.FirstWebApp.service;

import com.example.FirstWebApp.model.Customer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomerService {

    // i am creating customer list which is going to hold customer object.
    private List<Customer> customerList = new CopyOnWriteArrayList<>(); // asi ithe normal arrayList nhi use kiti
    private int customerIdCount = 1; // mai ithe id assign krti jo ki 1 a .

    public Customer addCustomer(Customer customer) { // ithe Customer jo kii class a oh ik mera type a jene ohde ander bht sare hor objects hold krne objects saade alag alag customers hune a.
        customer.setCustomerId(customerIdCount); // ithe mai keha jeda mera phla customer huna a ohnu id= 1 dede.
        customerList.add(customer); // ithe mai customer nu List ch add krta a
        customerIdCount++; // ithe mai keha ki id nu incerase krde mtlb id= 2 ho gyi, hun jeda next customer create huna ohdi id automatically 2 ho jani te idai hi increse hoi jani .
        return customer; // ithe mai keha ki customer return krde saada.
    }

    // how to get list of customers
    public List<Customer> getCustomers(){
        return customerList; // ithe mai customerList jo mai uper bnai c oh return kra reha a.
    }

    // how to return only specific customer
    public Customer getCustomer(int customerId){
       return customerList
                .stream()// mai keha ki Customer LIst ch ja
                .filter(c -> c.getCustomerId() == customerId) // mai loop laya, c nu mai as id assign krreha a jedi utente ne insert krni a, m keha ki every inserted c ne  {gets CustomerId() } that isequal to already existed customerId
                .findFirst() // oh id nu find kr
                .get(); // oh id nu print kr
    }

    // i am creating method to update existing customer by passing id and customer as a parameters
    public Customer updateCustomer(int customerId, Customer customer ){

        customerList
                .stream() // mai keha ki Customer List ch
                .forEach(c -> { // for every c
                    if (c.getCustomerId() == customerId) { // where inserted id is equalto customerId
                        c.setNome(customer.getNome()); // set Name krde as eh wala method use krke getNome()
                        c.setCognome(customer.getCognome());// set Cogname krde as eh wala method use krke getCognome()
                        c.setEmail(customer.getEmail());// set E-mail krde as eh wala method use krke getEmail()
                    }
                });
                return customerList
                        .stream()
                        .filter(c -> c.getCustomerId() == customerId)
                        .findFirst()
                        .get();
    }

    // how to delete customer with id
    public void deleteCustomer(int customerId) {

        customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                        }
                        );
    }
}
