import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileBackup {

	private Path src;
	private Path dest;
	
	
	FileBackup(String path, String destination){
		src = Paths.get(path);
		
		final String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		destination = timestamp + "-" + destination;
		dest = Paths.get(destination);
	}
	
	
	private void backupFile() {
		try {
			Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
