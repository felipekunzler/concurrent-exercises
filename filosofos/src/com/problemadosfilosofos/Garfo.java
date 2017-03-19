package com.problemadosfilosofos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Garfo extends ReentrantLock {

    private int id;

    public Garfo(int id) {
        this.id = id;
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit) {
        try {
            return super.tryLock(timeout, unit);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getId() {
        return id;
    }

}
