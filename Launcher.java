import javax.swing.SwingUtilities;


public class Launcher {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){ // runs everything on the same thread
		@Override
			public void run() {
				MainMenu main = new MainMenu();
				
			}
		});
	}
}
