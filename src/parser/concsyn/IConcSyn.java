package parser.concsyn;

public interface IConcSyn {
	
	public interface IProgram{};
	public interface IDecl{};
	public interface IStoreDecl extends IDecl{};
	public interface IFunDecl extends IDecl{};
	public interface IProcDecl extends IDecl{};
	public interface IAuxGlobCpsDecl{};
	public interface IAuxLocCpsDecl{};
	public interface ICpsDecl{};
	public interface IRepDecl{};
	public interface IParamList{};
	public interface IAuxParamList{};
	public interface IRepParam{};
	public interface IParam{};
	public interface IAuxGlobImpList{};
	public interface IGlobImpList{};
	public interface IRepGlobImp{};
	public interface IGlobImp{};
	public interface ICmd{};
	public interface IBlockCmd{};
	public interface IAuxGlobInitList{};
	public interface IGlobInitList{};
	public interface IRepCmd{};
	public interface IRepIdent{};
	public interface IExpr{};
	public interface IRepTerm1{};
	public interface ITerm1{};
	public interface IRepTerm2{};
	public interface ITerm2{};
	public interface IRepTerm3{};
	public interface ITerm3{};
	public interface IRepFactor{};
	public interface IFactor{};
	public interface IAuxIdent{};
	public interface IExprList{};
	public interface IAuxExprList{};
	public interface IRepExpr{};
	public interface IMonadicOpr{};
	public interface IAuxMechMode{};
	public interface IAuxChangeMode{};
	public interface IAuxFlowMode{};
	public interface IAuxExprCmd{};
}
