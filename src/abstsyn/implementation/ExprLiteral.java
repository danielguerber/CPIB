package abstsyn.implementation;

import token.classes.Literal;
import abstsyn.IAbstSyn.IExpr;

public class ExprLiteral implements IExpr {
private Literal literal;
	
	public ExprLiteral(Literal literal) {
		this.literal = literal;
	}
}
