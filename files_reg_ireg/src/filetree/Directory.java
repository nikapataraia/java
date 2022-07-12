package filetree;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Directory extends File {

	private final List<File> files;
	private final List<File> newlist = new ArrayList<>();

	public Directory(Path path, List<File> files) throws IOException {
		super(path);
		this.files = files;
		newlist.add(this);
		addalltonewlist(files);
	}

	private void addalltonewlist(List<File> input) throws IOException {
		for(File file:input){
			if(file.isRegularFile()){
				newlist.add(file);
			}
			else{
				newlist.add(file);
				addalltonewlist(((Directory) file).getFiles());
			}
		}
	}

	@Override
	public Iterator<File> iterator() {

		return new Iterator<File>() {

			@Override
			public boolean hasNext() {
				return !newlist.isEmpty();
			}

			@Override
			public File next() {
				if(hasNext()){
				File saved = newlist.get(0);
				newlist.remove(0);
				return saved;
				}
				else throw new NoSuchElementException();
			}
		};
	}

	@Override
	public int getHeight() {
		if(files.size() == 0) return 0;
		int max = 0;
		int compareator = 0;
		for(File file : files){
			compareator = 	file.getHeight();
			if(compareator > max) max = compareator;
		}
		return max + 1;
	}

	@Override
	public boolean isRegularFile() {
		return false;
	}

	public List<File> getFiles() {
		return files;
	}

}
