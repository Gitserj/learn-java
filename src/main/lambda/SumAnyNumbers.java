package main.lambda;

interface SomeMath<T> {
    T result(T...num);
}

public class SumAnyNumbers {
    public static void main(String[] args) {
        SomeMath<Integer> sum = num -> {
            int result = 0;
            for (int a : num) result += a;
            return result;
        };

        System.out.println(sum.result(10, 20));
        System.out.println(sum.result(10, 20, 30));
        System.out.println(sum.result());
        System.out.println(sum.result(10));
    }
}
