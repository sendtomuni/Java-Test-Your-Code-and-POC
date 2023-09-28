package learn.luv2code.main;

import java.util.List;

public class testImmutabilityOfListObjectCreatedThroughList_ofMethod {

	public static void main(String[] args) {
		List<Integer> ints = List.of(1,2);
		ints.forEach(System.out::println);
		ints.add(3); //java.lang.UnsupportedOperationException
		ints.forEach(System.out::println);
	}

}
