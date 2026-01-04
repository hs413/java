public class SoldState implements State {
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("알맹이를 내보내고 있씁니다");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("이미 뽑았습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한 번만 돌려주세요");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();

        if (gumballMachine.getCount() == 0) {
            System.out.println("알맹이가 없읍니다.");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
