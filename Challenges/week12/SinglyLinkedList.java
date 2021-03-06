// import org.w3c.dom.Node;

public class SinglyLinkedList {
	public Node head;

	public SinglyLinkedList() {
		// your code here
		head = null;
	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}

	public void remove() {
		if (head == null) {
			// empty
			System.out.println("It is empty");
		} else if (head.next == null) {
			// one item
			int deleted = head.value;
			head = null;
			System.out.println("First item " + deleted + " deleted");
		} else {
			Node runner = head;
			while (runner.next.next != null) {
				runner = runner.next;
			}
			int deleted = runner.next.value;
			runner.next = null;
			System.out.println("Last item " + deleted + " deleted");
		}
	}

	public void reverse() {
		if (head == null) {
			// it is empty
		} else if (head.next == null) {
			// it is size 1
		} else {
			Node prevNode, currentNode, nextNode;
			prevNode = null;
			currentNode = head;
			nextNode = head.next;

			while (currentNode != null) {

				currentNode.next = prevNode;

				prevNode = currentNode;
				currentNode = nextNode;

				if (nextNode != null) {
					nextNode = nextNode.next;
				}
			}

			head = prevNode;
		}
	}

	public static SinglyLinkedList reverseSLL(SinglyLinkedList ssl) {
		SinglyLinkedList newSSL = new SinglyLinkedList();
		Node runner = ssl.head;
		while (runner != null) {
			newSSL.addBack(runner.value);
			runner = runner.next;
		}
		// Print rev
		// newSSL.printValues();
		return newSSL;
	}

	public void addBack(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void printValues() {
		if (head == null) {
			System.out.println("[ ]");
		} else {
			Node runner = head;
			String str = "[";
			while (runner != null) {
				str += runner.value;
				runner = runner.next;
				if (runner != null) {
					str += ", ";
				}
			}

			System.out.println(str + "]");
		}
	}

	public void createLoop(int linkedVal) {
		Node loopStarter = head;
		while (loopStarter.next != null) {
			loopStarter = loopStarter.next;
		}

		Node loopLink = head;
		while (loopLink != null && loopLink.value != linkedVal) {
			loopLink = loopLink.next;
		}

		loopStarter.next = loopLink;
	}

	public boolean hasLoop() {
		Boolean loop = false;
		if (head == null) {
			return loop;
		} else if (head.next == null) {
			return loop;
		} else {
			Node loopStarter = head;
			Node loopLink = head.next;

			while (loopStarter != null && loopLink != null) {
				if (loopStarter.value == loopLink.value) {
					return true;
				}

				loopStarter = loopStarter.next;
				loopLink = loopLink.next.next;
			}
			return loop;

		}

	}

	public void breakLoop() {
		if (hasLoop()) {
			Node walker = head;
			Node runner = head.next;
			Node goalie = null;

			while (walker != null && runner != null) {
				if (walker.next == goalie) {
					// System.out.println("Walker " + walker.value);
					// System.out.println("Runner " + runner.value);
					// System.out.println("Goalie " + goalie.value);
					// System.out.println("Break !!");

					walker.next = null;
					break;
				}

				if (walker == runner) {
					if (goalie != null) {
						goalie = goalie.next;
					} else {
						goalie = head;
					}
				}

				walker = walker.next;
				runner = runner.next.next;
			}
		}
	}

}