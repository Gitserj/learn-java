package main.generic;

class Summation {
    private int sum;

    <T extends Number> Summation(T num) {
        sum = 0;
        for(int i = 0; i <= num.intValue(); i++) sum += i;
    }

    int getSum() {
        return sum;
    }
}

public class GenConDemo {
    public static void main(String[] args) {
        Summation ob = new Summation(11.9);
        System.out.println("Сумма целых чисел от 0 до 11.9: " + ob.getSum());
    }
}
