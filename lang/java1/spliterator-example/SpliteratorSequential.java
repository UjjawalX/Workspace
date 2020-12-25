import java.util.Spliterator;
import java.util.Arrays;
import java.util.List;
public class SpliteratorSequential {
	public static void main(String args[]){
		List<String> names = Arrays.asList(new String[]{"Ran","Man","Tan"});
		Spliterator<String> splited = names.spliterator();
		splited.forEachRemaining(System.out::println);
	}
}
