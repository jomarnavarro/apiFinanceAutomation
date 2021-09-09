package com.finance.pojo.api;

public class Credentials {
    String username;
    String password;

    public Credentials(String u, String p) {
        this.username = u;
        this.password = p;
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

    public String toString() {
        return "[" + this.getUsername() + ", " + this.getPassword() + "]";
    }
}
