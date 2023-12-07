import java.util.ArrayList;
import java.util.List;

public class AppStream {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("10");
        stringList.add("2");
        stringList.add("5");
        stringList.add("6");

        String str = stringList.stream()
                .mapToInt(Integer::valueOf)
                .filter(x -> x > 4)
                .reduce((x,y)-> x + y).toString();
        System.out.println(str);
    }
}
