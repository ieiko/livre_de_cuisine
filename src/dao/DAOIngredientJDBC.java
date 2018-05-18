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

public class DAOIngredientJDBC implements DAOIngredient {

	private Connection connec() throws SQLException {
		
		Properties pt = new Properties();
		pt.setProperty("user", "root");
		pt.setProperty("password", "ajcformation");
		pt.setProperty("useSSL", "false");
		pt.setProperty("autoReconnect", "true");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/recettes?serverTimezone=UTC", pt);
	}
	
	
	public Ingredient selectById(Integer id) throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("select * from ingredients where id_ingredients = ?");
		ps.setInt(1, id);
		Ingredient ingredient = null;
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ingredient = new Ingredient(rs.getInt("id_ingredients"), rs.getString("name"), rs.getString("image_path"));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return ingredient;
	}

	
	public List<Ingredient> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connec();
		
		PreparedStatement ps = conn.prepareStatement("select * from ingredients");
		ArrayList <Ingredient> listeIngredient = new ArrayList <Ingredient>();
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			listeIngredient.add(new Ingredient (rs.getInt("id_ingredients"), rs.getString("name"), rs.getString("image_path")));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return listeIngredient;
	}

	
	public void insert(Ingredient obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("insert into ingredients (name, image_path) values (?, ?)");
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getImage());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}


	public void update(Ingredient obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("update ingredients set name = ?, image_path = ? where id_ingredients = ?)");
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getImage());
		ps.setInt(3, obj.getId());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}

	
	public void delete(Ingredient obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("delete * from ingredients where id_ingredients = ?");
		ps.setInt(1, obj.getId());
		ResultSet rs = ps.executeQuery();
		
		ps.close();
		rs.close();
		conn.close();
		
	}

}
