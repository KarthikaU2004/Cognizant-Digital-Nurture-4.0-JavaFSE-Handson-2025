public class TaskManagementSystem {

    static class Task {
        int taskId;
        String taskName;
        String status;

        Task next;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    static class TaskList {
        private Task head;

        public void addTask(int id, String name, String status) {
            Task newTask = new Task(id, name, status);
            if (head == null) {
                head = newTask;
            } else {
                Task temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newTask;
            }
            System.out.println("Task added: " + id);
        }

        public void viewTasks() {
            System.out.println("All Tasks:");
            Task current = head;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }

        public Task searchTask(int id) {
            Task current = head;
            while (current != null) {
                if (current.taskId == id) return current;
                current = current.next;
            }
            return null;
        }

        public void deleteTask(int id) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.taskId == id) {
                head = head.next;
                System.out.println("Task deleted: " + id);
                return;
            }

            Task current = head;
            while (current.next != null) {
                if (current.next.taskId == id) {
                    current.next = current.next.next;
                    System.out.println("Task deleted: " + id);
                    return;
                }
                current = current.next;
            }

            System.out.println("Task not found: " + id);
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(1, "Design UI", "Pending");
        taskList.addTask(2, "Write backend logic", "In Progress");
        taskList.addTask(3, "Testing", "Not Started");

        System.out.println();
        taskList.viewTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task t = taskList.searchTask(2);
        if (t != null) System.out.println(t);
        else System.out.println("Task not found.");

        System.out.println("\nDeleting Task ID 1:");
        taskList.deleteTask(1);

        System.out.println("\nFinal Task List:");
        taskList.viewTasks();
    }
}
