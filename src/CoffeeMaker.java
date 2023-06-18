public class CoffeeMaker {
    public Coffee makeCoffee(CoffeePack cp){
        Coffee res = new SimpleCoffee();
        int needM = cp.getNeededMilk();
        int needS = cp.getNeededSugar();
        for(int i=0; i<needM; i++){
            res= new WithMilk(res);
        }
        for(int i=0; i<needS; i++){
            res= new WithSugar(res);
        }
        return res;

    }
}
