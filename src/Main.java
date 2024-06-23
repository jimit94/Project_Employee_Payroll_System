import java.security.PublicKey;
import java.util.ArrayList;

abstract class Employee{
    private int id;
    private String name;
    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
   public String getName(){
        return name;
   }
   public int getId(){
        return id;
   }
   public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee { name :"+name
                +" , id :"+id
                +" , Salary :"+calculateSalary()+" }";
    }
}
class FullTimeEmployee extends Employee{
private double monthlySalary;

    public FullTimeEmployee(String name, int id,double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }


    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
     Employee employeeToRemove = null;
     for(Employee employee : employeeList){
         if(employee.getId() == id){
            employeeToRemove = employee;
             employeeList.remove(employeeToRemove);
            break;
         }

     }
    }
    public void displayEmployees(){
        for (Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
      PayrollSystem payrollSystem = new PayrollSystem();
      FullTimeEmployee emp1 = new FullTimeEmployee("Jimit",4,50000);
      PartTimeEmployee emp2 = new PartTimeEmployee("Raju",6,22,4000);
      PartTimeEmployee emp3 = new PartTimeEmployee("Guddu",3,12,2000);
      payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        System.out.println("Initial Employee Details");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employee");
        payrollSystem.removeEmployee(3);
        System.out.println("Updated employee list");
        payrollSystem.displayEmployees();

    }
}