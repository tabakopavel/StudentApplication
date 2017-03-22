package Model;

public class User {
    private int id_user;
    private String user;
    private String password;
    private String email;
    private int activation;
    private String user_token;

    public User() {
    }

    public int getId_user() {
        return id_user;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActivation() {
        return activation;
    }

    public String getEmail() {
        return email;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq;
        User user = (User) obj;
        String login = user.getUser();
        String pass = user.getPassword();


        if (login.equals(this.getUser()) && pass.equals(this.getPassword())) {
            eq = true;
        } else {
            eq = false;
        }
        return eq;
    }

    @Override
    public String toString() {
        return this.id_user + " " + this.user + " " + this.password + " " + this.email + " " + this.activation + " "+ this.user_token;
    }
}
