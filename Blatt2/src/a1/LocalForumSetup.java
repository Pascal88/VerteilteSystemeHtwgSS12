package a1;
import de.htwg_konstanz.forum.ForumClient;
import de.htwg_konstanz.forum.IForumModel;
import de.htwg_konstanz.forum.ForumModel;
import de.htwg_konstanz.forum.ForumView;
import java.lang.System;
import java.io.*;


public class LocalForumSetup extends ForumClient {
	
	public static BufferedReader console;
	public static ForumView[] views;
	public static LocalForumServer server;
	
	public LocalForumSetup() throws Exception {}

	@Override
	protected IForumModel getModelForwarder() throws Exception {
		return ForumModel.INSTANCE;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String views = null;
		System.out.println("How many views are needed?\n");
		try {
			console = new BufferedReader(new InputStreamReader(System.in));
			views = console.readLine();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		LocalForumSetup.views = new ForumView[Integer.parseInt(views)];
		
		LocalForumSetup.server = new LocalForumServer();
		
		LocalForumClient[] client = new LocalForumClient[2];
		try{
			client [0].register();
			client [2].register();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
