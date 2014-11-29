package sources;

public interface SourceInterface {

	public boolean getSource();

	public Outcome confront(SourceInterface source);

	public void view_changes();

	public void setSourcePath(String string) throws Exception;

	public void setName(String string) throws Exception;

	public void setDescription(String string);

	public String getSourcePath() throws Exception;

	public String getName() throws Exception;

	public String getDescription() throws Exception;

	public boolean setCheckTime(Interval interval);

	public void clearAllChecks();

	public Interval get_next_check_time();
}
