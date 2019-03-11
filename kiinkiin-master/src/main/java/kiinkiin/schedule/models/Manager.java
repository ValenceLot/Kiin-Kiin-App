package kiinkiin.schedule.models;

public class Manager {
    private int managerId;
    private String name;
    private String username;
    private String password;
    private String cpr;
    private String position;

    public Manager(int managerId, String name, String username, String password,String cpr, String position){
        this.managerId = managerId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.cpr = cpr;
        this.position = position;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
