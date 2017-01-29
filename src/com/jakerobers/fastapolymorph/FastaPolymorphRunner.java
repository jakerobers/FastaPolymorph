package com.jakerobers.fastapolymorph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * A simple PDB to Fasta converter
 * @author jake
 *
 *
 * Todo List:
 * setup assertions
 * sequence RNA (whatever that means)
 * find length of RNA
 * Find frequencies of the four nucleotides
 * Specify the type of molecule (found before ATOM/HETATM records). This can be something like 16S rRNA.
 * Verify the Chain letter
 * Verify each line for the sequence has 60 nucleotides
 * Verify that these are 1-letter symbols
 * 
 * Print sequence of each protein of the 20 amino acids in the protein.
 * Print the length of each of the 20 amino acid proteins
 * Print the frequencies of the 20 amino acid proteins
 * Verify that each line of the sequence contains 60 amino acids.
 * Verify that the output is written to a single text file with this information. This filepath should be specified with the -o argument or default to output.fasta 
 */
public class FastaPolymorphRunner {
  public static void main(String[] args) throws Exception {

    final String[] help = {
        "All inputs must be a pdb filetype -- regardless of whehther the file ends .pdb",
        "The output file will be a fasta file and also print out information regarding the results",
        "If the --output is not provided, the results will be printed to the console",
        "If the --input is not provided, the input will be prompted in the console",
        "",
        "Options:",
        "--input=input_filename.pdb",
        "--output=output_filename.fasta",
        "",
        "Usage:",
        "java -jar fastaPolymorph --input=my_pdb_file.pdb --output=my_fasta_file.fasta",
        "",
    };

    BufferedWriter out = null;
    BufferedReader in = null;

    for (int i = 0; i < args.length; i++) {
      String[] arg = args[i].split("=");
      if (arg[0].equals("--input")) {
        in = new BufferedReader(new FileReader(arg[1]));
      } else if (arg[0].equals("--output")) {
        System.out.println("file: " + arg[1]);
        out = new BufferedWriter(new FileWriter(arg[1]));
      } else if (arg[0].equals("--help") || arg[0].equals("-h")) {
        for (String s : help) {
          System.out.println(s);
        }
        System.exit(0);
      } else {
        System.out.println("Unknown argument: " + arg[0] + ". use -h or --help for options.");
        System.exit(0);
      }
    }

    if (in == null) {
      in = new BufferedReader(new InputStreamReader(System.in));
    }

    if (out == null) {
      out = new BufferedWriter(new OutputStreamWriter(System.out));
    } 

    Map<String, Sequence> solution = new FastaSolution(in).solve();
    for (String k : solution.keySet()) {
      out.write(solution.get(k) + "");
      out.write("\n");
    }
    out.close();
  }
}
