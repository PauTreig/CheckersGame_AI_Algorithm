
public class Heuristica3 /*Diferència de número de fitxes bloquejades*/{

	public Heuristica3(Taulell t) {
		
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
			resultat=12-t.getNblockTorn(torn_actual)+t.getNblockTorn(3-torn_actual);
		}
		else {
			resultat=12-t.getNblockTorn(3-torn_actual)+t.getNblockTorn(torn_actual);
		}
		
		return resultat;
	}
}

