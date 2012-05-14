package a1;
import java.net.Socket;
import java.io.*;
import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.lang.reflect.*;

import de.htwg_konstanz.forum.IForumView;
import de.htwg_konstanz.forum.ForumModel;
import de.htwg_konstanz.forum.IForumModel;

public class ServerTask implements Runnable {

	private final Socket socket;
	@SuppressWarnings("unused")
	private OutputStream os;
	private InputStream is;
	private BufferedReader br;
	private ArrayList<String> list;
	private ForumModel FM = ForumModel.INSTANCE;
	
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
			Object[] tmp = this.list.toArray();
			
			if(tmp[0] == "registerView") {
				try {
					this.FM.registerView((String) tmp[1], (IForumView) tmp[2]);
				} catch (AlreadyBoundException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Method method = IForumModel.class.getMethod((String) tmp[0], new Class[]{String.class});
					method.invoke(ForumModel.INSTANCE, (String) tmp[1]);
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
						
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
