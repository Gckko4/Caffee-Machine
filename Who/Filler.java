package machine.Who;
import machine.Resources.Machine;

import static machine.CoffeeMachine.scannerInt;


public class Filler {
    Machine machine;
    public Filler(Machine machine){
        this.machine = machine;

    }

    public void setWater(){
        //* get the Supply amount of water
        System.out.println("Write how many ml of water you want to add: ");
        int waterSup = scannerInt();
        machine.addWater(waterSup);
    }
    public void setMilk(){
        //* get the Supply amount of milk
        System.out.println("Write how many ml of milk you want to add: ");
        int milkSup = scannerInt();
        machine.addMilk(milkSup);
    }
    public void setCoffee(){
        //* get the Supply amount of coffee beans
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int coffeeSup = scannerInt();
        machine.addCoffee(coffeeSup);
    }
    public void setCup(){
        //* get the Supply amount of coffee beans
        System.out.println("Write how many disposable cups you want to add: ");
        int cupSup = scannerInt();
        machine.addCups(cupSup);
    }
}
