package main.lambda.refs;

interface MyFunc {
    MyClass func(String s);
}

class MyClass {
    private String str;

    MyClass(String s) { str = s; }
    MyClass() { str = ""; }

    public String getStr() {
        return str;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc mf = MyClass::new;
        MyClass mc = mf.func("Hello, refs");

        System.out.println(mc.getStr());
    }
}
