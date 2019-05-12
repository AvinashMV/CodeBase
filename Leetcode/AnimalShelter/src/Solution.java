import java.util.LinkedList;

/**
 * @author Avinash Vijayakumar
 * 2019-01-19
 */
public class Solution {
    private static LinkedList<Animal> animalList = new LinkedList<>();

    public static void main(String[] args) {
        enqueue(new Animal("dog1","dog"));
        enqueue(new Animal("dog2","dog"));
        enqueue(new Animal("cat1","cat"));
        enqueue(new Animal("dog3","dog"));
        enqueue(new Animal("cat2","cat"));
        enqueue(new Animal("cat3","cat"));

        Animal del;
        del = dequeueCat();
        display(del);

    }

    public static void display (Animal animal){
        System.out.println("deleted animal is ");
        System.out.println(animal.getName()+" "+"is a "+animal.getType());
        System.out.println("Timestamp :"+animal.getTimestamp());
    }

    public static void enqueue (Animal animal){
        animalList.add(animal);
    }

    public static Animal dequeueAny (){
        return animalList.remove(0);
    }

    public static Animal dequeueDog(){
        for(Animal i:animalList){
            if(i.getType().equals("dog"))
                return i;
        }
        return null;
    }

    public static Animal dequeueCat(){
        for(Animal i:animalList){
            if(i.getType().equals("cat")){
                return i;
            }
        }
        return null;
    }

}
