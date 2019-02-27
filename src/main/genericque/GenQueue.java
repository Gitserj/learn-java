package main.genericque;

public class GenQueue<T> implements IGenQ<T>{
    private T q[];
    private int putloc, getloc;

    public GenQueue(T[] aRef){
        q = aRef;
        putloc = getloc = 0;
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if(putloc == q.length-1) throw new QueueFullException(q.length-1);
        q[putloc++] = obj;
    }

    @Override
    public T get() throws QueueEmptyException {
        if(getloc == putloc){
            reset();
            throw new QueueEmptyException();
        }
        return q[getloc++];
    }

}
