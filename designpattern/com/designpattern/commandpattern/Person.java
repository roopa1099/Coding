package designpattern.com.designpattern.commandpattern;

public class Person {
    
    public static void main(String[] args) {
        /**
         * Client: Person
         * Invoker: Remote Control
         * Command: Interface
         * Concrete Command: OnCommand / OffCommand
         * Receiver: Television
         */
        Television television=new Television();
        RemoteControl remoteControl=new RemoteControl(television);
        OnCommand onCommand=new OnCommand();
        remoteControl.setCommand(onCommand);
        remoteControl.execute();

        OffCommand offCommand=new OffCommand();
        remoteControl.setCommand(offCommand);
        remoteControl.execute();
    }
}
