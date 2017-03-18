package com.barbeirodorminhoco;

public class Barbearia {

    private final Barbeiro barbeiro;
    private final Cadeiras<Cliente> cadeiras;

    public Barbearia(Barbeiro barbeiro, int capacidade) {
        this.barbeiro = barbeiro;
        this.cadeiras = new Cadeiras<>(capacidade);
    }

    public void abrir() {
        while (true) { // NOSONAR
            if (cadeiras.size() > 0) {
                Cliente cliente = cadeiras.remove();
                barbeiro.atender(cliente);
            }
            else { // uma maneira de evitar busy-waiting, busy-looping or spinning
                barbeiro.dormir();
            }
        }
    }

    public void aceitarClientes(long frequencia) {
        new Thread(() -> {
            while (true) {
                Util.sleep(frequencia);
                Cliente cliente = new Cliente();
                boolean result = cadeiras.add(cliente);
                if (result) {
                    System.out.println("Novo cliente na fila: " + cliente);
                }
                else {
                    System.out.println("Barbearia cheia, cliente recusado");
                }
            }
        }).start();
    }
}
