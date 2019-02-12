package sort.bubblesort;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

class VisualSort extends JFrame{
    private static final long serialVersionUID = 1L;
    private int arr[];

    public VisualSort(int array[]) {
        arr = array;
        setSize(400,300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void paint(Graphics g){
        // Рисую массив
        for(int i = 0; i < this.getWidth(); i++){
            g.setColor(Color.BLACK);
            g.drawLine(i, this.getHeight()-this.arr[i], i, this.getHeight());
            g.setColor(Color.WHITE);
            g.drawLine(i, 0, i, this.getHeight()-this.arr[i]);
        }
    }

    public void bubbleSort() throws InterruptedException {
        for(int i = 1; i < this.arr.length; i++){
            for(int j = this.arr.length-1; j >= i; j--){
                if (this.arr[j-1] > this.arr[j]) swap(this.arr, j-1, j);
            }
            this.repaint();
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    private static void swap(int arr[], int a, int b){
        int buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }

    public static void main(String[] args) throws InterruptedException {

        // Инициализация массива для сортировки
        int nums[] = new int[400];
        System.out.print("Исходный массив:\t ");
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int)(300*Math.random());
            System.out.print(nums[i] + " ");
        }

        VisualSort visualSort = new VisualSort(nums);
        visualSort.bubbleSort();
    }
}