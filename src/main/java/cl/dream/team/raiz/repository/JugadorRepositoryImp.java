package cl.dream.team.raiz.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.dream.team.raiz.modelo.Jugador;

@Repository
public class JugadorRepositoryImp implements JugadorRepository{
	
	//Con autowired inyectamos la clase JdbcTemplate(viene seteado con la infor de application.properties)
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*Este metodo recibe primero un resultes y luego los numeros de las filas
	Lo unico que hace este metodo es instanciar un objeto alumno con el resultado de la query
	en este caso tomara la respuesta del id, nombre, posicion que entrega la BD y hara un nuevo jugador con esos datos
	este metodo sirve para recuperar datos, lo usan los metodos find*/
	private Jugador makeObject(ResultSet rs, int filaNum) throws SQLException {
		return new Jugador(rs.getInt("id"), rs.getString("nombre"), rs.getString("posicion"));
	}
	
	//Ahora en el segundo parametro recibimos todos los datos de la consulta y los guardamos 
	//como indicamos en el method makeObject(id,nombre,posicion), este metodo puede tener cualquier nombre
	@Override
	public List<Jugador> findAll() {
		String sql = "SELECT * FROM jugadores";
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Jugador findById(int id) {
		String sql = "SELECT * FROM jugadores WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Jugador jugador) {
		String sql = "INSERT INTO jugadores(nombre, posicion) VALUES(?, ?)";
		jdbcTemplate.update(sql, jugador.getNombre(), jugador.getPosicion());
	}

	@Override
	public void edit(Jugador jugador) {
		String sql = "UPDATE jugadores SET nombre = ?, posicion = ? WHERE id = ?";
		jdbcTemplate.update(
				sql, 
				jugador.getNombre(), 
				jugador.getPosicion(), 
				jugador.getId()
		);
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM jugadores WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	
	
}
