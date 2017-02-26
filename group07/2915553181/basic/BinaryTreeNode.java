package com.coding.basic;


public class BinaryTreeNode {
	//比data大右边
	//比data小左边
	//一样大，加不进来
	private Comparable data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public Comparable getData() {
		return data;
	}
	public void setData(Comparable data) {
		this.data = data;
	}
	
	public BinaryTreeNode getLeft() {
		if(left == null){
			left = new BinaryTreeNode();
		}
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		if(right == null){
			right = new BinaryTreeNode();
		}
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public BinaryTreeNode insert(Comparable newData){
		if(data == null){
			data = newData;
			return this;
		}
		if(data.compare(newData) > 0){
			getRight().insert(newData);
		}
		if(data.compare(newData) < 0){
			getLeft().insert(newData);
		}
		if(data.compare(newData) == 0){
			return this;
		}
		return null;
	}
	
}
