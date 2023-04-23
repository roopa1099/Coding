package designpattern.com.designpattern.commandpattern;

public class OnCommand implements Command{



    @Override
    public void performCommand(Television television) {
        television.switchedOn();
    }


    
}
