package com.example.girilab2;

public class client {
    private int ID;
    private String Name;

    private String Username;

    private String Password;
    public client(int ID, String Name, String Username, String Password) {
        this.ID = ID;
        this.Name = Name;
        this.Username = Username;
        this.Password = Password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
       this.Password = password;
    }
}
