package machine.Resources.Products;

public class Coffee {


    protected int price;   //* price of the coffee in $


    protected int waterUse; //* Needed water to cook a coffee in ml

    protected int milkUse;    //* Needed milk to cook a coffee in ml


    protected int coffeeUse; //* Beans used to cook a coffee in g


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getWaterUse() {
        return waterUse;
    }
    public void setWaterUse(int waterUse) {
        this.waterUse = waterUse;
    }

    public int getMilkUse() {
        return milkUse;
    }

    public void setMilkUse(int milkUse) {
        this.milkUse = milkUse;
    }

    public int getCoffeeUse() {
        return coffeeUse;
    }

    public void setCoffeeUse(int coffeeUse) {
        this.coffeeUse = coffeeUse;
    }


}
