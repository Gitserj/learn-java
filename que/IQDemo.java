package que;

class FixedQueue implements ICharQ {
    private char q[];
    private int putloc, getloc;

    public FixedQueue(int size){
        q = new char[size + 1];
        putloc = getloc = 0;
    }

    @Override
    public void put(char ch){
        if(putloc == q.length - 1){
            System.out.println("- Очередь заполнена");
            return;
        }
        q[++putloc] = ch;
    }

    @Override
    public char get(){
        if(getloc == putloc){
            System.out.println("\n- Очередь пуста");
            getloc = putloc = 0;
            return (char) 0;
        }
        return q[++getloc];
    }

    @Override
    public int getLength(){
        return q.length;
    }

    @Override
    public void reset() {
        getloc = putloc = 0;
    }
}

class CircularQueue implements ICharQ {
    private char q[];
    private int getloc, putloc;

    public CircularQueue(int size){
        q = new char[size + 1];
        getloc = putloc = 0;
    }

    @Override
    public void put(char ch){
        if(putloc+1 == getloc | ((putloc == q.length-1) & (getloc == 0))){
            System.out.println("- Очередь заполнена");
            return;
        }
        if(++putloc == q.length) putloc = 0;
        q[putloc] = ch;
    }

    @Override
    public char get(){
        if(getloc == putloc){
            System.out.println("\n- Очередь пуста");
            getloc = putloc = 0;
            return (char) 0;
        }
        if(++getloc == q.length) getloc = 0;
        return q[getloc];
    }

    @Override
    public int getLength(){
        return q.length;
    }

    @Override
    public void reset() {
        getloc = putloc = 0;
    }
}

class DynQueue implements ICharQ {
    private char q[];
    private int getloc, putloc;

    public DynQueue(int size){
        q = new char[size + 1];
        getloc = putloc = 0;
    }

    @Override
    public void put(char ch){
        if(putloc == q.length-1){
            char t[] = new char[q.length * 2];
            for(int i = 0; i < q.length; i++) t[i] = q[i];
            q = t;
        }
        q[++putloc] = ch;
    }

    @Override
    public char get(){
        if(getloc == putloc){
            System.out.println("\n- Очередь пуста");
            getloc = putloc = 0;
            return (char) 0;
        }
        return q[++getloc];
    }

    @Override
    public int getLength(){
        return q.length;
    }

    @Override
    public void reset() {
        getloc = putloc = 0;
    }
}

class IQDemo {
    public static void main(String[] args) {
        FixedQueue fixQ = new FixedQueue(10);
        CircularQueue circQ = new CircularQueue(10);
        DynQueue dynQ = new DynQueue(5);

        ICharQ iQ;

        iQ = fixQ;
        System.out.println("Заполнение фиксированной очереди.");
        for(int i = 0; i <= 10; i++){
            iQ.put((char)('a' + i));
        }
        System.out.println("Чтение из фиксированной очереди.");
        for(int i = 0; i <= 10; i++){
            System.out.print(iQ.get()+ " ");
        }

        System.out.println("");        

        iQ = dynQ;
        System.out.println("Начальный размер динамической очереди: " + iQ.getLength());
        System.out.println("Заполнение динамической очереди.");
        for(int i = 0; i <= 10; i++){
            iQ.put((char)('z' - i));
        }
        System.out.println("Текущий размер динамической очереди: " + iQ.getLength());
        System.out.println("Чтение из динамической очереди.");
        for(int i = 0; i <= 10; i++){
            System.out.print(iQ.get()+ " ");
        }

        System.out.println("");

        iQ = circQ;
        System.out.println("Заполнение кольцевой очереди на половину.");
        for(int i = 0; i <= 5; i++){
            iQ.put((char)('a' + i));
        }
        System.out.println("Чтение из кольцевой очереди.");
        for(int i = 0; i <= 10; i++){
            System.out.print(iQ.get()+ " ");
        }
        System.out.println("Заполнение кольцевой очереди с переполнением.");
        for(int i = 0; i <= 20; i++){
            iQ.put((char)('a' + i));
        }
        System.out.println("Чтение из кольцевой очереди.");
        for(int i = 0; i <= 10; i++){
            System.out.print(iQ.get()+ " ");
        }
    }
}