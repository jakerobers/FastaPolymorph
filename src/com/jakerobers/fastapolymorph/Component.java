package com.jakerobers.fastapolymorph;

import java.util.LinkedList;

public interface Component {
  
  public int getId();
  public void setId(int id);
  public String getChain();
  public void setChain(String chain);
  public void addStart(char x);
  public void addMiddle(char x);
  public void addEnd(char x);
  public LinkedList<Character> getStart();
  public LinkedList<Character> getMiddle();
  public LinkedList<Character> getEnd();
}
