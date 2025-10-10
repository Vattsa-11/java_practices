public class Q1 {
    
    static class Employee {
        private
        String name;
        int id;
        double salary = 0;

        public
        Employee(String n, int i, double s){
            name = n;
            id = i;
            salary = s;
        }
        void display(){
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Salary: " + salary);
        }
    }

    public static void main(String[] args){
        Employee e1 = new Employee("John Doe", 12345, 50000.0);
        Employee e2 = new Employee("Jane Smith", 67890, 60000.0);

        e1.display();
        e2.display();
    }



}
