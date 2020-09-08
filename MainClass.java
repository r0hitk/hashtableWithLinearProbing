package linearProbingHT;

public class MainClass {

	public static void main(String[] args) {
		
		Person one = new Person(26, "Rohan", "Patna");
		Person two = new Person(21, "Abhijeet", "Kolkata");
		Person three = new Person(22, "Ankita", "Bangalore");
		Person four = new Person(24, "Richa", "Ranchi");

		Hashtable ht = new Hashtable(10);
		
		ht.put("Rohan", one);
		ht.put("Abhijeet", two);
		ht.put("Ankita", three);
		ht.put("Richa", four);
		

		ht.printHashTable();
		
		System.out.println();
		//System.out.println(ht.get("Richa").getName());
		//System.out.println(ht.get("Ankita").getName());
		
		System.out.println("Removed : " + ht.remove("Ankita").getName());
		System.out.println();
		ht.printHashTable();
		System.out.println();
		System.out.println(ht.get("Richa").getName());
		System.out.println();
		ht.printHashTable();
		
		
	}

}
