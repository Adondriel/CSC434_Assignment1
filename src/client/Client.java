package client;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Client
{
	public String address = "";
	public String directory = "";
	public String file = "";
	
	private ClientGUI gui;

	//JFrame frame = new JFrame();

	public Client()
	{
		gui = new ClientGUI(this);
		gui.setVisible(true);
	}

	public void run() throws UnknownHostException, IOException
	{
		// Go visit this location.
		Socket socket = new Socket(address,8090);
	      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	      //Assemble the get request, the replacement of the "/" ensure that it will not cause a double // to occur if the user enters data differently.
	      String req = "GET " + "/" + directory.replace("/", "") + "/" + file + " HTTP/1.0";
	      out.println(req);
	      out.println();   // blank line separating header & body
	      out.flush();
	      //read the response from the server.
	      String line;
	      // readLine() returns null if server close the network socket.
	      while((line = in.readLine()) != null) {
	    	 System.out.println(line);
	         gui.txtAreaLog.setText(gui.txtAreaLog.getText()+ line +"\n");
	      }
	      in.close();
	      out.close();
	}
	
	public static void main(String[] args)
	{
		Client c = new Client();
//		try {
//			c.run();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
