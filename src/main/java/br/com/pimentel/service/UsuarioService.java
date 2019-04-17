package br.com.pimentel.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pimentel.models.Usuario;
import br.com.pimentel.repositories.EnderecoRepository;
import br.com.pimentel.repositories.UsuarioRepository;

/**
 * classe Service de Usuario
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	/**
	 * Salva o Usuario
	 * @param usuario Usuario
	 */
	@Transactional
	public void salvar(Usuario usuario) {
		logger.info(" ==> Salvando USUARIO: [{}]", usuario.getCpf());
				
		enderecoRepository.save(usuario.getEndereco());		
		usuarioRepository.save(usuario);
	}
	
    /**
	 * Busca todos os Usuarios
	 * @return Todos os Usuarios
	 */
	@Transactional
	public List<Usuario> buscarTodos() {
		logger.info(" ==> Buscando todos os USUARIOS");
		return usuarioRepository.findAll();
	}
	
	/**
	 * Buscando Usuario pelo CPF
	 * @param cpf Numero do CPF
	 * @return Usuario
	 */
	@Transactional
	public Optional<Usuario> buscarByCpf(String cpf) {
		logger.info(" ==> Buscando USUARIO pelo CPF:{}", cpf);
		
		return usuarioRepository.findById(cpf);
	}
	
	/**
	 * Exclui Usuario pelo CPF
	 * @param cpf Numero do CPF
	 */
	@Transactional
	public void excluir(String cpf) {
		logger.info(" ==> Excluindo USUARIO: [{}]", cpf);
		
		usuarioRepository.deleteById(cpf);
	}

}
