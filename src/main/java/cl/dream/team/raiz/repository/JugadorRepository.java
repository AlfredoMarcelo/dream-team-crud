package cl.dream.team.raiz.repository;

import java.util.List;

import cl.dream.team.raiz.modelo.Jugador;

public interface JugadorRepository {

	//metodo para buscar a todos los jugadores de la base de datos
	public List<Jugador> findAll();
	
	//metodo para buscar a un jugador por su id
	public Jugador findById(int id);
	
	//Estos metodos van con void porque no se espera recuperar o que retorne algo, solo dan instrucciones a la base de datos
	
	//metodo para crear un jugador nuevo
	public void create(Jugador jugador);
	
	//metodo para editar a un jugador
	public void edit(Jugador jugador);
	
	//metodo para borrar a un jugador
	public void delete(int id);
	
}
