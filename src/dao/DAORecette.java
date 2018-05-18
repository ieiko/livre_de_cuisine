package dao;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.*;

public interface DAORecette extends DAO <Recette, Integer> {
	
	public ArrayList<Recette> getRecetteByType(Type type) throws SQLException;
	
}
