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
    public static String ListToJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
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
