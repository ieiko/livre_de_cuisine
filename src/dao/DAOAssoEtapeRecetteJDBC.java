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
	
	@Override
	public AssoEtapeRecette selectById(Integer id) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		AssoEtapeRecette asso = null;
		
		PreparedStatement ps=conn.prepareStatement("select * from asso_etapes_recettes where id_asso_etapes_recettes = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			asso = new AssoEtapeRecette(rs.getInt("id_asso_etapes_recettes"), rs.getInt("id_recette"), rs.getInt("id_etape"));
		}
		
		return asso;
	}

	@Override
	public List<AssoEtapeRecette> selectAll() throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		ArrayList<AssoEtapeRecette> assoRecettes = new ArrayList<AssoEtapeRecette>();
		PreparedStatement ps= conn.prepareStatement("select * from asso_etapes_recettes");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			assoRecettes.add(new AssoEtapeRecette(rs.getInt("id_asso_etapes_recettes"), rs.getInt("id_recette"), rs.getInt("id_etape")));
		}
		
		conn.close();
		return assoRecettes;
	}

	@Override
	public void insert(AssoEtapeRecette obj) throws ClassNotFoundException, SQLException {

	}

	@Override
	public void update(AssoEtapeRecette obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AssoEtapeRecette obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<AssoEtapeRecette> selectByRecette(int idRecette) {
		// TODO Auto-generated method stub
		return null;
	}

}
