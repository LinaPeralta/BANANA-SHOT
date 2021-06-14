package model;

import java.util.Comparator;

public class UserTime  implements Comparator<User> {

	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getTime().compareTo(o2.getTime());
	}

}
