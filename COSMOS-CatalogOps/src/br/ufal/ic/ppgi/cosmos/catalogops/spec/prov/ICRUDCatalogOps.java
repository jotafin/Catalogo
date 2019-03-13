package br.ufal.ic.ppgi.cosmos.catalogops.spec.prov;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.dt.CatalogDT;

public interface ICRUDCatalogOps {
	public CatalogDT adicionarCatalogo(CatalogDT catalog);
	public CatalogDT alterarCatalogo(int id, CatalogDT catalog);
	public void excluirCatalogo(int id);

}
