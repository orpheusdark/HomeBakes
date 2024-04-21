package com.example.cupcake;

public class Order
{
    private String OrderID;
    private String Customername;
    private String ProductID;
    private int Quantity;
    private int Total;


    public Order(String customername, String productID, int quantity, int total) {
        Customername = customername;
        ProductID = productID;
        Quantity = quantity;
        Total = total;
    }

    public Order() {

    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }
}
