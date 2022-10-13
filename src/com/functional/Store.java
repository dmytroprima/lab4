package com.functional;

import com.candy.Candy;
import com.candy.ChocolateWithFillings;
import com.candy.FruitJelly;
import com.candy.Lollipops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Candy> storeList = new ArrayList<>();
    public Store(){
        storeList.add(new ChocolateWithFillings("korivka", 20, 15, 5, "caramel"));
        storeList.add(new FruitJelly("bdjilka", 15, 8, 3, "orange"));
        storeList.add(new Lollipops("diushes", 20, 10, 3, "pear"));
    }

    public boolean isCandyAvaliable(String name){
        for(Candy candy : storeList)
            if (candy.getName().equals(name)){
                return true;
            }
        return false;
    }

    public Candy returnCandy(String name){
        for(Candy candy : storeList)
            if (candy.getName().equals(name)){
                return candy;
            }
        return new Candy("None", 0,0,0);
    }

    public void sortStore(){
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.print("Available parameters for sorting of assortment - ABC, sugar\nSorting by the: ");
            String param = scan.next();
            if (param.equals("ABC")){
                List<String> candyList = new ArrayList<>();
                for(Candy candy: storeList){candyList.add(candy.getName());}
                Collections.sort(candyList);
                Candy buf;
                for (int i = 0; i < storeList.size(); i++){
                    if(!candyList.get(i).equals(storeList.get(i).getName())){
                        for (int j = i+1; j < storeList.size(); j++){
                            if(storeList.get(j).getName().equals(candyList.get(i))){
                                buf = storeList.get(i);
                                storeList.set(i, storeList.get(j));
                                storeList.set(j, buf);
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
                    for (int i = 0; i < storeList.size()-1; i++) {
                        if(storeList.get(i).getSugarContent() < storeList.get(i+1).getSugarContent()){
                            isSorted = false;
                            buf = storeList.get(i);
                            storeList.set(i, storeList.get(i+1));
                            storeList.set(i+1, buf);
                        }
                    }
                }
                return;
            }
            else
                System.out.println("Incorrect parameter for sorting");
        }
    }

    public void printStore() {
        for (Candy candy : storeList) {
            System.out.println(candy.getName()+ "\t sugar content: " + candy.getSugarContent());
        }
    }
}
