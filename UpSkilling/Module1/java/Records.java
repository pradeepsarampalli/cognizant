import java.util.ArrayList;
// import java.util.List;
import java.util.stream.Collectors;
class Record{
    String name;
    int age;

    public Record(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class Records {
    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record("pradeep", 25));
        records.add(new Record("suresh", 30));
        records.add(new Record("ramesh", 28));
        records.add(new Record("mahesh", 22));
        ArrayList<Record> aboveEighteen =(ArrayList<Record>)records.stream().filter(r->r.age>18).collect(Collectors.toList());
        System.out.println("Records with age above 18:");
        aboveEighteen.forEach(r->System.out.println("Name: "+r.name+", Age: "+r.age));
        
    }
}