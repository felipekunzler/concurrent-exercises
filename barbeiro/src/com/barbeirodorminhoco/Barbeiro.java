package com.barbeirodorminhoco;

public class Barbeiro {

    private final long sono;
    private final long atendimento;

    public Barbeiro(long sono, long atendimento) {
        this.sono = sono;
        this.atendimento = atendimento;
    }

    public void dormir() {
        System.out.println("Barbeiro dormindo");
        Util.sleep(sono);
        System.out.println("Barbeiro acordou");
    }

    public void atender(Cliente cliente) {
        System.out.println("Cliente [" + cliente.getId() + "] sendo atendido");
        Util.sleep(atendimento);
    }

}
