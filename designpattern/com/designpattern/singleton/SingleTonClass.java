package designpattern.com.designpattern.singleton;

public class SingleTonClass implements Cloneable{
    
    // Make thread safe
    // make constructor private
    private static volatile SingleTonClass instance;

    // Early initialization
    // private static volatile SingleTonClass instance=new SingleTonClass();



    private SingleTonClass(){

    }

    public static SingleTonClass getInstance(){

        if(instance==null){
            // lock for thread safety
            synchronized(SingleTonClass.class){
                if(instance==null){
                    instance=new SingleTonClass();
                }
            }
        }

        return instance;
    }


    // To be safe from cloning
   @Override
   protected Object clone() throws CloneNotSupportedException {
       throw new CloneNotSupportedException();
   }

}
