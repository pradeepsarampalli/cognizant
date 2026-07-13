public class RemoteControl {
    public Light light;
    public RemoteControl(Light light){
        this.light = light;
    }
    public void execute(Command command){
        command.execute();
    }
}