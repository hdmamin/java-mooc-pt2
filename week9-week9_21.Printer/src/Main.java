
public class Main {

    public static void main(String[] args) throws Exception {
        // write some test code here
        // for testing purposes, project has files
        Printer printer = new Printer("src/textfile.txt");
        printer.printLinesWhichContain("vanha");
        printer.printLinesWhichContain("tuo");
        //    src/kalevala.txt
    }
}
