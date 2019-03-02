package br.ufal.ic.ppgi.conector;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite2.spec.dt.ClienteDT2;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;

public class Conector implements ILimiteReq  {
	private ILimiteOps limite;
	private ILimiteOps2 limite2;
	
	public Conector(ILimiteOps limite, ILimiteOps2 limite2) {
		this.limite = limite;
		this.limite2 = limite2;
	}
	
	protected double getMaior(double n1, double n2) {
		if (n1 >= n2) {
			return n1;
		}
		return n2;
	}
	
	protected double getMenor(double n1, double n2) {
		if (n1 <= n2) {
			return n1;
		}
		return n2;
	}
	
	@Override
	public double estimarLimite(UsuarioDT usuario) {
		ClienteDT cliente = new ClienteDT();
		cliente.salario = Double.parseDouble(usuario.rendimentos);
		double var1 = this.limite.calcularLimite(cliente);
		
		ClienteDT2 cliente2 = new ClienteDT2();
		cliente2.salario = Double.parseDouble(usuario.rendimentos);
		double var2 = this.limite2.calcularLimite(cliente2);

		double maior = this.getMaior(var1, var2);
		double menor = this.getMenor(var1, var2);
		double diff = maior - menor;
		double percent5 = (0.05)*maior;
		
		if (diff > percent5) {
			throw new RuntimeException("Erro de confiabilidade. Procurar o Gerente!");
		}
		return (var1+var2)/2;
	}
}