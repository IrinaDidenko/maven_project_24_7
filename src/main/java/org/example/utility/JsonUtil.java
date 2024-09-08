package org.example.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.models.Student;
import org.example.models.University;

import javax.lang.model.element.NestingKind;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    /*to JSON*/
    public static String StudentSerialize(Student student) {

        return new GsonBuilder().setPrettyPrinting().create().toJson(student);

    }

    public static String UniversitySerialize(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String StuListSerialize(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String UniListSerialize(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }
    /*from JSON*/

    public static Student StudentDeSerialize(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static University UniversityDeSerialize(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static List<University> UniListDeSerialize(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {
        }.getType());
    }

    public static List<Student> StuListDeSerialize(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {
        }.getType());
    }

}
