package coffee;
public class CoffeePack {
    private int neededMilk;

    public int getNeededMilk() {
        return neededMilk;
    }

    public int getNeededSugar() {
        return neededSugar;
    }

    private int neededSugar;

    public CoffeePack(int neededMilk,int neededSugar){
        this.neededSugar =neededSugar;
        this.neededMilk=neededMilk;
    }


}
