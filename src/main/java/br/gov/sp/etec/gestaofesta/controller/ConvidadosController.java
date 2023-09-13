package br.gov.sp.etec.gestaofesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaofesta.model.Convidado;
import br.gov.sp.etec.gestaofesta.repository.ConvidadoRepository;

@Controller /* Para dizer que é um controller */
@RequestMapping("convidado")
public class ConvidadosController {

	@Autowired // Esse @ serve para injetar o objeto, é como se fosse a instanciação do java
	private ConvidadoRepository repo; // estou chamando a camada Repository

	@GetMapping("home") /* é oque da nome ao url quando for usar Ex: localhost:8080/home */
	public String abrirTelaCadastro() {
		return "convidado";
	}

	@PostMapping("salvar") // PostMapping é para receber os dados da tag form pois ela tem o method="post"
							// que tem o nome(action) salvar
	public String salvarConvidado(Convidado convidado) {
		repo.save(convidado);
		return "lista-convidado"; // lista-convidado é o nome da pagina html
	}

	@GetMapping("lista-convidados")
	public ModelAndView listaConvidados() {

		List<Convidado> lista = repo.findAll();

		ModelAndView view = new ModelAndView("lista-convidado");
		view.addObject("convidados", lista);

		return view;
	}
	@GetMapping("excluir/{id}")
	public ModelAndView  excluirConvidado(@PathVariable Long id) {
		repo.deleteById(id);
		List<Convidado> lista = repo.findAll();

		ModelAndView view = new ModelAndView("lista-convidado");
		view.addObject("convidados", lista);

		return view;
		
	}

}
