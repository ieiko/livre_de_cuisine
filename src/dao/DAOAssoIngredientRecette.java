package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.*;

public interface DAOAssoIngredientRecette extends DAO <AssoIngredientRecette, Integer> {
	
	public ArrayList <AssoIngredientRecette> selectByIngredientRecette(int idRecette) throws SQLException;
	
}
