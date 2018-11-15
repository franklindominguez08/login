package com.fdlsolution.firstappexample;

import java.io.Serializable;

public class Profile implements Serializable {
    private String Name;
    private String Memo;
    private String Email;
    private String Password;
    private int Repos;
    private int Projects;
    private int Stars;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public int getRepos() {
        return Repos;
    }

    public void setRepos(int repos) {
        Repos = repos;
    }

    public int getProjects() {
        return Projects;
    }

    public void setProjects(int projects) {
        Projects = projects;
    }

    public int getStars() {
        return Stars;
    }

    public Profile(String name, String memo,String email, int repos, int projects, int stars,String password) {
        Name = name;
        Memo = memo;
        Email = email;
        Repos = repos;
        Projects = projects;
        Stars = stars;
        Password = password;
    }

    public void setStars(int stars) {
        Stars = stars;

    }
}
