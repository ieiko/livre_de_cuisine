package dao;
import java.util.ArrayList;
import metier.*;

public interface DAOAssoEtapeRecette extends DAO <AssoEtapeRecette, Integer> {
	
	public ArrayList <AssoEtapeRecette> selectByRecette(int idRecette);
	
}
