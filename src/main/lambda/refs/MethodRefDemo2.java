package main.lambda.refs;

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

    boolean hasCommonFactor(int a){
        int limit = (num > a) ? num : a;
        for(int i = 2; i <= limit; i++){
            if(((num % i) == 0) && ((a % i) == 0)) return true;
        }
        return false;
    }
}

public class MethodRefDemo2 {
    public static void main(String[] args) {
        boolean result;
        MyInNum mInA = new MyInNum(12);
        MyInNum mInB = new MyInNum(16);

        IntPredicate ip = mInA::isFactor;
        result = ip.test(3);
        if(result) System.out.println("3 - делитель " + mInA.getNum());

        ip = mInB::isFactor;
        result = ip.test(3);
        if(!result) System.out.println("3 - не делитель " + mInB.getNum());

        ip = mInA::hasCommonFactor;
        result = ip.test(4);
        if(result) System.out.println("4 и " + mInA.getNum() + " имеют общий делитель");

        result = ip.test(5);
        if(!result) System.out.println("5 и " + mInA.getNum() + " не имеют общий делитель");
    }
}
