package designpattern.com.designpattern.commandpattern;

public class RemoteControl{
    
    Command command;
    Television television;

    public RemoteControl(Television television) {
        this.television=television;        
    }


    public void execute(){
        command.performCommand(television);
    }

    public void setCommand(Command command){
        this.command=command;
    }

    public Command getCommand(){
       return command;
    }


}
