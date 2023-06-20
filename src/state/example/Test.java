// 本题解信息来源于【九章算法】。请勿进行商业转载，非商业转载请注明出处。
package state.example;


import java.util.HashMap;

class VendingMachine {
    private String currentSelectedItem;
    private int currentInsertedMoney;
    private AbstractState state;
    private NoSelectionState noSelectionState;
    private HasSelectionState hasSelectionState;
    private InsertedMoneyState insertedMoneyState;
    private HashMap<String, Integer> itemPrice;

    public VendingMachine() {
        currentInsertedMoney = 0;
        currentSelectedItem = null;
        //这里很关键 vm 里有3个state     那个state 里面又有vm   和book example 类似 book exmaple 是通过  state method 时候 把vm context 当作方法parameter 去 state classs 里
        noSelectionState = new NoSelectionState(this);
        hasSelectionState = new HasSelectionState(this);
        insertedMoneyState = new InsertedMoneyState(this);
        state = noSelectionState;

        itemPrice = new HashMap<>();
        itemPrice.put("Coke", 199);
        itemPrice.put("Sprite", 299);
        itemPrice.put("MountainDew", 399);
    }

    public void setSelectedItem(String item) {
        this.currentSelectedItem = item;
    }

    public String getSelectedItem() {
        return currentSelectedItem;
    }

    public void insertMoneyVM(int amount) {
        this.currentInsertedMoney += amount;
    }

    public void emptyInsertedMoney() {
        this.currentInsertedMoney = 0;
    }

    public int getInsertedMoney() {
        return currentInsertedMoney;
    }

    public int getSalePrice() {
        if (currentSelectedItem == null) {
            System.out.println("Please make a selection before asking price");
            return 0;
        } else {
            return itemPrice.get(currentSelectedItem);
        }
    }

    public void changeToNoSelectionState() {
        state = noSelectionState;
    }

    public void changeToHasSelectionState() {
        state = hasSelectionState;
    }

    public void changeToInsertedMoneyState() {
        state = insertedMoneyState;
    }

    public void selectItemVM(String selection) {
        state.selectItem(selection);
    }

    public void addMoney(int value) {
        state.insertMoney(value);
    }

    public void executeTransactionVM() {
        state.executeTransaction();
    }

    public int cancelTransaction() {
        return state.cancelTransaction();
    }

    public String printState() {
        String res = "";

        res = "Current selection is: " + currentSelectedItem + ", current inserted money: " + currentInsertedMoney
                + ", current state is : " + state;

        return res;
    }

}

public class Test {

    public static void main(String[] args){

        System.out.println("**********************************************");


        var vm = new VendingMachine();

//        vm.cancelTransaction();

//        vm.insertMoney(2);
//        vm.selectItem("Coke");

//        vm.executeTransaction();
        vm.selectItemVM("Coke");
        vm.insertMoneyVM(500);
        vm.executeTransactionVM();




        System.out.println();
        System.out.println("**********************************************");

    }


}

interface State {
    public void selectItem(String selection);
    public void insertMoney(int value);
    public void executeTransaction();
    public int cancelTransaction();
    public String toString();
}

abstract class AbstractState implements State {
    protected VendingMachine vendingMachine;

    public AbstractState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}

class NoSelectionState extends AbstractState{

    public NoSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void selectItem(String selection) {
        // TODO Auto-generated method stub
        vendingMachine.setSelectedItem(selection);
        vendingMachine.changeToHasSelectionState();
    }

    @Override
    public void insertMoney(int value) {
        // TODO Auto-generated method stub
      System.out.println("Please make a selection first");
//        vendingMachine.insertMoney(value);
//        vendingMachine.changeToInsertedMoneyState();
    }

    @Override
    public void executeTransaction() {
        // TODO Auto-generated method stub
        System.out.println("Please make a selection first");
    }

    @Override
    public int cancelTransaction() {
        // TODO Auto-generated method stub
        System.out.println("Please make a selection first");
        return 0;
    }

    @Override
    public String toString(){
        return "NoSelection";
    }
}

class HasSelectionState extends AbstractState{

    public HasSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void selectItem(String selection) {
        // TODO Auto-generated method stub
        vendingMachine.setSelectedItem(selection);
    }

    @Override
    public void insertMoney(int value) {
        // TODO Auto-generated method stub
        vendingMachine.insertMoneyVM(value);
        vendingMachine.changeToInsertedMoneyState();
    }

    @Override
    public void executeTransaction() {
        // TODO Auto-generated method stub
        //System.out.println("You need to insert money first");
        // TODO Auto-generated method stub
        int diff = vendingMachine.getInsertedMoney() - vendingMachine.getSalePrice();
        if(diff >= 0){
            System.out.println("Executing transaction, will return you : " + diff + " money and item: " + vendingMachine.getSelectedItem());
            vendingMachine.setSelectedItem(null);
            vendingMachine.emptyInsertedMoney();
            vendingMachine.changeToNoSelectionState();
        }
        else{
            System.out.println("Not enough money, please insert " + (-diff) + " more.");
        }
    }

    @Override
    public int cancelTransaction() {
        // TODO Auto-generated method stub
        System.out.println("Transaction canceled");
        vendingMachine.setSelectedItem(null);
        vendingMachine.changeToNoSelectionState();
        return 0;
    }
    @Override
    public String toString(){
        return "HasSelection";
    }
}

class InsertedMoneyState extends AbstractState{

    public InsertedMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void selectItem(String selection) {
        // TODO Auto-generated method stub
        System.out.println("Already has a selection, please cancel transaction to make a new selection");
    }

    @Override
    public void insertMoney(int value) {
        // TODO Auto-generated method stub
        vendingMachine.insertMoneyVM(value);
    }

    @Override
    public void executeTransaction() {
        // TODO Auto-generated method stub
        int diff = vendingMachine.getInsertedMoney() - vendingMachine.getSalePrice();
        if(diff >= 0){
            System.out.println("Executing transaction, will return you : " + diff + " money and item: " + vendingMachine.getSelectedItem());
            vendingMachine.setSelectedItem(null);
            vendingMachine.emptyInsertedMoney();
            vendingMachine.changeToNoSelectionState();
        }
        else{
            System.out.println("Not enough money, please insert " + (-diff) + " more.");
        }
    }

    @Override
    public int cancelTransaction() {
        // TODO Auto-generated method stub
        int insertedMoney = vendingMachine.getInsertedMoney();
        vendingMachine.setSelectedItem(null);
        vendingMachine.emptyInsertedMoney();
        vendingMachine.changeToNoSelectionState();
        return insertedMoney;
    }

    @Override
    public String toString(){
        return "InsertedMoney";
    }
}