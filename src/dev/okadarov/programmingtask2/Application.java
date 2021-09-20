package dev.okadarov.programmingtask2;


public class Application {

	public static void main(String[] args) {

		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>( null );
		
		
		dll.push( 100 );
		dll.append(200);
		dll.append(300);
		dll.append(400);
		dll.append(500);
		
		dll.printNodes();
		
		System.out.println();
		
		
		
		

	}

}
