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
        if(!result) System.out.println("3 -не делитель " + mInA.getNum());
    }
}
