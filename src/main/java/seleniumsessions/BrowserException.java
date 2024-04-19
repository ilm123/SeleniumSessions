package seleniumsessions;

public class BrowserException extends RuntimeException {

	public BrowserException(String msg) { //constructor
		super(msg); // supply the same message to RuntimeException class. RuntimeException has the
					// logic to handle the exception
	}

}
