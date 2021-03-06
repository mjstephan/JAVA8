package java8.ocp.sg2.chapter2;

//Lazy instantiation
public class VisitorTicketTracker {
	private static VisitorTicketTracker instance;

	private VisitorTicketTracker() {
	}

	public static VisitorTicketTracker getInstance() {
		if (instance == null) {
			instance = new VisitorTicketTracker(); // NOT THREAD-SAFE! make
													// method synchronized which
													// means only one thread
													// will be
			// allowed in the method at a time, ensuring that only one object is
			// created
		}
		return instance;
	}
	// Data access methods
	// ...
}
