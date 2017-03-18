package com.barbeirodorminhoco;

public class Cliente {

    private static int nextId;

    private final int id;
    private boolean atendido = false;

    public Cliente() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", atendido=" + atendido + "}";
    }
}
