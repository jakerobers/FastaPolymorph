package com.jakerobers.fastapolymorph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class FastaSolution {

  BufferedReader in;

  public FastaSolution(BufferedReader in) {
    this.in = in;
  }

  public int solve() throws IOException {
    Stream<String> stream = this.in.lines();
    Map<String, Component> fastaData = new HashMap<String, Component>();
    
    boolean shouldParseRemark = false;
    
    stream.forEach((line) -> {
      final StringTokenizer lineParts = new StringTokenizer(line);
      final String key = lineParts.nextToken();

      switch(key) {
        case "COMPND": 
          FastaActions.processCompound(fastaData, lineParts);
          break;
        case "REMARK":
          String code = lineParts.nextToken();
          if (code.equals("465")) {
            if (shouldParseRemark) {
             FastaActions.processRemark(fastaData, lineParts);
            } else if(lineParts.nextToken().equals("M")) {
              shouldParseRemark = true;
            }
          }
          break;
        case "ATOM":
          FastaActions.processesAtom(fastaData, lineParts);
          break;
      }
    });
    
    return -1;
  }
}
