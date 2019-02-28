package main.lambda;

interface SomeTest<T> {
    boolean test(T a, T b);
}

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeTest<Integer> isFactor = (a, b) -> (a % b) == 0;
        if(isFactor.test(10, 2)) System.out.println("2 - делитель 10\n");

        SomeTest<Double> isFactorD = (a, b) -> (a % b) == 0;
        if(isFactorD.test(10.0, 5.0)) System.out.println("5.0 - делитель 10.0\n");


        SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
        String str = "Обобщенный функциональный интерфейс";

        System.out.println("Тестируемая строка: " + str);
        if (isIn.test(str, "face")) System.out.println("'face' найдено");
        else System.out.println("'face' не найдено");
    }
}
