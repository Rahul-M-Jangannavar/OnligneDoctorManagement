package doctordao;
import java.sql.SQLException;
import java.util.List;
import com.onlinedoctor.customer.Doctors;

public interface DoctorDao {
	boolean bookappoint(Doctors msEntity) throws SQLException;
	List<Doctors> selectAll() throws SQLException; 
	
	boolean delete(int dId) throws SQLException;
	void singleRecord(int id) throws SQLException;
	void modify(int id)throws SQLException;


}