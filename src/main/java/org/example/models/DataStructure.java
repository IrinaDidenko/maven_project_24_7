package org.example.models;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;
@XmlRootElement(name= "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataStructure {

    @XmlElementWrapper(name="studentsInfo")
    @XmlElement(name="studentEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name="universitiesInfo")
    @XmlElement(name="universityEntry")
    private List<University> universityList;
    @XmlElementWrapper(name="statisticalInfo")
    @XmlElement(name="statisticsEntry")
    private List<Statistics> statisticsList;

    @XmlElement(name="processedAt")
    private Date processedDate;
    public DataStructure(){//private constructor
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

}
