package scanner;

import java.util.Map;
import java.util.TreeMap;

import token.ITokenList;
import token.TokenList;
import token.classes.Ident;
import token.classes.Literal;
import token.enums.Terminals;
import token.enums.Types;



public class Scanner {
	static Map<String, token.classes.Base> lexems = new TreeMap<String, token.classes.Base>();
	
	public static ITokenList scan(CharSequence cs) throws LexicalError {
		assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';
		
		ITokenList tokens= new TokenList();
		LexemeDictionary lexems = new LexemeDictionary();
		
		int state= 0;
		StringBuffer lexAccu= null; // for constructing the identifier
		long numAccu= 0L; // for constructing the literal value
		for (int i= 0; i < cs.length(); i++) {
		    char c= cs.charAt(i);
			switch (state) {
				case 0:
					if (isLetter(c)) {
						state=1;
						lexAccu=new StringBuffer();
						lexAccu.append(c);
					} else if (Character.isDigit(c)) {
						state=2;
						numAccu = Character.digit(c,10);
					} else if (lexems.containsKey(Character.toString(c)) || c == '/') {
						state=3;
						lexAccu=new StringBuffer();
						lexAccu.append(c);
					} else if (!Character.isWhitespace(c)) {
						throw new LexicalError("Invalid Character: " + c);
					}
					break;
				case 1:
					if (isLetter(c) || Character.isDigit(c)) {
						lexAccu.append(c);
					} else {
						state=0;
						
						if (lexems.containsKey(lexAccu.toString())) {
							tokens.add(lexems.get(lexAccu.toString()));
						} else {
							tokens.add(new Ident(lexAccu));
						}
						
						i--;
					}
					break;
				case 2:
					if (Character.isDigit(c)) {
						numAccu*=10;
						numAccu+=Character.digit(c,10);
						if (numAccu > Integer.MAX_VALUE) {
							throw new LexicalError
							("Integer literal too large!");
						} 
					} else {
						state=0;
						tokens.add(new Literal((int) numAccu,Types.INT32));
						i--;
					}
					break;
				case 3:
					if (lexems.containsKey(lexAccu.toString() + c)) {
						state=0;
						tokens.add(lexems.get(lexAccu.toString() + c));
					} else if (lexems.containsKey(lexAccu.toString())) {
						state=0;
						tokens.add(lexems.get(lexAccu.toString()));
						i--;
					} else {
						throw new LexicalError("Invalid Symbol: " + lexAccu.toString());
					}
			}
		} 
		assert state == 0;
		tokens.add(new token.classes.Base(Terminals.SENTINEL));
		return tokens;
	}
	
	private static boolean isLetter(Character c) {
		return ('A' <= c &&  c <= 'Z') || ('a' <= c &&  c <= 'z');
	}
	
}
