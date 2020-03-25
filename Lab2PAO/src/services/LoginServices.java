package services;

import model.User;
import repositories.UserRepository;
import java.util.Optional;

public class LoginServices {


    public LoginServices() {

    }

    public boolean login(User user) {
        Optional<User> u = UserRepository.getInstance().findUserByUsername(user.getUsername());

        if (u.isPresent()) {
            User usr =u.get();
            if(usr.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
            return false;
    }

    public static LoginServices getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {        // bill pugh
        private static final LoginServices INSTANCE = new LoginServices();
    }

}
