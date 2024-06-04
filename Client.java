
import java.net.UnknownHostException;
import java.io.*;




public class Client {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Client <host> <port>");
			return;

		}

		String hostname = args[0];
		int port = Integer.parseInt(args[1]);

		MySocket s = new MySocket(hostname,port); // host, port

		// Thread d'entrada
		new Thread() {
			public void run() {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String message;
				try {
					while ((message = in.readLine()) != null) {
						s.write(message);
					}
					s.close();
				} catch (UnknownHostException ex){
					System.out.println("Server not found: " + ex.getMessage());
				
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}.start();

		// Thread de sortida
		new Thread() {
			public void run() {
				String message;
				while ((message = s.readLine()) != null) {
					System.out.println(message);
				}
			}
		}.start();
	}

}
