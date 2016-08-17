import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {	
	
	private static Socket socket;
	
	public static void main(String[] args) {
		initSocket();
		try (
			
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);
		) {
			
			String inputFromScanner = null;
			Scanner scanner = new Scanner(System.in);
			while ((inputFromScanner = scanner.nextLine()) != "EXIT") {
				System.out.println("Message: ");
				outputStream.println(inputFromScanner);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}
	
	private static void initSocket() {
		try {
			socket = new Socket("127.0.0.1", 1234);
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

}
