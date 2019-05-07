/**
 * @author Avinash Vijayakumar
 * 2019-04-02
 */
public class Interval {
    int starttime,endtime;
    public Interval(int s,int e){
        starttime =s;
        endtime =e;
    }

    @Override
    public String toString() {
        return "("+starttime+","+endtime+")";
    }
}
