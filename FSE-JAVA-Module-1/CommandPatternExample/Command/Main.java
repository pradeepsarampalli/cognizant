package Command;

public class Main {
    public static void main(String[] args){

    Light light = new Light();

    Command onCommand = new LightOnCommand(light);
    Command offCommand = new LightOffCommand(light);

    RemoteControl remote = new RemoteControl(onCommand);
        remote.execute();

    remote = new RemoteControl(offCommand);
        remote.execute();
    }

}
