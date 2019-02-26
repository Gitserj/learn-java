package main.thrds;

class MyExThread extends Thread {

    MyExThread(String name){
        super(name);
        start();
    }

    @Override
    public void run() {
        System.out.println(getName() + " - Запуск.");
        try {
            for(int i = 0; i < 10; i++){
                Thread.sleep(400);
                System.out.println("В " + getName() + ", счетчик: " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " - Прерван.");
        }
        System.out.println(getName() + " - Завершение.");
    }
}

public class ExtendThread {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока.");

        MyExThread mt = new MyExThread("Child #1");

        for (int i = 0; i < 50; i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Основной поток прерван.");
            }
        }
        System.out.println("Завершение основного потока.");
    }
}
