import java.util.LinkedList;
import java.util.List;

public class Minimax {

	Taulell t = new Taulell();
	int infinitpos = Integer.MAX_VALUE;
	int infinitneg = Integer.MIN_VALUE;
	int nivell_maxim_minimax = 7;
	int torn;
	
	public Minimax() {
		
	}

	public Minimax(int torn) {
		this.torn = torn;
	}
	
	public Object[] exeMinimax(Taulell t, int nivell, int heuristica) {
		List<Taulell> taulells;
		int val_a_devolver=0, val=0;
		Taulell nodo_a_devolver = new Taulell();
		Taulell F = new Taulell();
		Heuristica1 h1 = new Heuristica1(t);
		Heuristica2 h2 = new Heuristica2(t);
		Heuristica3 h3 = new Heuristica3(t);
		Object[] retornar_minimax = new Object[2];
		
		if (esFi(t)) {
			if (((t.getNdames1() >= t.getNdames2()) && (torn == 1))
					|| ((t.getNdames2() >= t.getNdames1()) && (torn == 2))) {
				retornar_minimax[0] = infinitpos;
				retornar_minimax[1] = null;
			} else {
				retornar_minimax[0] = infinitneg;
				retornar_minimax[1] = null;

			}
			return (retornar_minimax);
		} else if (nivell == nivell_maxim_minimax) {
			if (heuristica==1) {
				retornar_minimax[0] = h1.calcular(t, torn, nivell);
				retornar_minimax[1] = null;
			}
			else if (heuristica==2) {
				retornar_minimax[0] = h2.calcular(t, torn, nivell);
				retornar_minimax[1] = null;
			}
			else {
				retornar_minimax[0] = h3.calcular(t, torn, nivell);
				retornar_minimax[1] = null;
			}
			return (retornar_minimax);
		} else {
			nodo_a_devolver=null;
			if(nivell%2!=0) { //MAX és imparell, MIN és parell (perque inicio el nivell a 1)
				val_a_devolver=infinitneg;
			}
			else {
				val_a_devolver=infinitpos;
			}
			taulells=generarFills(t, nivell);
			while(taulells.size()>0) {
				F=taulells.remove(0);
				retornar_minimax = exeMinimax(F, nivell+1, heuristica);
				val=(int)retornar_minimax[0];
				if (nivell%2!=0) {
					if (val > val_a_devolver) {
						val_a_devolver=val;
						nodo_a_devolver=F.clone();
					}
				} else {
					if (val < val_a_devolver) {
						val_a_devolver=val;
						nodo_a_devolver=F.clone();
					}
				}
				
			}
			if(nodo_a_devolver==null) {
				nodo_a_devolver=F.clone();
			}
			retornar_minimax[0]=val_a_devolver;
			retornar_minimax[1]=nodo_a_devolver;
			return(retornar_minimax);
		}
	}

	public List<Taulell> generarFills(Taulell t, int nivell) {
		List<Taulell> taulells = new LinkedList<Taulell>();
		Taulell aux = new Taulell();
		int torn_actual=0;
		if(nivell%2!=0) {
			torn_actual=torn;
		}
		else {
			torn_actual=3-torn;
		}
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(torn_actual==t.getTaulell()[i][j]) {
					aux = t.clone();
					if(aux.moureFitxa(i, j, "D", torn_actual)==1) {
						aux.comprovarNFitxes();
						aux.comprovarDames();
						aux.comprovarBloquejades();
						taulells.add(aux);
					}
					aux = t.clone();
					if(aux.moureFitxa(i, j, "E", torn_actual)==1) {
						aux.comprovarNFitxes();
						aux.comprovarDames();
						aux.comprovarBloquejades();
						taulells.add(aux);
					}
				}
			}
		}
		if(taulells.size()==0) {
			taulells.add(t);
		}
		return (taulells);
	}
	
	public boolean esFi(Taulell t) {
		boolean retornar = false;

		t.comprovarNFitxes();
		t.comprovarDames();
		t.comprovarBloquejades();
		if (((t.getNfitxes1() == t.getNblock1()) && (t.getNfitxes2() == t.getNblock2())) || (t.getNfitxes1() == 0)
				|| (t.getNfitxes2() == 0)) {
			retornar = true;
		}
		return (retornar);
	}

}
