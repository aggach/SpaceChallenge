package com.company;

import java.util.Random;

public class U2 extends Rocket {
    private double chanceLaunched;
    private double chanceLand;

    public U2() {
        setCost(12000);
        setWeight(18000);
        setMaxWeight(29000);
    }

    @Override
    public boolean launch() {
        Random random = new Random();
        double chance = random.nextDouble();
        chanceLaunched = 0.04 * getCurrentWeight()/getMaxWeight();
        return chanceLaunched<=chance;
    }

    @Override
    public boolean land() {
        Random random = new Random();
        double chance = random.nextDouble();
        chanceLand = 0.08 * getCurrentWeight()/getMaxWeight();
        return chanceLand<=chance;
    }

    public boolean canCarry(Item item) {
        return super.canCarry(item);
    }


    public void carry(Item item) {
        super.carry(item);
    }
}
