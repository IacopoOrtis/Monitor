package sources;

import java.util.List;

import core.NoticeException;

/**
 * 
 * Generic source definition class
 * 
 * @author Iacopo Ortis
 *
 */
public abstract class Source implements SourceInterface {

	String name = ""; // name of the source
	String description = ""; // description of the source
	String source_path = ""; // path of the source
	String source_body = ""; // binary of the source

	List<Interval> interval; // list of intervals

	@Override
	abstract public boolean getSource();

	@Override
	abstract public Outcome confront(SourceInterface source);

	@Override
	abstract public void view_changes();

	/**
	 * Empty constructor.
	 */
	public Source() {
	}

	/**
	 * Constructor with source
	 * 
	 * @param source_path
	 *            path of the source
	 * @throws Exception
	 */
	public Source(String source_path) throws Exception {
		this.setSourcePath(source_path); // it sets the source path
	}

	/**
	 * Constructor with path source and source name
	 * 
	 * @param source_path
	 *            path of the source
	 * @param name
	 *            name of the source
	 * @throws Exception
	 */
	public Source(String source_path, String name) throws Exception {
		this.setSourcePath(source_path); // it sets the source path
		this.setName(name); // it sets the name
	}

	/**
	 * Constructor with path source, source name and descritpion source
	 * 
	 * @param source_path
	 *            path of the source
	 * @param name
	 *            name of the source
	 * @param description
	 *            description of the source
	 * @throws Exception
	 */
	public Source(String source_path, String name, String description) throws Exception {
		this.setSourcePath(source_path); // it sets the source path
		this.setName(name); // it sets the name
		this.setDescription(description); // it sets the description
	}

	/**
	 * 
	 * @param source_path
	 *            it sets the source path
	 * @throws Exception
	 */
	@Override
	public void setSourcePath(String source_path) throws Exception {
		if (source_path.length() < 5) {
			throw new Exception("You are tryng to set a short source_path. Chose a longer one.");
		} else {
			this.source_path = source_path;
		}
	}

	/**
	 * 
	 * @param name
	 *            it sets the name
	 * @throws Exception
	 */
	@Override
	public void setName(String name) throws Exception {
		if (name.length() < 5) {
			throw new Exception("You are tryng to set a short name. Chose a longer one.");
		} else {
			this.name = name;
		}
	}

	/**
	 * 
	 * @param description
	 *            it sets the description of the source
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * It return the source path
	 * 
	 * @return source path
	 * @throws Exception
	 */
	@Override
	public String getSourcePath() throws Exception {
		if (this.source_path == null)
			throw new Exception("The source path has not been set yet!");
		return this.source_path;
	}

	/**
	 * It return the name of the path
	 * 
	 * @return name of the path
	 * @throws Exception
	 */
	@Override
	public String getName() throws Exception {
		if (this.name == null)
			throw new NoticeException("The name of the path has not been set yet!");
		return this.name;
	}

	/**
	 * It return the description of the path
	 * 
	 * @return description of the path
	 * @throws Exception
	 */
	@Override
	public String getDescription() throws Exception {
		if (this.description == null)
			throw new Exception("The description of the path has not been set yet!");
		return this.description;
	}

	/**
	 * This will add a new check to the source object
	 * 
	 * @param interval
	 *            interval to add
	 * @return it returns true if added, false if not added
	 */
	@Override
	public boolean setCheckTime(Interval interval) {
		if (this.interval.add(interval)) {
			this.interval.sort(new IntervalComparator());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * it clears all checks
	 */
	@Override
	public void clearAllChecks() {
		this.interval.clear();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Interval get_next_check_time() {
		if (this.interval.size() > 0) {
			return this.interval.get(0);//FIXME attualmente prende solo il primo
		} else {
			return null;
		}
	}
}