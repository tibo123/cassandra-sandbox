package iblutha.demo.cassandra;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import iblutha.demo.cassandra.persistance.CassandraManager;
import iblutha.demo.cassandra.persistance.ICassandraManager;
import iblutha.demo.cassandra.services.UserService;

import javax.inject.Inject;

import static spark.Spark.get;

/**
 * Created by talend on 13.11.15.
 */
public class Application {

    private ICassandraManager cassandraManager;
    private UserService userService;

    public Application () {
        Gson gson = new Gson();
        Injector injector = Guice.createInjector(new AppModule());
        this.cassandraManager = injector.getInstance(ICassandraManager.class);
        this.userService = injector.getInstance(UserService.class);

        get("/cassandra", (req, res) -> cassandraManager.toString());

        get("/users", (req, res) -> userService.getAllUsers(), gson::toJson);
    }

    public static void main(String[] args) {
        new Application();
    }
}
