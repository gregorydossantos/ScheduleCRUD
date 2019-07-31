package model;

public class Schedule {

    //Variables (variable names are the same as in DB)...
    private int id;
    private String name, number, nick_name, email;

    //Getters and Setters...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nickname) {
        this.nick_name = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
