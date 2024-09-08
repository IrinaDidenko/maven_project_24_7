package org.example.enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    COMPUTERSCIENCE("Информационные технологии"),
    PHILOSOPHY("Философия"),
    FUNDAMENTALMATH("Фундаментальная математика"),
    PHYSICS ("Физика"),
    MATHEMATICS("Математика"),
    LINGUISTICS ("Лингвистика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "Специальность " + profileName;
    }
}
