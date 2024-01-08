
public class Taulell {
	int[][] taulell = {{0,1,0,1,0,1,0,1},
			   		   {1,0,1,0,1,0,1,0},
			   		   {0,1,0,1,0,1,0,1},
			   		   {0,0,0,0,0,0,0,0},
			   		   {0,0,0,0,0,0,0,0},
			   		   {2,0,2,0,2,0,2,0},
			   		   {0,2,0,2,0,2,0,2},
			   		   {2,0,2,0,2,0,2,0}};
	
	int ndames1=0, ndames2=0, nblock1=0, nblock2=0, nfitxes1=0, nfitxes2=0;
	
	public Taulell(){
		
	}
	
	public void mostraTaula() {
		System.out.print("    A B C D E F G H\n\n8   ");
		for (int x=0; x < 8; x++) {
			   for (int y=0; y < 8; y++) {
			       System.out.print(taulell[x][y]+" ");
			   }
			   System.out.print("\n");
			   switch(x) {
			   case 0: System.out.print("7   ");
			   				break;
			   case 1: System.out.print("6   ");
  							break;
			   case 2: System.out.print("5   ");
			   				break;
			   case 3: System.out.print("4   ");
  							break;
			   case 4: System.out.print("3   ");
  							break;
			   case 5: System.out.print("2   ");
  							break;
			   case 6: System.out.print("1   ");
  							break;
			   
			   }
			}
		System.out.print("\n");
	}
	
	//Getters i Setters
	public int[][] getTaulell(){return taulell;}
	
	public int getValor(int x, int y) {return(taulell[x-1][y-1]);}
	
	public int getNfitxes1() {return nfitxes1;}
	
	public void setNfitxes1(int nfitxes1) {this.nfitxes1 = nfitxes1;}
	
	public int getNfitxes2() {return nfitxes2;}
	
	public void setNfitxes2(int nfitxes2) {this.nfitxes2 = nfitxes2;}
	
	public int getNdames1() {return ndames1;}

	public void setNdames1(int ndames1) {this.ndames1 = ndames1;}

	public int getNdames2() {return ndames2;}

	public void setNdames2(int ndames2) {this.ndames2 = ndames2;}

	public int getNblock1() {return nblock1;}

	public void setNblock1(int nblock1) {this.nblock1 = nblock1;}

	public int getNblock2() {return nblock2;}

	public void setNblock2(int nblock2) {this.nblock2 = nblock2;}
	
	public int getNfitxesTorn(int torn) {
		if(torn==1) {
			return nfitxes1;
		}
		else {
			return nfitxes2;
		}
	}
	
	public int getNblockTorn(int torn) {
		if(torn==1) {
			return nblock1;
		}
		else {
			return nblock2;
		}
	}

	public int getNdamesTorn(int torn) {
		if(torn==1) {
			return ndames1;
		}
		else {
			return ndames2;
		}
	}
	
	public void setTaulell(int[][] taulell) {this.taulell = taulell;}

	//Funció que mou la fitxa i realitza accions com ara eliminar fitxa
	public int moureFitxa(int x, int y, /* operador */String direccio, int color) {
		int mogut=0;
		switch(color) {
			case 1:
				if(taulell[x][y]==1) {
					if (direccio.equals("D")) {
						if((x<8)&&(y<7)&&(taulell[x+1][y+1]!=color)&&(taulell[x+1][y+1]!=9)) {
							if(taulell[x+1][y+1]==(3-color)) {
								if((x<6)&&(y<6)&&(taulell[x+2][y+2]==0)) {
									taulell[x+2][y+2]=taulell[x][y];
									taulell[x+1][y+1]=0;
									taulell[x][y]=0;
									mogut=1;
								}
							}
							else {
								taulell[x+1][y+1]=taulell[x][y];
								taulell[x][y]=0;
								mogut=1;
							}
						}
					}
					else if (direccio.equals("E")){
						if((x<8)&&(y>0)&&(taulell[x+1][y-1]!=color)&&(taulell[x+1][y-1]!=9)) {
							if(taulell[x+1][y-1]==(3-color)) {
								if((x<6)&&(y>1)&&(taulell[x+2][y-2]==0)) {
									taulell[x+2][y-2]=taulell[x][y];
									taulell[x+1][y-1]=0;
									taulell[x][y]=0;
									mogut=1;
								}
							}
							else {
								taulell[x+1][y-1]=taulell[x][y];
								taulell[x][y]=0;
								mogut=1;
							}
						}
					}
				}
				break;
			case 2:
				if(taulell[x][y]==2) {
					if (direccio.equals("D")) {
						if((x<8)&&(y<7)&&(taulell[x-1][y+1]!=color)&&(taulell[x-1][y+1]!=9)) {
							if(taulell[x-1][y+1]==(3-color)) {
								if((x>1)&&(x<8)&&(y<6)&&(taulell[x-2][y+2]==0)) {
									taulell[x-2][y+2]=taulell[x][y];
									taulell[x-1][y+1]=0;
									taulell[x][y]=0;
									mogut=1;
								}
							}
							else {
								taulell[x-1][y+1]=taulell[x][y];
								taulell[x][y]=0;
								mogut=1;
							}
						}
					}
					else if (direccio.equals("E")){
						if((x<8)&&(y>0)&&(taulell[x-1][y-1]!=color)&&(taulell[x-1][y-1]!=9)) {
							if(taulell[x-1][y-1]==(3-color)) {
								if((x>1)&&(x<8)&&(y>1)&&(taulell[x-2][y-2]==0)) {
									taulell[x-2][y-2]=taulell[x][y];
									taulell[x-1][y-1]=0;
									taulell[x][y]=0;
									mogut=1;
								}
							}
							else {
								taulell[x-1][y-1]=taulell[x][y];
								taulell[x][y]=0;
								mogut=1;
							}
						}
					}
				}
				break;
		}
		return(mogut);
	}
	
	public int llegirFitxa(int numorigen, String lletraorigen, int numdesti, String lletradesti, int torn) {
		int mogut=0;
		String direccio="";
		lletraorigen=lletraorigen.toUpperCase();
		lletradesti=lletradesti.toUpperCase();
		int pos_numorigen, pos_lletraorigen, pos_numdesti, pos_lletradesti;
		switch(numorigen) {
			case 8:	pos_numorigen=0;
					break;
			case 7:	pos_numorigen=1;
					break;
			case 6:	pos_numorigen=2;
					break;
			case 5:	pos_numorigen=3;
					break;
			case 4:	pos_numorigen=4;
					break;
			case 3:	pos_numorigen=5;
					break;
			case 2:	pos_numorigen=6;
					break;
			case 1:	pos_numorigen=7;
					break;
			default:pos_numorigen=9;
					break;
		}
		switch(lletraorigen) {
			case "A":	pos_lletraorigen=0;
						break;
			case "B":	pos_lletraorigen=1;
						break;
			case "C":	pos_lletraorigen=2;
						break;
			case "D":	pos_lletraorigen=3;
						break;
			case "E":	pos_lletraorigen=4;
						break;
			case "F":	pos_lletraorigen=5;
						break;
			case "G":	pos_lletraorigen=6;
						break;
			case "H":	pos_lletraorigen=7;
						break;
			default: 	pos_lletraorigen=9;
						break;
		}
		switch(numdesti) {
			case 8:	pos_numdesti=0;
					break;
			case 7:	pos_numdesti=1;
					break;
			case 6:	pos_numdesti=2;
					break;
			case 5:	pos_numdesti=3;
					break;
			case 4:	pos_numdesti=4;
					break;
			case 3:	pos_numdesti=5;
					break;
			case 2:	pos_numdesti=6;
					break;
			case 1:	pos_numdesti=7;
					break;
			default:pos_numdesti=9;
					break;
		}
		switch(lletradesti) {
			case "A":	pos_lletradesti=0;
						break;
			case "B":	pos_lletradesti=1;
						break;
			case "C":	pos_lletradesti=2;
						break;
			case "D":	pos_lletradesti=3;
						break;
			case "E":	pos_lletradesti=4;
						break;
			case "F":	pos_lletradesti=5;
						break;
			case "G":	pos_lletradesti=6;
						break;
			case "H":	pos_lletradesti=7;
						break;
			default: 	pos_lletradesti=9;
						break;
		}
		
		if((pos_numorigen==9) || (pos_lletraorigen==9) || (pos_numdesti==9) || (pos_lletradesti==9)) {
			mogut=0;
		}
		else if((Math.abs(pos_numorigen-pos_numdesti)>2) || (Math.abs(pos_lletraorigen-pos_lletradesti)>2)) {
			mogut=0;
		}
		else {
			if(pos_lletraorigen==pos_lletradesti) {
				mogut=0;
			}
			else if(pos_lletraorigen>pos_lletradesti) {
				direccio="E";
			}
			else {
				direccio="D";
			}
			mogut=moureFitxa(pos_numorigen, pos_lletraorigen, direccio, torn);
		}
		return(mogut);
	}
	public void comprovarBloquejades() {
		int aux_nb1=nblock1;
		int aux_nb2=nblock2;
		
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				if(taulell[i][j]==1) {
					if(i<6) {
						if(j==0) {
							if(taulell[i+1][j+1]==1) {
								nblock1++;
							}
							else if((taulell[i+1][j+1]==2) && (taulell[i+2][j+2]!=0)) {
								nblock1++;
							}
						}
						else if(j==7) {
							if(taulell[i+1][j-1]==1) {
								nblock1++;
							}
							else if((taulell[i+1][j-1]==2) && (taulell[i+2][j-2]!=0)) {
								nblock1++;
							}
						}
						else {
							if((taulell[i+1][j+1]==1) && (taulell[i+1][j-1]==1)) {
								nblock1++;
							}
							else {
								if((j<6) && (j>1)) {
									if((taulell[i+1][j+1]==2) && (taulell[i+2][j+2]!=0) && (taulell[i+1][j-1]==2) && (taulell[i+2][j-2]!=0)) {
										nblock1++;
									}
									if((taulell[i+1][j+1]==1) && (taulell[i+1][j-1]==2) && (taulell[i+2][j-2]!=0)) {
										nblock1++;
									}
									if((taulell[i+1][j-1]==1) && (taulell[i+1][j+1]==2) && (taulell[i+2][j+2]!=0)) {
										nblock1++;
									}
								}
								if(j==1) {
									if((taulell[i+1][j-1]==2) && (taulell[i+1][j+1]==2) && (taulell[i+2][j+2]!=0)) {
										nblock1++;
									}
									if((taulell[i+1][j-1]==2) && (taulell[i+1][j+1]==1)) {
										nblock1++;
									}
									if((taulell[i+1][j-1]==1) && (taulell[i+1][j+1]==2) && (taulell[i+2][j+2]!=0)) {
										nblock1++;
									}
								}
								if(j==6) {
									if((taulell[i+1][j+1]==2) && (taulell[i+1][j-1]==2) && (taulell[i+2][j-2]!=0)) {
										nblock1++;
									}
									if((taulell[i+1][j+1]==2) && (taulell[i+1][j-1]==1)) {
										nblock1++;
									}
									if((taulell[i+1][j+1]==1) && (taulell[i+1][j-1]==2) && (taulell[i+2][j-2]!=0)) {
										nblock1++;
									}
								}
							}
						}
					}
					else {
						if(j==0) {
							if(taulell[i+1][j+1]!=0) {
								nblock1++;
							}
						}
						else if(j==7) {
							if(taulell[i+1][j-1]!=0) {
								nblock1++;
							}
						}
						else {
							if((taulell[i+1][j+1]!=0) && (taulell[i+1][j-1]!=0)) {
								nblock1++;
							}
						}
					}
				}
				else if(taulell[i][j]==2) {
					if(i>1) {
						if(j==0) {
							if(taulell[i-1][j+1]==2) {
								nblock2++;
							}
							else if((taulell[i-1][j+1]==1) && (taulell[i-2][j+2]!=0)) {
								nblock2++;
							}
						}
						else if(j==7) {
							if(taulell[i-1][j-1]==2) {
								nblock2++;
							}
							else if((taulell[i-1][j-1]==1) && (taulell[i-2][j-2]!=0)) {
								nblock2++;
							}
						}
						else {
							if((taulell[i-1][j+1]==2) && (taulell[i-1][j-1]==2)) {
								nblock2++;
							}
							else {
								if((j<6) && (j>1)) {
									if((taulell[i-1][j+1]==1) && (taulell[i-2][j+2]!=0) && (taulell[i-1][j-1]==1) && (taulell[i-2][j-2]!=0)) {
										nblock2++;
									}
									if((taulell[i-1][j+1]==2) && (taulell[i-1][j-1]==1) && (taulell[i-2][j-2]!=0)) {
										nblock2++;
									}
									if((taulell[i-1][j-1]==2) && (taulell[i-1][j+1]==1) && (taulell[i-2][j+2]!=0)) {
										nblock2++;
									}
								}
								if(j==1) {
									if((taulell[i-1][j-1]==1) && (taulell[i-1][j+1]==1) && (taulell[i-2][j+2]!=0)) {
										nblock2++;
									}
									if((taulell[i-1][j-1]==1) && (taulell[i-1][j+1]==2)) {
										nblock2++;
									}
									if((taulell[i-1][j-1]==2) && (taulell[i-1][j+1]==1) && (taulell[i-2][j+2]!=0)) {
										nblock2++;
									}
								}
								if(j==6) {
									if((taulell[i-1][j+1]==1) && (taulell[i-1][j-1]==1) && (taulell[i-2][j-2]!=0)) {
										nblock2++;
									}
									if((taulell[i-1][j+1]==1) && (taulell[i-1][j-1]==2)) {
										nblock2++;
									}
									if((taulell[i-1][j+1]==2) && (taulell[i-1][j-1]==1) && (taulell[i-2][j-2]!=0)) {
										nblock2++;
									}
								}
							}
						}
					}
					else {
						if(j==0) {
							if(taulell[i-1][j+1]!=0) {
								nblock2++;
							}
						}
						else if(j==7) {
							if(taulell[i-1][j-1]!=0) {
								nblock2++;
							}
						}
						else {
							if((taulell[i-1][j+1]!=0) && (taulell[i-1][j-1]!=0)) {
								nblock2++;
							}
						}
					}
				}
			}
		}
		for (int i=0; i<=7; i++) { //les dames també formen part de les fitxes bloquejades
			if (taulell[0][i]==9) {
				nblock2++;
			}
			if (taulell[7][i]==9) {
				nblock1++;
			}
		}
		nblock1=nblock1-aux_nb1;
		nblock2=nblock2-aux_nb2;
	}
	
	public void mostraInfo() {
		System.out.print("Número de fitxes del jugador 1: "+nfitxes1+"   //   ");
		System.out.print("Número de dames del jugador 1: "+ndames1+"   //   ");
		System.out.println("Número de fitxes bloquejades del jugador 1: "+nblock1);
		System.out.print("Número de fitxes del jugador 2: "+nfitxes2+"   //   ");
		System.out.print("Número de dames del jugador 2: "+ndames2+"   //   ");
		System.out.println("Número de fitxes bloquejades del jugador 2: "+nblock2);
	}
	public void comprovarNFitxes() {
		int aux_nf1=nfitxes1;
		int aux_nf2=nfitxes2;
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				if(taulell[i][j]==1) {
					nfitxes1++;
				}
				if(taulell[i][j]==2) {
					nfitxes2++;
				}
				if((i==0) && (taulell[i][j])==9) {
					nfitxes2++;
				}
				if((i==7) && (taulell[i][j])==9) {
					nfitxes1++;
				}
			}
		}
		nfitxes1=nfitxes1-aux_nf1;
		nfitxes2=nfitxes2-aux_nf2;
	}
	
	public void comprovarDames() {
		
		for(int i=0; i<=7; i++) {
			if (taulell[0][i]==2) {
				ndames2++;
				taulell[0][i]=9;
			}
			if (taulell[7][i]==1) {
				ndames1++;
				taulell[7][i]=9;
			}
		}

	}
	
	public int mostraGuanyador() {
		int guanyador=0;
		
		if(ndames1>ndames2) {
			guanyador=1;
			System.out.println("Fi del joc - guanya el jugador 1 amb "+ndames1+" dames");
		}
		else if(ndames2>ndames1){
			guanyador=2;
			System.out.println("Fi del joc - guanya el jugador 2 amb "+ndames2+" dames");
		}
		else {
			int desempat1=0, desempat2=0;
			for (int i=0; i<=7; i++) {
				if(taulell[6][i]==1) {
					desempat1++;
				}
				if(taulell[1][i]==2) {
					desempat2++;
				}
			}
			if (desempat1==desempat2) {
				for (int i=0; i<=7; i++) {
					if(taulell[5][i]==1) {
						desempat1++;
					}
					if(taulell[2][i]==2) {
						desempat2++;
					}
				}
			}
			if (desempat1==desempat2) {
				for (int i=0; i<=7; i++) {
					if(taulell[4][i]==1) {
						desempat1++;
					}
					if(taulell[3][i]==2) {
						desempat2++;
					}
				}
			}
			if(desempat1>desempat2) {
				guanyador=1;
				System.out.println("Fi del joc - Empat de dames - guanya el jugador 1 amb més fitxes properes a ser dama");
			}
			else if(desempat2>desempat1){
				guanyador=2;
				System.out.println("Fi del joc - Empat de dames - guanya el jugador 2 amb més fitxes properes a ser dama");
			}
			else {
				System.out.println("Fi del joc - Empat");
			}
		}
		return(guanyador);
	}
	
	public Taulell clone() {
		Taulell aux = new Taulell();
		int[][] taulellAux =new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				taulellAux[i][j]=this.taulell[i][j];
			}
		}
		aux.setTaulell(taulellAux);
		aux.setNblock1(this.nblock1);
		aux.setNblock2(this.nblock2);
		aux.setNdames1(this.ndames1);
		aux.setNdames2(this.ndames2);
		aux.setNfitxes1(this.nfitxes1);
		aux.setNfitxes2(this.nfitxes2);
		
		return(aux);
	}
}
