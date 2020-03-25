package repositories;

import model.User;

import java.util.Optional;

public class UserRepository {
    private User[] users = new User[10]; // am o singura instanta, cea a array-ului

    public UserRepository(){
        this.users[0] = new User("gigel", "12345");
        this.users[1] = new User("dorel", "abcde");
        this.users[2] = new User("nicu", "qwerty");
    }

    // clasa option este folosita ca sa eviti null
    public Optional<User> findUserByUsername(String username) {
        for(User u : users) {
            if(u != null) {
                if(username.equals(u.getUsername())) { // == in Java testeaza referintele, de aia folosim equals
                    return Optional.of(u);
                }
            }
        }
        return Optional.empty();
    }

    public static UserRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private static final class SingletonHolder {        // bill pugh
        private static final UserRepository INSTANCE = new UserRepository();
    }
}
