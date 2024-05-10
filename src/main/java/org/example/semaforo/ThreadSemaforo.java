package org.example.semaforo;

public class ThreadSemaforo implements Runnable {

    private CorSemaforo cor;
    private boolean parar;
    private boolean corMudou;

    public ThreadSemaforo() {
        this.cor = CorSemaforo.Vermelho;


        //opicional poi sé um valor booleano e ja é iniciaalmente false
        this.parar = false;
        this.corMudou = false;

        new Thread(this).start();

    }

    @Override
    public void run() {

        while (!parar) {
            try {
                Thread.sleep(this.cor.getTempoEspera());
                this.mudarCor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Mudar Cor aqui
    private synchronized void mudarCor() {
        switch (this.cor) {

            case Vermelho:
                this.cor = CorSemaforo.Verde;
                break;

            case Verde:
                this.cor = CorSemaforo.Amarelo;
                break;

            case Amarelo:
                this.cor = CorSemaforo.Vermelho;
                break;

            default:
                break;
        }
        this.corMudou = true;
        notify();
    }

    public synchronized void esperaCorMudar() {
        while (!this.corMudou) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.corMudou = false;
    }

    public synchronized void desligarSemaforo() {
        this.parar = true;
    }

    public CorSemaforo getCor() {
        return cor;
    }

    public void setCor(CorSemaforo cor) {
        this.cor = cor;
    }
}



