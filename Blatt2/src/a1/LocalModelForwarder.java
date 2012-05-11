package a1;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import de.htwg_konstanz.forum.IForumModel;
import de.htwg_konstanz.forum.IForumView;

public class LocalModelForwarder implements IForumModel {

	public LocalModelReciver Reciver;
	
	public LocalModelForwarder() {
		this.Reciver = LocalModelReciver.getInstance();
	}
	
	public LocalModelForwarder(LocalModelReciver reciver) {
		this.Reciver = reciver;
	}
	
	@Override
	public void deregisterView(String view) throws NotBoundException,
			IOException {
		this.Reciver.deregisterView(view);

	}

	@Override
	public void moveEast(String east) throws NotBoundException, IOException {
		this.Reciver.moveEast(east);

	}

	@Override
	public void moveNorth(String north) throws NotBoundException, IOException {
		this.Reciver.moveNorth(north);

	}

	@Override
	public void moveSouth(String south) throws NotBoundException, IOException {
		this.Reciver.moveSouth(south);

	}

	@Override
	public void moveWest(String west) throws NotBoundException, IOException {
		this.Reciver.moveWest(west);

	}

	@Override
	public void registerView(String name, IForumView view)
			throws AlreadyBoundException, IOException {
		this.Reciver.registerView(name, view);

	}

}
