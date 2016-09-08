package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
/**
 * The server, displays a log of all web requests that are sent to the server.
 * @author Adam Pine
 *
 */
public class Server extends JFrame
{
	boolean flag = true;
	ServerGui gui;
	JFrame frame = new JFrame();

	/**
	 * initialize the server GUI
	 */
	public Server()
	{
		gui = new ServerGui();
		frame.getContentPane().removeAll();
		frame.add(gui);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * starts the loop that accepts and  incoming requests.
	 * @throws IOException
	 */
	public void run() throws IOException
	{
		ServerSocket servSocket = new ServerSocket(8090);
		while (flag)
		{
			Socket socket = servSocket.accept();
			InputStream sis = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(sis));
			
			String request = in.readLine(); // Now you get GET index.html HTTP/1.1
			gui.txtServerLog.setText(gui.txtServerLog.getText() + request + "\n");

			String[] requestParam = request.split(" ");
			String path = requestParam[1];
			String[] splitPath = requestParam[1].split("/");
			String dir = splitPath[1];
		    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		    //Check to make sure it is trying to access an acceptable directory.  
			if (dir.equalsIgnoreCase("public") || dir.equalsIgnoreCase("global"))
			{
				//Remove the prefixing "/" from the get request, to get the relative path.
				File file = new File(path.substring(1, path.length()));
				//Check if the file exists
				if( file.exists()){
					out.println("HTTP/1.1 200 OK");
					out.println();
					FileReader fr = new FileReader(file);
					BufferedReader bfr = new BufferedReader(fr);
					String line;
					while ((line = bfr.readLine()) != null) {
					    out.println(line);
					}
				}else
				{
					out.write("HTTP/1.0 404 File Not Found"); // the file does not exists  
				}
			}
			else
			{
				out.write("HTTP/1.1 403 Forbidden"); // server does not have access to this directory.
			}
			out.flush();
			
			in.close();
			out.close();
			socket.close();
		}
	}

	/**
	 * The main run method, that makes the server runnable.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Server s = new Server();
		try {
			s.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
