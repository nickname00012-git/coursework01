public class Employee {
    public static int idCounter = 1;
    private String firstName;
    private String middleName;
    private String lastName;
    private String department;
    private int id;
    private int salary;


    public Employee(String fName, String mName, String lName, String employeeDepartment, int employeeSalary) {
        this.id = idCounter;
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
        this.salary = employeeSalary;
        this.department = employeeDepartment;
        idCounter++;
    }

    @Override
    public String toString() {
        return "ИД: " + this.id + ", " + this.firstName + " " + this.middleName + " " + this.lastName + ", " + this.department + ", ЗП: " + this.salary + " р.";
    }

    // Исправить метод
    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.lastName, this.middleName, this.firstName);
    }

    @Override
//            исправить метод
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (this.hashCode() != that.hashCode()) {
            return false;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        Employee someEmployee = (Employee) that;
        if (!(this.lastName.equals(someEmployee.lastName))) {
            return false;
        }
        return (this.lastName.equals(someEmployee.lastName) && this.firstName.equals(someEmployee.firstName) && this.middleName.equals(someEmployee.middleName));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public void setSalary(String newDepartment) {
        this.department = newDepartment;
    }
}
