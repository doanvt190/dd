import java.util.*;
import java.util.Stack;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. add Student");
                System.out.println("2. edit Student");
                System.out.println("3. delete Student");
                System.out.println("4. sort Student");
                System.out.println("5. search Student");
                System.out.println("6. display Students");
                System.out.println("7. exit");
                System.out.print("Choose an option: ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        addStudent(sc);
                        break;
                    case 2:
                        editStudent(sc);
                        break;
                    case 3:
                        deleteStudent(sc);
                        break;
                    case 4:
                        sortStudents();
//                    sortReversed();

                        break;
                    case 5:
                        searchStudent(sc);
                        break;
                    case 6:
                        displayStudents();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine();
            }catch (NoSuchElementException e) {
                System.out.println("lỗi không tìm thấy sinh viên ");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }

    }

    private static void addStudent(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            String id = sc.next();
            System.out.print("Enter a name: ");
            String name = sc.next();
            if (name.matches(".*\\d.*")){
                System.out.println("tên ko được chứa số");
                return;
            }
            System.out.print("Enter points: ");
            double marks = sc.nextDouble();
            if (marks < 0 || marks > 10) {
                System.out.println("điểm phải nămf trong khoảng từ 0 đến 10.");
                return;
            }
            students.add(new Student(id, name, marks));
        }catch (InputMismatchException e) {
            System.out.println("Lỗi: Điểm phải là số");
            sc.nextLine();
            return;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
    }

    private static void editStudent(Scanner sc) {
        System.out.print("Nhập ID để chỉnh sửa: ");
        String id = sc.next();
        boolean found = false;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                try {
                    System.out.print("Nhập Tên mới: ");
                    String name = sc.next();
                    if (name.matches(".*\\d.*")){
                        System.out.println("tên ko được chứa số");
                        return;
                    }
                    System.out.print("Nhập Điểm mới: ");
                    double marks = sc.nextDouble();
                    if (marks < 0 || marks > 10) {
                        System.out.println("điểm phải nằm trong khoảng từ 0 đến 10");
                        return;
                    }
                    students.remove(student);
                    students.add(new Student(id, name, marks));
                    found = true;
                    break;
                }catch(InputMismatchException e ) {
                    System.out.println("Lỗi: điểm phải là số ");
                    sc.nextLine();
                    return;
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
        if(!found){

            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    private static void deleteStudent(Scanner sc) {
        System.out.print("Nhập ID để xóa: ");
        String id = sc.next();
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (removed) {
            System.out.println("sinh viên đã được xóa");

        }else {
            System.out.println("không tìm thấy sinh viên ");
        }
    }

    private static void sortStudents() {
//        Collections.sort(students, (s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
        Collections.sort(students, Comparator.comparing(Student::getMarks));
        for(Student std : students){
            System.out.println(std.toString());
        }
        System.out.println("Sinh viên đã được sắp xếp theo điểm.");
    }

    public static void sortReversed() {
        Collections.sort(students, Comparator.comparing(Student::getMarks).reversed());
        for(Student std : students){
            System.out.println(std.toString());
        }
        System.out.println("Sinh vien duoc sap xep giam dan theo diem");
    }

    private static void searchStudent(Scanner sc) {
        System.out.print("Nhập ID để tìm kiếm: ");
        String id = sc.next();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }
}