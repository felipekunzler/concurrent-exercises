package com.barbeirodorminhoco;

public class Main {

    public static void main(String[] args) {
        long sono = 2000;
        long atendimento = 500;
        long frequencia = 300;
        int capacidade = 5;

        Barbeiro barbeiro = new Barbeiro(sono, atendimento);
        Barbearia barbearia = new Barbearia(barbeiro, capacidade);
        barbearia.aceitarClientes(frequencia);
        barbearia.abrir();
    }
}
