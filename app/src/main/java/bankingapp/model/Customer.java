package bankingapp.model;

import java.util.Collections;
import java.util.ArrayList;

public class Customer {
    // Required fields
    private final String firstName;
    private final String lastName;
    private final String email;
    private int idnumber;
    private String phoneNumber;
    private int age;

    private ArrayList<Account> accounts;

    private Customer(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;

    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public int getIDNumber(){ return idnumber; }
    public String getPhoneNumber(){ return phoneNumber; }
    public int age(){ return age; }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private int idnumber;
        private String phoneNumber;
        private int age;

        public Builder (String firstName, String lastName, String email){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder idnumber(int idnumber){
            this.idnumber = idnumber;
            return this;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Customer build(){
            return new Customer(this);
        }
    }
}
