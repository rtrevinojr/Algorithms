package socialnetwork;

import java.util.ArrayList;

public class Person {
	
	private ArrayList <Integer> friends;
	private int personId;
	private String info;
	
	public Person (int id) {
		personId = id;
		info = "";
		friends = new ArrayList <>();
	}

	public String getInfo () {
		return info;
	}
	public int getId () {
		return personId;
	}
	public ArrayList <Integer> getFriends() {
		return friends;
	}
	public void addFriend (int id) {
		friends.add(id);
	}
	
}
