package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import core.jdbc.DataAccessException;
import next.model.User;

/**
 * @author zack <zack@nhn.com>
 * @since 2018. 01. 24.
 */
public class JdbcTemplate {
	public void update(String sql, Object... parameter) throws DataAccessException {
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);
		) {

			for(int i=0; i < parameter.length; i++) {
				pstmt.setObject(i+1, parameter[i]);
			}

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter) throws DataAccessException {
		ResultSet rs = null;
		List<T> result = null;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			for(int i=0; i < parameter.length; i++) {
				pstmt.setObject(i+1, parameter[i]);
			}

			rs = pstmt.executeQuery();

			result = new ArrayList<T>();
			while (rs.next()) {
				result.add(rowMapper.mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... parameter) throws DataAccessException {
		List<T> result = query(sql, rowMapper, parameter);

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}

}
