package com.pb.khyl.hw12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Contact {
    private String fullName;
    private GregorianCalendar dateOfBirth;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<String> phoneNumbers;
    private String address;
    private String changeTime;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        if (dateOfBirth != null) {
            return df.format(dateOfBirth.getTime());
        } else {
            return null;
        }
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumbers(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        changeTime = formatter.format(calendar.getTime());
    }

    public Contact(String fullName, GregorianCalendar dateOfBirth, ArrayList<String> phoneNumbers, String address) {
        this();
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }

    public Contact(String fullName, ArrayList<String> phoneNumbers) {
        this();
        this.fullName = fullName;
        this.phoneNumbers = phoneNumbers;
    }

    public Contact() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.changeTime = formatter.format(calendar.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(fullName, contact.fullName) && Objects.equals(dateOfBirth, contact.dateOfBirth) && Objects.equals(phoneNumbers, contact.phoneNumbers) && Objects.equals(address, contact.address) && Objects.equals(changeTime, contact.changeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, dateOfBirth, phoneNumbers, address, changeTime);
    }

    @Override
    public String toString() {
        return "Contact {" +
                "Имя: '" + fullName + '\'' + "\n" +
                "Дата рождения: " +  getDateOfBirth() + "\n" +
                "Номер: " + phoneNumbers + "\n" +
                "Адрес: '" + address + '\'' + "\n" +
                "Время изменения: '" + changeTime + '\'' +
                '}' + "\n" + "\n";
    }

}

