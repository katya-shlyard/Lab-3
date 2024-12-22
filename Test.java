public class Main {
    public static void main(String[] args) {
        System.out.println("Создан новый бюджет:");
        budget b = new budget(); // создание нового бюджета

        b.add("+",77000, "зарплата"); // добавление доходов
        b.add("+",5600,"подарок от бабушки");
        b.add("+",6000,"подработка");
        b.add("+",100,"нашел на тротуаре");
        b.add("-",45, "сосиска в тесте"); // добавление расходов
        b.add("-",5000, "подарки на новый год друзьям");
        b.add("-",1500, "оплата общаги");
        b.add("-",78500, "покупка ноутбука");
        System.out.println(b);
        System.out.println(" ");
        System.out.println(b.spends()); // количество записей о расходах
        System.out.println(" ");
        System.out.println(b.summ());//cумма доходов
        System.out.println(" ");
        System.out.println(b.isIncomeBigger());
        System.out.println(" ");
        System.out.println(b.bigger(3000)); // записи операций с суммами больше 3000
        System.out.println(" ");
        System.out.println(b.onlySpends()); // только записи о расходах
        System.out.println(" ");
        System.out.println(b.threeTheMost()); // 3 самых значимых дохода
        b.delete(3);// удаление 3ей записи в бюджете
        System.out.println("Бюджет после удаления 3ей записи");
        System.out.println(b);
        System.out.println(" ");
        System.out.println(b.minimum());
        System.out.println(" ");
        System.out.println("Бюджет с уравненными расходами и доходами: ");
        b.equal(); //уравнивание доходов и расходов
        System.out.println(b);
    }
}