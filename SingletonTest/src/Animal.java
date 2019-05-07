/**
 * @author Avinash Vijayakumar
 * 2019-02-14
 */
public class Animal {
    private Animal(){
        System.out.println("This is a animal class created now.");
    }
    private static class BillPushSingleInstance{
        private static final Animal INSTANCE = new Animal();
    }

    public static Animal getInstance(){
        return BillPushSingleInstance.INSTANCE;
    }

    public void SetName(String animalName){
        System.out.println("ANimal name is now "+animalName);
    }

}
