package designpattern.com.designpattern.proxypattern;

public class AuthorizationCheck implements Internet{
    
    public void connectTo(String providerService) {
    
        
        ConnectInternetImpl connectInternetImpl=new ConnectInternetImpl();
        if(providerService=="airtel" || providerService=="jio"){
            connectInternetImpl.connectTo(providerService);
        }
        else{
            System.out.println("Not possible to connect");
        }

    }
}
