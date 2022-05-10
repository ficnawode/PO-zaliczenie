package ResManagement;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
	Hashtable<String, Clip> soundDictionary;
	
	public SoundManager() {
		soundDictionary = new Hashtable<String, Clip>();
		loadClip("click1.wav", "click1");
		loadClip("jump.wav", "jump");
		loadClip("run.wav", "run");
	}
	
	private void loadClip( String fileName, String soundName )
	{
	    Clip in = null;

	    try{
	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("./res/sound/" + fileName));
	        in = AudioSystem.getClip();
	        in.open(audioIn);
	        soundDictionary.put(soundName, in);
	    }
	    catch( Exception e )
	    {
	        e.printStackTrace();
	    }
	}
	
	public void playClip(String soundName)
	{
		Clip clip = soundDictionary.get(soundName);
	    if( clip.isRunning() ) return;
	    clip.setFramePosition( 0 );
	    clip.start();
	}
}
