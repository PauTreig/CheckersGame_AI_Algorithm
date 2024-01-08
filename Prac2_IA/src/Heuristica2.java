
public class Heuristica2 /*Diferència de número de dames*/{

	public Heuristica2(Taulell t) {
		
	}
	
	public int calcular(Taulell t, int torn, int nivell) {
		int resultat=0;
		int torn_actual=0;
		if(nivell%2!=0) {
			torn_actual=torn;
		}
		else {
			torn_actual=3-torn;
		}
		
		if(torn_actual==torn) {
			resultat=t.getNdamesTorn(torn_actual)-t.getNdamesTorn(3-torn_actual);
		}
		else {
			resultat=t.getNdamesTorn(3-torn_actual)-t.getNdamesTorn(torn_actual);
		}
		
		return resultat;
	}
}

