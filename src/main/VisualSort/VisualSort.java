package main.VisualSort;


import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class VisualSort extends JFrame{
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
            repaint();
            TimeUnit.MILLISECONDS.sleep(50);
        }
        System.out.println("Сортировка завершена");
    }

    //
    private static int[] mergeSort(int arr[]){
        // System.out.println("[IN] СОРТИРОВКА -----------------------------------");
        // printArr(arr);
        // System.out.println("---------------------------------------------------");
        if(arr.length <= 1) return arr;
        else {
            int midL = arr.length / 2;
            int midR = arr.length / 2;
            if(arr.length % 2 != 0) midR += 1;

            int arrL[] = new int[midL];
            int arrR[] = new int[midR];
            for(int i = 0; i < midL; i ++)               arrL[i] = arr[i];
            for(int i = midR; i <= arr.length - 1; i ++)  arrR[i-midR] = arr[i];

            // System.out.println("[OUT] СОРТИРОВКА ----------------------------------");
            // printArr(arr);
            // System.out.println("---------------------------------------------------");
            return arr = merge(mergeSort(arrL), mergeSort(arrR));
        }
    }

    // Сливает 2 остортированных массива
    private static int[] merge(int arrL[], int arrR[]){
        // System.out.println("------ МЕРДЖ------");
        // printArr(arrL);
        // printArr(arrR);
        // System.out.println("------------------");
        int[] newArr = new int[arrL.length+arrR.length];
        int l = 0;
        int r = 0;
        for(int i = 0; i <= newArr.length -1; i++){
            if(l <= arrL.length-1 & r <= arrR.length-1){
                if(arrL[l] <= arrR[r]) newArr[i] = arrL[l++];
                else newArr[i] = arrR[r++];
            } else {
                if (r <= arrR.length-1) newArr[i] = arrR[r++];
                if (l <= arrL.length-1) newArr[i] = arrL[l++];
            }
        }
        // printArr(newArr);
        // System.out.println("------------------");
        return newArr;
    }

    // Стандартная конструкция для свапа двух элементов в массиве
    private static void swap(int arr[], int a, int b){
        int buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }

    // Выводит массив в консоль
    private static void printArr(int arr[]){
        // int n = 1;  // Тут должен быть счетчик вызова функции
        System.out.print("[" + arr.length + "] : ");
        for(int j : arr){
            System.out.print(j + " ");
        }
        System.out.print("\n");
        // n++;
    }

    public static void main(String[] args) throws InterruptedException {

        VisualSort vSort = new VisualSort(400, 200);
        vSort.bubbleSort();

        // int arrD[] = new int[111];
        // for(int i = 0; i < arrD.length; i++){
        //     arrD[i] = (int)(i*Math.random());
        // }
        // printArr(arrD);
        // printArr(mergeSort(arrD));

    }
}