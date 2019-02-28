package main.lambda.refs;

interface IntPredicate {
    boolean test(int n);
}

class MyIntPredicates {
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= n/i; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
}

class MyInNum {
    private int num;

    MyInNum(int n){
        num = n;
    }

    public int getNum() {
        return num;
    }

    boolean isFactor(int f){
        return (num % f) == 0;
    }
}

public class MethodRefDemo {
    static boolean numTest(IntPredicate ip, int num){
        return ip.test(num);
    }

    public static void main(String[] args) {
        boolean result;

        result = numTest(MyIntPredicates::isPrime, 17);
        if(result) System.out.println("17 - простое число");

        result = numTest(MyIntPredicates::isEven, 12);
        if(result) System.out.println("12 - четное число");

        result = numTest(MyIntPredicates::isPositive, 11);
        if(result) System.out.println("11 - положительное число");

        MyInNum mInA = new MyInNum(12);
        MyInNum mInB = new MyInNum(16);

        IntPredicate ip = mInA::isFactor;
        result = ip.test(3);
        if(result) System.out.println("3 - делитель " + mInA.getNum());

        ip = mInB::isFactor;
        result = ip.test(3);
        if(!result) System.out.println("3 -не делитель " + mInA.getNum());
    }
}
