package MRChatApplicationFinal2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class SocketList implements Runnable{

	public int id; 
	public String ipAddress;
	public String portNumber;
	final DataInputStream inData;
	final DataOutputStream outData;
	public Socket sockets; 
	boolean isloggedin;//get rid of this
	
	
	public SocketList(int id, String ipAddress, String portNumber, DataInputStream in, DataOutputStream out, Socket sockets){
		this.id = id;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.inData = in;
		this.outData = out;
		this.sockets = sockets;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public Socket getSockets() {
		return sockets;
	}
	public void setSockets(Socket sockets) {
		this.sockets = sockets;
	}
	
	public DataInputStream getInData() {
		return inData;
	}
	public DataOutputStream getOutData() {
		return outData;
	}
	
	@Override
    public void run(){
 
        String received;
        while (true) 
        {
            try
            {
                // receive the string
                received = inData.readUTF();
                 
                System.out.println(received);
                 
                if(received.equals("end")){
                    this.isloggedin=false;
                    this.sockets.close();
                    break;
                }
                 
                // break the string into message and recipient part
                StringTokenizer st = new StringTokenizer(received, ".*");
                String MsgToSend = st.nextToken();
                String recipient = st.nextToken();
 
                // search for the recipient in the connected devices list.
                // ar is the vector storing client of active users
                for (SocketList mc : Server.connect) 
                {
                    // if the recipient is found, write on its
                    // output stream
                    if (mc.ipAddress.equals(recipient) && mc.isloggedin==true) 
                    {
                        mc.outData.writeUTF(this.ipAddress+" : "+MsgToSend);
                        break;
                    }
                }
            } catch (IOException e) {
                try {
					sockets.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("You disconnected");
				}
                Server.getList().remove(0);
                break;
            }
             
        }
        try
        {
            // closing resources
            this.inData.close();
            this.outData.close();
             
        }catch(IOException e){
            e.printStackTrace();
        }

	}
	
}
