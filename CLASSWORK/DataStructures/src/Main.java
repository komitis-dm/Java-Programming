import java.util.*;

public class Main {

	public static void main(String[] args) {
				
		//=================================== Linked List ===================================

		LinkedList<String> list = new LinkedList<>();
		list.add("John");
		list.add("Bob");
		list.add("Helen");
		list.add("John");
		list.add("Nick");
		list.addFirst("Kathrine");
		
		// for-each Traversal
		System.out.println("Traversal with 'for-each' =>");
		for (String name : list)
		{
			System.out.println(name);
		}
		
		// toString Traversal
		// toString is used even if we don't type it
		System.out.println("\nTraversal with 'toString' =>");
		System.out.println(list.toString());
		
		// Iterator Traversal
		System.out.println("\nTraversal with 'Iterator' =>");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
		{
			String name = iter.next();
			System.out.println(name);
		}
		
		list.remove(0);
		list.remove("Bob");
		System.out.println("\nTraversal after removal =>");
		System.out.println(list.toString());
		
		//=================================== Hash Set ===================================
		
		HashSet<String> set = new HashSet<>();
		set.add("John");
		set.add("Bob");
		set.add("Anna");
		// This will be denied since we already have this name in our HashSet
		// The "add" method returns a boolean value: True (if the item is added), False (if it's not)
		// The "add" value first goes through the items to check if the item we want to add already exists
		set.add("John");
		
		System.out.println("\nSet =>" + set);
		
		//=================================== Conversion ===================================
		
		System.out.println("\nOriginal list =>" + list);
		// If we declare a HashSet with a List inside it, then the HashSet will automatically
		// add the items of the list to it, simultaneously checking for duplicates
		Collection<String> noDuplicates = new HashSet<>(list);
		System.out.println("\nNo duplicates =>" + noDuplicates);

		
	}

}
