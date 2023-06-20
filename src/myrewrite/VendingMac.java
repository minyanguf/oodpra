package myrewrite;

public class VendingMac {
    public VendingMac() {
        this.state =noselect;
    }
    public VendingMac(Istate state) {
        this.state =noselect;
        this.state = state;
    }

    public Istate getState() {
        return state;
    }

    public void setState(Istate state) {
        this.state = state;
    }

    private Istate state;
    //这些 卸载 default construcotr 比较好
    Istate noselect = new NoselectState(this);
    Istate selected = new SelectedState(this);

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;

    public void insertVM(double num){
        this.state.insertMoney(num);
    }

}
interface Istate{
    public void insertMoney(double num);
}
abstract class Abstate implements Istate{
    public VendingMac vm;

    public Abstate(VendingMac vm) {
        this.vm = vm;
    }

    public VendingMac getVm() {
        return vm;
    }

    public void setVm(VendingMac vm) {
        this.vm = vm;
    }

    public abstract void insertMoney(double num);

}

class NoselectState extends Abstate{

    public NoselectState(VendingMac vm) {
        super(vm);
    }

    @Override
    public void insertMoney(double num) {
        System.out.println("in noselect State  inserting coin");
        var existing = vm.getMoney();
        vm.setMoney(num+existing);
        System.out.println(vm.getMoney());
        //move to next state
        vm.setState(vm.selected);

    }
}
class SelectedState extends Abstate{

    public SelectedState(VendingMac vm) {
        super(vm);
    }

    @Override
    public void insertMoney(double num) {
        System.out.println("in selected State  pls dont isnert");
        var existing = vm.getMoney();
        vm.setMoney(num+existing);
        System.out.println(vm.getMoney());
    }
}
class Test2{
    public static void main(String[] args){
        var vem = new VendingMac();
        vem.insertVM(500);
        //这里运行上一个method 后 自动进入 下个state
        vem.insertVM(600);
    }
}
