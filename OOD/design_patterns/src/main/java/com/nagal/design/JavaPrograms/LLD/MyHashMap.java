package com.nagal.design.JavaPrograms.LLD;

import lombok.Getter;
import lombok.Setter;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
//

class HashNode{
	int key,value;
	HashNode next;

	public HashNode(int key, int value) {
		this.key = key;
		this.value = value;
	}

}

class MyHashMap {

	/** Initialize your data structure here. */
	private int mod=22121;
	HashNode [] mapArray= new HashNode[mod];

	public MyHashMap() {
	}

	private int hash(int key){
		return key%mod;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		if(mapArray[hash(key)]==null){
			mapArray[hash(key)]=new HashNode(key,value);
			return;
		}
		HashNode node=mapArray[hash(key)];

		while(node.next!=null){
			if(node.key==key) {
				node.value = value;
				return;
			}
			node=node.next;
		}
		if(node.key==key) {
			node.value = value;
			return;
		}
		node.next=new HashNode(key,value);
		return;
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		if(mapArray[hash(key)]==null){
			return -1;
		}
		HashNode node=mapArray[hash(key)];
		while(node!=null){
			if(node.key==key) {
				return node.value;
			}
			node=node.next;
		}
		return -1;
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		if(mapArray[hash(key)]==null){
			return;
		}
		HashNode prev=mapArray[hash(key)];
		HashNode curr=prev.next;

		if(prev.key==key){
			mapArray[hash(key)]=prev.next;
			return;
		}

		while(prev!=null) {
			curr = prev.next;
			if (curr!=null && curr.key == key) {
				prev.next = curr.next;
				return;
			}
			prev = prev.next;
		}
		return;
	}

}
