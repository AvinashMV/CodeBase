/**
 * @author Avinash Vijayakumar
 * 2019-02-14
 */
public class Solution {
    public static void main(String[] args) {
        Animal ob1 = Animal.getInstance();
        ob1.SetName("Horse");

        Animal ob2 = Animal.getInstance();
        ob2.SetName("Giraffe");
    }
}
