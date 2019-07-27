package com.company;

import java.util.Random;

public class U1 extends Rocket{
    private double chanceLaunched;
    private double chanceLand;

    public U1() {
        setCost(100);
        setWeight(1000);
        setMaxWeight(18000);
        setCurrentWeight(10000);

    }

    @Override
    public boolean launch() {
        Random random = new Random();
        double chance = random.nextDouble();
        chanceLaunched = 0.05 * getCurrentWeight()/getMaxWeight();
        return chanceLaunched<=chance;
    }

    @Override
    public boolean land() {
        Random random = new Random();
        double chance = random.nextDouble();
        chanceLand = 0.01 * getCurrentWeight()/getMaxWeight();
        return chanceLand<=chance;
    }

    public boolean canCarry(Item item) {
        return super.canCarry(item);
    }

    public void carry(Item item) {
        super.carry(item);
    }
}
