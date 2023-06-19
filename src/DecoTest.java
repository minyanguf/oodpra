import code.chapter6.decorator3.ICharacter;

public class DecoTest {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        var sc = new SimpleCoffee();
//        var wm = new WithMilk();
//        var ws = new WithSugar();
//
//        wm.setCoffee(sc);
//        ws.setCoffee(wm);
//        System.out.println(ws.getCost());
        var p =  new Person("niw");
        var t = new Tie();
        var s = new Suit();
        t.setComp(p);
        s.setComp(t);
        s.show();
//        System.out.println(t.show());


    }
}

interface ICHaracter{
    public void show();
}

class Person implements ICharacter{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }


    public void show(){
        System.out.print("修饰的 "+this.name);
    }
}

class Finery implements ICharacter{
    protected ICharacter comp;

//    public Finery(ICharacter comp) {
//        this.comp = comp;
//    }

    public void setComp(ICharacter comp){
        this.comp = comp;
    }
    public void show(){
        if (this.comp != null){
            this.comp.show();
        }
    }
}

class Tie extends Finery{


    public void show(){
        System.out.print(" added tie ");
        super.show();// 这里super 和comp show 是一样的结果    注意这里都没有写constructor。 都是default ocnstructor
//        comp.show();

    }
}

class Suit extends Finery{


    public void show(){
        System.out.print(" added suit ");
        super.show();
//        comp.show();

    }
}

