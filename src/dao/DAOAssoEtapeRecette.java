package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.*;

public interface DAOAssoEtapeRecette extends DAO <AssoEtapeRecette, Integer> {
	
	public ArrayList <AssoEtapeRecette> selectByRecette(int idRecette) throws SQLException;
	
}
