package com.jakerobers.fastapolymorph.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.jakerobers.fastapolymorph.FastaSolution;

public class Suite4YY3 {
  @Test
  public void a() throws Exception {
    final BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/test_files/4yy3.pdb"));
    //final FastaSolution s = new FastaSolution(in);

    //final BufferedReader out = new BufferedReader(
        //new FileReader(System.getProperty("user.dir") + "/datapub/4yy3.fasta"));
    //final int expected = Integer.parseInt(out.readLine());
    //out.close();

    //assertEquals(expected, s.solve());
  }
}
