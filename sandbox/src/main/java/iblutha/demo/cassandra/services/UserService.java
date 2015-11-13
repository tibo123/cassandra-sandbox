package iblutha.demo.cassandra.services;

import iblutha.demo.cassandra.domain.User;

import java.util.List;

/**
 * Created by talend on 13.11.15.
 */
public interface UserService {

    List<User> getAllUsers();
    String getAllUsersJSON();
}
