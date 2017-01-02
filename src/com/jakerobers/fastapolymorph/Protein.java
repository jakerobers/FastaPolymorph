package com.jakerobers.fastapolymorph;

import java.util.LinkedList;
import java.util.TreeMap;

public class Protein implements Component {

  private int id;
  private String chain;
  private LinkedList<Character> start;
  private LinkedList<Character> middle;
  private LinkedList<Character> end;
  private TreeMap<Character, Integer> frequencies;
  private int residueLength;
  
  
  @Override
  public int getId() {
    return 0;
  }

  @Override
  public void setId(int id) {
    
  }

  @Override
  public String getChain() {
    return null;
  }

  @Override
  public void setChain(String chain) {
    
  }

  @Override
  public void addStart(char x) {
    
  }

  @Override
  public void addMiddle(char x) {
    
  }

  @Override
  public void addEnd(char x) {
    
  }

  @Override
  public LinkedList<Character> getStart() {
    return null;
  }

  @Override
  public LinkedList<Character> getMiddle() {
    return null;
  }

  @Override
  public LinkedList<Character> getEnd() {
    return null;
  }
}