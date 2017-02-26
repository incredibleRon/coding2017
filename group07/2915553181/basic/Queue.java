package com.coding.basic;

public class Queue {
	private LinkedList link = new LinkedList();
	
	//进队列
	public void enQueue(Object o){
		link.add(o);
	}
	//出队列
	public Object deQueue(){
		return link.removeFirst();
	}
	//空
	public boolean isEmpty(){
		return link.size() == 0 ? true : false;
	}
	//大小
	public int size(){
		return link.size();
	}
}
