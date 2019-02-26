package main.que;

class QueueFullException extends Exception{
    private static final long serialVersionUID = 1L;
    int size;
    QueueFullException(int s){size = s;}
    public String toString(){
        return "\nОчередь заполнена. Максимальный размер очереди " + size;
    }
}

class QueueEmptyException extends Exception{
    private static final long serialVersionUID = 1L;

    public String toString() {
        return "\nОчередь пуста.";
    }
}

class QExcDemo{
    public static void main(String[] args) {
        FixedQueue q = new FixedQueue(10);
    }
}