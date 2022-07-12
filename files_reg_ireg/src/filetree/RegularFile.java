package filetree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegularFile extends File {

	public RegularFile(Path path) {
		super(path);
	}

	@Override
	public Iterator<File> iterator() {
		if(Files.exists(getPath())){
			return new Iterator<File>() {
				private int size = 0;
				@Override
				public boolean hasNext() {
					return size == 0;
				}

				@Override
				public File next() {
					if(hasNext()){size++; return RegularFile.this;}
					else throw new NoSuchElementException();
				}
			};
		}
		else throw new NoSuchElementException();
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isRegularFile() {
		return true;
	}

}
