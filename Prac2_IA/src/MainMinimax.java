import java.util.List;
import java.util.LinkedList;

public class MainMinimax {

	public static void main(String[] args) {
		
		int torn=1;
		Minimax m1 = new Minimax(1);
		Minimax m2 = new Minimax(2);
		Taulell t = new Taulell();
		Object[] retornar_minimax = new Object[2];
		int nIteracions1=0, nIteracions2=0;
		long tempsExecucio1=0, tempsExecucio2=0;
		List<Long> taulaTemps1 = new LinkedList<Long>();
		List<Long> taulaTemps2 = new LinkedList<Long>();
		long inici1=0, inici2=0, final1=0, final2=0, durada1=0, durada2=0;
		System.out.println("Taulell inicial:");
		
		while (!m1.esFi(t)) {
			if(t.getNfitxes1()!=t.getNblock1()) {
				inici1 = System.nanoTime();
				t.mostraTaula();
				t.mostraInfo();
				System.out.println("Torn del jugador "+torn);
				retornar_minimax=m1.exeMinimax(t, 1, 1);
				t=(Taulell)retornar_minimax[1];
				//int valor1 = (int)retornar_minimax[0];
				//System.out.println(valor1);
				torn=3-torn;
				nIteracions1++;
				final1 = System.nanoTime();
				durada1 = (final1 - inici1)/1000000;
				taulaTemps1.add(durada1);
			}  
			else {
				System.out.println("Jugador 1 té totes les fitxes bloquejades, no pot tirar");
				torn=3-torn;
			}
			
			if(t.getNfitxes2()!=t.getNblock2()) {
				inici2 = System.nanoTime();
				t.mostraTaula();
				t.mostraInfo();
				System.out.println("Torn del jugador "+torn);
				retornar_minimax=m2.exeMinimax(t, 1, 1);
				t=(Taulell)retornar_minimax[1];
				//int valor2 = (int)retornar_minimax[0];
				//System.out.println(valor2);
				torn=3-torn;
				nIteracions2++;
				final2 = System.nanoTime();
				durada2 = (final2 - inici2)/1000000;
				taulaTemps2.add(durada2);
			}
			else {
				System.out.println("Jugador 2 té totes les fitxes bloquejades, no pot tirar");
				torn=3-torn;
			}
		}
		t=(Taulell)retornar_minimax[1];
		t.mostraTaula();
		t.mostraGuanyador();
		System.out.println("Número d'iteracions del jugador 1: "+nIteracions1);
		System.out.println("Número d'iteracions del jugador 2: "+nIteracions2+"\n");
		System.out.println("Temps d'execució de cada iteració del jugador 1 en ms:");
		int i=1;
		for(long temps1:taulaTemps1) {
			System.out.println("Iteració "+i+": "+temps1+" ms");
			i++;
		}
		System.out.println("\nTemps d'execució de cada iteració del jugador 2 en ms:");
		i=1;
		for(long temps2:taulaTemps2) {
			System.out.println("Iteració "+i+": "+temps2+" ms");
			i++;
		}
		
		for(long temps1:taulaTemps1) {
			tempsExecucio1+=temps1;
		}
		for(long temps2:taulaTemps2) {
			tempsExecucio2+=temps2;
		}
		double mitjana1=0, mitjana2=0;
		mitjana1=tempsExecucio1/nIteracions1;
		mitjana2=tempsExecucio2/nIteracions2;
		System.out.println("\nTemps d'execució total del jugador 1: "+tempsExecucio1+" ms ||| Mitjana de milisegons per iteració: "+mitjana1+ "ms/iteració");
		System.out.println("Temps d'execució total del jugador 2: "+tempsExecucio2+" ms ||| Mitjana de milisegons per iteració: "+mitjana2+ "ms/iteració");
		
	}

}
