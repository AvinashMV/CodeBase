import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Avinash Vijayakumar
 * 2019-01-19
 */
public class Animal {
    private String name;
    private String type;

    public String getTimestamp() {
        return timestamp;
    }

    private String timestamp;

    public Animal(String pname,String ptype){
        name = pname;
        type = ptype;
        timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
