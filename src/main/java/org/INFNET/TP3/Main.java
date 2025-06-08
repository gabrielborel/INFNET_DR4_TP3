package org.INFNET.TP3;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new Customer("João", "joao@email.com"));
        order.addItem("Notebook", 1, 3500.0);
        order.addItem("Mouse", 2, 80.0);

        new Invoice(order).print();
        EmailService.sendEmail(order.getCustomerEmail(), generateEmailMessage(order));
    }

    private static String generateEmailMessage(Order order) {
        return "Pedido recebido, " + order.getCustomerName() + "! Obrigado pela compra.";
    }
}
