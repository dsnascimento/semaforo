package org.example.semaforo;

public enum CorSemaforo {

    Verde(2500), Amarelo(1000), Vermelho(1500);

    private int tempoEspera;

    CorSemaforo(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
}
