package data;

import entities.*;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class FotoDAO {

	public void add(Foto f) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT INTO foto(idIncidencia, descripcion, photo) values (?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, f.getIncidencia().getId());
			stmt.setString(2, f.getDescripcion());
			//stmt.setBlob(3, f.getInputStream());

			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                f.setIdFoto(keyResultSet.getInt(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
	
}
