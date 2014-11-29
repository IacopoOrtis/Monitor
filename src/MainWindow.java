import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import sources.SourceInterface;
import core.NoticeException;

public class MainWindow {

	private JFrame frmMonitor;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonitor = new JFrame();
		frmMonitor.setTitle("Monitor");
		frmMonitor.setResizable(false);
		frmMonitor.setSize(800, 600);
		frmMonitor.setLocationRelativeTo(null);
		frmMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonitor.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				core.Monitor gestore = new core.Monitor();//factory
				try {
					sources.SourceInterface source = gestore.giveMeNewSource("http");
					source.setName("Pagina web da monitorare");
					source.setSourcePath("http:///www.polito.it");
					source.setDescription("Questa è una breve descrizione");
					/*
					 * if (source.getSource()) { source.view_changes(); }
					 */
					List<SourceInterface> ss = new ArrayList<SourceInterface>();
					ss.add(source);

				} catch (NoticeException e1) {
					System.err.println("");
				} catch (Exception e1) {
					System.err.println("");
				}

			}
		});
		btnNewButton.setBounds(6, 16, 43, 29);
		frmMonitor.getContentPane().add(btnNewButton);

		JButton button = new JButton("-");
		button.setBounds(41, 16, 43, 29);
		frmMonitor.getContentPane().add(button);

		JList list = new JList();
		list.setBounds(6, 45, 248, 341);
		frmMonitor.getContentPane().add(list);
		this.frmMonitor.setVisible(true);
	}
}
