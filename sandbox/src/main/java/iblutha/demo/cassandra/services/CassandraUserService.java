package iblutha.demo.cassandra.services;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import iblutha.demo.cassandra.domain.User;
import iblutha.demo.cassandra.persistance.CassandraManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by talend on 13.11.15.
 */
public class CassandraUserService implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraUserService.class);
    private static final String GETALL_USERS = "SELECT * FROM users";

    private Session session;

    @Inject
    public CassandraUserService(CassandraManager cassandraManager) {
        LOGGER.debug(cassandraManager.toString());
        this.session = cassandraManager.getSession();
    }

    public List<User> getAllUsers() {
        List<User> rows = session.execute(GETALL_USERS).all()
                .stream()
                .map(r ->  new User(r.getInt("id"), r.getString("firstname"), r.getString("lastname")))
                .collect(Collectors.toList());
        return rows;
    }

    public String getAllUsersJSON() {
        return session.execute(GETALL_USERS).toString();
    }
}
