package com.barbeirodorminhoco;

public class Barbeiro {

    private final long sono;
    private final long atendimento;
    private boolean dormindo;

    public Barbeiro(long sono, long atendimento) {
        this.sono = sono;
        this.atendimento = atendimento;
    }

    public void dormir() {
        System.out.println("Barbeiro dormindo");
        dormindo = true;
        Util.sleep(sono);
        dormindo = false;
        System.out.println("Barbeiro acordou");
    }

    public void atender(Cliente cliente) {
        System.out.println("Cliente sendo atendido: " + cliente);
        cliente.setAtendido(true);
        Util.sleep(atendimento);
    }

    public boolean isDormindo() {
        return dormindo;
    }

}
