package org.example.utility;

import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUnil {
    private StatisticsUnil() {
    }//приватный конструктор

    public static List<Statistics> formStatistics(List<Student> studentList,
                                                  List<University> uniList) {

        List<Statistics> statisticsList = new ArrayList<>();

        //make a set of study profiles

        Set<StudyProfile> studyProfiles = uniList.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        studyProfiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);

            //по каждому профилю нужно собрать университеты с эим профилем, чтобы потом
            // считать средний балл и прочее
            List<String> uniPerProfile = uniList.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            //собрали в лист айдишники универов по профилю
//считаем количество универов как длину листа
            statistics.setUniversityCount(uniPerProfile.size());
            //считаем количество студентов в универах по профилю
            List<Student> stuPerProfile = studentList.stream()
                    .filter(student -> uniPerProfile.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStudentCount(stuPerProfile.size());
            //считаем средний балл как сумму средних баллов студентов по профилю разделенное на количество студентов
            OptionalDouble avgExamScore = stuPerProfile.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
// складываем в одну строку названия универов по профилю, наверное короткие
            statistics.setUniversityNames(StringUtils.EMPTY);
            uniList.stream()
                    .filter(university -> uniPerProfile.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullNameUniversity + ",\n"));
        });
        return statisticsList;
    }
}


