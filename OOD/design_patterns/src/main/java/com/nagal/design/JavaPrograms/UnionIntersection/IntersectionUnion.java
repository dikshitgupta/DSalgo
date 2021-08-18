package com.nagal.design.JavaPrograms.UnionIntersection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionUnion {

	public static List union(int [] a,int [] b){
		Set<Integer> set=new HashSet<>();

//		for(int i=0;i<a.length;i++)

		for(int num:a){
			set.add(num);
		}
		for(int num:b){
			set.add(num);
		}
		ArrayList<Integer> union=new ArrayList<>();

		for(int element: set){
			union.add(element);
		}
		System.out.println(union);
		return union;
	}

	public static List intersect(int [] a,int [] b){
		Set<Integer> set=new HashSet<>();
//		for(int i=0;i<a.length;i++)
		for(int num:a){
			set.add(num);
		}
		for(int num:b){
			set.add(num);
		}
		List<Integer> intersect=new ArrayList<>();

		for(int element: set){
			intersect.add(element);
		}
//		System.out.println(intersect);
//		int ans[]= intersect.toArray(new int[intersect.size()]);
		return intersect;

	}


	public static void main(String[] args) {
//		int[] a=new int[]{1,2,3,4,8};
//		int[] b=new int[]{8,9,2,77,8,1};
//		IntersectionUnion.intersect(a,b);


		List<Integer> list=new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(111);
//		String names[]=list.toArray(new String[list.size()]);
//		int dsf[]=new int[list.size()];
//		list.toArray(dsf);
//		System.out.println(dsf);

	}
}
