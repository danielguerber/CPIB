package ch.fhnw.cpib.dgu;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.context.RoutineTable;
import ch.fhnw.cpib.dgu.context.Scope;
import ch.fhnw.cpib.dgu.context.StoreTable;
import ch.fhnw.cpib.dgu.parser.Parser;
import ch.fhnw.cpib.dgu.parser.Parser.GrammarError;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn;
import ch.fhnw.cpib.dgu.scanner.LexicalError;
import ch.fhnw.cpib.dgu.scanner.Scanner;
import ch.fhnw.cpib.dgu.token.ITokenList;

public final class IMLCompiler {
    private static RoutineTable routineTable 
        = new RoutineTable();
    private static StoreTable globalStoreTable
        = new StoreTable();
    private static Scope scope = null;
   
    public static RoutineTable getRoutineTable() {
        return routineTable;
    }
    
    public static StoreTable getGlobalStoreTable() {
        return globalStoreTable;
    }
    
    public static Scope getScope() {
        return scope;
    }
    
    public static void setScope(final Scope scope) {
        IMLCompiler.scope = scope;
    }
    
    private IMLCompiler() {
        throw new AssertionError("Instantiating utility class...");
    }
    
    public static synchronized void compile(final String imlCode) 
            throws LexicalError, GrammarError {
        System.out.println("Scanning:");
        final ITokenList tokenList = Scanner.scan(imlCode);
        System.out.println("Success!");
        System.out.println("\nTokenList:");
        System.out.println(tokenList);
        System.out.println("\nParsing:");
        final Parser parser = new Parser(tokenList);
        final IConcSyn.IProgram concSyn = parser.parse();
        System.out.println("\nSuccess!");
        System.out.println("\nConcrete syntax tree:");
        System.out.println(concSyn.toString(""));
        System.out.println("Generating abstract syntax tree:");
        final IAbstSyn.IProgram abstSyn = concSyn.toAbstrSyntax();
        System.out.println("Success!");
        System.out.println("\nAbstract syntax tree:");
        System.out.println(abstSyn.toString(""));
    }
}
