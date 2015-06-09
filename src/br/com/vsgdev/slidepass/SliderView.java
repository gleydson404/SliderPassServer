package br.com.vsgdev.slidepass;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Visao basica que, entre outras funcoes, exibe textualmente os comandos recebidos pelo dispositivo android. 
 * 
 * @author Franklin Soares
 *
 */
public class SliderView extends JFrame {
	private static final long serialVersionUID = -7733121166076008826L;
	private static final int WIDTH = 350;
	private static final int HEIGHT = 150;
	//JLabel para exibir mensagens de conexão e erro.
	final JLabel lblInfo;
	
	public SliderView(){
		super("SliderPass - Passador de Slides");//construtor de JFrame informando o nome da janela
		setLayout(null);//remove o layout default
		setSize(WIDTH, HEIGHT);//determina as dimensoes da janela (largura/width, altura/height) em px.
		
		setLocationRelativeTo(null);//exibe centralizado
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//determina comportamento quando for clicado no botao fechar da janela
		
		lblInfo = new JLabel("Waiting Connection...");
		//adiciona o JLabel ao JFrame.
		add(lblInfo);
		//define posicao e dimensao
		lblInfo.setBounds(20,60, 330, 25);
		
		//torna visivel.
		setVisible(true);
		new UDPHandler(this);
	}
	
	public void setMessage(final String msg){
		this.lblInfo.setText(msg);
		this.lblInfo.repaint();
	}
	
	public static void main(String a[]){
		new SliderView();
	}

}
