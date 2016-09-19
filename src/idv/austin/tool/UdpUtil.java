package idv.austin.tool;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpUtil {

	public void send(String ip, int port, String postData) throws IOException{
		
		InetAddress ipv4 = InetAddress.getByName(ip);
		byte[] buf = postData.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, ipv4, port);
		
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		socket.close();
	}
	
	public void runTest1() throws IOException{
		UdpUtil test = new UdpUtil();
		test.send("10.1.1.30", 8000, "123");		
	}
	
	public static void main(String[] args) {
	}
	
}
