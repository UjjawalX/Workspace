package main;

import model.Work;

import java.io.*;
import java.util.List;

public abstract class InputSource {
    public abstract List<? extends Object> read(InputStream inputStream) throws Exception;
}
