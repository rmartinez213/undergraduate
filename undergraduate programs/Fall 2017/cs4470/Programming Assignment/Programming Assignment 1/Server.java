package MRChatApplicationFinal2;
import java.io.BufferedReader;  
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;


public class Server{
	
	public static ArrayList<SocketList> connect = new ArrayList<SocketList>();
	static public final int PORT = 4332;
	static ServerSocket listener;
	static int id = 1;
	static Socket SSocket;


	public static void server() throws InterruptedException, IOException{


		listener = new ServerSocket(PORT);

		// running infinite loop for getting
		// client request
		while (true) 
		{
			// Accept the incoming request
			SSocket = listener.accept();
			
			//Test purpose
			System.out.println("Client's IP Address: " + (((InetSocketAddress) SSocket.getRemoteSocketAddress()).getAddress()).toString().replaceAll(".*/", ""));
			System.out.println("Client's Port: " + getPort(SSocket.getRemoteSocketAddress()));

			//Test case, in order to reassure that the server is connected to the socket
			System.out.println(SSocket.isConnected()); //Blocks code, until socket is connected

			// DataInputStream is supposed to receive the input of the user from message sent
			//DateOutput stream is supposed to send the input of the user to the Message sent
			DataInputStream dis = new DataInputStream(SSocket.getInputStream());
			DataOutputStream dos = new DataOutputStream(SSocket.getOutputStream());

			System.out.println("Creating a new handler for this client...");

			// Create an SocketList object
			SocketList list = new SocketList(id,SSocket.getInetAddress().getHostAddress(),getPort(SSocket.getRemoteSocketAddress()), dis, dos,SSocket);
			
			// Create a new Thread 
			Thread thread = new Thread(list);


			// add this client to active users list
			connect.add(list);
			
			
			// start the thread.
			thread.start();
			
			// increment id
			id++;
			break;
		}
		
		
	}

	//Returns the IP Address of the connected client
	public static String getPort(SocketAddress address) {
		return ((InetSocketAddress) address).getPort() + " ";
	}
	
	
	public static ArrayList<SocketList> getList(){
		return connect;
	}
}