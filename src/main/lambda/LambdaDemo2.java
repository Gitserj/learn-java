package main.lambda;

interface NumericTest {
    boolean test(int a, int b);
}

public class LambdaDemo2 {
    public static void main(String[] args) {
        NumericTest isFactor = (a, b) -> (a % b) == 0;
        if(isFactor.test(10, 2)) System.out.println("2 - делитель 10");
        if(!isFactor.test(10, 3)) System.out.println("3 - не делитель 10");

        NumericTest lessThan = (a, b) -> a < b;
        if(lessThan.test(10, 20)) System.out.println("10 меньше 20");
        if(!lessThan.test(20, 2)) System.out.println("20 больше 2");

        NumericTest absEqual = (a, b) -> (a < 0 ? -a : a) == (b < 0 ? -b : b);
        if(absEqual.test(4, -4)) System.out.println("Абсолютные величины 4 и -4 равны");
        if(!absEqual.test(4, -5)) System.out.println("Абсолютные величины 4 и -5 не равны");
    }
}
