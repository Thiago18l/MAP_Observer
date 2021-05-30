package domain;

import interfaces.Observable;
import interfaces.Observer;

import java.util.List;
import java.util.ArrayList;

public class Dieta implements Observable {
    private List<Observer> observers;
    private double peso;
    public Dieta () {
        observers = new ArrayList<>();
    }

    public Dieta(double peso) {
        this.peso = peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        // Quando a alteração do peso ocorrer, esse é o momento correto para notificar os observers.
        this.notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        // Chama o método de atualização de todos os observers disponíveis.
        for (Observer ob : observers) {
            System.out.println("Notificando observers!");
            ob.update(this.peso);
        }
    }
}
