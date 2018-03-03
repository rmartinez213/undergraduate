package ProgrammingAssignment2Final;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import ProgrammingAssignment2Version2.Client;



public class ServerThread extends Thread{
	Socket socket;
	
	public static int counter = 0;
	public static int counter2 = 0;
	static ArrayList<String> list = FileReader.getList();
	static ArrayList<String> IpAddressList = new ArrayList<String>();
	Socket clientSocket;
	public static int[]  serverId;
	public static int [] PortNumbers;
	public static String [] IpAddress = new String[3];
	public static String [] IpAddress2 = new String[3];
	public static String [] IpAddress3 = new String[3];
	public static String [] IpAddress4 = new String[3];

	ServerThread(Socket socket){
		this.socket = socket;
	}
	
	/*
	 * Method that returns the number of edges (neighbors)
	 */
	public static int edges(){
		int edge = Integer.parseInt(list.get(1));
		//Test Case to see if edges is working
		//    	System.out.println("Edges :" + edge);
		return edge;
	}
	
	/*
	 * Method that returns the server id
	*/
	public static int[] server_id(){

		//Port numbers array initialization
		serverId = new int[4];

		serverId[0] = Integer.parseInt(list.get(2).substring(0, 1));
		serverId[1] = Integer.parseInt(list.get(3).substring(0, 1));
		serverId[2] = Integer.parseInt(list.get(4).substring(0, 1));
		serverId[3] = Integer.parseInt(list.get(5).substring(0, 1));

		return serverId;
	}
	
	public static int[] portNumber() {
		//Retrieving the splited arraylist from other class
		PortNumbers = new int[4];

		//Since each array is different indexes, we will get the length of the value-4...Instead of splitting...To get Port #
		int portLength1 = list.get(2).length();
		int portLength2 = list.get(3).length();
		int portLength3 = list.get(4).length();
		int portLength4 = list.get(5).length();

		//Store the port numbers into a String array
		PortNumbers[0] = Integer.parseInt(list.get(2).substring(portLength1-4, portLength1));
		PortNumbers[1] = Integer.parseInt(list.get(3).substring(portLength2-4, portLength2));
		PortNumbers[2] = Integer.parseInt(list.get(4).substring(portLength3-4, portLength3));
		PortNumbers[3] = Integer.parseInt(list.get(5).substring(portLength4-4, portLength4));

		return PortNumbers;
	}
	
	
	public static void ipAddress() {
		//Get the exact IP address from the text file
		IpAddress = list.get(2).split(" ");
		IpAddress2 = list.get(3).split(" ");
		IpAddress3 = list.get(4).split(" ");
		IpAddress4 = list.get(5).split(" ");

		//Store the IP addresses into an arraylist
		IpAddressList.add(IpAddress[1]);
		IpAddressList.add(IpAddress2[1]);
		IpAddressList.add(IpAddress3[1]);
		IpAddressList.add(IpAddress4[1]);

		//Test to print out arraylist with IP address
		//System.out.println("Here are the IP Addresses from the file...");
		//for(int i = 0 ; i < IpAddressList.size(); i++) {
			//System.out.println(IpAddressList.get(i));
		//}
		
		//Test Purpose
		//System.out.println(counter++);
	}
	
	

	public void run() {
		server_id();
		portNumber();
		ipAddress();
		
		try {
			String message = null;
			//Print writer for opening a stream to send to the client
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

			//Reads any incoming messages in order to display onto the server screen class
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//Displayed whenever the client is connected
			System.out.println("Client Connected...");
			//Create table for client
			Dvr.main(null);
			
			while ((message = bufferedReader.readLine()) != null) {
				
				
				
				//What is displayed on the screen in server window
				Dvr.menu(message);
				
				
				/*
				 * This conditional statement consists of 
				 */
				if(message.substring(0, 1).equals("1")) {
					Dvr.printTable();
					
					String messageString = Dvr.messageStringUpdate;
					
					//Success message
					System.out.println(message + " Success!");
					
					printWriter.println(messageString);
				}
				//Step
				else if(message.substring(0, 1).equals("2")) {
					System.out.println(message + " Success");
				}
				//Update
				else if(message.substring(0, 1).equals("3")) {
					System.out.println(message + " Success");
				}
				//DisplayTable
				else if(message.substring(0, 1).equals("4")) {
					
					String messageTableString = "";
					
					System.out.println(message);
					ArrayList<String> displayTable = Dvr.display();
					
					for(int i = 0 ; i < displayTable.size() ;i++) {
						messageTableString += displayTable.get(i);
					}
					messageTableString += ".";
					
					printWriter.println(messageTableString);
				}
				else if(message.substring(0, 1).equals("5")) {
					System.out.println(message + " Disable Success");
				}
				else if (message.substring(0, 1).equals("6")){
					System.out.println(message + " disconnected client");
				}
				
				
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}