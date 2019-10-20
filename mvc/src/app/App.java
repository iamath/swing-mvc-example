package app;

import controllers.Controller;
import models.Model;
import views.View;

public class App {

	public static void main(String[] args) {
		Model m = new Model();
		View v = new View("MVC App");
		Controller c = new Controller(m, v);
		
		c.initController();		
	}

}
