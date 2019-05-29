package IO;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    public
    static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }
    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dir = new ArrayList<>();
        public Iterator<File> iterator(){
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dir.addAll(other.dir);
        }
        @Override
        public String toString(){
            //TODO
            return "dir: " + PPrint.pformat(dir)+"\n\nfiles: " + PPrint.pformat(files);
        }
    }
    static TreeInfo recurseDirs(File startDir, String regex){
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()){
            if (item.isDirectory()){
                result.dir.add(item);
                result.addAll(recurseDirs(item,regex));
            }else if (item.getName().matches(regex))
                    result.files.add(item);
        }
        return result;
    }
    public static TreeInfo walk(String start, String regex){
        return recurseDirs(new File(start),regex);
    }
    public static  TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }
    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }
    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }
    public static void main(String[] argv) throws IOException {
        File old = new File ("E:\\新建文件夹\\1.txt");
        File rename = new File ("E:\\2.txt");
        old.createNewFile();
        old.renameTo(rename);
    }

}
