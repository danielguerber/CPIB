package abstsyn;

public interface IAbstSyn {
	public interface IProgram extends IAbstSyn {}
	public interface ICpsDecl extends IAbstSyn {}
	public interface IDecl extends IAbstSyn {}
	public interface IStoreDecl extends IDecl{}
	public interface ICmd extends IAbstSyn {}
	public interface IParam extends IAbstSyn {}
	public interface IGlobImp extends IAbstSyn {}
	public interface IExpr extends IAbstSyn {}
	public interface IExprList extends IAbstSyn {}
	public interface IGlobInit extends IAbstSyn{}
	
	public String toString(String indent);
}
