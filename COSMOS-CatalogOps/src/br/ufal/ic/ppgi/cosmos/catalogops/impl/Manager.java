package br.ufal.ic.ppgi.cosmos.catalogops.impl;

import java.util.HashMap;
import java.util.Set;

import br.ufal.ic.ppgi.cosmos.catalogops.spec.prov.IManager;

class Manager implements IManager {
	private HashMap<String, Object> providedInterfaces;
	private HashMap<String, Object> requiredInterfaces;
	
	//CONSTRUCTOR
		Manager() {
			this.providedInterfaces = new HashMap<>();
			this.requiredInterfaces = new HashMap<>();
			//add interfaces
			this.providedInterfaces.put("ICatalogOps", new FacadeCatalogOps(this));
			this.providedInterfaces.put("IPatternsOps", new FacadePatternsOps(this));
			this.providedInterfaces.put("IAntipatternsOps", new FacadeAntipatternsOps(this));
			this.providedInterfaces.put("ICRUDCatalogOps", new FacadeCRUDCatalogOps(this));
			
			this.requiredInterfaces.put("ICatalogBusinessReq",null);
			this.requiredInterfaces.put("ICatalogSystemReq",null);
					
		}
	
	@Override
	public Set<String> getProvidedInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getRequiredInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProvidedInterface(String interfaceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequiredInterface(String interfaceName, Object interfaceObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getRequiredInterface(String interfaceName) {
		// TODO Auto-generated method stub
		return null;
	}

}
