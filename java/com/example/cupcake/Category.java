package com.example.cupcake;

public class Category
{
    private String CategoryId;
    private String CategoryName;

    public Category (String categoryId){
        CategoryId=categoryId;
    }
    public Category(String categoryId, String categoryName){
        CategoryId= categoryId;
        CategoryName= categoryName;
    }

    public Category() {

    }

    public String getCategoryId()
    {
        return CategoryId;
    }
    public void setCategoryId(String categoryId){
        CategoryId=categoryId;
    }
    public String getCategoryName(){
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
