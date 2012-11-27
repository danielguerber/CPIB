package abstsyn.implementation;

import token.classes.Literal;
import abstsyn.IAbstSyn.IExpr;

public class ExprLiteral implements IExpr {
private Literal literal;
	
	public ExprLiteral(Literal literal) {
		this.literal = literal;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ExprLiteral>\n" +
				literal.toString(indent + '\t') +
				indent +
				"</ExprLiteral>\n";
	}
}
