import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class sourcesCntrl 
{
	// open browser and link
	public void openLink(String url) throws IOException, URISyntaxException
	{
		Desktop dt = Desktop.getDesktop();
		dt.browse(new URI (url)); // open the url using the default browser
	}
	
}
