package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Welcome!"));
    }

    public static Result signUp() {

        User user = Form.form(User.class).bindFromRequest().get();

        // TODO: save user
        if (user.getLogin() == null) {
            return ok(signUp.render("Welcome to sign up form"));
        } else {
        	System.out.println(user.getLogin() + " : " + user.getPassword());
        }
        return redirect("/home/" + user.getLogin());
    }

    public static Result signIn() {
        User user = Form.form(User.class).bindFromRequest().get();
        if (!user.getLogin().contentEquals(user.getPassword())) {
            return unauthorized(index.render("Incorrect user credentials!"));
        }
        return ok();
    }

    public static Result home(String user) {

    	return ok(home.render(user));
    }
}
