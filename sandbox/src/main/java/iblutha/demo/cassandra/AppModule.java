package iblutha.demo.cassandra;

import com.google.inject.AbstractModule;
import iblutha.demo.cassandra.persistance.CassandraManager;
import iblutha.demo.cassandra.persistance.ICassandraManager;
import iblutha.demo.cassandra.services.CassandraUserService;
import iblutha.demo.cassandra.services.UserService;

/**
 * Created by talend on 13.11.15.
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ICassandraManager.class).to(CassandraManager.class);
        bind(UserService.class).to(CassandraUserService.class);
    }
}
