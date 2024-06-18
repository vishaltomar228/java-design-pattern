package BuilderPattern;

public class BuilderPattern {

    public static void main(String[] args) {

        Employee employee = new Employee.EmployeeBuilder().email("vishal.tomar")
                .name("Vishal")
                .salary(10000000)
                .build();

        System.out.println(employee.toString());
    }
}

class Employee {

    String name;
    int salary;
    String email;

    Employee(EmployeeBuilder employeeBuilder) {
        this.email = employeeBuilder.email;
        this.salary = employeeBuilder.salary;
        this.name = employeeBuilder.name;
    }

    public static class EmployeeBuilder {

        String name;
        int salary;
        String email;

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}
