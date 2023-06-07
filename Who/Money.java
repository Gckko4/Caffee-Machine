package machine.Who;

import machine.Resources.Machine;

public class Money {
    Machine machine;
    public Money(Machine machine){
        this.machine = machine;
    }

    public void takeMoney(){
        int moneyAmount = machine.getMoneySupp();
        System.out.println("I gave you $" + moneyAmount);
        machine.setMoney(0);
    }
}
