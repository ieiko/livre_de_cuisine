package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import metier.AssoEtapeRecette;
import metier.AssoIngredientRecette;
import metier.Recette;
import metier.Type;

public class DAOAssoEtapeRecetteJDBC implements DAOAssoEtapeRecette {
	
	private Connection connect() throws SQLException {
		Properties pt = new Properties();
		pt.setProperty("user", "root");
		pt.setProperty("password", "");
		pt.setProperty("useSSL", "false");
		pt.setProperty("autoReconnect", "true");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/recettes?serverTimezone=UTC", pt);
	}
	
	
	public AssoEtapeRecette selectById(Integer id) throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connect();
		AssoEtapeRecette asso = null;
		
		PreparedStatement ps=conn.prepareStatement("select * from asso_etapes_recettes where id_asso_etapes_recettes = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			asso = new AssoEtapeRecette(rs.getInt("id_asso_etapes_recettes"), rs.getInt("id_etape"), rs.getInt("id_recette"));
		}
		
		return asso;
	}


	public List<AssoEtapeRecette> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection conn = this.connect();
		
		ArrayList<AssoEtapeRecette> listeAssoEtapeRecettes = new ArrayList<AssoEtapeRecette>();
		PreparedStatement ps= conn.prepareStatement("select * from asso_etapes_recettes");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listeAssoEtapeRecettes.add(new AssoEtapeRecette(rs.getInt("id_asso_etapes_recettes"), rs.getInt("id_etape"), rs.getInt("id_recette")));
		}
		
		conn.close();
		return listeAssoEtapeRecettes;
	}

	
	public void insert(AssoEtapeRecette obj) throws ClassNotFoundException, SQLException {

		Connection conn = this.connect();

		PreparedStatement ps = conn.prepareStatement("insert into asso_etapes_recettes (id_asso_etapes_recettes, id_etape, id_recette) values (?, ?, ?)");
		ps.setInt(1, obj.getId());
		ps.setInt(3, obj.getIdEtape());
		ps.setInt(2, obj.getIdRecette());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	
	public void update(AssoEtapeRecette obj) throws ClassNotFoundException, SQLException {

		Connection conn = this.connect();

		PreparedStatement ps = conn.prepareStatement("update into asso_etapes_recettes set id_etape = ?, id_recette = ?,"
				+ " where id_asso_etapes_recettes = ?)");
		ps.setInt(1, obj.getIdEtape());
		ps.setInt(2, obj.getIdRecette());
		ps.setInt(3, obj.getId());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	
	public void delete(AssoEtapeRecette obj) throws ClassNotFoundException, SQLException {
	
		Connection conn = this.connect();

		PreparedStatement ps = conn.prepareStatement("delete * from asso_etapes_recettes where id_asso_etapes_recettes = ?");
		ps.setInt(1, obj.getId());
		ResultSet rs = ps.executeQuery();
		
		ps.close();
		rs.close();
		conn.close();
	}


	public ArrayList<AssoEtapeRecette> selectByRecette(int idRecette) throws SQLException {
		
		Connection conn = this.connect();
		
		PreparedStatement ps = conn.prepareStatement("select * from asso_ingredients_recette where id_recette = ?");
		ps.setInt(1, idRecette);
		ArrayList <AssoEtapeRecette> listeAssoEtapeRecette = new ArrayList <AssoEtapeRecette>();
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			listeAssoEtapeRecette.add(new AssoEtapeRecette (rs.getInt("id_asso_etapes_recettes"), rs.getInt("id_etape"), 
					rs.getInt("id_recette")));
		}
		
		ps.close();
		rs.close();
		conn.close();
		return listeAssoEtapeRecette;
	}

}
