import junit.framework.TestCase;
import org.asdt.Customer;
import org.asdt.movie.Movie;
import org.asdt.Rental;
import org.asdt.movie.solid.ChildrensMovie;
import org.asdt.movie.solid.NewReleaseMovie;
import org.asdt.movie.solid.RegularMovie;

public class TestCustomer extends TestCase {
	
	Customer client;

	protected void setUp() throws Exception {
		client = new Customer("Joao");
	}
	
	public void testNameCreation(){
		String result = client.statement();
		assertContain(result,"Rental Record for Joao");
	}
	
	public void testOneRegularOneDay(){
		rentRegularMovie("Indiana Jones", 1);
		String result = client.statement();
		assertContain(result,"Amount owed is 2.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneRegularTreeDays(){
		rentRegularMovie("Indiana Jones", 3);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneChildrensOneDay(){
		rentChildrensMovie("Finding Nemo", 1);
		String result = client.statement();
		assertContain(result,"Amount owed is 1.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneChildrensFiveDays(){
		rentChildrensMovie("Finding Nemo",  5);
		String result = client.statement();
		assertContain(result,"Amount owed is 4.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneNewReleaseOneDay(){
		rentNewReleaseMovie("Spider Man - Far from Home",  1);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneNewReleaseTreeDays(){
		rentNewReleaseMovie("Spider Man - Far from Home", 3);
		String result = client.statement();
		assertContain(result,"Amount owed is 9.0");
		assertContain(result,"You earned 2 frequent renter points");
	}
	
	public void testManyRents(){
		rentNewReleaseMovie("Spider Man - Far from Home", 2);
		rentNewReleaseMovie("Dune", 3);
		rentChildrensMovie("Finding Nemo", 3);
		rentRegularMovie("Indiana Jones", 2);
		rentChildrensMovie("The Lion King", 4);
		rentRegularMovie("Matrix", 3);
		String result = client.statement();
		assertContain(result,"Amount owed is 25.0");
		assertContain(result,"You earned 8 frequent renter points");
	}
	
	private void rentRegularMovie(String title, int days) {
		Movie movie = new RegularMovie(title);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}

	private void rentChildrensMovie(String title, int days) {
		Movie movie = new ChildrensMovie(title);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}

	private void rentNewReleaseMovie(String title, int days) {
		Movie movie = new NewReleaseMovie(title);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}

	private void assertContain(String result, String content) {
		assertTrue(result.contains(content));
	}

}
