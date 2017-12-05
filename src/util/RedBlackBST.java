package util;

import util.BST.Node;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;
		public Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public Value get(Key key) {
		return get(root, key);
	}
	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.val;
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value val) {
		
	}
	
	public int size() {
		return size(root);
	}
	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	}
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left)+size(h.right)+1;
		return x;
	}
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left)+size(h.right)+1;
		return x;
	}
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	private boolean isRed(Node h) {
		if (h == null) return false;
		return h.color == RED;
	}
}
