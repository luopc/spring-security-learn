package com.luopc.web.model;

import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

/**
 * 把一行数据转换到HasMap中
 * 
 * @author chenl
 *
 */

public class HasMapMapper implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {
		return ResultSetToList(rs);
	}

	/**
	 * 把一行数据转换到HasMap中
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private HashMap<String, Object> ResultSetToList(ResultSet rs) throws SQLException {
		HashMap<String, Object> row = new HashMap<String, Object>();
		ResultSetMetaData rsm = rs.getMetaData();
		int size = rsm.getColumnCount();
		for (int j = 1; j <= size; j++) {
			String field = rsm.getColumnName(j);
			String fieldType = rsm.getColumnTypeName(j);
			// 文本字段
			if ("CLOB".equals(fieldType)) {
				Clob clob = rs.getClob(j);
				if (clob != null) {
					String value = clob.getSubString((long) 1, (int) clob.length());
					row.put(field, value);
				} else {
					row.put(field, "");
				}
				// 二进制字段不读取
			} else if ("BLOB".equals(fieldType)) {
				row.put(field, "");
			} else {
				Object value = rs.getObject(j);
				if (value != null) {
					// 日期需要转换
					if ("DATE".equals(fieldType)) {
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						try {
							String strDate = df.format(rs.getTimestamp(j));
							row.put(field, strDate);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						row.put(field, value.toString());
					}
				} else {
					row.put(field, "");
				}

			}
		}
		return row;
	}

}
