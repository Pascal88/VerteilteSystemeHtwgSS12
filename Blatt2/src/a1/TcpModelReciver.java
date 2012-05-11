package a1;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.io.IOException;

public class TcpModelReciver {
	
	private ServerSocket servSocket = null;
	private volatile boolean done = false;
	public ExecutorService exec;
	
	public TcpModelReciver() {
		try{
			this.servSocket = new ServerSocket(60000);
			this.exec = Executors.newFixedThreadPool(2);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void work(){
		while(!this.done){
			try{
				Socket socket = this.servSocket.accept();
				this.exec.execute(new ServerTask(socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try{
			this.exec.shutdown();
			this.servSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void done(){
		this.done = true;
	}

}
