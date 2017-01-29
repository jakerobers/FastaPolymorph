package com.jakerobers.fastapolymorph;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class FastaSolution {

  public static final String NUMBER_REGEX = "[0-9]+";
  BufferedReader in;
  AminoAcidLookup lookupTable;

  public FastaSolution(BufferedReader in) {
    this.in = in;
    this.lookupTable = new AminoAcidLookup();
  }

  public Map<String, Sequence> solve() throws Exception {
    Map<String, Sequence> fastaData = new HashMap<String, Sequence>();

    // Values for COMPD parsing.
    String nextMolecule = null;
    String nextMolId = null;
    boolean isProtein = false;

    //values for ATOM parsing
    String lastId = "-1"; // The sequence begins at 0.

    for (String line = this.in.readLine(); line != null; line = this.in.readLine()) {
      final String key = line.substring(0, 6).trim();

      switch(key) {
      case "COMPND": 
        String tail = line.substring(10);
        String[] parts = tail.split(":");
        String subject = parts[0].trim();
        String value = parts[1].trim();
        
        if (value.charAt(value.length()-1) == ';') {
          value = value.substring(0, value.length()-1);
        }

        if (subject.equals("MOL_ID")) {
          nextMolId = value;
        } else if (subject.equals("MOLECULE")) {
          if (value.contains("PROTEIN")) {
            isProtein = true;
          }
          nextMolecule = value.replaceFirst("RIBOSOMAL ", "r");
        } else if (subject.equals("CHAIN")) {
          if (nextMolId == null) {
            throw new Exception("Error reading pdb: COMPND MOL_ID must be provided for all entities");
          }
          
          if (nextMolecule == null) {
            throw new Exception("Error reading pdb: COMPND MOLECULE must be provided for all entities");
          }

          fastaData.put(value, new Sequence(nextMolId, nextMolecule, isProtein, value));
          nextMolId = null;
          nextMolecule = null;
        }
        break;
      case "ATOM":
        String acid = line.substring(17, 20).trim();
        char acidShort;
        if (acid.length() > 1) {
          acidShort = this.lookupTable.getSmall(acid);
        } else {
          acidShort = acid.charAt(0);
        }
        String chain = line.substring(21, 22);
        String sequenceId = line.substring(22, 28).trim();
        
        if (!sequenceId.equals(lastId)) {
         Sequence next = fastaData.get(chain);
         
         for (int i = 0; i < FastaSolution.getSequenceDifference(lastId, sequenceId)-1; i++) {
           next.addSegment(null, '-');
         }
         
         next.addSegment(sequenceId, acidShort);
        }
        lastId = sequenceId;
        break;
      }
    }

    return fastaData;
  }
  
  public static int getSequenceDifference(String a, String b) {
    int aIndex = 0;
    int bIndex = 0;
    
    for (int i = 0; i < a.length(); i++) {
      if ((int)a.charAt(i) > 64) {
        aIndex = i;
        break;
      }
    }
    
    for (int i = 0; i < b.length(); i++) {
      if ((int)b.charAt(i) > 64) {
        bIndex = i;
        break;
      }
    }
    
    int aSum = 0;
    int bSum = 0;
    
    if (aIndex > 0) {
      aSum = FastaSolution.getBaseTen(a.substring(aIndex, a.length())) + Integer.parseInt(a.substring(0, aIndex));
    } else {
      aSum = Integer.parseInt(a);
    }
    
    if (bIndex > 0) {
      bSum = FastaSolution.getBaseTen(b.substring(bIndex, b.length())) + Integer.parseInt(b.substring(0, bIndex));
    } else {
      bSum = Integer.parseInt(b);
    }
    
    return bSum - aSum;
    
  }
  
  /**
   * Converts from base 26 to base 10.
   * @param a The integer represented in base26 as [A-Z]
   * @return The integer in base 10
   */
  public static int getBaseTen(String a) {
    int total = 0;
    for (int i = a.length()-1; i >= 0; i--) {
      total += ((a.length()-1-i)*26)+(((int)(a.charAt(i)))-65);
    }
    return total+1;
  }
}
