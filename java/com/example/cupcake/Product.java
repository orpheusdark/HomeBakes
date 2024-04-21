package com.example.cupcake;

public class Product
{
    private String ProductID;
    private String ProductName;
    private String CategoryID;
    private int Quantity;
    private int Price;

    public Product() {

    }

    public Product(String productID, String productName, String categoryID, int quantity, int price) {
        ProductID = productID;
        ProductName = productName;
        CategoryID = categoryID;
        Quantity = quantity;
        Price = price;
    }

    public Product(String productID,String productName, int parseInt, int parseInt1) {
        ProductID = productID;
        ProductName = productName;
        Quantity = parseInt;
        Price = parseInt1;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }




}
