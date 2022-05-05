package br.com.anderson.controledeescala.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.anderson.controledeescala.dto.FuncionarioDto;
import br.com.anderson.controledeescala.form.AtualizaFuncionarioForm;
import br.com.anderson.controledeescala.form.CriaFuncionarioForm;
import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("{id}")
	public Funcionario buscaFuncionarioPorID(@PathVariable Long id) {
		return funcionarioService.buscaPorId(id);
	}
	
	@PostMapping("cadastraFuncionario")
	@Transactional
	public ResponseEntity<FuncionarioDto> cadastrar(@RequestBody @Valid CriaFuncionarioForm form, UriComponentsBuilder uriBuilder) {
		Funcionario funcionario = form.converter();
		funcionarioService.salvar(funcionario);
		URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
	}
	
	@PutMapping("/atualizaFuncionario/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaFuncionarioForm form) {
		Funcionario funcionario = funcionarioService.buscaPorId(id);
		funcionario = form.atualizar(id, funcionarioService);
		return ResponseEntity.ok(new FuncionarioDto(funcionario));
	}
	
}
