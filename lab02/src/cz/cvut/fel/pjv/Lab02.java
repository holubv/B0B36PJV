/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;

public class Lab02 {


    public void homework(String[] args) {

        NumberReader reader = new NumberReader(System.in, 10);

        reader.setHandler((buffer, len) -> {
            double mean = computeMean(buffer, len);
            double sd = computeSD(buffer, len, mean);

            System.out.println(String.format("%2d %.3f %.3f", len, mean, sd));
        });

        reader.read();
    }

    public double computeMean(double[] numbers, int length) {
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += numbers[i];
        }
        return sum / length;
    }

    public double computeSD(double[] numbers, int length, double mean) {

        double sd = 0;

        for (int i = 0; i < length; i++) {
            sd += Math.pow(numbers[i] - mean, 2);
        }

        return Math.sqrt(sd / length);
    }
}

/* end of Lab02.java */
