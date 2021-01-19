package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	ArrayList<Song> songs = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		Song song = new Song("demo.mp3");
		song.play();
		song.stop();
				
		JFrame frame = new JFrame();
		JButton shuffleButton = new JButton("Surprise Me!");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		shuffleButton.addActionListener(this);
		frame.add(shuffleButton);
		frame.pack();
		
		Song demo = new Song("demo.mp3");
		songs.add(demo);
		Song forza = new Song("forza.mp3");
		songs.add(forza);
		Song franck = new Song("franck.mp3");
		songs.add(franck);
		Song gold = new Song("gold.mp3");
		songs.add(gold);
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(Song s: songs) {
			s.stop();
		}
		Random r = new Random();
		int x = r.nextInt(4);
		songs.get(x).play();
		
	}
}