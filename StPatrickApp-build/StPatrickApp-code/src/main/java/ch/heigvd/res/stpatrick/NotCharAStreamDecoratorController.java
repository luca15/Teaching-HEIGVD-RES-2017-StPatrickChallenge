package ch.heigvd.res.stpatrick;

import java.io.*;

/**
 * Created by luca on 20.03.17.
 */
public class NotCharAStreamDecoratorController implements IStreamDecoratorController {

    class DecorateWriter extends FilterWriter {
        public DecorateWriter(Writer writer) {
            super(writer);
        }

        public void write(int c) throws IOException {
            if (c != 'a' && c != 'A') {
                super.write(c);
            }
        }

        public void write(char[] cbuff, int off, int len) throws IOException {
            for (int i = off; i < off + len; i++) {
                write(cbuff[i]);
            }
        }

        public void write(String cbuff, int off, int len) throws IOException {
            for (int i = off; i < off + len; i++) {
                write(cbuff.charAt(i));
            }
        }
    }

    public Reader decorateReader(Reader inputReader) {
        return inputReader;
    }

    public Writer decorateWriter(Writer outputWriter) {
        DecorateWriter writer = new DecorateWriter(outputWriter);

        return writer;
    }
}
