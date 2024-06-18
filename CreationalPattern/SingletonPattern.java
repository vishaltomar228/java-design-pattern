package SingeltonPattern;

public class SingletonPattern {

    public static void main(String[] args) {

        Employee employee = Employee.getInstance();

        employee.printHello();

    }
}

class Employee {

    private final static Employee EMPLOYEE = new Employee();

    private Employee() {}

    public void printHello() {
        System.out.println("Hello from employee");
    }

    public static Employee getInstance() {
        return EMPLOYEE;
    }

}
