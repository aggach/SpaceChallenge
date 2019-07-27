package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        Simulation simulation = new Simulation();

        ArrayList<Item> file1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> file2 = simulation.loadItems("phase-2.txt");

        ArrayList<Rocket> rocket1WithFile1 = simulation.loadU1(file1);
        ArrayList<Rocket> rocket1WithFile2 = simulation.loadU2(file2);

        System.out.println("Load rocket U1");

        ArrayList<Rocket> rocket2WithFile1 = simulation.loadU1(file1);
        ArrayList<Rocket> rocket2WithFile2 = simulation.loadU2(file2);

        System.out.println("Load rocket U2");

        rocket1WithFile1.addAll(rocket1WithFile2);
        int totalCostForU1 = simulation.runSimulation(rocket1WithFile1);
        System.out.println("Total cost for U1 is " + totalCostForU1);

        rocket2WithFile1.addAll(rocket2WithFile2);
        int totalCostForU2 = simulation.runSimulation(rocket2WithFile1);
        System.out.println("Total cost for U2 is " + totalCostForU2);



    }
}
