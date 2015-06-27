// import ANTLR's runtime libraries

package br.ufrgs.inf.tlbellini.tcc;

import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Main {
    public static void main(String[] args) throws Exception {
    	
    	Scanner sc = new Scanner(System.in);
    	ANTLRFileStream input;
    	//FileInputStream in = new FileInputStream(sc.nextLine());
        // create a CharStream that reads from standard input
        //ANTLRFileStream input = new ANTLRFileStream(sc.nextLine());
        if(args.length>0 && args[0] != null){
        	input = new ANTLRFileStream(args[0]);
        }else{
        	input = new ANTLRFileStream(sc.nextLine());
        }
        sc.close();

        // create a lexer that feeds off of input CharStream
        PajeParserLexer lexer = new PajeParserLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        PajeParserParser parser = new PajeParserParser(tokens);

        ParseTree tree = parser.paje(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}