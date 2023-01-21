package idv.game.breakoutclone.breakoutclone.testframe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.collider.Rectangle;
import idv.game.breakoutclone.gameobject.GameObject;
import idv.game.breakoutclone.system.Scenes;
import idv.game.breakoutclone.system.physics.Point;

public class TestFrame extends JFrame {
	private final static String UNIT = "UNIT";
	private final static String SIMULATOR = "SIMULATOR";

	private JPanel contentPane;
	private JPanel panel_unit;
	private JPanel panel_show;
	private JLabel lblInfo2;
	private JLabel lblInfo3;
	private JLabel lblInfo1;
	private JLabel lblInfo4;

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
				UnitPanelPaintable paintable = new UnitPanelPaintable();
				paintable.paint(g);
			}

		};
		panel_show.add(panel_unit, UNIT);

		JPanel panel_simulator = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				SimulationPanelPaintable paintable = new SimulationPanelPaintable();
				paintable.setLblInfo1(lblInfo1);
				paintable.setLblInfo2(lblInfo2);
				paintable.setLblInfo3(lblInfo3);
				paintable.setLblInfo4(lblInfo4);
				paintable.paint(g);

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
		contentPane.add(panel_infomation, BorderLayout.SOUTH);
		panel_infomation.setLayout(new BoxLayout(panel_infomation, BoxLayout.Y_AXIS));

		lblInfo1 = new JLabel("");
		panel_infomation.add(lblInfo1);

		lblInfo2 = new JLabel("");
		panel_infomation.add(lblInfo2);

		lblInfo3 = new JLabel("");
		panel_infomation.add(lblInfo3);

		lblInfo4 = new JLabel("");
		panel_infomation.add(lblInfo4);
	}

}
