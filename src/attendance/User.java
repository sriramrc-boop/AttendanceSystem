package attendance;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected String id;

    public User(){}
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
    public String getId() { return id; }
}
