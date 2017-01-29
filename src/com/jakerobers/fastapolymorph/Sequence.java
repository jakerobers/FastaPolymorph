package com.jakerobers.fastapolymorph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Sequence {

  private int id;
  private String chain;
  private String molecule;
  private LinkedList<Character> segment;
  private Map<Character, Integer> frequencies;
  private Map<String, Character> segmentById;
  private String type;
  
  public Sequence(String id, String molecule, boolean isProtein, String chain) {
    this.id = Integer.parseInt(id);
    this.molecule = molecule;
    this.chain = chain;
    this.frequencies = new TreeMap<Character, Integer>();
    this.segment = new LinkedList<Character>();
    this.segmentById = new HashMap<String, Character>();
    
    if (isProtein) {
      this.type = "aa";
    } else {
      this.type = "nt";
    }
  }

  public String getType() {
    return this.type;
  }
  
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getMolecule() {
    return this.molecule;
  }
  
  public void setMolecule(String molecule) {
    this.molecule = molecule;
  }

  public String getChain() {
    return this.chain;
  }

  public void setChain(String chain) {
    this.chain = chain;
  }

  public void addSegment(String id, char x) {
    if (this.frequencies.containsKey(x)) {
      this.frequencies.put(x, this.frequencies.get(x)+1);
    } else {
      this.frequencies.put(x, 1);
    }
    this.segment.add(x);
    
    if (id != null) {
     this.segmentById.put(id, x);
    }
  }

  public LinkedList<Character> getSegment() {
    return this.segment;
  }
  
  public String toString() {
    String retVal = ">"+this.molecule + " Chain " + this.chain + ", length: " + this.segment.size() + " "+ this.getType() +"          ";
    for (Character k : this.frequencies.keySet()) {
      if (k != '-') {
       retVal += k + ": " + this.frequencies.get(k) + ", ";
      }
    }
    retVal = retVal.substring(0, retVal.length()-2); //remove trailing comma/space
    retVal += "\n";

    int count = 1;
    for (Character s : this.segment) {
      retVal += s;
      if (count >= 60) {
        retVal += "\n";
        count = 0;
      }
      count++;
    }
    
    return retVal;
  }
}
