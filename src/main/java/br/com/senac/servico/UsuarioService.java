package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.UsuarioRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	private UsuarioRepositorio repoUsuario;
	
	public Usuario buscar(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> objCurso = repoUsuario.findById(id);
		return objCurso.orElseThrow(() -> new  ObjectNotFoundException(
				"Curso não encotrado! id: " + id + ", Tipo!" + Usuario.class.getName()));
	}	
	
	public Usuario inserir (Usuario usuario) {
		//estou colacondo um objeto novo entao o id precisa ser null
		usuario.setId(null);
		return repoUsuario.save(usuario);
	}
	
   public Usuario alterar(Usuario objUsuario) throws ObjectNotFoundException{
		
		Usuario objUsuarioEncotrado = buscar(objUsuario.getId());
		objUsuarioEncotrado = buscar(objUsuario.getId());
		objUsuarioEncotrado.setNome(objUsuario.getNome());
		objUsuarioEncotrado.setCpf(objUsuario.getCpf());
		objUsuarioEncotrado.setEmail(objUsuario.getEmail());
		objUsuarioEncotrado.setSenha(objUsuario.getSenha());
		
		return repoUsuario.save(objUsuarioEncotrado);
	}
   		public void excluir(Integer id) {
   			repoUsuario.deleteById(id);
   }
   		public List<Usuario> listaUsuario(){
   			return repoUsuario.findAll();
   }
}















