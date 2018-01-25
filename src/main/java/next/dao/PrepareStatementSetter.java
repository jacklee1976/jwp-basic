package next.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zack <zack@nhn.com>
 * @since 2018. 01. 24.
 */
public interface PrepareStatementSetter {
	public void setValues(PreparedStatement pstmt) throws SQLException;
}
