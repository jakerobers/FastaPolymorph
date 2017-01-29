package com.jakerobers.fastapolymorph.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jakerobers.fastapolymorph.FastaSolution;

public class BaseTen {

  
  @Test
  public void testBaseTenA() {
    String a = "A";
    int aExpected = 1;
    assertEquals(aExpected, FastaSolution.getBaseTen(a));
  }
  
  @Test
  public void testBaseTenZ() {
    String z = "Z";
    int zExpected = 26;
    assertEquals(zExpected, FastaSolution.getBaseTen(z));
  }
  
  @Test
  public void testBaseTenJ() {
    String j = "J";
    int jExpected = 10;
    assertEquals(jExpected, FastaSolution.getBaseTen(j));
  }
  
  @Test
  public void testBaseTenAA() {
    String aa = "AA";
    int aaExpected = 27;
    assertEquals(aaExpected, FastaSolution.getBaseTen(aa));
  }

  @Test
  public void testBaseTenAB() {
    String aa = "AB";
    int aaExpected = 28;
    assertEquals(aaExpected, FastaSolution.getBaseTen(aa));
  }
}
