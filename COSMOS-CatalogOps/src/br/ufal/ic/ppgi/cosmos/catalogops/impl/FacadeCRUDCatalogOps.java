package br.ufal.ic.ppgi.cosmos.catalogops.impl;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.dt.CatalogDT;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.ICRUDCatalogOps;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IManager;

class FacadeCRUDCatalogOps implements ICRUDCatalogOps {
	private IManager manager;
	
	public FacadeCRUDCatalogOps(Manager manager) {
		// TODO Auto-generated constructor stub
		this.manager = manager;
	}
	@Override
	public CatalogDT adicionarCatalogo(CatalogDT catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatalogDT alterarCatalogo(int id, CatalogDT catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirCatalogo(int id) {
		// TODO Auto-generated method stub
		
	}

}
