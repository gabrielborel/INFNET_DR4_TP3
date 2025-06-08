package org.INFNET.TP3;

public class Invoice {
    private static final double DISCOUNT_RATE = 0.1;
    private final Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public void print() {
        double subtotal = calculateSubtotal();
        double discount = DiscountPolicy.calculateDiscount(subtotal, DISCOUNT_RATE);
        double total = subtotal - discount;

        System.out.println("Cliente: " + order.getCustomerName());
        for (Item item : order.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProductName() + " - R$" + item.getPrice());
        }
        System.out.println("Subtotal: R$" + subtotal);
        System.out.println("Desconto: R$" + discount);
        System.out.println("Total final: R$" + total);
    }

    private double calculateSubtotal() {
        double subtotal = 0;
        for (Item item : order.getItems()) {
            subtotal += item.getQuantity() * item.getPrice();
        }
        return subtotal;
    }
}

