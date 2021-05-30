package domain;

import interfaces.Observer;

public class BalancaDieta implements Observer {
    @Override
    public void update(double peso) {
        if (peso >= 100) {
            System.out.println("Você ultrapassou o peso limite no sistema!");
        }
    }
}
