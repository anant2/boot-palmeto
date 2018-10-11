import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.omg.Messaging.SyncScopeHelper;

public class StreamsDemo {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("great");
		names.add("ash");
		names.add("pandey");
		names.add("tommy");
		names.add("rabin");
		names.add("rashi");
		names.add("ankit");
		names.add("pooja");
		names.add("asdasd");
		names.add("hello");
		names.add("zyan");
		names.add("rita");
		names.add("cat");
		names.add("mat");
		names.add("ant");
		names.add("fatima");
		names.add("jack");

		//List<String> filtered = new ArrayList<>();

		/*for (String name : names) {
			if (name.startsWith("r")) {
				filtered.add(name);
			}
		}*/
		Predicate<String> p1 = s-> s.startsWith("r");
		
		List<String> filtered = names.stream().filter(p1).collect(Collectors.toList());

		
		Consumer<String> c1 = c-> System.out.println(c);
		
		//names.stream().filter(p1).forEach(c1);;
		
		System.out.println(filtered.toString());

	}

}
