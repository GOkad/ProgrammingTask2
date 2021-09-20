package dev.okadarov.programmingtask2;


public class Application {

	public static void main(String[] args) {

		// Create Doubly Linked List head node
			Node<Integer> node = new Node<Integer>( 100 );
		
		// Create Doubly Linked List
			DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>( node );
		
		
		// Insert first node
			doublyLinkedList.push(100);
		// Insert last node
			doublyLinkedList.append(200);
		// Insert node at index
			doublyLinkedList.insertAtIndex(1, 300);
		// Insert before Node
			doublyLinkedList.insertBefore(doublyLinkedList.head, 400 );
		// Insert after Node
			doublyLinkedList.insertAfter(doublyLinkedList.head.next, 400 );
		
		
		// Print all nodes
			doublyLinkedList.printNodes();
		
		
		
		
		

	}

}
