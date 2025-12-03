public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        Stereo stereo = new Stereo();

        LightOnCommand livingRoomRightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomRightOff = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomRightOn, livingRoomRightOff);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
    }

}
