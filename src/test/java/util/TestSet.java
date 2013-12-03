package test.java.util;

import java.util.TreeSet;

import org.junit.Test;

public class TestSet {

	
	public static void main(String args[]){
		TreeSet<String> aSet = new TreeSet<String>();
		aSet.add("HA");
		aSet.add("GA");
		aSet.add("JI");
		aSet.add("KI");
		aSet.add("KI");
		aSet.add("KI");
		aSet.add("HE");
		aSet.add("GE");
		System.out.println("aSet="+aSet);
		System.out.println("aSet.headSet(K)="+aSet.headSet("K"));
		System.out.println("aSet.subSet(HA, HE)="+aSet.subSet("HA",false, "HE",true));
		System.out.println("aSet.tailSet(J)="+aSet.tailSet("J"));
		System.out.println("aSet.tailSet(J, true)="+aSet.tailSet("J", true));
		System.out.println("aSet.tailSet(J, false)="+aSet.tailSet("J", false));
	}
}
