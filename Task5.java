import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getDetails() {
        return courseCode + " - " + title + "\nDescription: " + description + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student {
    int studentID;
    String name;
    List<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (String course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Course course1 = new Course("CSE1001", "Introduction to Computer Science", "Fundamental concepts of computer science", 50, "Mon/Wed 10:00 AM - 11:30 AM");
        Course course2 = new Course("MAT2002", "Linear Algebra", "linear algebra and its applications", 40, "Tue/Thu 1:00 PM - 2:30 PM");

        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(course1);
        availableCourses.add(course2);

        Student student1 = new Student(1001, "shiva");
        Student student2 = new Student(1002, "nanda");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("1. View available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Courses:");
                    for (Course course : availableCourses) {
                        System.out.println(course.getDetails());
                    }
                    break;
                case 2:
                System.out.println("Enter course code to register: ");
                String courseCode = scanner.next();
                Course selectedCourse = null;
                for (Course course : availableCourses) {
                    if (course.courseCode.equals(courseCode)) {
                        selectedCourse = course;
                        break;
                    }
                }
                if (selectedCourse != null && selectedCourse.capacity > 0) {
                    student1.registerCourse(courseCode);
                    selectedCourse.capacity--;
                    System.out.println("Registration successful.");
                } else {
                    System.out.println("Course is full or does not exist.");
                }
                break;
                case 3:
                System.out.println("Enter course code to drop: ");
                String courseToDrop = scanner.next();
                if (student1.registeredCourses.contains(courseToDrop)) {
                    student1.dropCourse(courseToDrop);
                    for (Course course : availableCourses) {
                        if (course.courseCode.equals(courseToDrop)) {
                            course.capacity++;
                        }
                    }
                    System.out.println("Course dropped successfully.");
                } else {
                    System.out.println("You are not registered for this course.");
                }
                break;
                case 4:
                    System.out.println("bye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}