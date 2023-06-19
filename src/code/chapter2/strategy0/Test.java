package code.chapter2.strategy0;

import java.util.Scanner;

public class Test {

	public static void main(String[] args){

		System.out.println("**********************************************");		
		System.out.println("《大话设计模式》代码样例");
		System.out.println();		

		Context context;

		//由于实例化不同的策略，所以最终在调用
		//context.contextInterface()时,所
		//获得的结果就不尽相同

        //strategy 和 simple factory 的区别是  大体在父子class 的方法继承是一样的  主要区别是在 context和factoryclass里对 父class的应用   factory 父class作为输出  而 strategy 这里 作为 constroctor paramter的输入
	    context = new Context(new ConcreteStrategyA());
	    context.contextInterface();

	    context = new Context(new ConcreteStrategyB());
	    context.contextInterface();

	    context = new Context(new ConcreteStrategyC());
	    context.contextInterface();		

		System.out.println();
		System.out.println("**********************************************");

	}
}

//抽象算法类
abstract class Strategy{
	//算法方法
	public abstract void algorithmInterface();

}

//具体算法A
class ConcreteStrategyA extends Strategy {
    //算法A实现方法
    public void algorithmInterface() {
        System.out.println("算法A实现");
    }
}

//具体算法B
class ConcreteStrategyB extends Strategy {
    //算法B实现方法
    public void algorithmInterface() {
        System.out.println("算法B实现");
    }
}

//具体算法C
class ConcreteStrategyC extends Strategy {
    //算法C实现方法
    public void algorithmInterface() {
        System.out.println("算法C实现");
    }
}

//上下文
class Context {
    Strategy strategy;
    //初始化时，传入具体的策略对象

    //strategy 和 simple factory 的区别是  大体在父子class 的方法继承是一样的  主要区别是在 context和factoryclass里对 父class的应用   factory 父class作为输出  而 strategy 这里 作为 constroctor paramter的输入
    public Context(Strategy strategy) {
        this.strategy=strategy;
    }
    //上下文接口
    public void contextInterface() {
    	//根据具体的策略对象，调用其算法的方法
        this.strategy.algorithmInterface();
    }
}


