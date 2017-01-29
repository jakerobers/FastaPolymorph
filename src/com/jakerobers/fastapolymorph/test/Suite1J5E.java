package com.jakerobers.fastapolymorph.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import org.junit.Test;

import com.jakerobers.fastapolymorph.FastaSolution;
import com.jakerobers.fastapolymorph.Sequence;

public class Suite1J5E {

  @Test
  public void a() throws Exception {
    final BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/test_files/1j5e.pdb"));

    final FastaSolution s = new FastaSolution(in);

    //final BufferedReader out = new BufferedReader(
    //    new FileReader(System.getProperty("user.dir") + "/datapub/1j5e.fasta"));
    
    Map<String, Sequence> solution = s.solve();
    for (String k : solution.keySet()) {
      System.out.println(solution.get(k));
      System.out.println("\n");
    }
    
    //final int expected = Integer.parseInt(out.readLine());
    //out.close();

    //assertEquals(expected, s.solve());
  }

}
