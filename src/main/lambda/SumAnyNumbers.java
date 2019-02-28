package main.lambda;

interface SomeMath<T extends Number> {
    T result(T...num);
}

public class SumAnyNumbers {
    public static void main(String[] args) {
        SomeMath<Integer> sum = num -> {
            int result = 0;
            for (int a : num) result += a;
            return result;
        };
        System.out.println(sum.result());
        System.out.println(sum.result(10));
        System.out.println(sum.result(10, 20));
        System.out.println(sum.result(10, 20, 30));

        SomeMath<Number> sumN = nums -> {
            Number result = 0;
            for (Number a : nums){
                result = a.doubleValue() + result.doubleValue();
            }
            if (result.doubleValue() % 10.0 == 0){
                return result.intValue();
            }
            return result;
        };
        System.out.println(sumN.result());
        System.out.println(sumN.result(10));
        System.out.println(sumN.result(10, 20));
        System.out.println(sumN.result(10, 20, 30));
        System.out.println(sumN.result(0.1, 20, 30, 0.3));

    }
}
