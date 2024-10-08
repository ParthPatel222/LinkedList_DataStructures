// Name: Parth Patel
// Class: CS 3305/Section #01
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment:  3
// IDE Name: <IntelliJ>
/*
This class define a linked list that stores integer values.
*/


public class LinkedList {
	public Node head, tail;

	//constructor method to create a list of object with head, tail, and size.
	public LinkedList() {
		head = null;
		tail = null;
	}

	//method add node to end of list
	public void addLastNode(int data) {
		if (tail == null)
			head = tail = new Node(data); //empty list
		else
		{
			tail.next = new Node(data); //link new node as last node
			tail = tail.next; //make tail pointer points to last node
		}
	}

	//======== Your part to complete for this assignment =========

	//method #1: add first node
	public void addFirstNode(int data) {
		if (tail == null){ // check if list is empty
			tail = head;
		}
		Node temp = new Node(data);//creates new node that will be head
		temp.next = head;//links new node
		head = temp;//head is now new node
	}

	//method #2: add node at index
	public void addAtIndex(int index, int data) {
		if (index == 0){
			addFirstNode(data); // adds data to head
		} else if (index >= countNodes()){
			addLastNode(data); // adds data to tail using countNodes() to find LinkedList size
		} else {
			Node current = head;
			Node temp = head.next;
			for (int i = 1; i < index; i++){ //iterates through list until index is found
				current = current.next;
				temp = temp.next;
			}
			temp = current.next;
			current.next = new Node(data); // creates new node
			current.next.next = temp;
		}
	}

	//method #3: remove first node
	public void removeFirstNode() {
		if (countNodes() == 0){
			System.out.println("\nList is Empty.");
		} else {
			Node temp = head;
			head = head.next; //sets next node as head
			if (head == null){ //removes old head
				tail = null;
			}
		}
	}


	//method #4: remove last node
	public void removeLastNode() {
		if (countNodes() == 0) {
			System.out.println("\nList is Empty.");
		} else if (countNodes() == 1) {
			head = tail = null;
		} else {
			Node curr = head;
			for (int i = 0;i < countNodes() - 2; i++){ //runs until second to last index is hit
				curr = curr.next;
			}
			tail = curr; //makes second to last index tail
			tail.next = null; //deletes old tail
		}
	}

	//method #5: remove node at index
	public void removeAtIndex(int index) {
		if (countNodes() == 0) {
			System.out.println("\nList is Empty.");
		} else if (index == 0){
			removeFirstNode(); // deletes data at head
		} else if (index >= countNodes()){
			removeLastNode(); // deletes data at tail using countNodes() to find LinkedList size
		} else {
			Node prev = head;
			for (int i = 1; i < index; i++){ //iterates until index and sets prev to next link
				prev = prev.next;
			}
			Node curr = prev.next; //current is now prev next
			prev.next = curr.next; //updates the link
		}
	}

	//method #6: countNodes
	public int countNodes() {
		int listSize= 0;
		Node current = head;
		while (current != null){ //will stop counting when last node is null
			listSize++; //increase listSize until the end of the list
			current = current.next;
		}
		//complete this method
		return listSize; //this methods returns the list size
	}

	//method #7: printInReverse  (Recursive method)
	public void printInReverse(Node L) {
		if (L == null) { //Base case
			return;
		}
		printInReverse(L.next); //recursively calls method until last node is reached
		System.out.print(L.data + "   "); //prints data
	}


	//================= end of your part ==============

	//method to print out the list
	public void printList() {
		Node temp;
		temp = head;
		while (temp != null) {
			System.out.print(temp.data + "   ");
			temp = temp.next;
		}
	}

	//class to create nodes as objects
	private class Node
	{
		private int data;  //data field
		private Node next; //link field

		public Node(int item) //constructor method
		{
			data = item;
			next = null;
		}
	}
}

