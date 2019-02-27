package main.genericque;

public class GenQDemo {
    public static void main(String[] args) {

        System.out.println("Демо очереди типа Integer\n");

        Integer iArray[] = new Integer[10];
        GenQueue<Integer> iQueue = new GenQueue<>(iArray);

        Integer iVal;

        try {
            for(int i = 0; i <= 10; i++){
                iQueue.put(i);
                System.out.println(i + " в очереди");
            }
        } catch (QueueFullException e) {
            System.out.println(e);
        }

        try {
            for(int i = 0; i <= 10; i++){
                iVal = iQueue.get();
                System.out.println(iVal + " извлечено успешно");
            }
        } catch (QueueEmptyException e) {
            System.out.println(e);
        }


        System.out.println("Демо очереди типа Double\n");

        Double dArray[] = new Double[10];
        GenQueue<Double> dQueue = new GenQueue<>(dArray);

        Double dVal;

        try {
            for(int i = 0; i <= 10; i++){
                dQueue.put((double)i/2);
                System.out.println((double)i/2 + " в очереди");
            }
        } catch (QueueFullException e) {
            System.out.println(e);
        }

        try {
            for(int i = 0; i <= 10; i++){
                dVal = dQueue.get();
                System.out.println(dVal + " извлечено успешно");
            }
        } catch (QueueEmptyException e) {
            System.out.println(e);
        }


        System.out.println("Демо циклической очереди типа String\n");

        String sArray[] = new String[10];
        GenCircularQueue<String> sQueue = new GenCircularQueue<>(sArray);

        String sVal;

        try {
            System.out.println("Заполнение половины очереди: ");
            for(int i = 0; i <= 5; i++){
                sQueue.put("Строка " + i);
                System.out.println(i + " в очереди");
            }
        } catch (QueueFullException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Чтение меньше половины очереди: ");
            for(int i = 0; i <= 4; i++){
                sVal = sQueue.get();
                System.out.println(sVal + " извлечена успешно");
            }
        } catch (QueueEmptyException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Попытка переполнения очереди: ");
            for(int i = 0; i <= 15; i++){
                sQueue.put("Строка " + i);
                System.out.println(i + " в очереди");
            }
        } catch (QueueFullException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Чтение всей очереди: ");
            for(int i = 0; i <= 15; i++){
                sVal = sQueue.get();
                System.out.println(sVal + " извлечена успешно");
            }
        } catch (QueueEmptyException e) {
            System.out.println(e);
        }
    }
}
