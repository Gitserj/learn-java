package main.thrds;

class MyThread implements Runnable {
    Thread thrd;

    MyThread(String name){
        thrd = new Thread(this, name);
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " - Запуск.");
        try {
            for(int i = 0; i < 10; i++){
                Thread.sleep(400);
                System.out.println("В " + thrd.getName() + ", счетчик: " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " - Прерван.");
        }
        System.out.println(thrd.getName() + " - Завершение.");
    }
}

public class UseThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока.");

//        MyThread mt = new MyThread("Child #1");
//        MyThread mt2 = new MyThread("Child #2");
//        MyThread mt3 = new MyThread("Child #3");

        MyThread mt4 = new MyThread("Child #4");
        MyThread mt5 = new MyThread("Child #5");
        MyThread mt6 = new MyThread("Child #6");

//        do {
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.println("Основной поток прерван.");
//            }
//
//        } while (mt.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());

        try {
            mt4.thrd.join();
            System.out.println("Поток 4 присоединен.");
            mt5.thrd.join();
            System.out.println("Поток 5 присоединен.");
            mt6.thrd.join();
            System.out.println("Поток 6 присоединен.");
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }

        System.out.println("Завершение основного потока.");
    }
}
