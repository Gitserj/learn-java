package main.lambda;

interface MyFunc {
    int func (int n);
}

public class VarCapture {
    public static void main(String[] args) {
        // Локальная переменная которая может быть захвачена
        int num = 10;

        MyFunc myLambda = n -> {
            // Такое использование переменной num корректно
            // поскольку её значение не изменяется
            int v = num + n;

            // А эта конструкция не корректна
            // num++;

            return v;
        };

        System.out.println(myLambda.func(8));

        // Приведенная ниже конструкция вызовет ошибку в выраженнии
        // поскольку лишает переменную статуса final
        // num = 9;
    }
}
