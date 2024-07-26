package org.example;

public class University {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getMainProfile() {
        return mainProfile.toString();
    }

    @Override
    public String toString() {
        return "-------------\n Полное наименование: " + getFullName() + "\n Краткое наименование :" + getShortName() +
                "\n Год основания: " + getYearOfFoundation() + "г. \n Основная специализация : "
                + getMainProfile();
    }
}
