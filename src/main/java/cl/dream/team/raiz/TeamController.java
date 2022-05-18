package cl.dream.team.raiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.dream.team.raiz.modelo.Jugador;
import cl.dream.team.raiz.repository.JugadorRepository;

@Controller
public class TeamController {
	
	@Autowired//se inyecto el repositorio con los metodos personalizados del jugador
	JugadorRepository jugadorRepository;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/jugador")
	public String jugadorForm(Jugador jugador) {
		return "jugador/registro";
	}
	
	@PostMapping("/jugador")
	public String crearRegistro(Jugador jugador) {
		
		if(jugador.getId() == 0 ) {
			jugadorRepository.create(jugador);
		}else {
			jugadorRepository.edit(jugador);
		}
		return "redirect:/equipo";
	}
	
	@GetMapping("/equipo")
	public String mostrarEquipo(Model modelo) {
		List<Jugador> jugadores = jugadorRepository.findAll();
		modelo.addAttribute("jugadores", jugadores);
	return "jugador/equipo";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam(name="id", required = true)int id) {
		jugadorRepository.delete(id);
	return "redirect:/equipo";
	}
	
	@GetMapping("/editar/{jugadorId}")
	public String editar(@PathVariable int jugadorId, Model modelo) {
		Jugador jugador = jugadorRepository.findById(jugadorId);
		modelo.addAttribute("jugador", jugador);
		return "/jugador/registro";
	}
	
	
}
