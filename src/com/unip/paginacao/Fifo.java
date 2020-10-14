package com.unip.paginacao;

public class Fifo {

	private int qtdPagina;
	private int qtdQuadro;
	int [] paginas;
	int [][] matriz;
	int [] falha;
	int aux = 0;
	
	public Fifo(){
		System.out.println("FIFO\n");
	}


	public void setPaginas(int[] paginas) {
		this.paginas = paginas;
	}


	public void setQuantidadePaginas(int qtdPagina) {
		this.qtdPagina = qtdPagina;
	}

	public void setQuantidadeFrames(int qtdQuadro) {
		this.qtdQuadro = qtdQuadro;
	}
	
	public void iniciarFalhas() {
		for(int i=0; i<qtdPagina; i++) {
			falha[i] = 0;
		}
	}
		
	public void proximo() {
		aux++;
		if(aux == qtdQuadro) {
			aux = 0;
		}
	}
	
	public boolean buscar(int pagAtual){
		boolean var1 = false;
		for(int j=0; j<qtdQuadro; j++){
			if(paginas[pagAtual] == matriz[j][pagAtual]){
				var1 = true;
			}
		}
		return var1;
	}
	
	
	public void modificar(boolean encontrado,int pagAtual){
		if(!encontrado){
			for(int aux = pagAtual; aux < qtdPagina ; aux++){
				matriz[aux][aux] = paginas[pagAtual];
				falha[pagAtual] = 1;
			}
			proximo();
		}
	}
	
	public void fifo(){
		matriz = new int[qtdQuadro][qtdPagina];
		falha= new int [qtdPagina];
		iniciarFalhas();
		for(int i=0; i<qtdPagina; i++){
			modificar(buscar(i), i);
		}
		mostrarMatriz();
	}
	
	public void mostrarMatriz(){
		int qtdFalha = 0;
		for(int i=0; i < qtdQuadro; i++){
			for(int j=0; j < qtdPagina; j++){
				System.out.print("" + matriz[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i<qtdPagina; i++){
			if(falha[i] == 1){
				qtdFalha++;
			}
			System.out.print("" + falha[i]);
		}
		System.out.println("\n\n Páginas encontradas: "+ qtdFalha);
	}
	
}
