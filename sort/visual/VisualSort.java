package sort.visual;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

class VisualSort extends JFrame{
    private static final long serialVersionUID = 1L;
    private int arr[];

    // Конструктор принимает желаемый размер окна
    // и инциализирует соответствующий массив для сортировки
    public VisualSort(int width, int height) {
        arr = new int[width];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(height*Math.random());
        }
        setSize(width,height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // Конструктор принимает указатель на массив для сортировки
    // Высота окна фиксированная
    public VisualSort(int array[]) {
        arr = array;
        setSize(arr.length,300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // Метод paint - стандартный свинговый
    // вызывается вместе с созданием нового экземпляра
    // и при вызове метода .repaint();
    public void paint(Graphics g){
        // Рисую массив
        for(int i = 0; i < this.getWidth(); i++){
            g.setColor(new Color(arr[i]));
            g.drawLine(i, this.getHeight()-this.arr[i], i, this.getHeight());
            g.setColor(Color.WHITE);
            g.drawLine(i, 0, i, this.getHeight()-this.arr[i]);
        }
    }

    // Реализация сортировки пузырьком с вызовом .repaint();
    public void bubbleSort() throws InterruptedException {
        for(int i = 1; i < this.arr.length; i++){
            for(int j = this.arr.length-1; j >= i; j--){
                if (this.arr[j-1] > this.arr[j]) swap(this.arr, j-1, j);
            }
            this.repaint();
            TimeUnit.MILLISECONDS.sleep(50);
        }
        System.out.println("Сортировка завершена");
    }

    // Стандартная конструкция для свапа двух элементов в массиве
    private static void swap(int arr[], int a, int b){
        int buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }

    public static void main(String[] args) throws InterruptedException {

        VisualSort visualSort = new VisualSort(400, 200);
        visualSort.bubbleSort();
    }
}