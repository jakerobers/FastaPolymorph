package com.jakerobers.fastapolymorph;

import java.util.Map;
import java.util.TreeMap;

public class AminoAcidLookup {

  private Map<String, Character> aminoAcidLookup;

  public AminoAcidLookup() {
    aminoAcidLookup = new TreeMap<String, Character>();
    aminoAcidLookup.put("ALA", 'A');
    aminoAcidLookup.put("ARG", 'R');
    aminoAcidLookup.put("ASN", 'N');
    aminoAcidLookup.put("ASP", 'D');
    aminoAcidLookup.put("ASX", 'B');
    aminoAcidLookup.put("CYS", 'C');
    aminoAcidLookup.put("GLU", 'E');
    aminoAcidLookup.put("GLN", 'Q');
    aminoAcidLookup.put("GLX", 'Z');
    aminoAcidLookup.put("GLY", 'G');
    aminoAcidLookup.put("HIS", 'H');
    aminoAcidLookup.put("ILE", 'I');
    aminoAcidLookup.put("LEU", 'L');
    aminoAcidLookup.put("LYS", 'K');
    aminoAcidLookup.put("MET", 'M');
    aminoAcidLookup.put("PHE", 'F');
    aminoAcidLookup.put("PRO", 'P');
    aminoAcidLookup.put("SER", 'S');
    aminoAcidLookup.put("THR", 'T');
    aminoAcidLookup.put("TRP", 'W');
    aminoAcidLookup.put("TYR", 'Y');
    aminoAcidLookup.put("VAL", 'V');
  }

  public char getSmall(String key) {
    return this.aminoAcidLookup.get(key);
  }
}
