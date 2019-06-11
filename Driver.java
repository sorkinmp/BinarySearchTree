
public class Driver {
	
	public static void main(String[] args) {
		// create a tree that has only the root
		// and remove the root
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Is it empty: " + bst.isEmpty());
		System.out.println("Test root with no children");
		
		bst.add("root");
		System.out.println("Is it empty: " + bst.isEmpty());
		
		System.out.println("Did we remove root: " + bst.remove("root"));
		System.out.println("Does it contain root: " + bst.contains("root"));
		System.out.println("Is it empty: " + bst.isEmpty());
		
		System.out.println("\n\nTest root with one child");
		System.out.println("Let's test the one child to the left");
		bst.add("j");
		System.out.println("Is it empty: " + bst.isEmpty());
		bst.add("i");
		System.out.println("Does it contain i: " + bst.contains("i"));
		System.out.println("Remove j: " + bst.remove("j"));
		System.out.println("Does it contain j: " + bst.contains("j"));
		System.out.println("Does it contain i: " + bst.contains("i"));
		
		System.out.println("Let's test the one child to the right");
		bst.add("p");
		System.out.println("Does it contain p: " + bst.contains("p"));
		System.out.println("Remove i: " + bst.remove("i"));
		System.out.println("Does it contain i: " + bst.contains("i"));
		System.out.println("Does it contain p: " + bst.contains("p"));
		
		System.out.println("\n\nTest leaf");
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.add("j");
		bst2.add("f");
		bst2.add("p");
		bst2.add("c");
		bst2.add("h");
		bst2.add("b");
		bst2.add("d");
		bst2.add("i");
		bst2.add("m");
		bst2.add("n");
		bst2.add("o");
		bst2.add("a");
		System.out.println("Let's remove the leaf nodes: a, d, i, o");
		System.out.println("Does it contain a: " + bst2.contains("a"));
		System.out.println("Remove a: " + bst2.remove("a"));
		System.out.println("Does it contain a now: " + bst2.contains("a"));
		
		System.out.println("Does it contain d: " + bst2.contains("d"));
		System.out.println("Remove d: " + bst2.remove("d"));
		System.out.println("Does it contain d now: " + bst2.contains("d"));
		
		System.out.println("Does it contain i: " + bst2.contains("i"));
		System.out.println("Remove i: " + bst2.remove("i"));
		System.out.println("Does it contain i now: " + bst2.contains("i"));
		
		System.out.println("Does it contain o: " + bst2.contains("o"));
		System.out.println("Remove o: " + bst2.remove("o"));
		System.out.println("Does it contain o now: " + bst2.contains("o"));
		
		System.out.println("\n\nTest one child");
		BinarySearchTree bst3 = new BinarySearchTree();
		bst3.add("j");
		bst3.add("f");
		bst3.add("p");
		bst3.add("c");
		bst3.add("h");
		bst3.add("b");
		bst3.add("d");
		bst3.add("i");
		bst3.add("m");
		bst3.add("n");
		bst3.add("o");
		bst3.add("a");
		System.out.println("Let's remove the nodes with one child: b, h, p, m");
		System.out.println("Does it contain b: " + bst3.contains("b"));
		System.out.println("Remove b: " + bst3.remove("b"));
		System.out.println("Does it contain b now: " + bst3.contains("b"));
		
		System.out.println("Does it contain h: " + bst3.contains("h"));
		System.out.println("Remove h: " + bst3.remove("h"));
		System.out.println("Does it contain h now: " + bst3.contains("h"));
		
		System.out.println("Does it contain p: " + bst3.contains("p"));
		System.out.println("Remove p: " + bst3.remove("p"));
		System.out.println("Does it contain p now: " + bst3.contains("p"));
		
		System.out.println("Does it contain m: " + bst3.contains("m"));
		System.out.println("Remove m: " + bst3.remove("m"));
		System.out.println("Does it contain m now: " + bst3.contains("m"));
		
		
		System.out.println("\n\nTest two children");
		BinarySearchTree bst4 = new BinarySearchTree();
		bst4.add("j");
		bst4.add("f");
		bst4.add("p");
		bst4.add("c");
		bst4.add("h");
		bst4.add("b");
		bst4.add("e");
		bst4.add("d");
		bst4.add("i");
		bst4.add("m");
		bst4.add("n");
		bst4.add("o");
		bst4.add("a");
		System.out.println("Let's remove the nodes with two children: f, c, j");
		System.out.println("Does it contain f: " + bst4.contains("f"));
		System.out.println("Remove f: " + bst4.remove("f"));
		System.out.println("Does it contain f now: " + bst4.contains("f"));
		System.out.println("Does it contain b now: " + bst4.contains("b"));
		
		System.out.println("Does it contain c: " + bst4.contains("c"));
		System.out.println("Remove c: " + bst4.remove("c"));
		System.out.println("Does it contain c now: " + bst4.contains("c"));
		
		System.out.println("Does it contain j: " + bst4.contains("j"));
		System.out.println("Remove j: " + bst4.remove("j"));
		System.out.println("Does it contain j now: " + bst4.contains("j"));
	}

}
