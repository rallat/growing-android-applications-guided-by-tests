package com.github.frankiesardo.gaagbt.framework.converter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;

public class ResourceReader extends Reader {

    private final String fileName;
    private final InputStreamReader delegateReader;

    public ResourceReader(String fileName) {
        this.fileName = fileName;
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        delegateReader = new InputStreamReader(inputStream);
    }

    @Override
    public int read(CharBuffer charBuffer) throws IOException {
        return delegateReader.read(charBuffer);
    }

    @Override
    public int read(char[] chars) throws IOException {
        return delegateReader.read(chars);
    }

    @Override
    public int read(char[] chars, int i, int i2) throws IOException {
        return delegateReader.read(chars, i, i2);
    }

    @Override
    public long skip(long l) throws IOException {
        return delegateReader.skip(l);
    }

    @Override
    public boolean markSupported() {
        return delegateReader.markSupported();
    }

    @Override
    public void mark(int i) throws IOException {
        delegateReader.mark(i);
    }

    @Override
    public void reset() throws IOException {
        delegateReader.reset();
    }

    @Override
    public void close() throws IOException {
        delegateReader.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceReader that = (ResourceReader) o;

        if (!fileName.equals(that.fileName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return fileName.hashCode();
    }
}
