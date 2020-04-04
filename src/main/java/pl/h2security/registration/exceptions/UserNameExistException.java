package pl.h2security.registration.exceptions;

public class UserNameExistException extends RuntimeException {
    public UserNameExistException(String message) {
        super(message);
    }
}
