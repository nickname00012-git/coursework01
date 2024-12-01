public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
//        Инициализация и заполнение значений массива
        employees[0] = new Employee("Игорь", "Петрович", "Стрельников01", "1-й отдел", 77000);
        employees[1] = new Employee("Геннадий", "Петрович", "Стрельников02", "2-й отдел", 77010);
        employees[2] = new Employee("Иван", "Васильевич", "Стрельников03", "1-й отдел", 74020);
        employees[3] = new Employee("Александр", "Владимирович", "Стрельников04", "3-й отдел", 77030);
        employees[4] = new Employee("Виктор", "Семёнович", "Стрельников05", "4-й отдел", 72040);
        employees[5] = new Employee("Алексей", "Александрович", "Стрельников06", "5-й отдел", 77050);
        employees[6] = new Employee("Тимофей", "Ильич", "Стрельников07", "4-й отдел", 77060);
        employees[7] = new Employee("Александр", "Николаевич", "Стрельников08", "5-й отдел", 67000);
        employees[8] = new Employee("Денис", "Викторович", "Стрельников09", "3-й отдел", 73000);
        employees[9] = new Employee("Анатолий", "Сергеевич", "Стрельников10", "2-й отдел", 72000);

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
    }

    public static int sumOfSalary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
//            System.out.println("employees[i].getSalary() = " + employees[i].getSalary());
        }
        return sum;
    }

    public static int minOfSalary(Employee[] employees) {
        int salary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (salary > employees[i].getSalary()) {
                salary = employees[i].getSalary();
//                System.out.println("employees[i].getSalary() = " + employees[i].getSalary());
            }
        }
        return salary;
    }

    public static int maxOfSalary(Employee[] employees) {
        int salary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (salary < employees[i].getSalary()) {
                salary = employees[i].getSalary();
//                System.out.println("employees[i].getSalary() = " + employees[i].getSalary());
            }
        }
        return salary;
    }
    public static void printSeparator() {
        System.out.println("-----------");
        System.out.println();
    }
}