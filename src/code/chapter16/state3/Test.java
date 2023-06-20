package code.chapter16.state3;

public class Test {
	
	public static void main(String[] args){

		System.out.println("**********************************************");		
		System.out.println("《大话设计模式》代码样例");
		System.out.println();		

        
        //紧急项目
        Work emergencyProjects = new Work();
        emergencyProjects.setHour(9);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(10);
        //Work class have state field,  某些条件下callStateWriteProgram 改变了 work里的state的子类具体类型 所以可以发生状态转移
        //为了改变 work里的state 所以callStateWriteProgram 的method 选哟传入work as parameter
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(12);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(13);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(14);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(17);

        emergencyProjects.setWorkFinished(false);
        //emergencyProjects.setWorkFinished(true);

        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(19);
        emergencyProjects.callStateWriteProgram();
        emergencyProjects.setHour(22);
        emergencyProjects.callStateWriteProgram();

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

//中午工作状态
class NoonState extends State {
    public void writeProgram (Work w) {
        if (w.getHour() < 13)  {
            System.out.println("当前时间："+ w.getHour() +"点 饿了，午饭；犯困，午休。");
        }
        else {
            w.setState(new AfternoonState());
            w.callStateWriteProgram();
        }
    }
}

//下午工作状态
class AfternoonState extends State {
    public void writeProgram (Work w) {
        if (w.getHour() < 17) {
            System.out.println("当前时间："+ w.getHour() +"点 下午状态还不错，继续努力");
        }
        else {
            w.setState(new EveningState());

            w.callStateWriteProgram();
        }
   }  
}

//晚间工作状态
class EveningState extends State {
    public void writeProgram(Work w)
    {
        if (w.getWorkFinished())  
        {
            w.setState(new RestState());
            w.callStateWriteProgram();
        }
        else
        {
            if (w.getHour() < 21) {
               System.out.println("当前时间："+ w.getHour() +"点 加班哦，疲累之极");
            }
            else {
              w.setState(new SleepingState());
              w.callStateWriteProgram();
            }
        }
    }
}

//睡眠状态
class SleepingState extends State {
    public void writeProgram(Work w) {
        System.out.println("当前时间："+ w.getHour() +"点 不行了，睡着了。");
    }
}

//下班休息状态
class RestState extends State {
    public void writeProgram(Work w) {
        System.out.println("当前时间："+ w.getHour() +"点 下班回家了");
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
    public void callStateWriteProgram() {
        this.current.writeProgram(this);
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




