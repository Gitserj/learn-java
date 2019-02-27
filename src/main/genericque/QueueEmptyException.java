package main.genericque;

class QueueEmptyException extends Exception {
    public String toString() {
        return "\nОчередь пуста.\n";
    }
}
