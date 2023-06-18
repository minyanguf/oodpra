package code.chapter6.decorator0;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();
        d2.Operation();

//        d1.SetComponent(c);	//首先用d1来包装c
//        d2.SetComponent(d1);//再用有来包装d1
//        //这里由于SetComponent   所以d2 里面的compoment 是d1  然后看下面super 时候 就是运行component的operation 所以最后是d1
//        d2.Operation();   	//最终执行d2的Operation()


        System.out.println();
        System.out.println("**********************************************");

    }
}

//Component类
abstract class Component {
    public abstract void Operation();
}


//ConcreteComponent类
class ConcreteComponent extends Component {

    public void Operation() {
        System.out.println("具体对象的实际操作");
    }

}

//Decorator类
abstract class Decorator extends Component {

    protected Component component;

    //装饰一个Component对象
    public void SetComponent(Component component) {
        this.component = component;
    }

    //重写Operation()，实际调用component的Operation方法
    public void Operation() {
        if (component != null) {
            //这里d2.operation 调用super。Operation 会来到这里    由于一开始new的时候  Decorator和ConcreteDecoratorB 共享了component fild。 这里d2 的componment 是d1
            component.Operation();

        }
    }
}

//ConcreteDecoratorA类
class ConcreteDecoratorA extends Decorator {

    private String addedState;//本类独有子段，以区别于ConcreteDecoratorB类

    public void Operation() {
        System.out.println(component);
        System.out.println("111111111");
        super.Operation();//首先运行了原有Component的Operation()

        this.addedState = "具体装饰对象A的独有操作";//再执行本类独有功能
        System.out.println(this.addedState);

    }
}

//ConcreteDecoratorB类
class ConcreteDecoratorB extends Decorator {

    public void Operation() {
        System.out.println(component);
        System.out.println("00000000000");
        super.Operation();//首先运行了原有Component的Operation()
        this.AddedBehavior();//再执行本类独有功能
    }

    //本类独有方法，以区别于ConcreteDecoratorA类
    private void AddedBehavior() {
        System.out.println("具体装饰对象B的独有操作");
    }
}




