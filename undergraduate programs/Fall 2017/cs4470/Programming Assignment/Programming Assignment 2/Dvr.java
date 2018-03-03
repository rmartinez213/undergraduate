package ProgrammingAssignment2Final;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Dvr  {
	/*we will be inserting the first serverid, second serverid and the cost in snc[][]*/
	static int snc[][]; 
	static int nt[][];
	static int t[][];
	static int numOfServerID = ServerThread.server_id().length + 1; //the length of servers
	static int edges = ServerThread.edges();//neighbors
	static ArrayList<String> list = FileReader.getList();
	static int newChoice;
	static String messageStringUpdate;

	public static void main(String[] args) throws NumberFormatException, IOException {
		snc = new int[numOfServerID] [numOfServerID];
		nt = new int[numOfServerID][numOfServerID];
		t = new int[numOfServerID][numOfServerID];


		for(int i = 0; i < numOfServerID ; i++)
			for(int j = 0; j < numOfServerID ; j++)
			{
				if(i == j)
					snc[i][j] = 0;
				else
					snc[i][j] = 9999;
			}


		for(int i = 0; i < edges - 1; i++){
			snc[Integer.parseInt(list.get(6).substring(0,1))][Integer.parseInt(list.get(6).substring(2,3))] = Integer.parseInt(list.get(6).substring(4,5));
			snc[Integer.parseInt(list.get(6).substring(2,3))][Integer.parseInt(list.get(6).substring(0,1))] = Integer.parseInt(list.get(6).substring(4,5));
			//		snc[1][2] = 3
			//		snc[2][1] = 3


			snc[Integer.parseInt(list.get(7).substring(0,1))][Integer.parseInt(list.get(7).substring(2,3))] = Integer.parseInt(list.get(7).substring(4,5));
			snc[Integer.parseInt(list.get(7).substring(2,3))][Integer.parseInt(list.get(7).substring(0,1))] = Integer.parseInt(list.get(7).substring(4,5));
			//		snc[1][3] = 6
			//		snc[3][1] = 6


			snc[Integer.parseInt(list.get(8).substring(0,1))][Integer.parseInt(list.get(8).substring(2,3))] = Integer.parseInt(list.get(8).substring(4,5));
			snc[Integer.parseInt(list.get(8).substring(2,3))][Integer.parseInt(list.get(8).substring(0,1))] = Integer.parseInt(list.get(8).substring(4,5));

			//		snc[1][4] = 4
			//		snc[4][1] = 4


		}		
		//For testing purposes 
		displayTable("The initial Routing Tables are:  ");	
	}

	public static void menu(String choice) throws NumberFormatException, IOException {
		String serverID1 = null;
		String serverID2 = null;
		String cost = null;
		int newChoice;

		//If the user did not choose option 1, newChoice is the new switch statement value
		if(choice.length() == 1) {
			newChoice = Integer.parseInt(choice);
		}
		//If user chose 1, 
		else {
			newChoice = Integer.parseInt(choice.substring(0,1));

			serverID1 = choice.substring(9,10);
			serverID2 = choice.substring(11,12);
			cost = choice.substring(13,14);
		}

		switch(newChoice){
		case 1: update(serverID1, serverID2, cost);
		break;
		case 2: step(cost);
		break;
		case 3: packets();
		break;
		case 4: display();
		break;
		}
	}

	public static void update(String serverID1, String serverID2, String cost){
		int inf = (int) Double.POSITIVE_INFINITY;
		String winf = "inf";

		//Verify that the server is receiving the correct data
		//System.out.println("serverID1: " + serverID1);
		//System.out.println("serverID2: " + serverID2);
		//System.out.println("cost: " + cost);


		if(cost.endsWith(winf)){ // if the cost is infinity
			snc[Integer.parseInt(serverID1)][Integer.parseInt(serverID2)] = inf;
			snc[Integer.parseInt(serverID2)][Integer.parseInt(serverID1)] = inf;
		}
		else{
			snc[Integer.parseInt(serverID1)][Integer.parseInt(serverID2)] = Integer.parseInt(cost);
			snc[Integer.parseInt(serverID2)][Integer.parseInt(serverID1)] = Integer.parseInt(cost);
		}
		displayTable("The updated Routing Tables are: ");
	}

	/*
	 *Send routing update to neighbors right away. Note that except this, routing updates only happen periodically.
	 */
	public static void step(String myport){
		if(myport == null)
            System.out.println("need to Start Server");
        else{
            step(myport);
        }
         //Andres method
        sendTable();
        System.out.println("step success");
	}

	

	/*
	 * Display the number of distance vector (packets) this server has received since the last invocation of this information.
	 */
	public static void packets(){
		int packCounter = 0;
        //Hongsuk's method
        System.out.println("Your receiveed " + packCounter + " Packets since your last called");
        packCounter = 0;
	}


	/*
	 * Display the current routing table. And the table should be displayed in a sorted order from small ID to big. 
	 * The display should be formatted as a sequence of lines, with each line indicating: 
	 * <source-server-ID> <next-hop-server-ID> <cost-of-path>
	 */

	//I do have a display table for testing,
	public static ArrayList<String> display() throws NumberFormatException, IOException{


		ArrayList<String> messageString = new ArrayList<String>(); 

		/*
		 * Display the current routing table. And the table should be displayed in a sorted order from
		 * small ID to big. The display should be formatted as a sequence of lines, with each line
		 * indicating: <source-server-ID> <next-hop-server-ID> <cost-of-path>
		 */

		messageString.add("Source   NextHop   Cost");
		for(int i = 1; i < numOfServerID ; i++){
			for(int j = 1; j < numOfServerID ; j++){
				messageString.add("\r" + i+"          "+ j + "           " + t[i][j]);
			}
			messageString.add("\r"); //for displaying purposes 
		}
		return messageString;
	}


	public static void displayTable(String message) {
		System.out.println();
		passValues();
		table();
		printTable();
		System.out.println();
	}

	public static void updateTable(int source) {

		for(int i = 1; i < numOfServerID ; i++){
			if(snc[source][i] != 9999){

				int distance = snc[source][i];

				// System.out.println("I'm the dist" + dist);

				for(int j = 1; j < numOfServerID ; j++) {
					int innerDistance = t[i][j];
					// System.out.println("I am the inner dist before loop " + inter_dist);
					if(nt [i][j] == source){

						innerDistance = 9999;
					}
					if(distance + innerDistance < t[source][j]) {
						t[source][j] = distance + innerDistance;
						nt [source][j] = i;
					}
				}
			}
		}
	}

	public static void table(){
		int k = 0;
		for(int i = 1; i < 4* (numOfServerID )  ; i++){

			updateTable(k);
			k++;
			if(k == numOfServerID)
				k = 0;

		}
	}

	public static void passValues() {
		for(int i = 0; i < numOfServerID ; i++) {
			for(int j = 0; j < numOfServerID ; j++) {
				if(i == j){
					t[i][j] = 0;
					nt [i][j] = i;
				}
				else{
					t[i][j] = 9999;
					nt [i][j] = 100;
				}
			}
		}
	}
	//for test purposes, i and j must start at 1. 
	public static void printTable() {// displaying the final table
		messageStringUpdate = "";

		for(int i = 1; i < numOfServerID ; i++){
			for(int j = 1; j < numOfServerID ; j++){
				messageStringUpdate += "Cost: " + t[i][j] + "    ";
			}
			messageStringUpdate += "\r";
		}
		messageStringUpdate += ".";
		//System.out.println(messageStringUpdate);
	}
	
	/*
	 * Send table to user
	 */
	private static void sendTable() {
		return;
	}
}
