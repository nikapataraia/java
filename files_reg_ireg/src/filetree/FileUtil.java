package filetree;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static File toFileRepresentation(Path path) throws IOException {
		if(!Files.exists(path)){
			return null;
		}
		if(Files.isRegularFile(path)){
			return new RegularFile(path);
		}
		else{
			List<File> directorylist = new ArrayList<>();
			if(Files.isDirectory(path)){
				Files.list(path).forEach(path1 -> {
					try {
						File mychildren = toFileRepresentation(path1);
						if(mychildren !=null){
							directorylist.add(mychildren);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} );
			}
			return new Directory(path,directorylist);
		}
	}
}
