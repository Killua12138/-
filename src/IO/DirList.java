package IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;


public class DirList {
    public List<String> dirList(String name){
         List<String> dir = new ArrayList<>();
         File path = new File(".");
         if (name.length() == 0){
             dir = Arrays.asList(path.list());
         }
         else{
             dir = Arrays.asList(path.list(new DirFilter(name)));
         }
         dir.sort(String.CASE_INSENSITIVE_ORDER);
         return dir;
    }
    public static void main(String[] argv){
        DirList test = new DirList();
        List<String> list = test.dirList("");
        for (String str : list){
            System.out.println(str);
        }
        File path = new File(".");
        for (String str : path.list())
            System.out.println(str);
    }

}
class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
