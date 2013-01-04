package ch.fhnw.cpib.dgu;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ContextError;
import ch.fhnw.cpib.dgu.context.RoutineTable;
import ch.fhnw.cpib.dgu.context.Scope;
import ch.fhnw.cpib.dgu.context.StoreTable;
import ch.fhnw.cpib.dgu.parser.Parser;
import ch.fhnw.cpib.dgu.parser.Parser.GrammarError;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn;
import ch.fhnw.cpib.dgu.scanner.LexicalError;
import ch.fhnw.cpib.dgu.scanner.Scanner;
import ch.fhnw.cpib.dgu.token.ITokenList;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.ExecutionError;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.HeapTooSmallError;
import ch.fhnw.lederer.virtualmachineHS2010.VirtualMachine;

public final class IMLCompiler {
    private static final int CODE_SIZE = 1000;
    private static final int STORE_SIZE = 1000;
    
    private static RoutineTable routineTable 
        = new RoutineTable();
    private static StoreTable globalStoreTable
        = new StoreTable();
    private static Scope scope = null;
    private static IVirtualMachine vm =
            new VirtualMachine(CODE_SIZE, STORE_SIZE);
    
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
    
    public static IVirtualMachine getVM() {
        return vm;
    }
    
    private IMLCompiler() {
        throw new AssertionError("Instantiating utility class...");
    }
    
    public static synchronized void compile(final String imlCode) 
            throws LexicalError, GrammarError, ContextError, 
            HeapTooSmallError, CodeTooSmallError, ExecutionError {
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
        System.out.println("Context check:");
        abstSyn.check();
        System.out.println("Success!");
        System.out.println("\nCode generation:");
        abstSyn.code(0);
        System.out.println("Success!");
        
        System.out.println("\nExecuting:");
        vm.execute();
        
    }
}
