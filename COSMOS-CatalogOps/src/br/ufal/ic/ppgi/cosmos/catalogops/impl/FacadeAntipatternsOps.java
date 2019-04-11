package br.ufal.ic.ppgi.cosmos.catalogops.impl;

import java.util.List;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.dt.PatternDT;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IAntipatternsOps;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IManager;

class FacadeAntipatternsOps implements IAntipatternsOps {
	private IManager manager;
	
	public FacadeAntipatternsOps(IManager manager) {
		this.manager = manager;
	}
	
	
	@Override
	public void marcarAntipattern(int userId, int projectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desmarcarAntipattern(int userId, int projectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PatternDT> obterCatalogoAntipatterns(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
