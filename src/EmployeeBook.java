public class EmployeeBook {
    private Employee[] list;

    public EmployeeBook() {
        this.list = new Employee[10];
        for (int i = 0; i < list.length; i++) {
            this.list[i] = null;
        }
    }

    public Employee[] getList() {
        return this.list;
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < this.list.length; i++) {
            if (!(list[i] == null) && list[i].getId() == id) {
                return list[i];
            }
        }
        return null;
    }

    public boolean deleteEmployeeById(int id) {
        for (int i = 0; i < this.list.length; i++) {
            if (!(list[i] == null) && list[i].getId() == id) {
                System.out.println(list[i]);
                list[i] = null;
                return true;
            }
        }
        return false;
    }

    private int findEmptySlot() {
        int emptySlot = -1;
        for (int i = 0; i < this.list.length; i++) {
            if (list[i] == null) {
                emptySlot = i;
                return emptySlot;
            }
        }
        return emptySlot;
    }

    public boolean addNewEmployee(Employee someEmployee) {
        if (findEmptySlot() >= 0) {
            this.list[findEmptySlot()] = someEmployee;
            return true;
        }
        return false;
    }

    public double sumOfSalaryInDepartment(Employee[] list, int department) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            if (department == list[i].getDepartment()) {
                sum += list[i].getSalary();
            }
        }
        return sum;
    }

    public double sumOfSalary(Employee[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i].getSalary();
        }
        return sum;
    }

    public Employee employeeWithMinSalaryInDepartment(Employee[] list, int department) {
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < list.length; i++) {
            if (department == list[i].getDepartment()) {
                if (employeeWithMinSalary == null || list[i].getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = list[i];
                }
            }
        }
        return employeeWithMinSalary;
    }

    public Employee employeeWithMinSalary(Employee[] list) {
        Employee employeeWithMinSalary = null;
        for (int i = 1; i < list.length; i++) {
            if (employeeWithMinSalary == null || list[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = list[i];
            }
        }
        return employeeWithMinSalary;
    }

    public Employee employeeWithMaxSalaryInDepartment(Employee[] list, int department) {
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < list.length; i++) {
            if (department == list[i].getDepartment()) {
                if (employeeWithMaxSalary == null || list[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = list[i];
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public Employee employeeWithMaxSalary(Employee[] list) {
        Employee employeeWithMaxSalary = null;
        for (int i = 1; i < list.length; i++) {
            if (employeeWithMaxSalary == null || list[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = list[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public int numberOflistInDepartment(Employee[] list, int department) {
        int emplCounter = 0;
        for (int i = 0; i < list.length; i++) {
            if (department == list[i].getDepartment()) {
                emplCounter++;
            }
        }
        return emplCounter;
    }

    public void listlistInDepartment(Employee[] list, int department) {
        for (int i = 0; i < list.length; i++) {
            if (department == list[i].getDepartment()) {
                printEmployee(list[i], 1);
            }
        }
    }

    public void increaseSalary(Employee employee, double increment) {
        employee.setSalary(employee.getSalary() + employee.getSalary() * (increment / 100));
    }

    public void increaseSalaryInDepartment(Employee[] list, int department, double increment) {
        for (int i = 0; i < list.length; i++) {
            if (department == list[i].getDepartment()) {
                list[i].setSalary(list[i].getSalary() + list[i].getSalary() * (increment / 100));
            }
        }
    }

    public void listSalaryLessThan(Employee[] list, double someSalary) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getSalary() < someSalary) {
                printEmployee(list[i], 1);
            }
        }
    }

    public void listSalaryEqualOrMoreThan(Employee[] list, double someSalary) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getSalary() >= someSalary) {
                printEmployee(list[i], 1);
            }
        }
    }

    public void printEmployee(Employee employee, int printmode) {
//        printmode: 1 - печать без отдела
//        printmode: 2 - печать только ФИО
//        printmode: 3 - печать всех данных
        String fioToPrint = employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName();
        if (printmode == 1) {
            System.out.println("ИД: " + employee.getId() + ", " + fioToPrint + ", " + employee.getSalary() + " р.");
        } else if (printmode == 2) {
            System.out.println(fioToPrint);
        } else if (printmode == 3) {
            int numberOfSpaces = 40 - fioToPrint.length();
            fioToPrint += ",";
            for (int i = 1; i <= numberOfSpaces; i++) {
                fioToPrint += " ";
            }
            System.out.println("ИД: " + employee.getId() + ", " + fioToPrint + "отдел " + employee.getDepartment() + ", " + employee.getSalary() + " р.");
        }
    }
}
