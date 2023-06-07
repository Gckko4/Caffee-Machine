package machine.Resources;

import machine.Resources.Products.Coffee;
import java.util.ArrayList;

public class Machine {

    private static int waterSupp;  //* water supply in the machine in ml
    private static int milkSupp;    //* milk supply in the machine in ml
    private static int coffeeSupp; //* coffee beans supply in the machine in grams
    private static int cupSupp;   //* disposable cups available
    private static int moneySupp;      //* amount of money in the machine


    public Machine(int water,int milk,int coffee,int cups,int money){
        waterSupp = water;
        milkSupp = milk;
        coffeeSupp =  coffee;
        moneySupp = money;
        cupSupp = cups;
    }
    public Machine(int water,int milk,int coffee){
        this(water,milk,coffee,9,550);
    }
    public Machine(){
        this(400,540,120,9,550);
    }


    public void takeCoffee(Coffee coffee){

        //* prove if there is room to get a coffee
        boolean hasWater = waterSupp>=coffee.getWaterUse();
        boolean hasMilk = milkSupp >= coffee.getMilkUse();
        boolean hasCoffee = coffeeSupp >= coffee.getCoffeeUse();
        boolean hasCups = cupSupp >= 1;


        //* ints to check if the division is smaller than 1. if so = no enough resources
        int howMuchWater =  waterSupp / coffee.getWaterUse();
        int howMuchMilk;
        try {               //! catch division by 0
            howMuchMilk =  milkSupp / coffee.getMilkUse();
        } catch (ArithmeticException e){
            howMuchMilk = 1;
        }
        int howMuchCoffee =  coffeeSupp / coffee.getCoffeeUse();
        int howMuchCups =  cupSupp / coffee.getWaterUse();


        //* List wiht all division to later get the smaller one, to print what felt
        ArrayList<Integer> resourcesList = new ArrayList<>();
        resourcesList.add(howMuchWater);
        resourcesList.add(howMuchMilk);
        resourcesList.add(howMuchCoffee);
        resourcesList.add(howMuchCups);



        //* boolean to prove if every resource is available to make one coffee
        boolean hasResource =  hasWater && hasMilk && hasCoffee && hasCups;

        //* if is resources available then do coffee
        if (hasResource){
            System.out.println("I have enough resources, making you a coffee!");
            addWater(-(coffee.getWaterUse()));
            addMilk(-(coffee.getMilkUse()));
            addCoffee(-(coffee.getCoffeeUse()));
            addCups(-1);
            addMoney(coffee.getPrice());
        } else {
            System.out.println("Sorry, not enough " + getResourceUnavailable(resourcesList) +"!");
        }

    }

        //* returns the name of the missing resource
        private static String getResourceUnavailable(ArrayList<Integer> list){
            String[] resourceNames = new String[]{"water", "milk" , "coffee", "cups"};
            int result = Integer.MAX_VALUE;
            int indexList = 0; //* Initialize indexList to an invalid value

            for (int i = 0; i < list.size(); i++) {
                int current = list.get(i);
                if (current < result) { //* assign the smallest one to result
                    result = current;
                    indexList = i; //* Assign the index of the list
                }
            }
            return resourceNames[indexList];
        }

    //? ============     water  ===============
    public int getWaterSupp() {
        return waterSupp;
    }
    public void setWaterSupp(int supp){
        waterSupp = supp;
    }
    public void addWater(int water){
        waterSupp += water;
    }

    //? ============    milk  ===============
    public int getMilkSupp() {
        return milkSupp;
    }
    public void setMilkSupp(int supp){
        milkSupp = supp;
    }
    public void addMilk(int milk){
        milkSupp += milk;
    }

    //? ============    Coffee  ===============
    public int getCoffeeSupp() {
        return coffeeSupp;
    }
    public void setCoffeeSupp(int supp){
        coffeeSupp = supp;
    }
    public void addCoffee(int coffee){
        coffeeSupp += coffee;
    }

    //? ============    Cups  ===============
    public int getCupSupp() {
        return cupSupp;
    }
    public void setCupSupp(int supp){
        cupSupp = supp;
    }
    public void addCups(int cups){
        cupSupp += cups;
    }

    //? ============    Money  ===============
    public int getMoneySupp() {
        return moneySupp;
    }
    public void setMoney(int money){
        moneySupp = money;
    }
    public void addMoney(int money){
        moneySupp += money;
    }






}
