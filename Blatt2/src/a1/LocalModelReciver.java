package a1;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import de.htwg_konstanz.forum.IForumModel;
import de.htwg_konstanz.forum.IForumView;
import de.htwg_konstanz.forum.ForumModel;

public class LocalModelReciver implements IForumModel {
	
	private static LocalModelReciver INSTANCE = null;
	
	private LocalModelReciver() {
		
	}
	
	public static LocalModelReciver getInstance() {
		if(LocalModelReciver.INSTANCE == null) {
			LocalModelReciver.INSTANCE = new LocalModelReciver();
		}
		return LocalModelReciver.INSTANCE;
	}
	

	@Override
	public void deregisterView(String view) throws NotBoundException,
			IOException {
		ForumModel.INSTANCE.deregisterView(view);

	}

	@Override
	public void moveEast(String east) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveEast(east);

	}

	@Override
	public void moveNorth(String north) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveNorth(north);

	}

	@Override
	public void moveSouth(String south) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveSouth(south);

	}

	@Override
	public void moveWest(String west) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveWest(west);

	}

	@Override
	public void registerView(String name, IForumView view)
			throws AlreadyBoundException, IOException {
		ForumModel.INSTANCE.registerView(name, view);

	}
}
