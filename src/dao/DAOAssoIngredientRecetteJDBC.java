package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import metier.AssoIngredientRecette;
import metier.Ingredient;

public class DAOAssoIngredientRecetteJDBC implements DAOAssoIngredientRecette {
	
	private Connection connec() throws SQLException {
		
		Properties pt = new Properties();
		pt.setProperty("user", "root");
		pt.setProperty("password", "");
		pt.setProperty("useSSL", "false");
		pt.setProperty("autoReconnect", "true");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/recettes?serverTimezone=UTC", pt);
	}


	public AssoIngredientRecette selectById(Integer id) throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("select * from asso_ingredients_recette where id_asso_ingredients_recettes = ?");
		ps.setInt(1, id);
		AssoIngredientRecette assoIngredientRecette = null;
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			assoIngredientRecette = new AssoIngredientRecette(rs.getInt("id_asso_ingredients_recettes"), rs.getInt("id_ingredient"), 
					rs.getInt("id_recette"), rs.getInt("quantite"));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return assoIngredientRecette;
	}


	public List<AssoIngredientRecette> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connec();
		
		PreparedStatement ps = conn.prepareStatement("select * from asso_ingredients_recette");
		ArrayList <AssoIngredientRecette> listeAssoIngredientRecette = new ArrayList <AssoIngredientRecette>();
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			listeAssoIngredientRecette.add(new AssoIngredientRecette (rs.getInt("id_asso_ingredients_recettes"), rs.getInt("id_ingredient"), 
					rs.getInt("id_recette"), rs.getInt("quantite")));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return listeAssoIngredientRecette;
	}

	
	public void insert(AssoIngredientRecette obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("insert into asso_ingredients_recette (id_ingredient, id_recette, quantite) values (?, ?, ?)");
		ps.setInt(1, obj.getIdIngredient());
		ps.setInt(2, obj.getIdRecette());
		ps.setInt(3, obj.getQuantite());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	
	public void update(AssoIngredientRecette obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("update asso_ingredients_recette set id_ingredient = ?, id_recette = ?,"
				+ " quantite = ? where id_asso_ingredients_recettes = ?)");
		ps.setInt(1, obj.getIdIngredient());
		ps.setInt(2, obj.getIdRecette());
		ps.setInt(3, obj.getQuantite());
		ps.setInt(4, obj.getId());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	
	public void delete(AssoIngredientRecette obj) throws ClassNotFoundException, SQLException {
		
		Connection conn = this.connec();

		PreparedStatement ps = conn.prepareStatement("delete * from asso_ingredients_recette where id_asso_ingredients_recettes = ?");
		ps.setInt(1, obj.getId());
		ResultSet rs = ps.executeQuery();
		
		ps.close();
		rs.close();
		conn.close();
	}

	
	public ArrayList<AssoIngredientRecette> selectByIngredientRecette(int idRecette) throws SQLException {
		
		Connection conn = this.connec();
		
		PreparedStatement ps = conn.prepareStatement("select * from asso_ingredients_recette where id_recette = ?");
		ps.setInt(1, idRecette);
		ArrayList <AssoIngredientRecette> listeAssoIngredientRecette = new ArrayList <AssoIngredientRecette>();
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			listeAssoIngredientRecette.add(new AssoIngredientRecette (rs.getInt("id_asso_ingredients_recettes"), rs.getInt("id_ingredient"), 
					rs.getInt("id_recette"), rs.getInt("quantite")));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return listeAssoIngredientRecette;
	}

}
