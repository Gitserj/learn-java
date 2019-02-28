package main.lambda;

interface StringFunc {
    String func(String str);
}

public class LambdaArgumentDemo {
    static String changeStr(StringFunc sf, String str){
        return sf.func(str);
    }

    public static void main(String[] args) {

        StringFunc reverse = (str) -> {
            String result = "";
            for(int i = str.length()-1; i>=0; i--) result += str.charAt(i);
            return result;
        };


        String inStr = "Lambda-выражения расширяют Java";
        String outStr;

        System.out.println("Вход: " + inStr);

        outStr = changeStr(reverse, inStr);
        System.out.println("Реверс: " + outStr);

        outStr = changeStr((str) -> str.replace(" ", "-"), inStr);
        System.out.println("Пробелы на дефисы: " + outStr);

        outStr = changeStr(str -> {
            String result = "";
            char ch;
            for(int i = 0; i < str.length(); i++){
                ch = str.charAt(i);
                result += Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
            }
            return result;
        }, inStr);
        System.out.println("Реверс регистра: " + outStr);

        outStr = changeStr((str) -> str.replace(" ", ""), inStr);
        System.out.println("Удалить пробелы: " + outStr);

    }
}
