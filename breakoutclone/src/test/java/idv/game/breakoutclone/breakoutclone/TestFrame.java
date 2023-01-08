package idv.game.breakoutclone.breakoutclone;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idv.game.breakoutclone.breakoutclone.collider.BaseRectangle;
import idv.game.breakoutclone.breakoutclone.collider.Rectangle;
import idv.game.breakoutclone.frame.graphics.paint.ColliderPainter;
import idv.game.breakoutclone.frame.graphics.paint.CollisionPainter;
import idv.game.breakoutclone.frame.graphics.paint.Painter;
import idv.game.breakoutclone.system.physics.Physics;
import idv.game.breakoutclone.system.physics.Point;
import idv.game.breakoutclone.system.physics.Ray;
import idv.game.breakoutclone.system.physics.RayCastHit;

public class TestFrame extends JFrame {
	private final static String UNIT = "UNIT";
	private final static String SIMULATOR = "SIMULATOR";

	private JPanel contentPane;
	private JPanel panel_unit;
	private JPanel panel_show;
	private JLabel lblInfo;

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

		panel_show = new JPanel();
		contentPane.add(panel_show, BorderLayout.CENTER);
		panel_show.setLayout(new CardLayout(0, 0));

		panel_unit = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Painter painter = new ColliderPainter();
				BaseRectangle rect = new Rectangle(111, 33);
				//BaseRectangle rect = new RoundedRectangle(111,35,18);
				//BaseRectangle rect = new Circle(111);

				painter.paint(g, rect);
			}

		};
		panel_show.add(panel_unit, UNIT);

		JPanel panel_simulator = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				CollisionPainter painter = new CollisionPainter();
				Point p0 = new Point(100, 100);
				Point nextMove = Physics.nextMove(p0, 200, 60);

				Point t1 = new Point(100, 200);
				Point t2 = new Point(500, 300);

				Ray ray = new Ray(p0, nextMove);
				Ray ray2 = new Ray(t1, t2);

				painter.paint(g, ray);
				painter.paint(g, ray2);

				RayCastHit hit = new RayCastHit();
				boolean isCollided = Physics.RaycastTest(ray, ray2, hit, 200);

				painter.paint(g, hit.getCollidePoint());
				if (!isCollided) {
					lblInfo.setText("沒有碰撞");
				} else {
					lblInfo.setText(hit.getCollidePoint().toString());
				}

			}
		};
		panel_show.add(panel_simulator, SIMULATOR);

		JPanel panel_title = new JPanel();
		contentPane.add(panel_title, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("UNIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) panel_show.getLayout();
				layout.show(panel_show, "UNIT");
			}
		});
		panel_title.add(btnNewButton);

		JButton btnSimulator = new JButton("SIMULATOR");
		btnSimulator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) panel_show.getLayout();
				layout.show(panel_show, "SIMULATOR");
			}
		});
		panel_title.add(btnSimulator);

		JPanel panel_infomation = new JPanel();
		panel_infomation.setPreferredSize(new Dimension(10, 30));
		contentPane.add(panel_infomation, BorderLayout.SOUTH);

		lblInfo = new JLabel("");
		panel_infomation.add(lblInfo);
	}

}
