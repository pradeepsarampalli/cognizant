public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        LightOffCommand loffc = new LightOffCommand(light);
        LightOnCommand lonc = new LightOnCommand(light);
        RemoteControl remoteControl = new RemoteControl(light);
        remoteControl.execute(lonc);
        remoteControl.execute(loffc);
    }
}