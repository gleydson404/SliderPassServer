package br.com.vsgdev.slidepass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Classe responsavel por trabalhar o processo de comunicacao das mensagens bem como o tratamento dos comandos recebidos pelo dispositivo android.
 * 
 * @author Franklin Soares
 *
 */
public class UDPHandler{
	//porta
	private static final int PORT = 9876;
	private DatagramSocket serverSocket;
	private Boolean isRunning = true;
	private Robot robot;
	private SliderView view;

	public UDPHandler(final SliderView sliderView) {
		this.view = sliderView;
		try {
			this.robot = new Robot();
			serverSocket = new DatagramSocket(PORT);
			final byte[] receiveData = new byte[1];
			System.out.println("Starting...");
			while (isRunning) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				processData(receivePacket.getData());
				receivePacket.setLength(receiveData.length);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view.setMessage(e.getMessage());
		}
	}

	private void processData(final byte[] data) {
		view.setMessage("Received data:"+data[0]);
		switch (data[0]) {
		case 48://left press
			robot.keyPress(KeyEvent.VK_LEFT);
			break;
		case 49://left release
			robot.keyRelease(KeyEvent.VK_LEFT);
			break;
		case 54://right press
			robot.keyPress(KeyEvent.VK_RIGHT);
			break;
		case 55://right press
			robot.keyRelease(KeyEvent.VK_RIGHT);
			break;
		case 52://F5 press
			robot.keyPress(KeyEvent.VK_F5);
			break;
		case 53://F5 release
			robot.keyRelease(KeyEvent.VK_F5);
			break;
		case 56://Home press
			robot.keyPress(KeyEvent.VK_HOME);
			break;
		case 57://Home release
			robot.keyRelease(KeyEvent.VK_HOME);
			break;
		case 97://End press
			robot.keyPress(KeyEvent.VK_END);
			break;
		case 98://End release
			robot.keyRelease(KeyEvent.VK_END);
			break;
		}
	}
}
