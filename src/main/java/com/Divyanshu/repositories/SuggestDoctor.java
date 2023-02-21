package com.Divyanshu.repositories;

import java.util.HashMap;
import java.util.Map;

public class SuggestDoctor 
{
	public static Map<String,String> mlist=new HashMap<>();
	static{
		mlist.put("Arthritis", "Orthopedic");
		mlist.put("Backpain", "Orthopedic");
		mlist.put("Tissue injuries", "Orthopedic");
		mlist.put("Dysmenorrhea", "Gynecology");
		mlist.put("Skin infection", "Dermatology");
		mlist.put("Skin burn", "Dermatology");
		mlist.put("Ear pain", "ENT");
	}
}
