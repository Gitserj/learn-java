package main.gener;

public class GenericMethodDemo {

    static <T extends Comparable<T>, V extends T> boolean arraysEquals(T[] x, V[] y) {
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) if(!x[i].equals(y[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Integer numsA[] = {1, 2, 3, 4, 5};
        Integer numsB[] = {1, 2, 3, 4, 5};
        Integer numsC[] = {1, 2, 7, 4, 5};
        Integer numsD[] = {1, 2, 3, 4, 5, 6};

        if(arraysEquals(numsA, numsA)) System.out.println("numsA == numsA");
        if(arraysEquals(numsA, numsB)) System.out.println("numsA == numsB");
        if(arraysEquals(numsA, numsC)) System.out.println("numsA == numsC");
        if(arraysEquals(numsA, numsD)) System.out.println("numsA == numsD");
    }
}
