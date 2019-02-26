package main.thrds;

class TickTock {
    String state;

    synchronized void tick(boolean running){
        if(!running){
            state = "ticked";
            notify();
            return;
        }
        System.out.print("Tick ");
        state = "ticked";
        notify();

        try {
            while (!state.equals("tocked")){
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока.");
        }
    }

    synchronized void tock(boolean running){
        if(!running){
            state = "tocked";
            notify();
            return;
        }
        System.out.print("Tock ");
        state = "tocked";
        notify();

        try {
            while (!state.equals("ticked")){
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока.");
        }
    }
}

class MyTickTockThread implements Runnable {
    Thread thrd;
    TickTock ttobj;

    MyTickTockThread(String name, TickTock tt){
        thrd = new Thread(this, name);
        ttobj = tt;
        thrd.start();
    }

    @Override
    public void run() {
        if(thrd.getName().compareTo("Tick") == 0){
            for (int i = 0; i < 5; i++) ttobj.tick(true);
            ttobj.tick(false);
        } else {
            for (int i = 0; i < 5; i++) ttobj.tock(true);
            ttobj.tock(false);
        }
    }
}

public class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyTickTockThread mtt1 = new MyTickTockThread("Tick", tt);
        MyTickTockThread mtt2 = new MyTickTockThread("Tock", tt);

        try {
            mtt1.thrd.join();
            mtt2.thrd.join();
        } catch(InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }
    }
}
