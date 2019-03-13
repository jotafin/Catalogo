package br.ufal.ic.ppgi.cosmos.catalogops.impl;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.ICatalogOps;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IManager;

class FacadeCatalogOps implements ICatalogOps {
	private IManager manager;
	
	public FacadeCatalogOps(Manager manager) {
		// TODO Auto-generated constructor stub
		this.manager = manager;
	}

}
