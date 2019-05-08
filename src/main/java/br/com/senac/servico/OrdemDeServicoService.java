package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senac.dominio.OrdemDeServico;

import br.com.senac.repositorio.OrdemDeServicoRepositorio;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class OrdemDeServicoService {
	

	private OrdemDeServicoRepositorio repoOrdem;
	
	public OrdemDeServico buscar(Long id) throws ObjectNotFoundException {
		Optional<OrdemDeServico> objOrdemDeServico = repoOrdem.findById(id);
		return objOrdemDeServico.orElseThrow(() -> new  ObjectNotFoundException(
				" não encotrado! id: " + id + ", Tipo!" + OrdemDeServico.class.getName()));
	}	
	
	public OrdemDeServico inserir (OrdemDeServico OrdemServico) {
		//estou colacondo um objeto novo entao o id precisa ser null
		OrdemServico.setId((Long) null);
		return repoOrdem.save(OrdemServico);
	}
	
   public OrdemDeServico alterar(OrdemDeServico objOrdemServico) throws ObjectNotFoundException{
		
	   OrdemDeServico objOrdemServicoEncotrado = buscar(objOrdemServico.getId());
	   objOrdemServicoEncotrado = buscar(objOrdemServico.getId());
	   objOrdemServicoEncotrado.setResponsavel(objOrdemServico.getResponsavel());
	   objOrdemServicoEncotrado.setDataInicio(objOrdemServico.getDataInicio());
	   objOrdemServicoEncotrado.setDataTermino(objOrdemServico.getDataTermino());
	   objOrdemServicoEncotrado.setDescricao(objOrdemServico.getDescricao());
	   objOrdemServicoEncotrado.setLatitudeInstalacao(objOrdemServico.getLatitudeInstalacao());
	   objOrdemServicoEncotrado.setLongitudeInstalacao(objOrdemServico.getLongitudeInstalacao());
		
		return repoOrdem.save(objOrdemServicoEncotrado);
	}
   		public void excluir(Long id) {
   			repoOrdem.deleteById(id);
   }
   		public List<OrdemDeServico> listaOrdemDeServico(){
   			return repoOrdem.findAll();
   }

}
