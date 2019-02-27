package main.genericque;

interface IGenQ<T> {

    void put(T obj) throws QueueFullException;
    T get() throws QueueEmptyException;

    default void reset() {
        int putloc = 0;
        int getloc = 0;
    }
}
