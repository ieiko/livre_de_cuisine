package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import metier.*;

public class DAOEtapeJDBC implements DAOEtape {
	
	private Connection connec() throws SQLException {
		
		Properties pt = new Properties();
		pt.setProperty("user", "root");
		pt.setProperty("password", "ajcformation");
		pt.setProperty("useSSL", "false");
		pt.setProperty("autoReconnect", "true");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/recettes?serverTimezone=UTC", pt);
	}

	public Etape selectById(Integer id) throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("select * from etapes where etapes_id = ?");
		ps.setInt(1, id);
		Etape etape = null;
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			etape = new Etape(rs.getInt("etapes_id"), rs.getString("name"), rs.getString("body"), rs.getInt("duration"));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return etape;
	}

	
	public List<Etape> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connec();
		
		PreparedStatement ps = conn.prepareStatement("select * from etapes");
		ArrayList <Etape> listeEtape = new ArrayList <Etape>();
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			listeEtape.add(new Etape (rs.getInt("etapes_id"), rs.getString("name"), rs.getString("body"), rs.getInt("duration")));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return listeEtape;
	}


	public void insert(Etape obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("insert into etapes (name, body, duration) values (?, ?, ?)");
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getBody());
		ps.setInt(3, obj.getDuration());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	
	public void update(Etape obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("update etapes set name = ?, body = ?, duration = ? where etapes_id = ?)");
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getBody());
		ps.setInt(3, obj.getDuration());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}

	
	public void delete(Etape obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("delete * from etapes where etapes_id = ?");
		ps.setInt(1, obj.getId());
		ResultSet rs = ps.executeQuery();
		
		ps.close();
		rs.close();
		conn.close();
		
	}

}
