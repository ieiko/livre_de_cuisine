package dao;
import java.sql.SQLException;
import java.util.List;

public interface DAO <T,K> {

	public T selectById(K id) throws SQLException, ClassNotFoundException;
	public List<T> selectAll() throws SQLException, ClassNotFoundException;
	public void insert(T obj) throws ClassNotFoundException, SQLException;
	public void update(T obj) throws ClassNotFoundException, SQLException;
	public void delete(T obj) throws ClassNotFoundException, SQLException;
	
}
