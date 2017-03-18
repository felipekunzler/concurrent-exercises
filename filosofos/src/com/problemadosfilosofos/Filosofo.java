package com.problemadosfilosofos;

public class Filosofo {

    private int id;
    private long satisfied;

    public Filosofo(int id) {
        this.id = id;
    }

    public void comer() {
        satisfied++;
        Util.sleep(Templo.periodoComer);
    }

    public int getId() {
        return id;
    }

}
