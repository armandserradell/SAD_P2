import java.io.*;
import java.net.*;




public class MySocket implements AutoCloseable{

	private Socket socket;
	private BufferedReader bufferedReader; 
	private PrintWriter printWriter;
	//private String nick; 

	public MySocket(String hostAddress, int hostPort){
		try{ 
			//this.nick=nick;
			this.socket = new Socket(hostAddress, hostPort);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true); //Activem l'autoflush
		}catch(IOException e){
			e.printStackTrace();
		}
	}


	public MySocket(Socket s){
		try{
			this.socket = s;
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void write(String text){
		printWriter.println(text);
	}


	public String readLine(){
	
		String text = null;
		try{
			text = bufferedReader.readLine();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return text;
	}

	   
	   public int readInt() {
        return Integer.parseInt(readLine());
    }

    
    public Double readDOuble() {
        return Double.parseDouble(readLine());
    }

    
    public Boolean readBool() {
        return Boolean.parseBoolean(readLine());
    }

   
    public Short readSHort() {
        return Short.parseShort(readLine());
    }

    
    public Long readLong() {
        return Long.parseLong(readLine());
    }

    
    public Byte readByte() {
        return Byte.parseByte(readLine());
    }

    

    
    public void printInt(int num) {
        printWriter.println(num);
        printWriter.flush();
    }

    
    public void printDouble(Double dob) {
        printWriter.println(dob);
        printWriter.flush();
    }

    
    public void printBool(Boolean bool) {
        printWriter.println(bool);
        printWriter.flush();
    }

    public void printShort(Short curt) {
        printWriter.println(curt);
        printWriter.flush();
    }

   
    public void printLong(Long llarg) {
        printWriter.println(llarg);
        printWriter.flush();
    }

   
    public void printByte(Byte byt) {
        printWriter.println(byt);
        printWriter.flush();
    }


	public void close(){
	/*
	Hem de tancar la connexió, pel que també tanquem el BufferedReader i PrintWriter corresponents
	*/
		try{
			bufferedReader.close();
			printWriter.close();
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}