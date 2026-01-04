public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;

        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
       state.turnCrank();
       state.dispense();
    }


    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("알맹이를 내보내고 있습니다");

        if (count > 0) {
            count = count - 1;
        }
    }
}

//public class GumballMachine {
//    final static int SOLD_OUT = 0;
//    final static int NO_QUARTER = 1;
//    final static int HAS_QUARTER = 2;
//    final static int SOLD = 3;
//
//    int state = SOLD_OUT;
//    int count = 0;
//
//    public GumballMachine(int count) {
//        this.count = count;
//
//        if (count > 0) {
//            state = NO_QUARTER;
//        }
//    }
//
//    public void insertQuarter() {
//        if (state == HAS_QUARTER) {
//            System.out.println("동전은 한 개만 넣어 주세요");
//        } else if (state == NO_QUARTER) {
//            state = HAS_QUARTER;
//            System.out.println("동전을 넣으셨습니다.");
//        } else if (state == SOLD_OUT) {
//            System.out.println("매진되었습니다.");
//        } else if (state == SOLD) {
//            System.out.println("알맹이를 내보내고 있씁니다");
//        }
//    }
//
//    public void ejectQuarter() {
//        if (state == HAS_QUARTER) {
//            System.out.println("동전이 반환됩니다");
//            state = NO_QUARTER;
//        } else if (state == NO_QUARTER) {
//            state = HAS_QUARTER;
//            System.out.println("동전을 넣어 주세요");
//        } else if (state == SOLD) {
//            System.out.println("이미 뽑았습니다.");
//        } else if (state == SOLD_OUT) {
//            System.out.println("동전을 넣지 않으셨읍니다");
//        }
//    }
//
//    public void turnCrank() {
//        if (state == SOLD) {
//            System.out.println("손잡이는 한 번만 돌려주세요");
//        } else if (state == NO_QUARTER) {
//            System.out.println("동전을 넣어주세요");
//        } else if (state == SOLD_OUT) {
//            System.out.println("매진되었습니다");
//        } else if (state == HAS_QUARTER) {
//            System.out.println("손잡이를 돌리셨읍니다");
//        }
//    }
//
//    public void dispense() {
//        if (state == SOLD) {
//            System.out.println("알맹이를 내보내고 있읍니다");
//            count = count - 1;
//            if (count == 0) {
//                System.out.println("알맹이가 없읍니다.");
//                state = SOLD_OUT;
//            } else {
//                state = NO_QUARTER;
//            }
//        } else if (state == NO_QUARTER) {
//            System.out.println("동전을 넣어주세요");
//        } else if (state == SOLD_OUT) {
//            System.out.println("매진되었습니다");
//        } else if (state == HAS_QUARTER) {
//            System.out.println("알맹이를 내보낼 수 없읍니다");
//        }
//    }
//}
