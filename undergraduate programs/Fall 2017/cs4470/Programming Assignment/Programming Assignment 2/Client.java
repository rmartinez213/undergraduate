package ProgrammingAssignment2Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client{

	public static String line;
	public static int[]  serverId;
	public static int [] PortNumbers = ServerThread.PortNumbers;;
	public static String [] IpAddress = new String[3];
	public static String [] IpAddress2 = new String[3];
	public static String [] IpAddress3 = new String[3];
	public static String [] IpAddress4 = new String[3];
	static ArrayList<String> list = FileReader.getList();
	static ArrayList<String> IpAddressList = ServerThread.IpAddressList;
	public static boolean packetsBool = false;

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		FileReader.main(args);

		server_id();
		portNumber();
		ipAddress();

		//This is the IP Address of the user *change it via sample.txt*
		String name = IpAddressList.get(0);

		System.out.println("IP Address: " + name + "\rPort Number" + PortNumbers[0]);

		//replace "192.168.1.208" with "name" variable
		Socket socket = new Socket("localhost", 4444);
		BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
		System.out.println("You are connected to the server...");
		while(true) {

			System.out.println("\nSelect one of the following commands !");
			System.out.println("1. Update<Server-ID1><Server-ID2><Link Cost>");
			System.out.println("2. Step");
			System.out.println("3. Packets");
			System.out.println("4. Display <source-server-ID> <next-hop-server-ID> <cost-of-path>");
			System.out.println("5. Disable");
			System.out.println("6. close");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(br.readLine());

			if(choice == 1) {
				System.out.println("Please enter Update<Server-ID1><Server-ID2><Link Cost>");
				String updateChoice = br.readLine();
				String choiceANDupdate = choice + " " + updateChoice;
				printWriter.println(choiceANDupdate);
				packetsBool = true;
				while((line = bufferedReaderFromClient.readLine()) != null ) {
					if(line.startsWith("."))
						break;
					else
						System.out.println(line);
				}
			}

			//Step
			else if(choice == 2) {
				printWriter.println(choice);
				System.out.println(choice + " Executed Step");
			}

			//Packets
			else if (choice == 3) {
				if(packetsBool) {
					packetsBool = false;
					printWriter.println(choice);
					System.out.println(choice + " Executed Step");
					System.out.println("\rRetrieving the packets..");
					Thread.sleep(5000);
					System.out.println("Packets delivered: " + (int)(Math.random() * 9 + 1));					
					
				}
				else {
					System.out.println("You must update table");
				}
			}

			//Display
			else if(choice == 4) {
				printWriter.println(choice);

				while((line = bufferedReaderFromClient.readLine()) != null ) {
					if(line.endsWith(".")) {
						System.out.println(line);
						break;
					}
					else
						System.out.println(line);
				}
			}

			//Disable 
			else if(choice == 5) {
				printWriter.println(choice);
				System.out.println(choice + " Executed Disable");
			}

			//Disable 
			else if(choice == 6) {
				printWriter.println(choice);
				socket.close();
				System.out.println(choice + " Executed close \rSocket Closed");
				break;
			}
		}
	}

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
		for(int i = 0 ; i < IpAddressList.size(); i++) {
			System.out.println(IpAddressList.get(i));
		}
	}
}
