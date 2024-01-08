import java.util.Scanner;

public class MainHuma {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int torn=1, mogut=0;
		int filaorigen, filadesti;
		String columnaorigen, columnadesti;
		boolean fi=false;
		Taulell t = new Taulell();
		t.setNfitxes1(12);
		t.setNfitxes2(12);
		
		while(((t.getNfitxes1()>t.getNblock1()) && (t.getNfitxes2()>t.getNblock2())) && (fi==false)) {
			t.mostraTaula();
			System.out.println("Torn del jugador "+torn);
			t.comprovarNFitxes();
			t.comprovarDames();
			t.comprovarBloquejades();
			if(t.getNfitxesTorn(torn)==t.getNblockTorn(torn)) {
				System.out.println("Tens totes les fitxes bloquejades, no pots tirar");
				torn=3-torn;
			}
			else {
				System.out.print("Escriu la fila de la fitxa que vols moure: ");
				filaorigen = reader.nextInt();
				System.out.print("Escriu la columna de la fitxa que vols moure: ");
				columnaorigen = reader.next();
				if(columnaorigen.equals("fi")) {
					fi=true;
					continue;
				}
				System.out.print("Escriu la fila on vols moure la fitxa: ");
				filadesti = reader.nextInt();
				System.out.print("Escriu la columna on vols moure la fitxa: ");
				columnadesti = reader.next();
				mogut=t.llegirFitxa(filaorigen, columnaorigen, filadesti, columnadesti, torn);
				while(mogut==0) {
					System.out.println("Coordenades incorrectes: torna a introduir les dades correctament");
					System.out.print("Escriu la fila de la fitxa que vols moure: ");
					filaorigen = reader.nextInt();
					System.out.print("Escriu la columna de la fitxa que vols moure: ");
					columnaorigen = reader.next();
					System.out.print("Escriu la fila on vols moure la fitxa: ");
					filadesti = reader.nextInt();
					System.out.print("Escriu la columna on vols moure la fitxa: ");
					columnadesti = reader.next();
					mogut=t.llegirFitxa(filaorigen, columnaorigen, filadesti, columnadesti, torn);
				}
				t.mostraInfo();
				torn=3-torn;
			}
		}
		t.mostraGuanyador();
		reader.close();
	}
}
