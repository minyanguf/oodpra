package myrewrite;

public class CoffeeMaker {

    public iCoffee makeCoffee(){
        iCoffee coffee = new SimpleCoffee();

        for (int i = 0; i < 2; i++) {
            coffee = new WithMilk(coffee);
        }

        for (int i = 0; i < 3; i++) {
            coffee = new WithSugar(coffee);
        }

        return coffee;
    }



}
class test {
    public static void main(String[] args) {
        var cm = new CoffeeMaker();
        var res = cm.makeCoffee();
        System.out.println(res.getCost());
        System.out.println(res.getIngre());

//        var sc = new SimpleCoffee();
//        var wm = new WithMilk();
//        var ws = new WithSugar();
//        wm.setIc(sc);
//        ws.setIc(wm);
//
//        System.out.println(ws.getCost());
//        System.out.println(ws.getIngre());



    }
}

interface iCoffee{
    public double getCost();
    public String getIngre();
}

class SimpleCoffee implements iCoffee{

    @Override
    public double getCost() {
        return 2;
    }

    @Override
    public String getIngre() {
        return "simple coffee";
    }
}

abstract class CoffeeDeo implements iCoffee{
    public iCoffee getIc() {
        return ic;
    }

    public void setIc(iCoffee ic) {
        this.ic = ic;
    }

//    public CoffeeDeo(iCoffee ic) {
//        this.ic = ic;
//    }

    public CoffeeDeo(iCoffee ic) {
        this.ic = ic;
    }

    protected iCoffee ic;

    @Override
    public double getCost() {
        return ic.getCost();
    }

    @Override
    public String getIngre() {
        return ic.getIngre();
    }

}
class WithMilk extends CoffeeDeo{
    public WithMilk(iCoffee ic) {
        super(ic);
    }

    @Override
    public double getCost() {
        return ic.getCost() + 3;
    }

    @Override
    public String getIngre() {
        return ic.getIngre() +" added milk ";
    }
}

class WithSugar extends CoffeeDeo{
    public WithSugar(iCoffee ic) {
        super(ic);
    }

    @Override
    public double getCost() {
        return ic.getCost() + 4;
    }

    @Override
    public String getIngre() {
        return ic.getIngre() +" added sugar ";
    }
}
//class Test{
//    public static void main(String[] args) {
//
//    }
//}