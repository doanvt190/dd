public class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        if (marks < 5.0) return "Trượt";
        if (marks < 6.5) return "Trung bình";
        if (marks < 7.5) return "Khá";
        if (marks < 9.0) return "Giỏi";
        return "Xuất sắc";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Điểm: " + marks + ", Xếp hạng: " + getRank();
    }
}
