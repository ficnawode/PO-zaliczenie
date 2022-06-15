package ResManagement;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class Sound {

	static int volume = 60;


	public static Clip loadClip( String fileName )
	{
	    Clip in = null;

	    try{
	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("./res/sound/" + fileName));
	        in = AudioSystem.getClip();
	        in.open(audioIn);
	    }
	    catch( Exception e )
	    {
	        e.printStackTrace();
	    }

	    return in;
	}
	
	public static void playClip( Clip clip )
	{
	    if( clip.isRunning() ) clip.stop();
	            clip.setFramePosition( 0 );


	    clip.start();
	}
	
	public static void loadAndPlaySound(String fileName) {
		playClip(loadClip(fileName));
	}
	
	
}
