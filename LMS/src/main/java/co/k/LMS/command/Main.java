package co.k.LMS.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "main/home";
	}

}
