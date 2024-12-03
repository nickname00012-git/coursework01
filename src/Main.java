public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

//        Инициализация и заполнение значений массива
        employees[0] = new Employee("Игорь", "Петрович", "Стрельников01", 1, 77000);
        employees[1] = new Employee("Геннадий", "Петрович", "Стрельников02", 2, 77010);
        employees[2] = new Employee("Иван", "Васильевич", "Стрельников03", 1, 74020);
        employees[3] = new Employee("Александр", "Владимирович", "Стрельников04", 3, 77030);
        employees[4] = new Employee("Виктор", "Семёнович", "Стрельников05", 4, 72040);
        employees[5] = new Employee("Алексей", "Александрович", "Стрельников06", 5, 77050);
        employees[6] = new Employee("Тимофей", "Ильич", "Стрельников07", 4, 77060);
        employees[7] = new Employee("Александр", "Николаевич", "Стрельников08", 5, 67000);
        employees[8] = new Employee("Денис", "Викторович", "Стрельников09", 3, 73000);
        employees[9] = new Employee("Анатолий", "Сергеевич", "Стрельников10", 2, 72000);

//        Вывод списка работников
        System.out.println("Список всех сотрудников со всеми имеющимися по ним данными:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        printSeparator();

        System.out.println("Сумма затрат на ЗП в месяц: " + sumOfSalary(employees) + " р.");
        printSeparator();

        System.out.println("Минимальная ЗП в месяц у сотрудника:");
        printEmployee(employeeWithMinSalary(employees), 1);
        printSeparator();

        System.out.println("Максимальная ЗП в месяц у сотрудника:");
        printEmployee(employeeWithMaxSalary(employees), 1);
        printSeparator();

        System.out.println("Средняя ЗП в месяц: " + sumOfSalary(employees)/ employees.length + " р.");
        printSeparator();

        System.out.println("ФИО всех сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            printEmployee(employees[i], 2);
        }
        printSeparator();

        System.out.println("Изменение ФИО и отдела работника (в 4-й ячейке массива):");
        int id = 4 - 1;
        employees[id].setDepartment(4);
        employees[id].setFirstName("Николай");
        employees[id].setMiddleName("Александрович");
        employees[id].setLastName("Колесов");
        System.out.println(employees[id]);
        printSeparator();

        int salaryPercentIncrement = 12;
        System.out.println("Индексация зарплаты всех сотрудников на " + salaryPercentIncrement + "%:");
        for (int i = 0; i < employees.length; i++) {
            increaseSalary(employees[i], salaryPercentIncrement);
            System.out.println(employees[i]);
        }
        printSeparator();

        int department = 5;
        System.out.println("Сотрудник с минимальной ЗП в месяц в отделе " + department + ":");
        printEmployee(employeeWithMinSalaryInDepartment(employees, department), 1);
        printSeparator();

        System.out.println("Сотрудник с максимальной ЗП в месяц в отделе " + department + ":");
        printEmployee(employeeWithMaxSalaryInDepartment(employees, department), 1);
        printSeparator();

        System.out.println("Средняя ЗП в месяц в отделе " + department + ": " + (sumOfSalaryInDepartment(employees, department) / numberOfEmployeesInDepartment(employees, department)) + " р.");
        printSeparator();

        System.out.println("Сумма затрат на ЗП в месяц в отделе " + department + ": " + sumOfSalaryInDepartment(employees, department) + "  р.");
        printSeparator();

        salaryPercentIncrement = 5;
        System.out.println("Индексация зарплаты сотрудников отдела " + department + " на " + salaryPercentIncrement + "%:");
        increaseSalaryInDepartment(employees, department, salaryPercentIncrement);
        listEmployeesInDepartment(employees, department);
        printSeparator();

        double salaryToCheck = 82902;
        System.out.println("Сотрудники с ЗП ниже чем " + salaryToCheck + " р.:");
        listSalaryLessThan(employees, salaryToCheck);
        printSeparator();

        System.out.println("Сотрудники с ЗП равной или больше чем " + salaryToCheck + " р.:");
        listSalaryEqualOrMoreThan(employees, salaryToCheck);
        printSeparator();
    }

//    **************
//    *** Методы ***
//    **************
//

    public static double sumOfSalaryInDepartment(Employee[] employees, int department) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public static double sumOfSalary(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static Employee employeeWithMinSalaryInDepartment(Employee[] employees, int department) {
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                if (employeeWithMinSalary == null || employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = employees[i];
                }
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee employeeWithMinSalary(Employee[] employees) {
        Employee employeeWithMinSalary = null;
        for (int i = 1; i < employees.length; i++) {
            if (employeeWithMinSalary == null || employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee employeeWithMaxSalaryInDepartment(Employee[] employees, int department) {
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                if (employeeWithMaxSalary == null || employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = employees[i];
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public static Employee employeeWithMaxSalary(Employee[] employees) {
        Employee employeeWithMaxSalary = null;
        for (int i = 1; i < employees.length; i++) {
            if (employeeWithMaxSalary == null || employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }
    public static int numberOfEmployeesInDepartment(Employee[] employees, int department) {
        int emplCounter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                emplCounter++;
            }
        }
        return emplCounter;
    }

    public static void listEmployeesInDepartment(Employee[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                printEmployee(employees[i], 1);
            }
        }
    }

    public static void increaseSalary(Employee employee, double increment) {
        employee.setSalary(employee.getSalary() + employee.getSalary() * (increment / 100));
    }

    public static void increaseSalaryInDepartment(Employee[] employees, int department, double increment) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * (increment / 100));
            }
        }
    }

    public static void listSalaryLessThan(Employee[] employees, double someSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < someSalary) {
                printEmployee(employees[i], 1);
            }
        }
    }
    public static void listSalaryEqualOrMoreThan(Employee[] employees, double someSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= someSalary) {
                printEmployee(employees[i], 1);
            }
        }
    }

    public static void printEmployee(Employee employee, int printmode) {
//        printmode: 1 - печать без отдела
//        printmode: 2 - печать только ФИО
//        printmode: 3 - печать всех данных

        if (printmode == 1) {
            System.out.println("ИД: " + employee.getId() + ", " + employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName() + ", " + employee.getSalary() + " р.");
        } else if (printmode == 2) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
        } else if (printmode == 3) {
            System.out.println(employee);
        }
    }

    public static void printSeparator() {
        System.out.println("-----------");
        System.out.println();
    }
}