/**
 * @author Avinash Vijayakumar
 * 2019-01-11
 */
public class Node {
    private int value;
    private Node link;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Node(int v){
        value = v;
        link = null;
    }
}
