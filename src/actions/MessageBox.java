package actions;

import javax.swing.JOptionPane;

public class MessageBox extends Action {

	private String message = "";

	/**
	 * This function will set the message to visualize. It will ask with an
	 * input box.
	 */
	@Override
	public void setAction() throws Exception {
		JOptionPane.showInputDialog("Write the message you want to visualize once the action is performed.", this.message);
		String message = new String();
		if (message.length() < 5)
			throw new Exception("The message is too short please set longer one.");
		this.message = message;

	}

	/**
	 * This function will show the message in a box.
	 */
	@Override
	public void performAction() {
		JOptionPane.showMessageDialog(null, this.message);
	}
}
