package a1;

import java.io.IOException;
import java.util.Map;

import de.htwg_konstanz.forum.IForumView;
import de.htwg_konstanz.forum.Position;
import de.htwg_konstanz.forum.ForumView;

public class LocalViewReciver implements IForumView {
	
	private static LocalViewReciver INSTANCE = null;
	
	private LocalViewReciver() {}
	
	public static LocalViewReciver getInstance(){
		if(LocalViewReciver.INSTANCE == null) {
			LocalViewReciver.INSTANCE = new LocalViewReciver();
		}
		
		return LocalViewReciver.INSTANCE;
	}
	
	public ForumView view;
	
	public LocalViewReciver(ForumView view) {
		this.view = view;
	}

	@Override
	public void notifyView(Map<String, Position> folks, String message)
			throws IOException {
		this.view.notifyView(folks, message);

	}

}
