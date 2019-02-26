package main.thrds;

class SumArray {
    private int sum;

    int sumArray(int nums[]){
        sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            System.out.println("Текущая сумма для " + Thread.currentThread().getName() + ": " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Прерывание основного потока.");
            }
        }
        return sum;
    }
}

class MySyncThread implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    MySyncThread(String name, int nums[]){
        thrd = new Thread(this, name);
        a = nums;
        thrd.start();
    }

    @Override
    public void run() {
        int sum;

        System.out.println(thrd.getName() + " - Запуск.");
        synchronized (sa) {
            answer = sa.sumArray(a);
        }
        System.out.println("Сумма для " + thrd.getName() + ": " + answer);
        System.out.println(thrd.getName() + " - Завершение.");
    }
}

public class Sync {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        MySyncThread mst1 = new MySyncThread("Child #1", a);
        MySyncThread mst = new MySyncThread("Child #2", a);
    }
}
