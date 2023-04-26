package designpattern.com.designpattern.proxypattern;

public class ConnectInternetImpl implements Internet {

    @Override
    public void connectTo(String providerService) {
        // TODO Auto-generated method stub
        System.out.println("Connected to "+providerService);
    }
    
}
