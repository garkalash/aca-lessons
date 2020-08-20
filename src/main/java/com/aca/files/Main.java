package com.aca.files;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author: garik
 * @created" 8/4/2020, 9:09 PM
 */

class InputOuputStreamExample{
    public void testStreams() throws IOException {
        try (InputStream in = new FileInputStream("input.txt");
             OutputStream out = new FileOutputStream("output.txt")) {
            int resultByte;
            while((resultByte = in.read()) != -1){
                out.write(resultByte);
            }
        }
    }
}

class MoreConvenientInOut{
    public void testStreams() throws IOException {
        String content = new String(Files.readAllBytes(Path.of("input.txt")), StandardCharsets.UTF_8);
        List<String> lines = Files.readAllLines(Path.of(""));
        Stream<String> linesStream = Files.lines(Path.of(""));
    }
}

class RandomAccesExample{
    public void test() throws FileNotFoundException {
        //r, rw, rws, rwd
        RandomAccessFile randomAccessFile = new RandomAccessFile("", "r");
    }
}

class UnicodeExample {
    public void testCharsets(){
        String japaneseStr = "たくさん";
        System.out.println(japaneseStr);

        byte[] bytes = japaneseStr.getBytes();

        System.out.println(new String(bytes, StandardCharsets.US_ASCII));
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        System.out.println(new String(bytes, StandardCharsets.UTF_16));
        System.out.println(new String(bytes, StandardCharsets.ISO_8859_1));
    }
}

class PathExample{
    private Path path;

    public Path createPath(){
        path = Paths.get("X", "f1", "f2", "file.txt");
        System.out.println("Path created: " + path.toString());
        return path;
    }
}

class RegexExample {
    private final String text = "))RegExr 9898 was created by gskinner.com, 56 and is proudly hosted by Media Temple.\n\n "+
            "Edit the Expression & Text to see matches. Roll over matches or the expaaaaaaaaression for details. PCRE & JavaScript flavors of RegEx are supported. Validate your expression with Tests mode.\n\n " +
            "The side bar includes a Cheatsheet, full Reference, and H888elp. You can also Save & Share with the Community, and view patterns you create or favorite in My Patterns.\n\n " +
            "Explore results with the Tools below. Replace & List output custom results. Details lists capture groups. Explain describes your expression in plain English.";


    public void printGroups(String regex){

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        while (m.find()){
            System.out.println(m.group());
        }
    }

    public void printMatchDetails(String regex){

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        System.out.println("Regex: " + regex + (m.find() ? ">>>>>>>>>> Matches " : ">>>>>>>>>>>>>>>>>>> No Matches"));
    }
}

class Person implements Serializable {
    private static final Long serialVersionUID = 2L;
    private transient String fbPassword;
}



public class Main {
    public static void main(String[] args) throws IOException {
        RegexExample pathExample = new RegexExample();
        System.out.println("printing chars >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\w");

        System.out.println("printing non chars >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\W");

        System.out.println("printing words >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\w+");

        System.out.println("printing non words >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\W+");


        System.out.println("printing digits >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\d");

        System.out.println("printing non digits >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\D");


        System.out.println("printing numbers >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\d+");

        System.out.println("printing non numbers >>>>>>>>>>>>>>>>>>..");
        pathExample.printGroups("\\D+");

        System.out.println("check any given character");
        pathExample.printMatchDetails("[abc]");
        pathExample.printMatchDetails("[^abc]");
        pathExample.printMatchDetails("a{4}");
        pathExample.printMatchDetails("reg|Reg");
    }
}
