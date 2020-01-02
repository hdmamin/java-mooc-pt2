import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder output = new StringBuilder();
        int length = t.length;
        output.append("{");
        for (int i=0; i<length; i++) {
            if (i % 4 == 0) {
                output.append("\n ");
            }
            output.append(t[i]);
            if (i < length-1) {
                output.append(", ");
            }
        }
        output.append("\n}");
        return output.toString();
    }
}
