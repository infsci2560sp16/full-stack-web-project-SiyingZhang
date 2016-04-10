package task1;

/*
 * @author siying
 * Logic tier: Task 1 - Server Rendered Function
 * Delete substring in one string and return the count of substring
 * 
 */

public class DeleteStringSolution {

	//Constructer
	public DeleteStringSolution() {

	}
	
	public int deleteSubstring(String s, String t) {
		
		//The target string has no length
		if(t.length() == 0) {
			return 0;
		}

		int count = 0;
		int preIndex = 0;

		while(s.length()>=t.length()) {
			int index = s.indexOf(t, preIndex-t.length());

			//no substring any more
			if(index == -1) {
				break;
			} else {
				//remove this substring
				s = s.substring(0, index) + s.substring(index+t.length());
				count ++;
				preIndex = index;
			}
		}

		return count;
	}
}