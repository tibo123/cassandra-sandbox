package iblutha.demo.cassandra.domain;

/**
 * Created by talend on 13.11.15.
 */
public class User {
    private int id;
    private String firstname;
    private String lastname;


    public User(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
