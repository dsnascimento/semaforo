package org.example.semaforo;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        ThreadSemaforo semaforo = new ThreadSemaforo();

        for (int i = 0; i < 10; i++) {
            System.out.println(semaforo.getCor());
            semaforo.esperaCorMudar();

        }

        semaforo.desligarSemaforo();
        System.out.println("Semaforo Desligado !!!");
    }
}
