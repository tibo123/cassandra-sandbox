package iblutha.demo.cassandra.persistance;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


import javax.inject.Singleton;

/**
 * Created by talend on 13.11.15.
 */
//@Singleton
public class CassandraManager implements ICassandraManager {

    public static final String ADDRESS = "localhost";
    public static final String KEYSPACE = "cassandrademo";

    private Session session;
    private String cassandraVersion;
    private String clusterName;

    public CassandraManager () {
        Cluster cluster = Cluster.builder().addContactPoint(ADDRESS).build();
        this.session = cluster.connect(KEYSPACE);
        getCassandraInfo();
    }

    private void getCassandraInfo() {
        Row row = getSession().execute("select cluster_name, release_version from system.local").one();
        this.cassandraVersion = row.getString("release_version");
        this.clusterName = row.getString("cluster_name");
    }

    public Session getSession() {
        return session;
    }

    public String toString() {
        return new StringBuilder("CassandraManager Info [")
                .append("version : ").append(cassandraVersion).append(",")
                .append("cluster name : ").append(clusterName).append("]")
                .toString();
    }
}
