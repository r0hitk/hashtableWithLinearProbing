package linearProbingHT;

public class Hashtable {

	private HashedObject hashtable[];

	public Hashtable(int size) {
		this.hashtable = new HashedObject[size];
	}

	public void put(String key, Person value) {

		int hashedKey = hashKey(key);

		if (occupied(hashedKey)) {

			int stopIndex = hashedKey;

			if (hashedKey == hashtable.length - 1)
				hashedKey = 0;
			else
				hashedKey++;

			while (occupied(hashedKey) && (hashedKey != stopIndex)) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		}
		if (occupied(hashedKey)) {
			System.out.println("Unable to add : " + value.getName());
		} else
			hashtable[hashedKey] = new HashedObject(key, value);
	}

	private boolean occupied(int hashedKey) {

		return hashtable[hashedKey] != null;
	}

	public Person get(String key) {
		int hashedKey = findKey(key);

		if (hashedKey == -1) {
			return null;
		} else
			return hashtable[hashedKey].person;
	}

	private int findKey(String key) {

		int hashedKey = hashKey(key);

		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		int stopIndex = hashedKey;

		if (hashedKey == hashtable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}

		while (hashtable[hashedKey] != null && !(hashtable[hashedKey].key.equals(key)) && stopIndex != hashedKey) {

			hashedKey = (hashedKey + 1) % hashtable.length;
		}

		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else
			return -1;

	}

	public Person remove(String key) {

		int hashedKey = findKey(key);

		if (hashedKey == -1)
			return null;

		Person temp = hashtable[hashedKey].person;
		hashtable[hashedKey] = null;

		
		//Rehashing since marking the deleted items will increase load factor and 
		//we'll need to change the put and get method as well.
		HashedObject[] oldTable = hashtable;
		hashtable = new HashedObject[oldTable.length];

		for (int i = 0; i < oldTable.length; i++) {
			if(oldTable[i] != null) {
				put(oldTable[i].key, oldTable[i].person);
			}
		}
		return temp;
	}

	private int hashKey(String key) {
		return key.length() % 7;
	}

	public void printHashTable() {

		for (HashedObject i : hashtable) {
			if (i == null) {

				System.out.println("empty");

			} else
				System.out.println(i.person.getName());
		}

	}

}
