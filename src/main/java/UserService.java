import java.util.*;
public class UserService {

    private List<User> allUsers = new ArrayList<>();

    public UserService(){
        allUsers.add(new User("1", "G", "g@gmail.com"));
        allUsers.add(new User("2", "M", "m@gmail.com"));
    }
    public List<User> getAllUsers(){
        return allUsers;
    }
}
