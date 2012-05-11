package a1;

import de.htwg_konstanz.forum.ForumServer;
import de.htwg_konstanz.forum.IForumModel;

public class LocalForumServer extends ForumServer {

	@Override
	protected void createModelReceiver(IForumModel arg0) throws Exception {
		// TODO Auto-generated method stub

	}
	
	public void run() {
		try {
			super.run();
		} catch (Exception e) {
			System.out.println("Somethingn went wrong with ForumServer");
		}
	}

}
