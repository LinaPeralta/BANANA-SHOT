package model;

import java.util.Comparator;

public class UserDate  implements Comparator<User> {

	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getDate().compareTo(o2.getDate());
	}

}
