package br.ufal.ic.ppgi.cosmos.catalogops.spec.prov;
 
import java.util.List;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.dt.PatternDT;

public interface IPatternsOps {
	public void marcarPattern(int userId, int projectId);
	public void desmarcarPattern(int userId, int projectId);
	public List <PatternDT> obterCatalogoPatterns(int userId);
}
