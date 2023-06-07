package machine;

import machine.Resources.Products.Cappuccino;
import machine.Resources.Products.Coffee;
import machine.Resources.Products.Espresso;
import machine.Resources.Products.Latte;
import machine.Who.Filler;
import machine.Who.Money;
import machine.Resources.Machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static Machine mainMachine;
    public static Coffee coffee;

    public static void main(String[] args) throws IndexOutOfBoundsException{

        //* Instance of Machine & Coffee
        mainMachine = new Machine();
        coffee = new Coffee();
        menu(mainMachine);


    }


    public static void menu(Machine machine){
    Scanner scanner = new Scanner(System.in);
    while (true){
        //* ask for the mode and create an object of it (client,filler,money)
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String mode = scanner.nextLine().toUpperCase().replace(" ","");
        System.out.println();

        switch (mode) {
            case "BUY" -> {
                System.out.println("What do you want to buy? " +
                        "1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String typeCoffee = scanner.nextLine();
                buyCoffee(typeCoffee);
                System.out.println();
            }
            case "FILL" -> {
                Filler filler = new Filler(machine);
                filler.setWater();
                filler.setMilk();
                filler.setCoffee();
                filler.setCup();
                System.out.println();

            }
            case "TAKE" -> {
                Money money = new Money(machine);
                money.takeMoney();
                System.out.println();

            }
            case "REMAINING" -> {
                getResources();  //* print all the resources of the machine
            }
            case "EXIT" ->{
                System.exit(0);
            }
            default -> {
                System.out.println("Try again");
                System.out.println();
            }

        }


    }
}

    public static void getResources(){
        int[] values = getResourcesRaw();

        System.out.println("The coffee machine has:");
        System.out.println(values[0] + " ml of water");
        System.out.println(values[1] + " ml of milk");
        System.out.println(values[2] + " g of coffee beans");
        System.out.println(values[3] + " disposable cups");
        System.out.println("$" + values[4] + " of money");
        System.out.println();

    }
    public static int[] getResourcesRaw(){
        int water = mainMachine.getWaterSupp();
        int milk = mainMachine.getMilkSupp();
        int coffee = mainMachine.getCoffeeSupp();
        int cups = mainMachine.getCupSupp();
        int money = mainMachine.getMoneySupp();

        return new int[]{water,milk,coffee,cups,money};


    }


    //* ask for an input and secure that the returned value is an int
    public static int scannerInt(){
        Scanner scanner = new Scanner(System.in);
        int waterSup;
        while (true){
            try {
                waterSup = scanner.nextInt();
                break;
            } catch (Exception e){
                System.out.println("try again");
            }
        }
        return waterSup;
    }

    public static Machine getMachine(){
        return mainMachine;
    }

    public static void buyCoffee(String type) {
        Coffee coffee = null;
        switch (type) {
            case "1" -> coffee = new Espresso();
            case "2" -> coffee = new Latte();
            case "3" -> coffee = new Cappuccino();
            case "back" -> menu(mainMachine);
            default -> System.out.println("try again");
        }
        try {
            mainMachine.takeCoffee(coffee);
        } catch (NullPointerException e){
            System.out.println("Try again");
        }

    }
}
