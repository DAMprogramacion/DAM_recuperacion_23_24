package RA5;

import java.util.Objects;

//id,first_name,last_name,email,gender
public class Persona {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;

    public Persona(int id, String firstName, String lastName, String email, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

   /* public void setId(int id) {
        this.id = id;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    /* id: 5
       first_name: xxxxxx
       last_name: xxxxxx
       email: kdkjf@jgkgdl.com
       gender: xxxx*/
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: ").append(id).append('\n');
        builder.append("first_name: ").append(firstName).append('\n');
        builder.append("last_name: ").append(lastName).append('\n');
        builder.append("email: ").append(email).append('\n');
        builder.append("gender: ").append(gender.toString().toLowerCase()).append('\n');
        return builder.toString();
    }
}