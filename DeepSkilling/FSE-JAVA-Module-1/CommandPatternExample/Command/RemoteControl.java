package Command;

public class RemoteControl {
    Command command;
    RemoteControl(Command command){
        this.command = command;
    }
    public void execute(){
        command.execute();
    }

}
