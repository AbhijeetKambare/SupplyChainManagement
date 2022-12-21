package com.example.supplychainmanagement;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class LogIn {
    private static byte[] getSHA(String input){
        try{
            MessageDigest messageDigest= MessageDigest.getInstance("SHA-256");
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getEncryptedPassword(String password){
        //String encryptedPassword="";
        try{
            BigInteger number=new BigInteger(1,getSHA(password));
            StringBuilder hexString=new StringBuilder(number.toString(16));//convert to hexadecimal
            return hexString.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean customerLogin(String email,String password){
        String query=String.format("SELECT * FROM customer WHERE email='%s' and password='%s'",email,password);
        try{
            DatabaseConnection dbcon=new DatabaseConnection();
            ResultSet rs= dbcon.getQueryTable(query);
            if(rs!=null && rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        LogIn login=new LogIn();
       // System.out.println(login.customerLogin("abhijewet@gmail.com","abc@123"));
        System.out.println(login.getEncryptedPassword("abc@123"));
    }
}
