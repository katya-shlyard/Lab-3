import java.util.Arrays;
class budget{ //создаю новый класс budget//
    double []amount = new double[0];// массив для храниеня денежной величины операции
    String []name = new String[0];//массив для храниения названия операции
    String []sign = new String[0]; // массив для хранения знака - показателя характера операции(пополнение/расход)
    public budget(){//конструктор
        String []sign = new String[0];
        double []amount = new double[0];
        String []name = new String[0];
    }
    public void add(String d,double x, String n){ //задание 2.метод для добавления дохода в бюджет
        String []d1 = new String[sign.length + 1];//создаю новые временные массивы на 1 больше чем изначальные
        double []a1 = new double[amount.length+1];
        String []n1 = new  String[name.length+1];
        for(int i = 0; i<name.length; i++){
            a1[i]=amount[i];
            n1[i]=name[i];
            d1[i] = sign[i];
        }
        a1[amount.length] = x;
        n1[name.length] = n;
        d1[sign.length] = d;
        //присваиваю изначальным массивам значения временных//
        name = n1;
        amount = a1;
        sign = d1;
    }
    public void addSpend(String d,double x, String n){//задание 3. Добавление расхода
        String []d1 = new String[sign.length + 1]; //новые временные массивы по аналогии с первым заданием
        double []a1 = new double[amount.length+1];
        String []n1 = new  String[name.length+1];
        for(int i = 0; i<name.length; i++){
            a1[i]=amount[i];
            n1[i]=name[i];
            d1[i] = sign[i];
        }
        a1[amount.length] = x;
        n1[name.length] = n;
        d1[sign.length] = d;
        // присваиваю изначальным массивам значения временных
        name = n1;
        amount = a1;
        sign = d1;
    }
    public int spends(){ //задание 4. посчет количества расходов
        int c = 0;//устанавливаю счетчик
        for(int i = 0; i<amount.length; i++){
            if (sign[i] == "-"){
                c++;
            }
        }
        System.out.println("Всего расходов ");
        return c;//возвращаю счетчик
    }
    public int summ(){//задание 5. Подсчет суммарного дохода
        int c = 0;
        for(int i = 0; i<amount.length; i++){
            if (sign[i] == "+"){
                c+=amount[i];
            }
        }
        System.out.println("Cумма всех доходов  ");
        return c;
    }
    public String bigger(int x){//задание 6. Выводит записи о доходах и расходах, больше суммы х
        System.out.println("Доходы и расходы больше чем  " + x+":");
        for(int i = 0; i<amount.length; i++){
            if (amount[i] > x){
                System.out.println(sign[i]+name[i] +" "+ amount[i]);
            }
        }
        return "";
    }
    public String onlySpends(){//задание 7. Вывод всех расходов
        System.out.println("Все записи расходов:");
        for(int i = 0; i<amount.length; i++){
            if (sign[i] == "-"){
                System.out.println(sign[i]+name[i] +" "+ amount[i]);
            }
        }
        return "";
    }
    public String threeTheMost(){ // задание 8. Выводит 3 самые большие дохода
        double a1 = -10000000;//3 вспомогательные переменные, изначально инициализиремые очень маленькими значениями, впомледствии будут хранить 3 значения саммых больших дохода
        double a2 = -10000000;
        double a3 = -10000000;
        for(int i = 0; i<amount.length; i++){ // записываю во временные переменные самые большие доходы
            if(sign[i] == "+"){
                if (amount[i]>a1){
                    double a4 = a2;
                    a2=a1;
                    a3=a4;
                    a1 = amount[i];
                }
                else if(amount[i]>a2){
                    a3 = a2;
                    a2 = amount[i];
                }
                else if(amount[i]>a3){
                    a3 = amount[i];
                }
            }
        }
        System.out.println("3 самые большие дохода: ");
        for (int i = 0; i<amount.length; i++){ // вывод записей с самыми большими доходами
            if(amount[i]==a1){
                System.out.println(sign[i]+name[i] +" "+ amount[i]);
            }
            if(amount[i]==a2){
                System.out.println(sign[i]+name[i] +" "+ amount[i]);
            }
            if(amount[i]==a3){
                System.out.println(sign[i]+name[i] +" "+ amount[i]);
            }
        }
        return "";
    }
    public boolean isIncomeBigger(){ //Задание 9. Превышают ли расходы доходы
        int income = 0;//переменные для подсчета суммы доходов и расходов
        int spend =0;
        System.out.println("Доходы больше расходов? ");
        for (int i = 0; i<amount.length; i++){
            if (sign[i] == "+"){
                income += amount[i];
            }
            else {
                spend+= amount[i];
            }
        }
        if (income>spend){
            return true;
        }
        else {
            return false;
        }
    }
    public int difference(){ // Задание 10. Вычисление разницы между доходами и расходами
        int income = 0; //переменные для подсчета суммы расходов и доходов
        int spend = 0;
        System.out.println("Разница между доходами и расходами составляет: ");
        for (int i = 0; i<amount.length; i++){
            if (sign[i] == "+"){
                income += amount[i];
            }
            else {
                spend+= amount[i];
            }
        }
        if (spend>=income){
            return -1;
        }
        else {
            int x = income-spend; // разница между доходами и расходами
            return x; // выводим разницу
        }

    }
    public void delete(int x){ // задание 11. Удаление записи бюджета по номеру
        for (int i = 0; i<amount.length-1; i++){
            if (i>=x-1){
                sign[i] = sign[i+1];
                amount[i] = amount[i+1];
                name[i] = name[i+1];
            }
        }
        double[]a1 = new double[amount.length-1];//создание новых массивов длины на 1 меньше изначальных
        String[]a2 = new String[a1.length];
        String[] a3 = new String[a1.length];
        for (int i = 0; i<amount.length-1; i++){
            a1[i] = amount[i];
            a2[i] = sign[i];
            a3[i] = name[i];
        }
        name = a3; // присвоение изначальным массиам значений новых массивов
        sign = a2;
        amount = a1;
    }
    public void equal(){ //задание 12. Удаление записей расходов до тех пор, пока расходы не будут превышать доходов
        int income = 0; //переменные для суммы доходов и расходов
        int spend = 0;
        for (int i = 0; i<amount.length; i++){
            if (sign[i] == "+"){
                income += amount[i];
            }
            else {
                spend+= amount[i];
            }
        }
        while (spend>income){
            double mn = 1111000000; //временная перменная с очень большим значением для поиска минимального элемента расходов
             for (int i = 0; i<amount.length; i++){
                if(sign[i] == "-"){
                    if (amount[i]<mn){
                        mn = amount[i];
                    }
                }
            }
            for (int j = 0; j<amount.length; j++){ // удаление записи по аналогии с предыдущим заданием
                if (amount[j] == mn){
                    for (int i = 0; i<amount.length-1; i++){
                        if (i>=j){
                            sign[i] = sign[i+1];
                            amount[i] = amount[i+1];
                            name[i] = name[i+1];
                        }
                    }
                    double[]a1 = new double[amount.length-1];
                    String[]a2 = new String[a1.length];
                    String[] a3 = new String[a1.length];
                    for (int i = 0; i<amount.length-1; i++){
                        a1[i] = amount[i];
                        a2[i] = sign[i];
                        a3[i] = name[i];
                    }
                    name = a3;
                    sign = a2;
                    amount = a1;
                }
            }
            income = 0;//пересчитываем суммы расходов и доходов после удаления
            spend = 0;
            for (int i = 0; i<amount.length; i++){
                if (sign[i] == "+"){
                    income += amount[i];
                }
                else {
                    spend+= amount[i];
                }
            }
        }
    }
    public String minimum() { //задание 13. Нахождение минимального расхода, при удалении которого доходы будут превышать расходы
        int income = 0;//временные переменные для подсчета суммы расходов  доходов
        int spend = 0;
        System.out.println("Минимальный расход, при удалении которого доходы будут превышать расходы составляет: ");
        for (int i = 0; i < amount.length; i++) {
            if (sign[i] == "+") {
                income += amount[i];
            } else {
                spend += amount[i];
            }
        }
        if (income > spend) { //если расхоы изначально меньше доходов выводим null
            return null;
        }
        else {
            double[] mn = new double[amount.length]; // новый массив, куда записываем только значения расходов
            for (int i = 0; i < amount.length; i++) {
                if (sign[i] == "-") {
                    mn[i] = amount[i];
                }
            }
            double[]mn1 = new double[mn.length];//новый массив, куда записываем значения тех расходов, при удалении которых доходы превысят расходы
            for (int i = 0; i < mn.length; i++){
                if (spend-mn[i]<income){
                    mn1[i] = mn[i];
                }
            }
            double x  = 10000000; //очень большая переменная для нахождения минимального элемента предыдущего массива
            for (int i = 0; i < mn1.length; i++) {
                if (mn1[i] < x&&mn1[i]!=0) {
                    x = mn1[i];
                }
            }
            if (x == 10000000){//если х остался равен очень большому числу, значит подходящего расхода не нашлось, выводим null
                return null;
            }
            return String.format("%.2f",x) ;
        }
    }
    @Override
    public String toString () { //вывод записей бюджета
        for (int i = 0; i < amount.length; i++) {
            System.out.println(sign[i] + name[i] + " " + amount[i]);
        }
        return "";
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Создан новый бюджет:");
        budget b = new budget();

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


