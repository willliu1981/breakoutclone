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

import idv.game.breakoutclone.collider.BaseRectangle;
import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.collider.Rectangle;
import idv.game.breakoutclone.frame.graphics.paint.ColliderPainter;
import idv.game.breakoutclone.frame.graphics.paint.CollisionPainter;
import idv.game.breakoutclone.frame.graphics.paint.Paintable;
import idv.game.breakoutclone.frame.graphics.paint.Painter;
import idv.game.breakoutclone.gameobject.GameObject;
import idv.game.breakoutclone.system.Scenes;
import idv.game.breakoutclone.system.location.Locations;
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

	private void init() {
		GameObject go1 = new GameObject();
		go1.setLocation(new Point(200, 200));
		Collider collider = new Rectangle(200, 160);
		go1.addCollider(collider);
		Scenes.addGameObject(go1);

		GameObject go2 = new GameObject();
		go2.setLocation(new Point(210, 360));
		Collider collider2 = new Rectangle(260, 60);
		go2.addCollider(collider2);
		Scenes.addGameObject(go2);
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		init();

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
				final double rayLength = 558;

				Scenes.getGameObjects().stream().forEach(go -> {
					CollisionPainter goCollisionPainter = new CollisionPainter();
					goCollisionPainter.paint(g, go.getLocation());

					go.getColliders().stream().forEach(c -> {
						ColliderPainter colliderPainter = new ColliderPainter();
						Point translateToWorldLocation = Locations
								.translateToWorldLocation(c, new Point());
						colliderPainter.setX(translateToWorldLocation.x);
						colliderPainter.setY(translateToWorldLocation.y);
						colliderPainter.paint(g, (Paintable) c);
					});
				});

				CollisionPainter collisionPainter = new CollisionPainter();
				Point p0 = new Point(80, 293);
				Point nextMove = Physics.nextMove(p0, rayLength, -12);

				Ray ray = new Ray(p0, nextMove);

				collisionPainter.paint(g, ray);

				RayCastHit hit = new RayCastHit();
				boolean isCollided = Physics.Raycast(ray, hit, rayLength);

				collisionPainter.paint(g, hit.getFirstCollidePoint());
				if (!isCollided) {
					lblInfo.setText("沒有碰撞");
				} else {
					lblInfo.setText(hit.getFirstCollidePoint().toString());
				}

				hit.getHits()
						.forEach(h -> System.out.println(h.getCollidePoint()));

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
