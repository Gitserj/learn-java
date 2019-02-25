package main.help;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Help {
    String helpfile;

    Help(String fname){
        helpfile = fname;
    }

    boolean helpon(String what){
        int ch;
        String topic, info;
        try(BufferedReader helpRd = new BufferedReader(new FileReader(helpfile))){
            do {
                ch = helpRd.read();
                if(ch == '#'){
                    topic = helpRd.readLine();
                    if(what.compareTo(topic) == 0){
                        do {
                            info = helpRd.readLine();
                            if(info != null) System.out.println(info);
                        } while ((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            } while (ch != -1);
        } catch (IOException exc) {
            System.out.println("Ошибка при попытке доступа к файлу справки.");
            return false;
        }
        return false;
    }

    String getSection(){
        String topic = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Укажите тему: ");
        try {
            topic = br.readLine();
        } catch (IOException exc){
            System.out.println("Ошибка при чтении консоли.");
        }
        return topic;
    }
}

class FileHelp{
    public static void main(String[] args) {
        Help helpobj = new Help("help.txt");
        String topic;

        System.out.println("Воспользуйтесь справочной системой.\n" +
                "Для вызода из системы введите 'stop'.");
        do {
            topic = helpobj.getSection();
            if(!helpobj.helpon(topic)) System.out.println("Тема не найдена.\n");
        } while (topic.compareTo("stop") != 0);
    }
}
