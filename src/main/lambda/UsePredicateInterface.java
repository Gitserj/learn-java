package main.lambda;

import java.util.function.Predicate;

public class UsePredicateInterface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = a -> (a % 2) == 0;
        if (isEven.test(12)) System.out.println("12 - четное число");
        if (!isEven.test(15)) System.out.println("15 - не четное число");
    }
}
