package model;

import java.util.Comparator;

public class UserScore  implements Comparator<User> {

	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getScore().compareTo(o2.getScore());
	}

}
