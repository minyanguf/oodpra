package code.chapter16.state0;

public class Test {
	
	public static void main(String[] args){

		System.out.println("**********************************************");		
		System.out.println("《大话设计模式》代码样例");
		System.out.println();		


        Context c = new Context(new ConcreteStateA());

        //这里主要都是 改变 c filed 然后一直call context。request
        c.request();
        c.request();
        c.request();
        c.request();

		System.out.println();
		System.out.println("**********************************************");

	}


}

//抽象状态类
abstract class State {

    public abstract void handle(Context context);
    
}

//具体状态类A
class ConcreteStateA extends State 
{
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}

//具体状态类B
class ConcreteStateB extends State 
{
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}

//上下文
class Context {
    private State state;
    public Context(State state)
    {
        this.state = state;
    }

    //可读写的状态属性，用于读取当前状态和设置新状态
    public State getState(){
        return this.state;
    }
    public void setState(State value){
        this.state = value;
        System.out.println("当前状态:" + this.state.getClass().getName());
    }
    //这里是关键 选哟call state。handle     在stateclass 里  得到 context 的class 然后 把 context里的state 改成另一个子类

    public void request()
    {
        this.state.handle(this); 
    }
}

