package main.genericque;

class QueueFullException extends Exception {
    int size;
    QueueFullException(int s) {size = s;}

    public String toString() {
        return "\nОчередь заполнена. Максимальный размер: " + size + "\n";
    }
}
