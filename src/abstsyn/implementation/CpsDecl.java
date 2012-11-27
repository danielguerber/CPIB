package abstsyn.implementation;

import abstsyn.IAbstSyn.ICpsDecl;

public class CpsDecl implements ICpsDecl {
	private IDecl decl;
	private ICpsDecl cpsDecl;
	
	public CpsDecl(IDecl decl, ICpsDecl cpsDecl) {
		this.decl = decl;
		this.cpsDecl = cpsDecl;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CpsDecl>\n" +
				decl.toString(indent + '\t') +
				cpsDecl.toString(indent + '\t') +
				indent +
				"</CpsDecl>\n";
	}
}
