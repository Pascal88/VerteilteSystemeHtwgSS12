package a1;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;

public class ServerTask implements Runnable {

	private final Socket socket;
	private OutputStream os;
	private InputStream is;
	private BufferedReader br;
	private ArrayList<String> list;
	
	public ServerTask(Socket socket) {
		this.socket = socket;
		this.list = new ArrayList<String>();
		try{
			this.os = this.socket.getOutputStream();
			this.is = this.socket.getInputStream();
			this.br = new BufferedReader(new InputStreamReader(this.is));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void run() {
		try{
			boolean x = false;
			do{
				x = this.list.add(this.br.readLine());
			}while(x);
				
			
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
