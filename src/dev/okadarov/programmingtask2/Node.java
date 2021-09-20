package dev.okadarov.programmingtask2;

public class Node<E> {
	public E data;
	public Node<E> previous;
	public Node<E> next;
	public Node( E data ) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}
}
