package lessonNine.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ваня", Arrays.asList(
                new Course("Алгебра"),
                new Course("Физика"),
                new Course("Философия"),
                new Course("Java"))));
        students.add(new Student("Света", Arrays.asList(
                new Course("IoT"),
                new Course("Моделирование"))));
        students.add(new Student("Паша", Arrays.asList(
                new Course("C++"),
                new Course("Java"),
                new Course("IoT"),
                new Course("Python"),
                new Course("БД"))));
        students.add(new Student("Татьяна", Arrays.asList(
                new Course("Экономика"),
                new Course("Java"),
                new Course("Философия"))));

        System.out.println(getUniqueCourses(students));
        System.out.println(getThreeMostCuriousStudent(students));
        System.out.println(getStudentsByCourse(students, new Course("Java")));
    }

    public static List<String> getUniqueCourses(List<Student> students) {
        return students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .map(c -> c.getName())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getThreeMostCuriousStudent(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsByCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());
    }
}
