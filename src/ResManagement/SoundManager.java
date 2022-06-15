package ResManagement;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundManager {
	Hashtable<String, Clip> soundDictionary;
	float volume = 0.6f;
	public SoundManager() {
		soundDictionary = new Hashtable<String, Clip>();
		loadClip("click1.wav", "click1");
		loadClip("jump.wav", "jump");
		loadClip("run.wav", "run");
		loadClip("die.wav", "die");
		loadClip("levelComplete.wav", "levelComplete");
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

		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(20f*(float) Math.log10(volume));

	    clip.start();
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
}
