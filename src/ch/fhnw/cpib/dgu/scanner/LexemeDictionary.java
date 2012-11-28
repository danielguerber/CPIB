package ch.fhnw.cpib.dgu.scanner;
import java.util.TreeMap;

import ch.fhnw.cpib.dgu.token.classes.Base;
import ch.fhnw.cpib.dgu.token.classes.Literal;
import ch.fhnw.cpib.dgu.token.classes.Mode;
import ch.fhnw.cpib.dgu.token.classes.Operator;
import ch.fhnw.cpib.dgu.token.classes.Type;
import ch.fhnw.cpib.dgu.token.enums.Modes;
import ch.fhnw.cpib.dgu.token.enums.Operators;
import ch.fhnw.cpib.dgu.token.enums.Terminals;
import ch.fhnw.cpib.dgu.token.enums.Types;



public final class LexemeDictionary {

    private LexemeDictionary() {
        throw new AssertionError("Instantiating utility class...");
    }
    
	private static TreeMap<String, Base> dictionary;
	
	public static TreeMap<String, Base> getDictionary() {
		return dictionary;
	}
	
	static {
		dictionary = new TreeMap<String, Base>();
		//Symbols
		dictionary.put("(", new Base(Terminals.LPAREN));
		dictionary.put(")", new Base(Terminals.RPAREN));
		dictionary.put(",", new Base(Terminals.COMMA));
		dictionary.put(";", new Base(Terminals.SEMICOLON));
		dictionary.put(":", new Base(Terminals.COLON));
		dictionary.put("?", new Base(Terminals.QUESTMARK));
		dictionary.put("!", new Base(Terminals.EXCLMARK));
		dictionary.put(":=", new Base(Terminals.BECOMES));
		dictionary.put("{", new Base(Terminals.LBRACE));
		dictionary.put("}", new Base(Terminals.RBRACE));
		
		//Operator Symbols
		dictionary.put("*", new Operator.MultOpr(Operators.TIMES));
		dictionary.put("+", new Operator.AddOpr(Operators.PLUS));
		dictionary.put("-", new Operator.AddOpr(Operators.MINUS));
		dictionary.put("=", new Operator.RelOpr(Operators.EQ));
		dictionary.put("/=", new Operator.RelOpr(Operators.NE));
		dictionary.put("<", new Operator.RelOpr(Operators.LT));
		dictionary.put(">", new Operator.RelOpr(Operators.GT));
		dictionary.put("<=", new Operator.RelOpr(Operators.LE));
		dictionary.put(">=", new Operator.RelOpr(Operators.GE));
		
		//Keywords
		dictionary.put("bool", new Type(Types.BOOL));
		dictionary.put("cand", new Operator.BoolOpr(Operators.CAND));
		dictionary.put("const", new Mode.ChangeMode(Modes.CONST));
		dictionary.put("copy", new Mode.MechMode(Modes.COPY));
		dictionary.put("cor", new Operator.BoolOpr(Operators.COR));
		dictionary.put("div", new Operator.MultOpr(Operators.DIV));
		dictionary.put("else", new Base(Terminals.ELSE));
		dictionary.put("false", new Literal(0, Types.BOOL));
		dictionary.put("fun", new Base(Terminals.FUN));
		dictionary.put("global", new Base(Terminals.GLOBAL));
		dictionary.put("if", new Base(Terminals.IF));
		dictionary.put("in", new Mode.FlowMode(Modes.IN));
		dictionary.put("init", new Base(Terminals.INIT));
		dictionary.put("inout", new Mode.FlowMode(Modes.INOUT));
		dictionary.put("int32", new Type(Types.INT32));
		dictionary.put("local", new Base(Terminals.LOCAL));
		dictionary.put("mod", new Operator.MultOpr(Operators.MOD));
		dictionary.put("not", new Base(Terminals.NOT));
		dictionary.put("out", new Mode.FlowMode(Modes.OUT));
		dictionary.put("proc", new Base(Terminals.PROC));
		dictionary.put("program", new Base(Terminals.PROGRAM));
		dictionary.put("ref", new Mode.MechMode(Modes.REF));
		dictionary.put("returns", new Base(Terminals.RETURNS));
		dictionary.put("skip", new Base(Terminals.SKIP));
		dictionary.put("true", new Literal(1, Types.BOOL));
		dictionary.put("var", new Mode.ChangeMode(Modes.VAR));
		dictionary.put("while", new Base(Terminals.WHILE));
	}
	
}
