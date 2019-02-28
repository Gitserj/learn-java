package main.lambda;

interface NumericFunc {
    int func(int a);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {

        NumericFunc smallestF = a -> {
            int result = 1;
            a = a < 0 ? -a : a;
            for (int i = 2; i <= a/i; i++){
                if ((a % i) == 0) {
                    result = i;
                    break;
                }
            }
            return result;
        };

        System.out.println("Наименьшим делитлем 12 является: " + smallestF.func(12));
        System.out.println("Наименьшим делитлем 11 является: " + smallestF.func(11));
    }
}
