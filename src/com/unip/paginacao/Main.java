package com.unip.paginacao;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int qtdPag, qtdQuadro;
		int []paginas;
		
		qtdPag = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de páginas: "));
		qtdQuadro = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de frames: "));
		
		paginas= new int[qtdPag];
		
		for(int c = 0; c<qtdPag; c++){
			paginas[c]= Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor de páginas: ["+(c+1)+"]"));
		}

		Fifo fifo=new Fifo();
		fifo.setQuantidadeFrames(qtdQuadro);
		fifo.setQuantidadePaginas(qtdPag);
		fifo.setPaginas(paginas);
		fifo.fifo();

	}
}
