package main.enums;

enum TrafficLightColor {
    RED, GREEN, YELLLOW
}

class TrafficLightSimulator implements Runnable {
    private Thread thrd;
    private TrafficLightColor tlc;
    boolean stop = false;
    boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init){
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightColor getColor(){
        return tlc;
    }

    void cancel(){
        stop = true;
    }

    synchronized void changeColor(){
        switch (tlc){
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLLOW;
                break;
            case YELLLOW:
                tlc = TrafficLightColor.RED;
                break;
        }
        changed = true;
        notify();
    }

    synchronized void waitForChange(){
        try{
            while (!changed) wait();
            changed = false;
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        while (!stop){
            try {
                switch (tlc){
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(12000);
                        break;
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            changeColor();
        }
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator tls1 = new TrafficLightSimulator();

        for (int i = 0; i < 9; i++){
            System.out.println(tls1.getColor());
            tls1.waitForChange();
        }
        tls1.cancel();

    }
}
