public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
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

        System.out.println("Минимальная ЗП в месяц среди работников: " + minOfSalary(employees) + " р.");
        printSeparator();

        System.out.println("Максимальная ЗП в месяц среди работников: " + maxOfSalary(employees) + " р.");
        printSeparator();

        System.out.println("Средняя ЗП в месяц: " + sumOfSalary(employees)/ employees.length + " р.");
        printSeparator();

        System.out.println("ФИО всех сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
        }
        printSeparator();

        System.out.println("Изменение ФИО и отдела работника (в 4-й ячейке массива):");
        int id = 4 - 1;
        employees[id].setDepartment(4);
        employees[id].setFirstName("Николай");
        employees[id].setMiddleName("Александрович");
        employees[id].setLastName("Колесов");
        System.out.println(employees[id].toString());
        printSeparator();

        int salaryPercentIncrement = 12;
        System.out.println("Индексация зарплаты всех сотрудников на " + salaryPercentIncrement + "%:");
        for (int i = 0; i < employees.length; i++) {
            increaseSalary(employees[i], salaryPercentIncrement);
            System.out.println("ИД " + employees[i].getId() + ": " + employees[i].getSalary() + " р., " + employees[i].getLastName() + ", отедел " + employees[i].getDepartment());
        }
        printSeparator();

        int department = 5;
        System.out.println("Минимальная ЗП в месяц среди работников в отделе " + department + ": " + minOfSalaryInDepartment(employees, department) + " р.");
        printSeparator();

        System.out.println("Максимальная ЗП в месяц среди работников в отделе " + department + ": " + maxOfSalaryInDepartment(employees, department) + " р.");
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

    public static double minOfSalaryInDepartment(Employee[] employees, int department) {
        double salary = 2_000_000_000;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                if (salary > employees[i].getSalary()) {
                    salary = employees[i].getSalary();
                }
            }
        }
        return salary;
    }

    public static double minOfSalary(Employee[] employees) {
        double salary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (salary > employees[i].getSalary()) {
                salary = employees[i].getSalary();
            }
        }
        return salary;
    }

    public static double maxOfSalaryInDepartment(Employee[] employees, int department) {
        double salary = -1;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                if (salary < employees[i].getSalary()) {
                    salary = employees[i].getSalary();
                }
            }
        }
        return salary;
    }

    public static double maxOfSalary(Employee[] employees) {
        double salary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (salary < employees[i].getSalary()) {
                salary = employees[i].getSalary();
            }
        }
        return salary;
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
                printEmployee(employees[i]);
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
                printEmployee(employees[i]);
            }
        }
    }
    public static void listSalaryEqualOrMoreThan(Employee[] employees, double someSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= someSalary) {
                printEmployee(employees[i]);
            }
        }
    }
    public static void printEmployee(Employee employee) {
        System.out.println("ИД: " + employee.getId() + ", " + employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName() + ", " + employee.getSalary() + " р.");
    }

    public static void printSeparator() {
        System.out.println("-----------");
        System.out.println();
    }
}