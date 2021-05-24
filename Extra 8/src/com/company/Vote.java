package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Vote implements Serializable {
    private Person person;
    private String date;
    public Vote(Person person, String date){
        this.person = person;
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(person, vote.person) && Objects.equals(date, vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }
}
