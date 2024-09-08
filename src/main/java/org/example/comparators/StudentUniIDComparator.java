package org.example.comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.models.Student;

public class StudentUniIDComparator implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
