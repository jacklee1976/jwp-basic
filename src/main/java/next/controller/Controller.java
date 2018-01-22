package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zack <zack@nhn.com>
 * @since 2018. 01. 22.
 */
public interface Controller {
	String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
