package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User requiredUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                requiredUser = user;
            }
        }
        if (requiredUser == null) {
            throw new UserNotFoundException("User was not found");
        }
        return requiredUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = true;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Non-valid user.");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}