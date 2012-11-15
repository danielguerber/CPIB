package parser.concsyn;

public interface IConcSyn {
	
	public interface IProgram{};
	public interface IDecl{};
	public interface IStoreDecl extends IDecl{};
	public interface IFunDecl extends IDecl{};
	public interface IProcDecl extends IDecl{};
	public interface ICpsDecl{};
	public interface IRepDecl{};
	public interface IParamList{};
	public interface IRepParam{};
	public interface IParam{};
	public interface IGlobImpList{};
	public interface IGlobImp{};
	public interface IRepGlobImp{};
	public interface ICmd{};
	public interface IRepCmd{};
	public interface IBlockCmd{};
	public interface IGlobInitList{};
	public interface IExpr{};
	public interface IRepExpr{};
	public interface ITerm1{};
	public interface IRepTerm1{};
	public interface ITerm2{};
	public interface IRepTerm2{};
	public interface ITerm3{};
	public interface IRepTerm3{};
	public interface IFactor{};
	public interface IRepFactor{};
	public interface IExprList{};
	public interface IMonadicOpr{};
	public interface IIdentSpec{};
	public interface IRepIdent{};
	
	
	
}
