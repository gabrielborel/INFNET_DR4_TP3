package org.INFNET.TP3;

import java.util.ArrayList;
import java.util.List;

class Order {
   private final Customer customer;
    private final List<Item> items = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addItem(String productName, int quantity, double price) {
        items.add(new Item(productName, quantity, price));
    }

    public void printInvoice() {
        double subtotal = 0;
        System.out.println("Cliente: " + customer.getName());
        for (Item item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProductName() + " - R$" + item.getPrice());
            subtotal += item.getPrice() * item.getQuantity();
        }

        double discountRate = 0.1;
        double discount = DiscountPolicy.calculateDiscount(subtotal, discountRate);
        double total = subtotal - discount;

        System.out.println("Subtotal: R$" + subtotal);
        System.out.println("Desconto: R$" + discount);
        System.out.println("Total final: R$" + total);
    }

    public void sendEmail() {
        EmailService.sendEmail(customer.getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}
