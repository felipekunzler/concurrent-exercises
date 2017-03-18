package com.barbeirodorminhoco;

import java.util.LinkedList;
import java.util.Queue;

public class Cadeiras <T> {

    private int capacidade;
    private Queue<T> queue;

    public Cadeiras(int capacidade) {
        this.capacidade = capacidade;
        this.queue = new LinkedList<>();
    }

    public synchronized boolean add(T t) {
        if (queue.size() == capacidade) {
            return false;
        }
        return queue.add(t);
    }

    public synchronized T remove() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

}
