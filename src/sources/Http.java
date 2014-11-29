package sources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http extends Source {

	/**
	 * empty constructor
	 */
	public Http() {
	}

	/**
	 * Constructor with source
	 * 
	 * @param source_path
	 *            path of the source
	 * @throws Exception
	 */
	public Http(String source_path) throws Exception {
		super(source_path);
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
	public Http(String source_path, String name) throws Exception {
		super(source_path, name);
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
	public Http(String source_path, String name, String description) throws Exception {
		super(source_path, name, description);
	}

	/**
	 * This gets the source
	 */
	@Override
	public boolean getSource() {
		this.source_body = "";
		try {
			URL url = new URL(this.source_path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				this.source_body += line;
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Outcome confront(SourceInterface source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void view_changes() {
		// TODO Auto-generated method stub		
	}

}
