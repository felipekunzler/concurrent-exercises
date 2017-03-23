package com.problemadosfilosofos;

import java.util.concurrent.TimeUnit;

public class Templo {

    public static long periodoComer;
    private int size;

    private final Filosofo[] filosofos;
    private final Garfo[] garfos;

    public Templo(int size, long periodoComer) {
        this.periodoComer = periodoComer;
        this.size = size;

        filosofos = new Filosofo[size];
        garfos = new Garfo[size];
        for (int i = 0; i < size; i++) {
            filosofos[i] = new Filosofo(i);
            garfos[i] = new Garfo(i);
        }
    }

    public void run() {
        for (Filosofo f : filosofos) {
            new Thread(() -> sobreviver(f)).start();
        }

        while (true) { // NOSONAR
            for (Filosofo f : filosofos) {
                System.out.println("Filosofo " + f.getId() + ". Comeu " + f.getSatisfied());
            }
            System.out.println("");
            Util.sleep(periodoComer);
        }
    }

    private void sobreviver(Filosofo f) {
        int id = f.getId();
        Filosofo fLeft = filosofos[previousId(id)];
        Filosofo fRight = filosofos[nextId(id)];
        Garfo gLeft = garfos[id];
        Garfo gRight = garfos[nextId(id)];

        while (true) { // NOSONAR
            // Se ambos filosofos ao meu lado já comeram mais do que eu, espera pelos garfos
            if (fLeft.getSatisfied() >= f.getSatisfied() && fRight.getSatisfied() >= f.getSatisfied()) {
                // Espera pelo garfo esquerdo
                gLeft.lock();
                // Depois de pegar o esquerdo, tenta pegar direito, se não estiver livre, solta o esquerdo
                if (gRight.tryLock(50, TimeUnit.MILLISECONDS)) {
                    f.comer();
                    gRight.unlock();
                }
                gLeft.unlock();

            }
            else Util.sleep(100); // Evita cpu spinning
        }

    }

    private int nextId(int id) {
        return id == size - 1 ? 0 : id + 1;
    }

    private int previousId(int id) {
        return id == 0 ? size - 1 : id - 1;
    }

}
