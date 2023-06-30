package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Queue<Customer> rsl = queue;
        for (int i = 0; i < count - 1; i++) {
            rsl.poll();
        }
        return rsl.peek().name();
    }

    public String getFirstUpsetCustomer() {
        Queue<Customer> rsl = queue;
        for (int i = 0; i < count; i++) {
            rsl.poll();
        }
        return rsl.peek().name();
    }

}
