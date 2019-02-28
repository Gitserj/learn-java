package main.lambda.refs;

interface MyIntNumPredicate {
    boolean test(MyInNum in, int n);
}

public class MethodRefDemo3 {
    public static void main(String[] args) {
        boolean result;
        MyInNum myNumA = new MyInNum(12);
        MyInNum myNumB = new MyInNum(16);

        MyIntNumPredicate minp = MyInNum::isFactor;

        result = minp.test(myNumA, 3);
        if(result) System.out.println("3 - делитель " + myNumA.getNum());

        result = minp.test(myNumB, 3);
        if(!result) System.out.println("3 - не делитель " + myNumB.getNum());
    }
}
