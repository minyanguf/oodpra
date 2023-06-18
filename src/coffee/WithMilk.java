package coffee;
public class WithMilk extends CoffeeDecorator{

    public WithMilk (Coffee c){
        super(c);
    }
    public String getIngredients(){
        return super.getIngredients()+", Milk";
    }
    public double getCost(){
        return super.getCost()+0.5;
    }
}
