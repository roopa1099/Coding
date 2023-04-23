package designpattern.com.designpattern.commandpattern;

public class OffCommand implements Command{
    
    @Override
    public void performCommand(Television television) {
        television.switchedOff();
    }
}
