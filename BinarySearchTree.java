/**
 * A Java implementation of a BinarySearchTree using Nodes.
 * @author sorkinmp
 *
 */
public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	/*
	 * Adds the specified node to the BST
	 */
	public String add(String value) {
		if (root == null) {
			root = new Node(value);
			return value;
		}
		return add(root, value);
	}

	private String add(Node root, String value) {
		// root has been determined to be not null
		int comparison = value.compareTo(root.data);

		// no duplicates allowed
		if (comparison == 0) {
			return value;
		}

		if (comparison < 0) { // new data is smaller than root data
			if (root.left == null) { // if left root empty/null
				root.left = new Node(value);
				return value;
			}
			return add(root.left, value);
		}

		if (comparison > 0) { // new data is greater than root data
			if (root.right == null) { // if right root empty/null
				root.right = new Node(value);
				return value;
			}
			return add(root.right, value);
		}
		return null; // should never really reach this step
	}

	/*
	 * Returns true if the string is found in the BST
	 */
	public boolean contains(String value) {
		return contains (root, value);
	}

	private boolean contains (Node root, String value) {
		// if tree empty
		if (root == null) {
			return false;
		}
		// if tree not empty
		int comparison = value.compareTo(root.data);

		// if equal to 0, we found match
		if (comparison == 0) {
			return true;
		}

		// if less than 0, we go to the left
		// this means that the value is less than the root/parent
		if (comparison < 0) {
			return contains (root.left, value);
		}

		// if greater than 0, we get to the right
		return contains(root.right, value);
	}

	/*
	 * Checks whether the tree is empty or not
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * Removes the specified string from the BST
	 */
	public boolean remove(String s) {
		// if the s is not in the tree
		if (contains(s) == false) {
			return false;
		}
		return remove(root, s);
	}

	private boolean remove(Node root, String s) {
//		if (root == null) {
//			return false;
//		}
		// see if root is the value to be removed
		if (this.root.data.equals(s)) {
			// if root has no children
			if (this.root.left == null && this.root.right == null) {
				// set root to null
				this.root = null;
				return true;
			}
			// if root has two children
			else if (this.root.left != null && this.root.right != null) {
				// find the max of the left
				Node current = this.root.left;
				Node currentParent = this.root;
				if(current.right == null) {
					this.root.data = current.data;
					this.root.left = this.root.left.left;
					return true;
				}
				
				while (current.right != null) {
					currentParent = current;
					current = current.right;
				}
				this.root.data = current.data;
				// if current has a left child
				if (current.left != null) {
					currentParent.right = current.left;
					return true;
				}
				currentParent.right = null;
				return true;
			}
			// if root has one child
			else {
				// if the root's only child is to the left
				if (this.root.left != null) {
					this.root = this.root.left;
					return true;
				}
				// if the root's only child is to the right
				//else {
					this.root = this.root.right;
					return true;
				//}
			}
		}  // end root is value check
		// if root is not the value
		// first find the value
		int comparison = s.compareTo(root.data);
		
		Node child = null;
		
		if (comparison < 0) {
			child = root.left;
		}
		
		if (comparison > 0) {
			child = root.right;
		}
		
		if (child.data.equals(s)) {
			// determine if leaf
			if (child.left == null && child.right == null) {
				// if the leaf is to the left
				if (root.left == child) {
					root.left = null;  // break left chain
					return true;
				}
				else {
					root.right = null;
					return true;
				}
			}
			// if it has two children
			else if (child.left != null && child.right != null) {
				// find max in left subtree of node to be removed
				Node current = child.left;
				Node currentParent = child;
				if(current.right == null) {
					child.data = current.data;
					child.left = child.left.left;
					return true;
				}
				
				while (current.right != null) {
					currentParent = current;
					current = current.right;
				}
				// change child to max
				// break chain to max
				child.data = current.data;
				currentParent.right = current.left;
				return true;
			}
			// if it has one child
			else if (child.left != null || child.right != null) {
				// if the child is to the left of the root
				if (root.left == child) {
					// if the child's one child is to the left
					if (child.left != null) {
						root.left = child.left;
						return true;
					}
					// if the child's one child is to the right
					else {
						root.left = child.right;
						return true;
					}
				}
				// if the child is to the right of the root
				else if(root.right ==child){
					if (child.left != null) {
						root.right = child.left;
						return true;
					}
					// if the child's one child is to the right
					else if(child.right != null) {
						root.right = child.right;
						return true;
					}
				}
			}
		}  // end cases leaf, two children, one child
		// if still contains, run again
		return remove(child, s);
	}
	
	/**
	 * Prints the inorder traversal of this tree
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	private void inorderTraversal(Node root) {
		if(root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

	/**
	 * A Node class with a left and right Node, and string data.
	 * @author sorkinmp
	 *
	 */
	private class Node {
		String data;
		Node left;
		Node right;

		public Node(String data) {
			this.data = data;
		}
	}

	/*
	 * Returns the height of the tree
	 */
	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node root) {
		if(root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));

	}


	public static void main(String [] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.add("D");
		bst.add("B");
		bst.add("F");
		bst.add("A");
		bst.add("C");
		bst.add("E");
		bst.add("G");

		System.out.println("The height: " + bst.getHeight());

		System.out.print("BST Inorder: ");
		bst.inorderTraversal();
		System.out.println();
		System.out.println(bst.contains("A"));
		System.out.println(bst.contains("B"));
		System.out.println(bst.contains("C"));
		System.out.println(bst.contains("D"));
		System.out.println(bst.contains("E"));
		System.out.println(bst.contains("F"));
		System.out.println(bst.contains("G"));

		System.out.println(bst.contains("X"));
		System.out.println(bst.contains("M"));
		System.out.println(bst.contains("L"));

	}

}
