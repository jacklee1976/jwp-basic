package next.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zack <zack@nhn.com>
 * @since 2018. 01. 07.
 */
public class RequestMapping {
	private static Map<String, Controller> mappings = new HashMap<String, Controller>();

	void initMapping(){
		mappings.put("/", new HomeController());
		mappings.put("/users/form", new ForwardController("/user/form.jsp"));
		mappings.put("/users/loginForm", new ForwardController("/user/login.jsp"));
		mappings.put("/users/create", new CreateUserController());
		mappings.put("/users", new ListUserController());
		mappings.put("/users/login", new LoginController());
	}

	public Controller findController(String requestUrl) {
		return mappings.get(requestUrl);
	}

	void putController(String url, Controller controller) {
		mappings.put(url, controller);
	}
}
