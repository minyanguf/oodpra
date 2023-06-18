abstract class CoffeeDecorator implements Coffee{
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator (Coffee c){
        this.decoratedCoffee=c;
    }

    public String getIngredients(){
        return decoratedCoffee.getIngredients();
    }
    public double getCost(){
        return decoratedCoffee.getCost();
    }

}
