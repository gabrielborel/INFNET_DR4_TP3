package org.INFNET.TP3;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Customer customer;
    private final List<Item> items = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addItem(String name, int quantity, double price) {
        items.add(new Item(name, quantity, price));
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }

    public List<Item> getItems() {
        return items;
    }

    public void notifyCustomer() {
        String message = "Pedido recebido! Obrigado pela compra.";
        sendEmailToCustomer(message);
    }

    private void sendEmailToCustomer(String message) {
        EmailService.sendEmail(customer.getEmail(), message);
    }
}

