package db;

/**
 * Created by Kotchaphan Muangsan on 07-Nov-14.
 */
public class user {
    private long id;
    private  String user;
    private  String pass;

    public void setId(long id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }
}
