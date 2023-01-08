package idv.game.breakoutclone.breakoutclone;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idv.game.breakoutclone.breakoutclone.collider.BaseRectangle;
import idv.game.breakoutclone.breakoutclone.collider.Rectangle;
import idv.game.breakoutclone.frame.graphics.paint.CollidePainter;
import idv.game.breakoutclone.frame.graphics.paint.Painter;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_single;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_show = new JPanel();
		contentPane.add(panel_show, BorderLayout.CENTER);
		panel_show.setLayout(new CardLayout(0, 0));

		panel_single = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Painter painter = new CollidePainter();
				BaseRectangle rect = new Rectangle(111,33);
				//BaseRectangle rect = new RoundedRectangle(111,35,18);
				//BaseRectangle rect = new Circle(111);

				painter.paint(g, rect);
			}

		};
		panel_show.add(panel_single, "name_160665681809900");

		JPanel panel_2 = new JPanel();
		panel_show.add(panel_2, "name_160677595925900");

		JPanel panel_title = new JPanel();
		contentPane.add(panel_title, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("SINGLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_single.repaint();
			}
		});
		panel_title.add(btnNewButton);
	}

}
