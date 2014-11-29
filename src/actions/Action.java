package actions;

import sources.SourceInterface;

public abstract class Action implements ActionInterface {

	protected SourceInterface source = null;

	@Override
	public abstract void setAction() throws Exception;

	@Override
	public void performAction(SourceInterface source) {
		this.source = source;
		this.performAction();
	}

	@Override
	public abstract void performAction();
}
