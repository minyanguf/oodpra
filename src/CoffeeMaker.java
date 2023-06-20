
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

    //这里有没有constructor无所谓 重点是要有setcomp 方法
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
        //看类似的两个 这里 无所谓有没有constructor  super 和comp 这里都可以work
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
        return super.getIngre()+" milk,";
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
