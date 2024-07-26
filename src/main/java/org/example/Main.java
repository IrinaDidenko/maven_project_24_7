package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        University mgu = new University("1", "Московский Государственный университет", "МГУ", 1755, StudyProfile.PHILOSOPHY);
        University bauman = new University("2", "Московский государственный технический университет им. Н. Э. Баумана", "МГТУ им. Н.Э. Баумана", 1830, StudyProfile.COMPUTERSCIENCE);
        University sfu = new University("3", "Южный Федеральный университет", "ЮФУ", 1915, StudyProfile.FUNDAMENTALMATH);

        Student student1 = new Student("Горшков Зиновий Николаевич", "1", 12, 4.89F);
        Student student2 = new Student("Сысоев Болеслав Игоревич", "1", 45, 3.48F);
        Student student3 = new Student("Сорокин Роберт Ярославович", "3", 7, 4.45F);
        Student student4 = new Student("Сысоев Терентий Евгеньевич", "2", 12, 4.00F);
        Student student5 = new Student("Кононова Вероника Лукьевна", "2", 35, 4.9F);
        System.out.println(mgu.toString());
        System.out.println(bauman.toString());
        System.out.println(sfu.toString());
        System.out.println("---------------------\n Студенты");
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());
        System.out.println(student5.toString());

        }
    }
