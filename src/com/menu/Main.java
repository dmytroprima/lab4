package com.menu;

import com.functional.Gift;
import com.functional.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Gift> giftsList = new ArrayList<>();
    static Store store = new Store();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        while (true){
            System.out.print("Select command:" + mainMenu.getCommands() +"\nYour command: ");
            String command = scan.next();
            mainMenu.execute(command);
        }
    }

    static public void createGift(){
        System.out.print("Enter gift name: ");
        String name = scan.next();
        Gift gift = new Gift(name);
        store.sortStore();
        while (true){
            System.out.println("Store");
            store.printStore();
            System.out.print("Select candy (Enter \"save\" if gift are ready):");
            String candyName = scan.next();
            if (candyName.equals("save")){
                break;
            }
            if(store.isCandyAvaliable(candyName)){
                gift.addCandy(store.returnCandy(candyName));
            }
        }
        giftsList.add(gift);
    }

    static public void printGiftComposition(){
        System.out.print("List of Gifts: ");
        for (Gift gift:giftsList){
            System.out.print(gift.getGiftName()+" ");
        }
        System.out.print("\nSelect gift: ");
        String giftName = scan.next();
        Gift currentGift = new Gift("None");
        for (Gift gift:giftsList){
            if (gift.getGiftName().equals(giftName)){
                currentGift = gift;
            }
        }
        currentGift.sortGift();
        while (true){
            currentGift.printComposition();
            System.out.println("Final weight: " + currentGift.weightGift());
            System.out.print("Delete candy(\"save\" for exit): ");
            String candyName = scan.next();
            if (candyName.equals("save")){
                break;
            }
            currentGift.deleteCandy(candyName);
        }
    }

    static public void deleteGift(){
        System.out.print("List of Gifts: ");
        for (Gift gift:giftsList){
            System.out.print(gift.getGiftName()+" ");
        }
        System.out.print("\nSelect gift for deleting: ");
        String giftName = scan.next();
        for (Gift gift:giftsList){
            if (gift.getGiftName().equals(giftName)){
                giftsList.remove(gift);
                break;
            }
        }
    }
}