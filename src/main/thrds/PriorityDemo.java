package main.thrds;

class Prior implements Runnable {
    int ctn;
    Thread thrd;
    static boolean stop = false;
    static String currentName;

    Prior(String name){
        thrd = new Thread(this, name);
        ctn = 0;
        currentName = name;
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " - Запуск.");
        do {
            ctn++;
            if(currentName.compareTo(thrd.getName()) != 0){
                currentName = thrd.getName();
                System.out.println("В " + currentName);
            }
        } while (stop == false && ctn < 10000000);
        stop = true;
        System.out.println("\n" + thrd.getName() + " - Завершение");
    }
}

public class PriorityDemo {
    public static void main(String[] args) {
        Prior p1 = new Prior("Child #1");
        Prior p2 = new Prior("Child #2");

        p1.thrd.setPriority(Thread.NORM_PRIORITY+2);
        p2.thrd.setPriority(Thread.NORM_PRIORITY-2);

        p1.thrd.start();
        p2.thrd.start();

        try {
            p1.thrd.join();
            p2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }
        System.out.println("Счетчик потока 1: " + p1.ctn);
        System.out.println("Счетчик потока 2: " + p2.ctn);
    }
}
