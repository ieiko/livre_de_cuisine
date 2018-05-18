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

public class DAORecetteJDBC implements DAORecette {

	private Connection connect() throws SQLException {
		Properties pt = new Properties();
		pt.setProperty("user", "root");
		pt.setProperty("password", "ajcformation");
		pt.setProperty("useSSL", "false");
		pt.setProperty("autoReconnect", "true");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/recettes?serverTimezone=UTC", pt);
	}
	
	public Recette selectById(Integer id) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();

		Recette recette = null;
		PreparedStatement ps=conn.prepareStatement("select * from recettes where id_recette=?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			recette = new Recette(rs.getInt("id_recette"), rs.getString("name"), rs.getString("resume"), Type.valueOf(rs.getString("type")));
		}
		conn.close();
		return recette;
	}

	
	public ArrayList<Recette> selectAll() throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		ArrayList<Recette> recettes = new ArrayList<Recette>();
		PreparedStatement ps= conn.prepareStatement("select * from recettes");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			recettes.add(new Recette(rs.getInt("id_recette"), rs.getString("name"), rs.getString("resume"), Type.valueOf(rs.getString("type"))));
		}
		
		conn.close();
		return recettes;
	}

	
	public void insert(Recette obj) throws ClassNotFoundException, SQLException {
		Connection conn = this.connect();
		
		PreparedStatement ps = conn.prepareStatement("insert into recettes (name, resume, type) values (?, ?, ?)");
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getResume());
		ps.setString(3, obj.getType().getLibelle());
		
		ps.executeUpdate();
		
		conn.close();
	}

	
	public void update(Recette obj) throws ClassNotFoundException, SQLException {
		Connection conn = this.connect();
		
		PreparedStatement ps = conn.prepareStatement("update recettes set name = ?, resume = ?, type = ? where id_recette = ?");
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getResume());
		ps.setString(3, obj.getType().getLibelle());
		ps.setInt(4, obj.getId());
		
		ps.executeUpdate();
		conn.close();
	}

	
	public void delete(Recette obj) throws ClassNotFoundException, SQLException {
		Connection conn = this.connect();
		
		PreparedStatement ps = conn.prepareStatement("delete from recettes where id_recette = ?");
		ps.setInt(1, obj.getId());
		
		ps.executeUpdate();
		conn.close();
	}

	@Override
	public ArrayList<Recette> getRecetteByType(Type type) throws SQLException {
		Connection conn = this.connect();
		
		ArrayList<Recette> recettes = new ArrayList<Recette>();
		PreparedStatement ps=conn.prepareStatement("select * from recettes where type=?");
		ps.setString(1, type.getLibelle());
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			recettes.add(new Recette(rs.getInt("id_recette"), rs.getString("name"), rs.getString("resume"), Type.valueOf(rs.getString("type"))));
		}
		conn.close();
		return recettes;
	}

}
