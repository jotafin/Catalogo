package br.ufal.ic.ppgi.cosmos.catalogops.spec.prov;

import java.util.List;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.dt.PatternDT;

public interface IAntipatternsOps {
	public void marcarAntipattern(int userId, int projectId);
	public void desmarcarAntipattern(int userId, int projectId);
	public List <PatternDT> obterCatalogoAntipatterns(int userId);
}
