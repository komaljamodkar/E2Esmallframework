package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<String> ls=new ArrayList<>();
		ls.add("abc");
		ls.add("aabc");
		ls.add("zabc");
		ls.add("rabc");
		ls.add("abc");
		ls.add("tabc");
		//convert list to stream
	for(int i=0;i<ls.size();i++) {
		if(ls.get(i).startsWith("a")) {
		System.out.println(ls.get(i));
		}
	}
	
	ArrayList<String> ls1=new ArrayList<>();
	ls1.add("abc");
	ls1.add("aabc");
	ls1.add("zabc");
	ls1.add("rabc");

	// using Stream() method 
	//convert list to stream method
	// .filter (param-> peration)
	//.filter(param->operation/action).count(); assign to some variable
	// /filter(param->action).forEach(param-> Sop(param));  //print all result in 1 line
	// directly create a list Stream.of("","")
	//limit the result .limit(1);
	long c=ls.stream().filter(s->s.startsWith("a")).count();
	System.out.println(c);
	
	long cd=ls.stream().filter(s->
	{s.startsWith("a");
	return true;
	}).count();
	
	System.out.println(cd);
	
	long d=Stream.of("xys","tyuii","xy","xxeusnss","rjje","ajnnz").filter(s->s.length()>=4).count();
	System.out.println(d);
	
	ls.stream().filter(s->s.length()>=4).limit(2).forEach(s->System.out.println(s.toUpperCase()));
	
	ls.stream().filter(s->s.endsWith("c")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//print upper with sorted map any string operation 
	//sotring by stream() and collection
	Collections.sort(ls);
	ls.stream().filter(s->s.endsWith("c")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//merge list
	Stream <String> mergeList=Stream.concat(ls.stream(),ls1.stream());
	mergeList.sorted().forEach(s->System.out.println(s));
	
	//check if present
	boolean flag=ls.stream().anyMatch(s->s.equalsIgnoreCase("abc"));
	System.out.println(flag);
	
	List<String> ls3=Stream.of("xys","tyuii","xy","xxeusnss","rjje","ajnnz").filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		ls3.get(0);
		
		Set<String> ls4=Stream.of("xysc","tyuiic","xyc","xyc","xxeusnss","rjje","ajnnz").filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).collect(Collectors.toSet());
		
		//print unique and sort array
		//get 3rd index
		List<Integer> ls5=Arrays.asList(2,5,4,3,3,2,5,6,1,1,4,8,9);
		List<Integer>ls6=ls5.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ls6.get(3));
		
		
		Integer arr[]={2,4,6,1,8,1,2,3,4,4,3,3,1,2};
		List<Integer> ls7=Arrays.asList(arr);
		
		ls7.stream().distinct().sorted().filter(s->s%2==1).forEach(s->System.out.println(s));
	}

}
