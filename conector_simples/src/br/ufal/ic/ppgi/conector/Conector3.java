package br.ufal.ic.ppgi.conector;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite2.spec.dt.ClienteDT2;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;
import br.ufal.aracomp.cosmos.limite3.spec.dt.ClienteDT3;
import br.ufal.aracomp.cosmos.limite3.spec.prov.ILimiteOps3;

public class Conector3 implements ILimiteReq  {
	private ILimiteOps limite;
	private ILimiteOps2 limite2;
	private ILimiteOps3 limite3;
	
	public Conector3(ILimiteOps limite, ILimiteOps2 limite2, ILimiteOps3 limite3) {
		this.limite = limite;
		this.limite2 = limite2;
		this.limite3 = limite3;
	}

	@Override
	public double estimarLimite(UsuarioDT usuario) {
		ClienteDT cliente = new ClienteDT();
		cliente.salario = Double.parseDouble(usuario.rendimentos);
		double var1 = this.limite.calcularLimite(cliente);
		//double var1 = 97;
		
		ClienteDT2 cliente2 = new ClienteDT2();
		cliente2.salario = Double.parseDouble(usuario.rendimentos);
		double var2 = this.limite2.calcularLimite(cliente2);
		//double var2 = 95;
		
		ClienteDT3 cliente3 = new ClienteDT3();
		cliente3.salario = Double.parseDouble(usuario.rendimentos);
		double var3 = this.limite3.calcularLimite(cliente3);
		//double var3 = 100;
		
		double diff1 = Math.abs(var1 - var2);
		double diff2 = Math.abs(var2 - var3);
		double diff3 = Math.abs(var3 - var1);
		
		double percent5_1 = (0.05)*Math.max(var1, var2);
		double percent5_2 = (0.05)*Math.max(var2, var3);
		double percent5_3 = (0.05)*Math.max(var3, var1);
		
		if (diff1 <= percent5_1 && diff2 <= percent5_2 && diff3 <= percent5_3) {
			//System.out.println("Validado os 03 componentes!");
			return (var1+var2+var3)/3;
		}
		else {
			if (diff1 <= percent5_1 && diff2 > percent5_2 && diff3 > percent5_3) {
				//System.out.println("O componente limite3 foi descartado!");
				return (var1+var2)/2;
			}

			if (diff1 > percent5_1 && diff2 <= percent5_2 && diff3 > percent5_3) {
				//System.out.println("O componente limite1 foi descartado!");
				return (var2+var3)/2;
			}

			if (diff1 > percent5_1 && diff2 > percent5_2 && diff3 <= percent5_3) {
				//System.out.println("O componente limite2 foi descartado!");
				return (var1+var3)/2;
			}
			throw new RuntimeException("Erro de confiabilidade. Procurar o Gerente!");
		}
	}
}