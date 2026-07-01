import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Streams {
    public static void main(String[] args) {
        List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> filteredNums = nums.stream().filter(n->n%2==0).collect(Collectors.toList());
        filteredNums.forEach(n->System.out.print(n+" "));
        System.out.println();
    }
}