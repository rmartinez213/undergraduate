package ProgrammingAssignment2Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	public static final int TEMPPORT = 4444;

	public static void main(String[] args) throws IOException{
		FileReader.main(args);
		new Server().runServer();
	}

	public void runServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(TEMPPORT);
		System.out.println("Server up & ready for connections");

		while(true){
			Socket socket = serverSocket.accept();

			for (int i = 0; i < 2; i++) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException x) {
				}
				System.out.println("Trying to establish a new client...");
			}
			System.out.println("Ready to establish a new connection...");

			new ServerThread(socket).start();
		}
	}
}