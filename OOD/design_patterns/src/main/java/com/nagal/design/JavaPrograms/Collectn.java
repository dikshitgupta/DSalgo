package com.nagal.design.JavaPrograms;

import java.util.*;

public class Collectn {

	public static int[] TwoSum(int [] nums,int target){
		HashMap<Integer,Integer> parsed=new HashMap<>();
		int[] ans=new int[2];
		for(int i=0;i<nums.length;i++){

			if(parsed.containsKey(target-nums[i])){
				ans[0]= parsed.get(target-nums[i]).intValue();
				ans[1]=i;
			}
			else parsed.put(nums[i],i);
			System.out.println(parsed.containsKey(target-nums[i]));
			parsed.put(nums[i],i);

		}
		return ans;
	}

	public void printarr(int [] nums){
		for(int num:nums){
			System.out.printf("%d ",num);
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {

			if (strs == null || strs.length == 0) return new ArrayList<>();
			Map<String, List<String>> map = new HashMap<>();
			for (String s : strs) {
				char[] ca = s.toCharArray();
				Arrays.sort(ca);
				String keyStr = String.valueOf(ca);  // Returns the string representation of character array.
				System.out.println(keyStr);
				if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
				map.get(keyStr).add(s);
			}
			System.out.println(map.keySet());  // take all the values of hashmap and converts it to an array
			return new ArrayList<>(map.values());
	}


	public static void main(String[] args) {
		String [] nums=new String[]{"eat","tea","tan","ate","nat","bat"};
		Collectn cn=new Collectn();
		System.out.println(cn.groupAnagrams(nums));

		}
}
