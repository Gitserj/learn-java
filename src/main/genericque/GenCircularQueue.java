package main.genericque;

class GenCircularQueue<T> implements IGenQ<T> {
    private T q[];
    private int putloc, getloc;

    GenCircularQueue(T[] aRef){
        q = aRef;
        putloc = getloc = 0;
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if(putloc+1 == getloc | ((putloc == q.length-1) & (getloc == 0))){
            throw new QueueFullException(q.length-1);
        }
        if(++putloc == q.length) putloc = 0;
        q[putloc] = obj;
    }

    @Override
    public T get() throws QueueEmptyException {
        if(getloc == putloc){
            reset();
            throw new QueueEmptyException();
        }
        if(++getloc == q.length) getloc = 0;
        return q[getloc];
    }

}
