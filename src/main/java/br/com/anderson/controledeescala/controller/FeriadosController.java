package br.com.anderson.controledeescala.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.anderson.controledeescala.dto.FeriadoDto;
import br.com.anderson.controledeescala.form.CriaFeriadoForm;
import br.com.anderson.controledeescala.modelo.Feriado;
import br.com.anderson.controledeescala.modelo.Mes;
import br.com.anderson.controledeescala.service.FeriadoService;

@RestController
@RequestMapping("/feriado")
public class FeriadosController {

	@Autowired
	private FeriadoService feriadoService;
	
	
	@GetMapping("/consultaFeriadosDoMes")
	public List<Feriado> consultaFeriadosDoMes(@RequestParam String mes) {
		return feriadoService.feriadosDoMes(Mes.valueOf(mes.toUpperCase())); 
	}
	
	@GetMapping("{id}")
	public Feriado buscaFeriadoPorID(@PathVariable Long id) {
		return feriadoService.buscaPorId(id);
	}
	
	
	@GetMapping("/consultaFeriadoDiaMes")
	public Boolean consultaSeDiaEhFeriado(@RequestParam String mes, @RequestParam String dia) {
		
		return feriadoService.consultaSeDiaEhFeriado(Mes.valueOf(mes.toUpperCase()), Integer.parseInt(dia)); 
	}
	
	@PostMapping("cadastraFeriado")
	@Transactional
	public ResponseEntity<FeriadoDto> cadastrar(@RequestBody @Valid CriaFeriadoForm form, UriComponentsBuilder uriBuilder) {
		Feriado feriado = form.converter();
		feriadoService.salvar(feriado);
		URI uri = uriBuilder.path("/feriado/{id}").buildAndExpand(feriado.getId()).toUri();
		return ResponseEntity.created(uri).body(new FeriadoDto(feriado));
		
	}
	
	
}
