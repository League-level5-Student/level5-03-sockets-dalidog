 package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends JFrame{
	JTextField textBox = new JTextField("",10);
	JPanel panel = new JPanel();
	JButton send = new JButton("SEND");
	ChatServer server;
	ChatClient client;
	
	
	public static void main(String[] args) {
		new ChatApp();
	}
	
	public ChatApp(){
		
		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			server = new ChatServer(8080);
			setTitle("SERVER");
			JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
			send.addActionListener((e)->{
				server.sendText(textBox.getText());
			});
			panel.add(send);
			panel.add(textBox);
			add(panel);
			panel.setVisible(true);
			setVisible(true);
			setSize(400, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			server.start();
			
		}else{
			setTitle("CLIENT");
			String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
			String prtStr = JOptionPane.showInputDialog("Enter the port number");
			int port = Integer.parseInt(prtStr);
			client = new ChatClient(ipStr, port);
			send.addActionListener((e)->{
				client.sendText(textBox.getText());
			});
			panel.add(send);
			panel.add(textBox);
			add(panel);
			panel.setVisible(true);
			setSize(400, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			client.start();
		}
	}
}

