package br.ufrgs.inf.tlbellini.queries;

public class Main {
	
	static DBInteraction db = new DBInteraction();

	public static void main(String[] args) {
		 db.connectDB();
		 System.out.println(db.status);

	}

}
