package com.coding.basic;

import javax.xml.crypto.Data;

public class ArrayList implements List {
	
	private int size = 0;
	
	private Object[] elementData = null;
	
	/**
	 * Creates a new instance of ArrayList.
	 *
	 */
	//默认32位空数组
	public ArrayList() {
		elementData = new Object[32];
	}
	//默认扩容为原数组的2倍
	public ArrayList(Object[] data){
		elementData = new Object[data.length*2];
		size = data.length;
	}
	
	//下标是否越界
	private boolean isOutOfBounds(int index){
		return elementData.length - (index + 1) > 0 ? true : false;
	}
	
	//自动扩容,扩成原来两倍
	private void becomeLarger(){
		Object[] temp = new Object[elementData.length*2];
		System.arraycopy(elementData, 0, temp, 0, size);
		elementData = temp;
	}
	
	
	public void add(Object o){
		//是否越界
		if(isOutOfBounds(size)){
			//越界--->扩容
			becomeLarger();
			add(o);
		}else{
			//不越界--->直接加
			elementData[size] = o;
			size = size + 1;
		}
	}
	
	public void set(int index, Object o){
		//是否越界
		if(isOutOfBounds(index)){
			//越界--->报错
			throw new RuntimeException("数组越界");
		}else{
			//不越界--->直接加
			elementData[index] = o;
		}
	}
	
	public Object get(int index){
		if(isOutOfBounds(index)){
			throw new RuntimeException("数组越界");
		}
		return elementData[index];
	}
	
	public Object remove(int index){
		if(isOutOfBounds(index)){
			throw new RuntimeException("数组越界");
		}
		Object temp = elementData[index];
		
		//后面的元素向前移
		Object[] newE =  new Object[elementData.length];
		System.arraycopy(elementData, 0, newE, 0, index - 1);
		System.arraycopy(elementData, index + 1 , newE, index, elementData.length - index - 1);
		
		elementData = newE;
		size = size - 1;
		return temp;
	}
	
	public int size(){
		return  size;
	}
	
	public Iterator iterator(){
		return null;
	}
	
}
