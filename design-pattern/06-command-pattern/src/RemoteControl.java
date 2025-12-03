public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[10];
        offCommands = new Command[10];

        Command noCommand = new NoCommand();
        for (int i = 0; i < onCommands.length; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n------ remote ------- \n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "]: " + onCommands[i].getClass().getName() + "   "
                    + offCommands[i].getClass().getName() + "\n");
        }

        return sb.toString();
    }

}
