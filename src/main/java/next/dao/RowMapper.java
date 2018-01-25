package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zack <zack@nhn.com>
 * @since 2018. 01. 24.
 */
@FunctionalInterface
public interface RowMapper<T> {
	T mapRow(ResultSet rs) throws SQLException;
}
