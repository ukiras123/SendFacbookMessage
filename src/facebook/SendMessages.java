package facebook;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openqa.selenium.WebDriver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendMessages {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMessages window = new SendMessages();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SendMessages() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Just Say I Love You");
		frame.setBounds(100, 100, 288, 166);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // main
				WebDriver driver = null;
				driver = new Base(driver).login();
				new SendMessage(driver).sendMessage();

			}
		});
		btnSendMessage.setBounds(56, 51, 156, 23);
		frame.getContentPane().add(btnSendMessage);
	}

}
