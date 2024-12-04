public class Main {
    public static void main(String[] args) {

//        Инициализация и заполнение значений массива
        EmployeeBook employees = new EmployeeBook();
        initialFillList(employees);

//        Вывод полного списка работников
        System.out.println("Список всех сотрудников со всеми имеющимися по ним данными:");
        for (int i = 0; i < employees.getList().length; i++) {
            employees.printEmployee(employees.getList()[i], 3);
        }
        printSeparator();

//        Вывод сотрудника, найденного по ИД с недействительным ИД
        int someId = 11;
        System.out.println("Вывод сведений о сотруднике с ИД (" + someId + "):");
        if (!(employees.getEmployeeById(someId) == null)) {
            employees.printEmployee(employees.getEmployeeById(someId), 3);
        } else System.out.println("Сотрудник с ИД " + someId + " не найден в списке.");
        printSeparator();

//        Вывод сотрудника, найденного по ИД с действительным ИД
        someId = 4;
        System.out.println("Вывод сведений о сотруднике с ИД (" + someId + "):");
        if (!(employees.getEmployeeById(someId) == null)) {
            employees.printEmployee(employees.getEmployeeById(someId), 3);
        } else System.out.println("Сотрудник с ИД " + someId + " не найден в списке.");
        printSeparator();

        // Добавление сотрудника в список, когда список заполнен полностью
        Employee someEmployee = new Employee("Лев", "Николаевич", "Толстой", 5, 85000);

//        System.out.println("Удаление записи о сотруднике из списка по его ИД (" + someId + "):");

        if (!(employees.addNewEmployee(someEmployee))) {
            System.out.println("Свободных ячеек в списке нет!");
        } else {
            System.out.println("Данные сотрудника внесены в список успешно!");
        }
        printSeparator();

//        Удаление сотрудника по ИД
        System.out.println("Удаление из списка записи о сотруднике с ИД (" + someId + "):");
        if (employees.deleteEmployeeById(someId)) {
            System.out.println(employees.getEmployeeById(someId));
        } else System.out.println("Сотрудник с ИД " + someId + " не найден в списке.");
        printSeparator();

        // Добавление сотрудника в список, когда есть свободная ячейка
        if (!(employees.addNewEmployee(someEmployee))) {
            System.out.println("Свободных ячеек в списке нет!");
        } else {
            System.out.println("Данные сотрудника внесены в список успешно!");
        }
        printSeparator();

        //        Вывод полного списка работников
        System.out.println("Список всех сотрудников со всеми имеющимися по ним данными:");
        for (int i = 0; i < employees.getList().length; i++) {
            employees.printEmployee(employees.getList()[i], 3);
        }
        printSeparator();

        /*
        System.out.println("Сумма затрат на ЗП в месяц: " + employees.sumOfSalary(employees) + " р.");
        printSeparator();

        System.out.println("Минимальная ЗП в месяц у сотрудника:");
        EmployeeBook.printEmployee(EmployeeBook.employeeWithMinSalary(employees), 1);
        printSeparator();

        System.out.println("Максимальная ЗП в месяц у сотрудника:");
        EmployeeBook.printEmployee(EmployeeBook.employeeWithMaxSalary(employees), 1);
        printSeparator();

        System.out.println("Средняя ЗП в месяц: " + EmployeeBook.sumOfSalary(employees)/ employees.length + " р.");
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
        printSeparator();*/
    }

    public static void printSeparator() {
        System.out.println("-----------");
        System.out.println();
    }

    public static void initialFillList(EmployeeBook list) {
//      Первоначальное заполнение списка сотрудников

        Employee someEmployee0 = new Employee("Игорь", "Петрович", "Стрельников01", 1, 77000);
        Employee someEmployee1 = new Employee("Геннадий", "Петрович", "Стрельников02", 2, 77010);
        Employee someEmployee2 = new Employee("Иван", "Васильевич", "Стрельников03", 1, 74020);
        Employee someEmployee3 = new Employee("Александр", "Владимирович", "Стрельников04", 3, 77030);
        Employee someEmployee4 = new Employee("Виктор", "Семёнович", "Стрельников05", 4, 72040);
        Employee someEmployee5 = new Employee("Алексей", "Александрович", "Стрельников06", 5, 77050);
        Employee someEmployee6 = new Employee("Тимофей", "Ильич", "Стрельников07", 4, 77060);
        Employee someEmployee7 = new Employee("Александр", "Николаевич", "Стрельников08", 5, 67000);
        Employee someEmployee8 = new Employee("Денис", "Викторович", "Стрельников09", 3, 73000);
        Employee someEmployee9 = new Employee("Анатолий", "Сергеевич", "Стрельников10", 2, 72000);

        list.addNewEmployee(someEmployee0);
        list.addNewEmployee(someEmployee1);
        list.addNewEmployee(someEmployee2);
        list.addNewEmployee(someEmployee3);
        list.addNewEmployee(someEmployee4);
        list.addNewEmployee(someEmployee5);
        list.addNewEmployee(someEmployee6);
        list.addNewEmployee(someEmployee7);
        list.addNewEmployee(someEmployee8);
        list.addNewEmployee(someEmployee9);
/*
    if (!(list.addNewEmployee(someEmployee0))) {
        System.out.println("Свободных ячеек в списке нет!");
    } else {
        System.out.println("Данные сотрудника внесены в список успешно!");
    }
    printSeparator();

    if (!(list.addNewEmployee(someEmployee1))) {
        System.out.println("Свободных ячеек в списке нет!");
    } else {
        System.out.println("Данные сотрудника внесены в список успешно!");
    }
    printSeparator();

    if (!(list.addNewEmployee(someEmployee2))) {
        System.out.println("Свободных ячеек в списке нет!");
    } else {
        System.out.println("Данные сотрудника внесены в список успешно!");
    }
    printSeparator();
*/
    }
}