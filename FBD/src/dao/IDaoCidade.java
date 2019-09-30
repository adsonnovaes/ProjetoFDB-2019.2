package dao;

import model.Cidade;

public interface IDaoCidade {
	
	public void salvarCidade(Cidade cidade);
	public void editarCidade(Cidade cidade);
	public void buscarCidadeId(int id);

}
