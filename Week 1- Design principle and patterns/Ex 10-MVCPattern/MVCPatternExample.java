public class MVCPatternExample {

    // MODEL
    static class Student {
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() { return name; }
        public String getId() { return id; }
        public String getGrade() { return grade; }

        public void setName(String name) { this.name = name; }
        public void setId(String id) { this.id = id; }
        public void setGrade(String grade) { this.grade = grade; }
    }

    // VIEW
    static class StudentView {
        public void displayStudentDetails(String name, String id, String grade) {
            System.out.println(" Student Details:");
            System.out.println("Name  : " + name);
            System.out.println("ID    : " + id);
            System.out.println("Grade : " + grade);
        }
    }

    // CONTROLLER
    static class StudentController {
        private Student student;
        private StudentView view;

        public StudentController(Student student, StudentView view) {
            this.student = student;
            this.view = view;
        }

        public void setStudentName(String name) { student.setName(name); }
        public void setStudentId(String id) { student.setId(id); }
        public void setStudentGrade(String grade) { student.setGrade(grade); }

        public String getStudentName() { return student.getName(); }
        public String getStudentId() { return student.getId(); }
        public String getStudentGrade() { return student.getGrade(); }

        public void updateView() {
            view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
        }
    }

    // MAIN - TEST MVC FLOW
    public static void main(String[] args) {
        Student model = new Student("Karthika", "S1023", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Karthika U");
        controller.setStudentGrade("A+");

        System.out.println("\n After Updating Details:\n");
        controller.updateView();
    }
}
