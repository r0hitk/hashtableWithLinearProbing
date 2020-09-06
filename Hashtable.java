package linearProbingHT;

public class Hashtable {

	private Person hashtable[];

	public void put(String key, Person value) {

		int hashedKey = hashKey(key);

		if (occupied(hashedKey)) {

			int stopIndex = hashedKey;
			
			if(hashedKey == hashtable.length - 1)
				hashedKey = 0;
			else
				hashedKey++;
			
			while (occupied(hashedKey) && (hashedKey != stopIndex)) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		}
		if(occupied(hashedKey)) {
			System.out.println("Unable to add : " + value.getName());
		}
		else
			hashtable[hashedKey] = value;
	}

	private boolean occupied(int hashedKey) {

		return hashtable[hashedKey] != null;
	}

	private int hashKey(String key) {
		return key.length() % 7;
	}

}
