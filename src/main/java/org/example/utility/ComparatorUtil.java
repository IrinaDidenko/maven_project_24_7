package org.example.utility;

import org.example.comparators.*;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    ;

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {

        return switch (studentComparatorType) {
            case UNIVERSITY_ID -> new StudentUniIDComparator();
            case FULL_NAME -> new StudentFullNameComparator();
            case COURSE -> new StudentCourseComparator();
            case AVG_EXAM_SCORE -> new StudentAvgCourseComparator();

        };
    }
    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType){
        return switch (universityComparatorType) {
            case ID -> new UniversityIDComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case PROFILE -> new UnivercityMainProfileComparator();
            case YEAR -> new UniversityYearComparator();

        };
    }

}
