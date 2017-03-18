package com.problemadosfilosofos;

import java.util.Arrays;

public class Templo {

    public static long periodoComer;
    private int size;

    private Filosofo[] filosofos = new Filosofo[size];
    private Garfo[] garfos = new Garfo[size];

    public Templo(int size, long periodoComer) {
        this.periodoComer = periodoComer;
        this.size = size;

        for (int i = 0; i < size; i++) {
            filosofos[i] = new Filosofo(i);
            garfos[i] = new Garfo(i);
        }
    }

    public void run() {
        for (Filosofo f : filosofos) {
            new Thread(() -> {
                sobreviver(f);
            }).start();
        }
    }

    private void sobreviver(Filosofo filosofo) {
        int id = filosofo.getId();
        Filosofo anterior = filosofos[previousId(id)];
        Filosofo proximo = filosofos[nextId(id)];
        Garfo esquerdo = garfos[id];
        Garfo direito = garfos[nextId(id)];
        while (true) { // NOSONAR

        }
    }

    private int nextId(int id) {
        return id == size - 1 ? 0 : id + 1;
    }

    private int previousId(int id) {
        return id == 0 ? size - 1 : id - 1;
    }

}
