package com.coding.basic;

public class LinkedList implements List {
	
	private Node head;
	
	//node的个数，linkedlist的下标
	public int size = 0;
	
	//越界检测
	private void checkBounds(int index){
		if(index > size - 1){
			throw new RuntimeException("越界");
		}
	}
	
	
	//移动游标，到指定节点
	private Node moveCursor(int index){
		checkBounds(index);
		Node temp = head;
		for(int i = 0 ; i < index ; i++){
			temp = temp.next;
		}
		return temp;
	}
	
	public void add(Object o){
		if(null == head){
			head.data = o;
		}else{
			moveCursor(size-1).next = new Node(o);
		}
		size = size + 1;
	}
	
	public Object get(int index){
		return moveCursor(index).data;
	}
	
	public Object remove(int index){
		checkBounds(index);
		Object temp = null;
		if(index == 0){
			//头节点
			temp = head.data;
			head = head.next;
		}else if(index == size - 1){
			//尾节点
			Node n = moveCursor(index - 1);
			temp = n.next.data;
			n.next = null;
		}else{
			Node beforeN = moveCursor(index - 1);
			Node moveN = beforeN.next;
			Node afterN = moveN.next;
			temp = moveN.data;
			beforeN.next = afterN;
		}
		size = size - 1;
		return temp;
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(Object o){
		Node node = new Node(o);
		node.next = head;
		head = node;
	}
	public void addLast(Object o){
		add(o);
	}
	public Object removeFirst(){
		return 	remove(0);
	}
	public Object removeLast(){
		return remove(size - 1);
	}
	public Iterator iterator(){
		return null;
	}
	public void set(int index, Object o) {
		checkBounds(index);
		moveCursor(index).data = o;
	}
	
	
	
	private static  class Node{
		Object data;
		Node next;
		
		public  Node(Object data){
			this.data = data;
		}
	}

}
