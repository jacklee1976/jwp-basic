package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zack <zack@nhn.com>
 * @since 2018. 01. 22.
 */
public class ForwardController implements Controller {
	private String forworadUrl;

	public ForwardController(String forworadUrl) {
		this.forworadUrl = forworadUrl;

		if (forworadUrl == null) {
			throw new NullPointerException("forward url is null");
		}
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		return forworadUrl;
	}
}
