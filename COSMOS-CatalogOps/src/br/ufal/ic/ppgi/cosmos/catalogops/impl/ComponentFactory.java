package br.ufal.ic.ppgi.cosmos.catalogops.impl;

import br.ufal.ic.ppgi.cosmos.catalogops.impl.Manager;
import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IManager;

public class ComponentFactory {
	private static IManager manager = null;
	
	private ComponentFactory() {
		// fazer nada
	}
	
	public static IManager createInstance(){
		if(manager == null)
			manager = new Manager();
		return manager;
	}
}

