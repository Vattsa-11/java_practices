public class Q3OOPS {
    static class Employee {
        private
        double salary;
        public
        Employee(double s){
            salary = s;
        }
        double getSalary(){
            return salary;
        }
    }
    public static void main(String[] args){
        Employee[] e = {
            new Employee(1000.59),
            new Employee(1200.55),
            new Employee(6900.45),
            new Employee(3400.22),
            new Employee(7200.35),
            new Employee(7200.34)
        };
        double highest = 0;
        for (Employee emp : e){
            if(emp.getSalary() > highest){
                highest = emp.getSalary();
            }
        }
        System.out.printf("Highest Salary : %.2f", highest);
    }
}
