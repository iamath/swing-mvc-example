package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Database;

public class Model {
	
	private int id;
	
	private PreparedStatement ps;
	private Connection conn;
	private String sql;
	private ResultSet rs;
	
	public Model() {
		try {
			conn = Database.createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private ResultSet getPerson() throws SQLException {
		sql = "SELECT * FROM person WHERE id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, getId());
		rs = ps.executeQuery();
		rs.next();
		return rs;
	}
	
	public ArrayList<Integer> getIds() {
		sql = "SELECT id FROM person";
		try {
			rs = conn.prepareStatement(sql).executeQuery();
			
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while(rs.next()) {
				ids.add(rs.getInt("id"));
			}
			return ids;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		try {
			return getPerson().getString("firstname");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getLastName() {
		try {
			return getPerson().getString("lastname");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	private void setName(String whatName, String name) {
		sql = "UPDATE person SET " + whatName + "name = ? WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setFirstName(String firstName) {
		setName("first", firstName);
	}
	
	public void setLastName(String lastName) {
		setName("last", lastName);
	}
}
