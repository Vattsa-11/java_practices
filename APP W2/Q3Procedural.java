public class Q3Procedural {
    public static double HighSalary(double[] s){
        double highest = 0;
        for (double sal : s){
            if(sal > highest){
                highest = sal;
            }
        }
        return highest;
    }
    public static void main(String[] args){
        double[] salaries = {1000.34, 2000.55, 2000.45, 2000.75, 700.99};
        System.out.printf("Highest Salary : %.2f", HighSalary(salaries));
    }
}
