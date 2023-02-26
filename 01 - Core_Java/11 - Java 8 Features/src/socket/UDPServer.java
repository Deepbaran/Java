package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(9999); //Port number is required in Server as client will be sending the data to this port number
		
		byte[] b1 = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(b1, b1.length);
		ds.receive(dp);
		String str = new String(dp.getData(), 0, dp.getLength());
		int num = Integer.parseInt(str.trim()); //We are trimming because an extra space gets added
		int result = num * num;
		byte[] b2 = String.valueOf(result).getBytes();
		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort()); //For port number we are using the same port number as in the packet
		ds.send(dp1);
	}

}
