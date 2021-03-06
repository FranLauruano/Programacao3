package prefeitura.siab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import prefeitura.siab.persistencia.RacaDao;
import prefeitura.siab.tabela.Raca;

@Component
public class RacaController {

	private @Autowired RacaDao dao;
	
	@Transactional
	public String salvarRaca(Raca raca) throws BusinessException{
		Raca auxiliar = dao.searchRaca(raca);
		if(auxiliar != null){
			if(auxiliar.getCodigo().equals(raca.getCodigo()) && auxiliar.getNome().equals(raca.getNome())){
				throw new BusinessException("Essa Raça já está cadastrada!!!");
			}else if(auxiliar.getCodigo().equals(raca.getCodigo())){
				throw new BusinessException("Esse Código já foi Cadastrado, favor modificar.");
			}else if(auxiliar.getNome().equals(raca.getNome())){
				throw new BusinessException("Esse Nome já foi Cadastrado, favor modificar. ");
			}
			throw new BusinessException("Impossível salvar essa Raça!");
		}
		dao.insert(raca);
		return null;
	}

	public List<Raca> searchRaca(Raca raca) {
		return dao.searchListRaca(raca);
	}

	
	
	
	
}
