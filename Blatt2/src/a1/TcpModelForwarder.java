package a1;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import de.htwg_konstanz.forum.IForumModel;
import de.htwg_konstanz.forum.IForumView;

import java.net.InetSocketAddress;
import java.net.Socket;


public class TcpModelForwarder implements IForumModel {
	
	private Socket socket;
	private OutputStreamWriter osw;
	
	public TcpModelForwarder(){
		this.socket = new Socket();
		try {
			this.socket.connect(new InetSocketAddress("127.0.0.1", 60000));
			this.osw = new OutputStreamWriter(this.socket.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deregisterView(String arg0) throws NotBoundException,
			IOException {
		String str = "deregisterView";
		this.osw.write(str, 0, str.length());
		this.osw.write(arg0, 0, arg0.length());

	}

	@Override
	public void moveEast(String arg0) throws NotBoundException, IOException {
		String str = "moveEast";
		this.osw.write(str, 0, str.length());
		this.osw.write(arg0, 0, arg0.length());

	}

	@Override
	public void moveNorth(String arg0) throws NotBoundException, IOException {
		String str = "moveNorth";
		this.osw.write(str, 0, str.length());
		this.osw.write(arg0, 0, arg0.length());

	}

	@Override
	public void moveSouth(String arg0) throws NotBoundException, IOException {
		String str = "moveSouth";
		this.osw.write(str, 0, str.length());
		this.osw.write(arg0, 0, arg0.length());

	}

	@Override
	public void moveWest(String arg0) throws NotBoundException, IOException {
		String str = "moveWest";
		this.osw.write(str, 0, str.length());
		this.osw.write(arg0, 0, arg0.length());

	}

	@Override
	public void registerView(String arg0, IForumView arg1)
			throws AlreadyBoundException, IOException {
		String str = "registerView";
		this.osw.write(str, 0, str.length());
		this.osw.write(arg0, 0, arg0.length());
		this.osw.write("60000", 0, 5);

	}

}
