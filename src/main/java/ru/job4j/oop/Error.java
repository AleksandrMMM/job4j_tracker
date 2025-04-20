package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printErrorDetails() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {

        Error defaultError = new Error();
        defaultError.printErrorDetails();

        Error error1 = new Error(true, 404, "Not Found");
        error1.printErrorDetails();

        Error error2 = new Error(true, 500, "Internal Server Error");
        error2.printErrorDetails();

        Error error3 = new Error(false, 200, "OK");
        error3.printErrorDetails();
    }
}