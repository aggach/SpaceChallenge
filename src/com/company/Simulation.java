package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Simulation {

    public Simulation() {
    }

    public ArrayList<Item> loadItems(String nameFile) throws Exception{

        File file = new File(nameFile);
        ArrayList<Item> items = new ArrayList<>();

        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineToItemObject  = line.split("=");
                items.add(new Item(lineToItemObject[0], Integer.parseInt(lineToItemObject[1])));
            }


        }
        catch (FileNotFoundException e){
            System.out.println("File doesn't found");
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items1){
        ArrayList<Rocket> rocket1 = new ArrayList<>();
        Rocket rocket = new U1();

        Iterator stream = items1.iterator();
        while (stream.hasNext()){
            Item item = (Item) stream.next();
            if(rocket.canCarry(item)){
                rocket.carry(item);
            }
            else {
                rocket1.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
        }
        return rocket1;

    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items2){
        ArrayList<Rocket> rocket2 = new ArrayList<>();
        Rocket rocket = new U2();

        Iterator stream = items2.iterator();
        while (stream.hasNext()){
            Item item = (Item) stream.next();
            if(rocket.canCarry(item)){
                rocket.carry(item);
            }
            else {
                rocket2.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
        }
        return rocket2;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int totalCost = 0;
        int numberOfCrash = 0;

        for(Rocket rocket: rockets){
            boolean launchSucces = rocket.launch();
            boolean landSucces = rocket.land();

            while(!(launchSucces && landSucces)){
                totalCost += rocket.getCost();

                landSucces = rocket.land();
                launchSucces = rocket.launch();

                numberOfCrash ++;


            }
            totalCost += rocket.getCost();

        }

        return totalCost;

    }

}
