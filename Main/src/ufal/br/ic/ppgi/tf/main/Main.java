package ufal.br.ic.ppgi.tf.main;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;
import br.ufal.ic.ppgi.conector.Conector;

public class Main {
	public static void main(String[] args) {
		br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager emprestimo;
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager limite;
		br.ufal.aracomp.cosmos.limite2.spec.prov.IManager limite2;
		
		emprestimo = br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory.createInstance();
		limite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();
		limite2 = br.ufal.aracomp.cosmos.limite2.impl.ComponentFactory.createInstance();
		
		ILimiteOps limiteOps = (ILimiteOps)limite.getProvidedInterface("ILimiteOps");
		ILimiteOps2 limiteOps2 = (ILimiteOps2)limite2.getProvidedInterface("ILimiteOps2");
		
		
		Conector conn = new Conector(limiteOps, limiteOps2);
		
		emprestimo.setRequiredInterface("ILimiteReq", conn);
		
		
		//Exec
		
		IEmprestimoOps emprestimoOps = (IEmprestimoOps)emprestimo.getProvidedInterface("IEmprestimoOps");

		UsuarioDT usuario = new UsuarioDT();
		usuario.rendimentos = "1001";
		try {
			if (emprestimoOps.liberarEmprestimoAutomatico(usuario) <= 0) {
				throw new RuntimeException("Redimento mínimo não atingido. Procurar o seu Gerente!");
			}
			else {
				System.out.println("Valor do emprestimo: "+ emprestimoOps.liberarEmprestimoAutomatico(usuario));
			}
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
