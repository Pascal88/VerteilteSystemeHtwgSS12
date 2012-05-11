package a1;

import java.io.IOException;
import java.util.Map;

import de.htwg_konstanz.forum.IForumView;
import de.htwg_konstanz.forum.Position;

public class LocalViewForwarder implements IForumView {

	public LocalViewReciver view;
	
	public LocalViewForwarder() {
		this.view = LocalViewReciver.getInstance();
	}

	@Override
	public void notifyView(Map<String, Position> folks, String message)
			throws IOException {
		this.view.notifyView(folks, message);

	}

}
