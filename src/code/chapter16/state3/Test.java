package code.chapter16.state3;

public class Test {
	
	public static void main(String[] args){

		System.out.println("**********************************************");		
		System.out.println("《大话设计模式》代码样例");
		System.out.println();		

        
        //紧急项目
        Work emergencyProjects = new Work();
//        emergencyProjects.setState(new ForenoonState());
        emergencyProjects.setHour(9);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(16);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(19);
        emergencyProjects.callStateWriteProgram();

        //Work class have state field,  某些条件下callStateWriteProgram 改变了 work里的state的子类具体类型 所以可以发生状态转移
        //为了改变 work里的state 所以callStateWriteProgram 的method 选哟传入work as parameter
//        emergencyProjects.callStateWriteProgram();
//        emergencyProjects.setHour(12);
//        emergencyProjects.callStateWriteProgram();
//        emergencyProjects.setHour(13);
//        emergencyProjects.callStateWriteProgram();
//        emergencyProjects.setHour(14);
//        emergencyProjects.callStateWriteProgram();
//        emergencyProjects.setHour(17);
//
//        emergencyProjects.setWorkFinished(false);
//        //emergencyProjects.setWorkFinished(true);
//
//        emergencyProjects.callStateWriteProgram();
//        emergencyProjects.setHour(19);
//        emergencyProjects.callStateWriteProgram();
//        emergencyProjects.setHour(22);
//        emergencyProjects.callStateWriteProgram();

		System.out.println();
		System.out.println("**********************************************");

	}
}

//抽象状态类
abstract class State {

    public abstract void writeProgram(Work w);

}

//上午工作状态
class ForenoonState extends State {
    public void writeProgram (Work w) {
        if (w.getHour() < 12)  {
            System.out.println("当前时间："+ w.getHour() +"点 上午工作，精神百倍");
        }
        else {
            w.setState(new NoonState());

            w.callStateWriteProgram();
        }
    }
}

class NoonState extends State {
    public void writeProgram (Work w) {
        if (w.getHour() < 18)  {
            System.out.println("当前时间："+ w.getHour() +"noon");
        }
        else {
            w.setState(new EndState());

            w.callStateWriteProgram();
        }
    }
}

class EndState extends State {
    public void writeProgram (Work w) {

            System.out.println("end");

    }
}


//工作类
class Work {

    private State current;
    
    public Work(){
        current = new ForenoonState();
    }
    //设置状态
    public void setState(State value) {
        this.current = value;
    }
    //写代码的状态
    //关键是context class 里面有 method call state。handle（this） 然后state class 那边 的method 接收到 context class 的parameter  然后在那边改变 state成另一个子类
    public void callStateWriteProgram() {
        this.current.writeProgram(this);
//        this.current.writeProgram(this);
    }

    //当前的钟点
    private int hour;
    public int getHour(){
        return this.hour;
    }
    public void setHour(int value){
        this.hour = value;
    }

    //当前工作是否完成
    private boolean workFinished = false;
    public boolean getWorkFinished(){
        return this.workFinished;
    }
    public void setWorkFinished(boolean value){
        this.workFinished = value;
    }
}




