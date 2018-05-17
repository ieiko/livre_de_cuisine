package dao;
import java.util.ArrayList;
import metier.*;

public interface DAOAssoIngredientRecette extends DAO <AssoIngredientRecette, Integer> {
	
	public ArrayList <AssoIngredientRecette> selectByIngredientRecette(int idRecette);
	
}
