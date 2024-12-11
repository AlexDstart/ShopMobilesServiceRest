package ru.alexdstart.shopmobilesservicerest.exceptions;

public class PhoneNotFoundException extends  RuntimeException{
    public PhoneNotFoundException(String message) {
        super(message);
    }
}
