
public class CoffeeMaker {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        var sc = new SimpleCoffee();
        var wm = new WithMilk();
        var ws = new WithSugar();

        wm.setCoffee(sc);
        ws.setCoffee(wm);
        System.out.println(ws.getCost());
        System.out.println(ws.getIngre());


    }
}

interface Coffee{
    public double getCost();
    public String getIngre();
}

abstract class CoffeeDec implements Coffee{
    protected Coffee c;

    public void setCoffee(Coffee c){
        this.c =c;
    }
    public double getCost(){
        return c.getCost();

    }
    public String getIngre(){
        return c.getIngre();
    }

//    protected void op(){
//        System.out.println(c.getIngre());
//        System.out.println(c.getCost());
//    }
}

class WithSugar extends CoffeeDec{
    public double getCost(){
        return c.getCost()+1;

    }
    public String getIngre(){
        return c.getIngre()+" sugar,";
    }

}

class WithMilk extends CoffeeDec{
    public double getCost(){
        return c.getCost()+2;

    }
    public String getIngre(){
        return c.getIngre()+" milk,";
    }

}

class SimpleCoffee implements Coffee{
    public double getCost(){
        return 2;

    }
    public String getIngre(){
        return "normal coffee";
    }

}
