package com.problemadosfilosofos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Problema dos filosofos.");
        System.out.print("Entre com o numero de filosofos (5): ");
        int size = in.nextInt();
        System.out.print("Quanto tempo um filosofo demora para comer [ms] (800)? ");
        long periodoComer = in.nextLong();

        Templo templo = new Templo(size, periodoComer);
        templo.run();
    }

}
