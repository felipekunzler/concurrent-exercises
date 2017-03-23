package com.barbeirodorminhoco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Barbeiro dorminhoco.");
        System.out.print("Tempo em ms que o barbeiro fica dormindo (200): ");
        long sono = in.nextLong();
        System.out.print("Tempo em ms que o barbeiro fica atendendo cada cliente (500): ");
        long atendimento = in.nextLong();
        System.out.print("Frequencia de novos clientes em ms (300): ");
        long frequencia = in.nextLong();
        System.out.print("Numero de cadeiras na barbearia (5): ");
        int capacidade = in.nextInt();

        Barbeiro barbeiro = new Barbeiro(sono, atendimento);
        Barbearia barbearia = new Barbearia(barbeiro, capacidade);
        barbearia.aceitarClientes(frequencia);
        barbearia.abrir();
    }
}
