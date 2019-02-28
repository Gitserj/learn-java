package main.generic;

class Gen<T> {
    T ob;

    Gen(T o){
        ob = o;
    }

    T getOb(){
        return ob;
    }

    void showType(){
        System.out.println("Тип Т - это " + ob.getClass().getName());
    }
}

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);
        iOb.showType();
        int v = iOb.getOb();
        System.out.printf("значение: %d\n\n", v);

        Gen<String> sOb;
        sOb = new Gen<String>("Тестирование строки");
        sOb.showType();
        String str = sOb.getOb();
        System.out.printf("значение: %s\n\n", str);

    }
}
