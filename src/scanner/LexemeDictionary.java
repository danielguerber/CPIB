package scanner;
import java.util.TreeMap;

import token.classes.Base;
import token.classes.Literal;
import token.classes.Mode;
import token.classes.Operator;
import token.classes.Type;
import token.enums.Modes;
import token.enums.Operators;
import token.enums.Terminals;
import token.enums.Types;


@SuppressWarnings("serial")
public class LexemeDictionary extends TreeMap<String, Base> {
	
	public LexemeDictionary() {
		
		//Symbols
		this.put("(", new Base(Terminals.LPAREN));
		this.put(")", new Base(Terminals.RPAREN));
		this.put(",", new Base(Terminals.COMMA));
		this.put(";", new Base(Terminals.SEMICOLON));
		this.put(":", new Base(Terminals.COLON));
		this.put("?", new Base(Terminals.QUESTMARK));
		this.put("!", new Base(Terminals.EXCLMARK));
		this.put(":=", new Base(Terminals.BECOMES));
		this.put("{", new Base(Terminals.LBRACE));
		this.put("}", new Base(Terminals.RBRACE));
		
		//Operator Symbols
		this.put("*", new Operator.MultOpr(Operators.TIMES));
		this.put("+", new Operator.AddOpr(Operators.PLUS));
		this.put("-", new Operator.AddOpr(Operators.MINUS));
		this.put("=", new Operator.RelOpr(Operators.EQ));
		this.put("/=", new Operator.RelOpr(Operators.NE));
		this.put("<", new Operator.RelOpr(Operators.LT));
		this.put(">", new Operator.RelOpr(Operators.GT));
		this.put("<=", new Operator.RelOpr(Operators.LE));
		this.put(">=", new Operator.RelOpr(Operators.GE));
		
		//Keywords
		this.put("bool", new Type(Types.BOOL));
		this.put("call", new Base(Terminals.CALL));
		this.put("cand", new Operator.BoolOpr(Operators.CAND));
		this.put("const", new Mode.ChangeMode(Modes.CONST));
		this.put("copy", new Mode.MechMode(Modes.COPY));
		this.put("cor", new Operator.BoolOpr(Operators.COR));
		this.put("div", new Operator.MultOpr(Operators.DIV));
		this.put("else", new Base(Terminals.ELSE));
		this.put("false", new Literal(0,Types.BOOL));
		this.put("fun", new Base(Terminals.FUN));
		this.put("global", new Base(Terminals.GLOBAL));
		this.put("if", new Base(Terminals.IF));
		this.put("in", new Mode.FlowMode(Modes.IN));
		this.put("init", new Base(Terminals.INIT));
		this.put("inout", new Mode.FlowMode(Modes.INOUT));
		this.put("int32", new Type(Types.INT32));
		this.put("local", new Base(Terminals.LOCAL));
		this.put("mod", new Operator.MultOpr(Operators.MOD));
		this.put("not", new Base(Terminals.NOT));
		this.put("out", new Mode.FlowMode(Modes.OUT));
		this.put("proc", new Base(Terminals.PROC));
		this.put("program", new Base(Terminals.PROGRAM));
		this.put("ref", new Mode.MechMode(Modes.REF));
		this.put("returns", new Base(Terminals.RETURNS));
		this.put("skip", new Base(Terminals.SKIP));
		this.put("true", new Literal(1,Types.BOOL));
		this.put("var", new Mode.ChangeMode(Modes.VAR));
		this.put("while", new Base(Terminals.WHILE));
	}
	
}
