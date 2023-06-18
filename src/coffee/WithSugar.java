package coffee;
public class WithSugar extends CoffeeDecorator{

    public WithSugar (Coffee c){
        super(c);
    }
    public String getIngredients(){
        return super.getIngredients()+", Sugar";
    }
    public double getCost(){
        return super.getCost()+1.5;
    }
}
