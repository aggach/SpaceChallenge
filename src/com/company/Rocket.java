package com.company;

public class Rocket implements SpaceShip {
    private int cost;
    private int weight;
    private int maxWeight;
    private int currentWeight;

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "cost=" + cost +
                ", weight=" + weight +
                ", maxWeight=" + maxWeight +
                ", currentWeight=" + currentWeight +
                '}';
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(maxWeight >= (item.getWeight() + currentWeight)){
            return true;
            }
        else {
            System.out.println("The item " + item.getName() + " is to weight");
            return false;
        }
    }

    @Override
    public void carry(Item item) {
        currentWeight = item.getWeight();
    }
}
