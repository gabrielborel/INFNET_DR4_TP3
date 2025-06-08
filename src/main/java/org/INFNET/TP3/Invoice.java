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
        printInvoiceInfo(subtotal, discount, total);
    }

    private double calculateSubtotal() {
        return order.getItems().stream()
                .mapToDouble(item -> item.quantity() * item.price())
                .sum();
    }

    private void printCustomerInfo() {
        System.out.println("Cliente: " + order.getCustomerName() + " E-mail: " + order.getCustomerEmail());
    }

    private void printInvoiceInfo(double subtotal, double discount, double total) {
        printCustomerInfo();
        printItems();
        printValues(subtotal, discount, total);
    }

    private void printItems() {
        for (Item item : order.getItems()) {
            System.out.println(item.quantity() + "x " + item.productName() + " - R$" + item.price());
        }
    }

    private void printValues(double subtotal, double discount, double total) {
        System.out.printf("Subtotal: R$%.2f%n", subtotal);
        System.out.printf("Desconto: R$%.2f%n", discount);
        System.out.printf("Total final: R$%.2f%n", total);
    }
}

