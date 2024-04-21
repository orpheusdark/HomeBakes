package com.example.cupcake;

public class User
{
    private String Name;
    private String Email;
    private String MobileNo;
    private String Password;
    private String Usertype;


    public User()
    {

    }


    public User( String name, String email, String mobileNo, String password, String usertype) {

        Name = name;
        Email = email;
        MobileNo = mobileNo;
        Password = password;
        Usertype = usertype;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String usertype) {
        Usertype = usertype;
    }





}
