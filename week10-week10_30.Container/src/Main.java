
import containers.ProductContainerRecorder;


public class Main {

    public static void main(String[] args) {
        // write test code here
        ProductContainerRecorder recorder = new ProductContainerRecorder("Soap", 10.0, 5.0);
        recorder.addToTheContainer(3);
        System.out.println(recorder.history());
    }

}
