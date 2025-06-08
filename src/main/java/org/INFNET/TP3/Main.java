package org.INFNET.TP3;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new Customer("João", "joao@email.com"));
        order.addItem("Notebook", 1, 3500.0);
        order.addItem("Mouse", 2, 80.0);

        order.printInvoice();
        order.sendEmail();
    }
}
