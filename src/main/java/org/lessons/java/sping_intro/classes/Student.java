package org.lessons.java.sping_intro.classes;

import java.io.Serializable;

//CREARE UN JAVA BEAN (implements Serializable) poi vedi in HomeController
public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String username;

    public Student() {
    };

    public Student(String firstName, String lastName, String email, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s;", firstName, lastName, email, username);
    }

}
