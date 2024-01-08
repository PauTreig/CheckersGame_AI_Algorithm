
public class Heuristica1 /*Diferència de número de fitxes*/ {

	public Heuristica1(Taulell t) {
		
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
			resultat=(t.getNfitxesTorn(torn_actual)-t.getNfitxesTorn(3-torn_actual));
		}
		else {
			resultat=(t.getNfitxesTorn(3-torn_actual)-t.getNfitxesTorn(torn_actual));
		}
		
		return resultat;
	}
}
