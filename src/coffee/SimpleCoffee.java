package coffee;
public class SimpleCoffee implements Coffee{
    public String getIngredients(){
        return "Plain Coffee";
    }
    public double getCost(){
        return 2;
    }
}
