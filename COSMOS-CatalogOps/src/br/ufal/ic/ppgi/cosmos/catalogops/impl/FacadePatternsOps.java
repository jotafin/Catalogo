package br.ufal.ic.ppgi.cosmos.catalogops.impl;

import java.util.List;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.dt.PatternDT;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IManager;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IPatternsOps;

class FacadePatternsOps implements IPatternsOps {
	private IManager manager;
	
	public FacadePatternsOps(IManager manager) {
		this.manager = manager;
	}
	
	
	@Override
	public void marcarPattern(int userId, int projectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desmarcarPattern(int userId, int projectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PatternDT> obterCatalogoPatterns(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
