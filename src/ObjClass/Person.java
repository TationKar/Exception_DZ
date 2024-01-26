package ObjClass;

import java.util.Date;

public class Person {
    String surnamePerson;
    String namePerson;
    String middleName;
    Long phone_number;
    String date_of_Birth;
    String persons_gender;

    public String getSurnamePerson() {
        return surnamePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public String getDate_of_Birth() {
        return date_of_Birth;
    }

    public String getPersons_gender() {
        return persons_gender;
    }

    public void setSurnamePerson(String surnamePerson) {
        this.surnamePerson = surnamePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public void setDate_of_Birth(String date_of_Birth) {
        this.date_of_Birth = date_of_Birth;
    }

    public void setPersons_gender(String persons_gender) {
        this.persons_gender = persons_gender;
    }
}
