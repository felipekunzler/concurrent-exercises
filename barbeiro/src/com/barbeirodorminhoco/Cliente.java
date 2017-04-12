package com.barbeirodorminhoco;

public class Cliente {

    private static int nextId;

    private final int id;

    public Cliente() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

}
