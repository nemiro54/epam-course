package by.epam.unit_6;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static AtomicInteger val = new AtomicInteger(100);

    public static void main(String[] args) {
        val.addAndGet(50);
        System.out.println(val);
        decrease(val, 15);
        System.out.println(val);
    }

    private static void decrease(AtomicInteger val, int i) {
        int curr = val.get();
        curr -= i;
        val.set(curr);
    }
}
