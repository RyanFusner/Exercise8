package com.fusner.Exercise8;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ContactBook contacts = new ContactBook();
        contacts.add(new Contact("name1", "name1@example.com"));
        contacts.add(new Contact("name2", "name2@example.com"));
        contacts.add(new BusinessContact("name3", "name3@example.com", "000-0001"));
        contacts.add(new BusinessContact("name4", "name4@example.com", "000-0002"));

        contacts.displayAll();
    }
}

class ContactBook
{
    private ArrayList<Contact> contacts;

    public ContactBook()
    {
        this.contacts = new ArrayList<>();
    }

    public void add(Contact contact)
    {
        this.contacts.add(contact);
    }

    public void displayAll()
    {
        for (Contact contact: this.contacts)
        {
            contact.display();
        }
        System.out.println("Total Contacts: " + Contact.getTotal());
        System.out.println("Total Business Contacts: " + BusinessContact.getTotal());
    }
}

class Contact
{
    private String name;
    private String email;
    private static int total = 0;

    //region getters and setters
    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public static int getTotal()
    {
        return Contact.total;
    }
    //endregion

    public Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
        Contact.total++;
    }

    public void display()
    {
        System.out.println("Name: " + this.name + "\nEmail: " + this.email + "\n");
    }
}

class BusinessContact extends  Contact
{
    private String phone;
    private static int businessTotal = 0;

    //region getters and setters
    public String getPhone()
    {
        return phone;
    }

    public static int getTotal()
    {
        return BusinessContact.businessTotal;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    //endregion

    public BusinessContact(String name, String email, String phone)
    {
        super(name, email);
        this.phone = phone;
        BusinessContact.businessTotal++;
    }

    @Override
    public void display()
    {
        System.out.println("Name: " + super.getName() + "\nEmail: " + super.getEmail() + "\nPhone: " + this.phone + "\n");
    }
}