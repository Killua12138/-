package IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] argv){
        File path = new File(".");
        String[] list;
        if (argv.length == 0)
            list = path.list();
        else
            list = path.list(DirList2.filter(argv[0]));
        for (String dirItem:list)
            System.out.println(dirItem);
    }

}
