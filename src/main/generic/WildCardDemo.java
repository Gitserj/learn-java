package main.generic;

class NumFns <T extends Number> {
    T num;

    NumFns(T n){
        num = n;
    }

    double reciprocal() {
        return 1/num.doubleValue();
    }

    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    boolean absEqual(NumFns<?> ob) {
        if(Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())) return true;
        return false;
    }
}

public class WildCardDemo {
    public static void main(String[] args) {
        NumFns<Integer> obi = new NumFns<Integer>(6);
        NumFns<Double> obd = new NumFns<Double>(-6.0);
        NumFns<Double> obdd = new NumFns<Double>(6.9);
        NumFns<Long> obl = new NumFns<Long>(5L);

        System.out.println("Дробная часть " + obdd.num + " : " + obdd.fraction());
        System.out.println("Обратная величина " + obdd.num + " : " + obdd.reciprocal());

        if(obi.absEqual(obd)) System.out.println("Абсолютные значнения " + obi.num + " и " + obd.num + " совпадают");
        else System.out.println("Абсолютные значнения " + obi.num + " и " + obd.num + " отличаются");

        if(obi.absEqual(obl)) System.out.println("Абсолютные значнения " + obi.num + " и " + obl.num + " совпадают");
        else System.out.println("Абсолютные значнения " + obi.num + " и " + obl.num + " отличаются");
    }
}
