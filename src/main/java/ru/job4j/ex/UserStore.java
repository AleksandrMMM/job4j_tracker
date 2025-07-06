package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {

        for (User user : users) {
            if (validate(user))
             if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("пользователя не нашли в списке");

    }

    public static boolean validate(User user) throws UserInvalidException {

        if (!(user != null && user.isValid())) {
            throw new UserInvalidException("пользователь не валидный");
        }
        if (user.getUsername().length() <= 3) {
            throw new UserInvalidException("имя пользователя состоит из менее трех символов");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        User user;
        try {
            user = findUser(users, "Petr Arsentev");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            throw new RuntimeException(e);
        }
    }
}