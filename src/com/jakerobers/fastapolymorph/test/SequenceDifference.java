package com.jakerobers.fastapolymorph.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jakerobers.fastapolymorph.FastaSolution;

public class SequenceDifference {

  @Test
  public void a() {
    String a = "100A";
    String b = "100C";
    int expected = 2;
    int actual = FastaSolution.getSequenceDifference(a, b);
    
    assertEquals(expected, actual);
  }
  
  @Test
  public void b() {
    String a = "100AA";
    String b = "100AD";
    int expected = 3;
    int actual = FastaSolution.getSequenceDifference(a, b);
    
    assertEquals(expected, actual);
  }
  
  @Test
  public void c() {
    String a = "100";
    String b = "100";
    int expected = 0;
    int actual = FastaSolution.getSequenceDifference(a, b);
    
    assertEquals(expected, actual);
  }
  
  @Test
  public void d() {
    String a = "100";
    String b = "100B";
    int expected = 2;
    int actual = FastaSolution.getSequenceDifference(a, b);
    
    assertEquals(expected, actual);
  }
}
