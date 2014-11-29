package actions;

import sources.SourceInterface;

public interface ActionInterface {
	/**
	 * This method should set-up / modify the action settings. It is
	 * independent: a window if necessary will appear to change settings. All
	 * managed by this call.
	 * 
	 * @throws Exception
	 *             It throws an exception
	 */
	public void setAction() throws Exception;

	/**
	 * This function should perform the action. All managed by the method.
	 */
	public void performAction();

	/**
	 * This function should perform the action. All managed by the method.
	 * 
	 * @param source
	 *            The source that has triggered the event
	 */
	public void performAction(SourceInterface source);
}
