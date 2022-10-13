package com.functional;

import com.candy.Candy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Gift {
    private String name;
    private List<Candy> candies;

    public Gift(String name) {
        candies = new ArrayList<>();
        this.name = name;
    }

    public void addCandy(Candy candy){
        this.candies.add(candy);
    }

    public String getGiftName(){
        return this.name;
    }

    public int weightGift(){
        int weight =0;
        for (Candy candy:candies){
            weight += candy.getWeight();
        }
        return weight;
    }

    public void deleteCandy(String candyName){
        for (Candy candy:candies){
            if (candy.getName().equals(candyName)){
                this.candies.remove(candy);
                return;
            }
        }
        System.out.println("Incorrect name of candy!");
    }

    public void sortGift(){
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.print("Available parameters for sorting of gift composition - ABC, sugar\nSorting by the: ");
            String param = scan.next();
            if (param.equals("ABC")){
                List<String> candyList = new ArrayList<>();
                for(Candy candy: candies){candyList.add(candy.getName());}
                Collections.sort(candyList);
                Candy buf;
                for (int i = 0; i < candies.size(); i++){
                    if(!candyList.get(i).equals(candies.get(i).getName())){
                        for (int j = i+1; j < candies.size(); j++){
                            if(candies.get(j).getName().equals(candyList.get(i))){
                                buf = candies.get(i);
                                candies.set(i, candies.get(j));
                                candies.set(j, buf);
                            }
                        }
                    }
                }
                return;
            } else if (param.equals("sugar")) {
                Candy buf;
                boolean isSorted = false;
                while(!isSorted) {
                    isSorted = true;
                    for (int i = 0; i < candies.size()-1; i++) {
                        if(candies.get(i).getSugarContent() < candies.get(i+1).getSugarContent()){
                            isSorted = false;
                            buf = candies.get(i);
                            candies.set(i, candies.get(i+1));
                            candies.set(i+1, buf);
                        }
                    }
                }
                return;
            }
            else
                System.out.println("Incorrect parameter for sorting");
        }
    }

    public void printComposition(){
        for (Candy candy : candies) {
            System.out.println(candy.getName()+ "\t sugar content: " + candy.getSugarContent());
        }}
}
