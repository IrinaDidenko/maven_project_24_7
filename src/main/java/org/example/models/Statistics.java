package org.example.models;

import org.example.enums.StudyProfile;

public class Statistics {
private StudyProfile studyProfile;
private float avgScore;
private int studentCount;
private int universityCount;
private String universityNames;

/*public Statistics(StudyProfile studyProfile, float avgScore, int studentCount, int universityCount, String universityNames){
    this.studyProfile=studyProfile;
    this.avgScore=avgScore;
    this.studentCount=studentCount;
    this.universityCount=universityCount;
    this.universityNames=universityNames;
}
*/

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
    }
}
