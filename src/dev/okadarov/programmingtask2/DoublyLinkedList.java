package dev.okadarov.programmingtask2;

public class DoublyLinkedList<E> {
	
	public Node<E> head;
	public int size;

	public DoublyLinkedList(Node<E> head) {
		this.head = head;
		this.size = 0;
	}

	// Insert first node
		public void push ( E data ) {
			Node<E> node = new Node<E>( data );
			node.next = this.head;
			if (this.head != null ) this.head.previous = node;
			this.head = node;
			
			this.size++;
		}
	// Insert last node
		public void append ( E data ) {
			Node<E> node = new Node<E>( data );
			
			// If List is empty, make new node the head
				if ( this.head == null ) this.head = node;
				
			// Else find last Node and add new Node
				else {
					Node<E> nextNode;
					nextNode = this.head;
					// Get the last node
						while ( nextNode.next != null ) { nextNode = nextNode.next; }
					// Update Nodes
						node.previous = nextNode;
						nextNode.next = node;
					
				}
				
			this.size++;
			
		}
	// Insert node at index
		public void insertAtIndex( int index, E data ) {
			// Check if index is out of bounds or is a negative number
				if ( index < 0 || index > this.size ) return;
				
			// If index is 0 append Node
				if ( index == 0 ) {
					this.push( data );
					return;
				}
				
			// Insert Node after index
				Node<E> node = new Node<E>( data );
				Node<E> prevNode = null;
				Node<E> nextNode = null;
				int counter = 0;
				
				// Get set next and previous Nodes
				nextNode = this.head;
					while ( counter < index ) {
						prevNode = nextNode;
						nextNode = nextNode.next;
						counter++;
					}
				// Update Nodes
					node.next = nextNode;
					node.previous = nextNode.previous;
					
					prevNode.next = node;
					nextNode.previous = node;

		}
	// Insert before Node
		public void insertBefore ( Node<E> nextNode, E data ) {
			
			// Check if passed Node is valid 
				if ( nextNode == null ) return;
			
			// Check if insertion is before the head 
				if ( nextNode == this.head ) {
					this.push(data);
					return;
				}
				
			// Create new Node and insert it
				Node<E> newNode = new Node<E>( data );
				
			// Update Nodes
				newNode.next = nextNode;
				newNode.previous = nextNode.previous;
				nextNode.previous.next = newNode;
				nextNode.previous = newNode;
				
				this.size++;
		}
	// Insert after Node
		public void insertAfter( Node<E> prevNode, E data ) {
			
			// Check if passed Node is valid 
				if ( prevNode == null ) return;
				
			// Check if insertion is after last Node
				if ( prevNode.next == null ) {
					this.append(data);
					return;
				}
			
			// Create new Node and insert it
				Node<E> newNode = new Node<E>(data);
			
			// Update Nodes
				newNode.previous = prevNode;
				newNode.next = prevNode.next;
				prevNode.next.previous = newNode;
				prevNode.next = newNode;
				
				this.size++;
			
		}
		
	// Get node from list by index
		public Node<E> getAtIndex ( int index ) {
			Node<E> node = this.head;
			int counter = 0;
			
			// Find and return Node
				while ( node != null ) {
					if ( counter == index ) return node;
					counter++;
					node = node.next;
				}
			
			return null;
		}
	// Get node index by value 
		public int indexOf ( E data ) {
			Node<E> node = this.head;
			int index = 0;
			
			// Find index of Node and return it
				while ( node != null ) {
					if ( node.data.equals(data) ) return index; 
					index++;
					node = node.next;
				}
			
			return -1;
		}
		
	// Remove Node at index
		public void removeAtIndex ( int index ) {
			// Check if index is out of bounds or is a negative number
				if ( index < 0 || index >= this.size ) return;
				
			Node<E> nextNode= this.head;
			Node<E> prevNode = null;
			int counter = 0;
			
			
			if ( index == 0 ) {
				this.head = nextNode.next;
			} else {
				// Find Nodes by index
					while ( counter < index ) {
						counter++;
						prevNode = nextNode;
						nextNode = nextNode.next;
					}
				// Update Nodes
					prevNode.next = nextNode.next;
					nextNode.next.previous = prevNode;
			}
			
			this.size--;
		}
	// Remove all nodes from list
		public void clearList ( ) {
			Node<E> temp = null;
			
			while ( this.head != null ) {
				temp = this.head;
				this.head = this.head.next;
				temp = null;
			}
			System.out.println("All nodes have been removed!");
			this.size = 0;
		}
		
	
		
	// Print all nodes data
		public void printNodes ( ) {
			Node<E> node = this.head;
			System.out.println("SIZE : "+this.size);
			while ( node != null ) {
				String message =
				""+(node.previous == null ? " - " : node.previous.data )+" | "+
				""+node.data+" | "+
				""+(node.next == null ? " - " : node.next.data );
				System.out.println( message );
				node = node.next; 
			}
		}
}
