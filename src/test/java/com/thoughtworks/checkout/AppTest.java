package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class AppTest {
    @Test
    public void testSingle() throws Exception {
        String inString =
            "Pizza - Pepperoni,12.99";
        String expectedOutString =
            "*************** RECEIPT ****************\n" +
            "\n" +
            "Pizza - Pepperoni                  12.99\n" +
            "                                --------\n" +
            "Total for 1 items                  12.99\n" +
            "                                ========\n";
        try (
            InputStream in = new ByteArrayInputStream(inString.getBytes("UTF-8"));
            ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(outBytes);
        ) {
            System.setIn(in);
            System.setOut(out);
            App.main(new String[] {});
            String actualOutString = new String(outBytes.toByteArray(), "UTF-8");
            assertThat(actualOutString, is(equalTo(expectedOutString)));
        }
        finally {
            System.setIn(null);
            System.setOut(null);
        }
    }
}
