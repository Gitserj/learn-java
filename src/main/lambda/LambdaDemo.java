package main.lambda;

interface MyValue {
    double getValue();
}

interface MyParamValue {
    double getValue(double v);
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyValue myVal;
        myVal = () -> 98.6;
        System.out.println("Постоянное значение: " + myVal.getValue());

        MyParamValue myParamVal = (n) -> 1/n;
        System.out.println("Обратная величина 4: " + myParamVal.getValue(4));
        System.out.println("Обратная величина 8: " + myParamVal.getValue(8));


    }
}
