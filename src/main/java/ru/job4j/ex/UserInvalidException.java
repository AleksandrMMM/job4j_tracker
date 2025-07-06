package ru.job4j.ex;

public class UserInvalidException extends UserNotFoundException {

    public UserInvalidException(String mess) {
        super(mess);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
