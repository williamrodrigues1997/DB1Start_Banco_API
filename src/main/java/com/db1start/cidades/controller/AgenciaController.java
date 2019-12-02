package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.adapter.AgenciaAdapter;
import com.db1start.cidades.domain.dto.AgenciaDTO;
import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.service.AgenciaService;

@RestController
@RequestMapping("/api")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	// CRIAR

	@PostMapping("/agencia")
	public AgenciaDTO criarAgencia(@RequestBody Agencia agencia) {
		return AgenciaAdapter.agenciaParaDTO(
				agenciaService.criar(agencia.getNumeroAgencia(), agencia.getCidade(), agencia.getNumeroBanco()));
	}

	// BUSCAR

	@GetMapping("/agencias")
	public List<AgenciaDTO> buscarTodosAgencias() {
		return AgenciaAdapter.listaDeAgenciasParaDTO(agenciaService.buscarTodasAgencias());
	}

	@GetMapping("/agencia/{id}")
	public AgenciaDTO buscarAgenciaPorId(@PathVariable(value = "id") Long id) {
		return AgenciaAdapter.agenciaParaDTO(agenciaService.buscarAgenciaPorId(id));
	}

	// APAGAR

	@DeleteMapping("/agencias")
	public void apagarTodasAgencias() {
		agenciaService.apagarTodasAgencias();
	}

	@DeleteMapping("/agencia/{id}")
	public void apagarAgenciaPorId(@PathVariable(value = "id") Long id) {
		agenciaService.apagarAgenciaPorId(id);
	}

}
