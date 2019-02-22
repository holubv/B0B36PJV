package cz.cvut.fel.pjv;

import java.io.InputStream;
import java.util.Scanner;

public class NumberReader {

    private Scanner scanner;
    private double[] buffer;
    private int bufferIndex;
    private int line;

    private ValueHandler handler = (buffer, len) -> {
    };

    public NumberReader(InputStream is, int groupBy) {
        this.scanner = new Scanner(is);
        this.buffer = new double[groupBy];
    }

    public void read() {
        while (scanner.hasNextLine()) {
            this.line++;

            String line = scanner.nextLine();
            double number;
            try {
                number = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.err.println("A number has not been parsed from line " + this.line);
                continue;
            }

            buffer[bufferIndex] = number;
            bufferIndex++;

            if (bufferIndex == buffer.length) {
                handler.onValues(buffer, bufferIndex);
                bufferIndex = 0;
            }
        }

        System.err.println("End of input detected!");

        if (this.bufferIndex > 1) {
            handler.onValues(buffer, bufferIndex);
        }
    }

    public void setHandler(ValueHandler handler) {
        this.handler = handler;
    }

    public interface ValueHandler {
        void onValues(double[] buffer, int len);
    }
}
