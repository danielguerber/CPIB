package parser.concsyn;

public interface IConcSyn {
	
	public interface IProgram extends IConcSyn{};
	public interface IDecl extends IConcSyn{};
	public interface IStoreDecl extends IDecl{};
	public interface IFunDecl extends IDecl{};
	public interface IProcDecl extends IDecl{};
	public interface IAuxGlobCpsDecl extends IConcSyn{};
	public interface IAuxLocCpsDecl extends IConcSyn{};
	public interface ICpsDecl extends IConcSyn{};
	public interface IRepDecl extends IConcSyn{};
	public interface IParamList extends IConcSyn{};
	public interface IAuxParamList extends IConcSyn{};
	public interface IRepParam extends IConcSyn{};
	public interface IParam extends IConcSyn{};
	public interface IAuxGlobImpList extends IConcSyn{};
	public interface IGlobImpList extends IConcSyn{};
	public interface IRepGlobImp extends IConcSyn{};
	public interface IGlobImp extends IConcSyn{};
	public interface ICmd extends IConcSyn{};
	public interface IBlockCmd extends IConcSyn{};
	public interface IAuxGlobInitList extends IConcSyn{};
	public interface IGlobInitList extends IConcSyn{};
	public interface IRepCmd extends IConcSyn{};
	public interface IRepIdent extends IConcSyn{};
	public interface IExpr extends IConcSyn{};
	public interface IRepTerm1 extends IConcSyn{};
	public interface ITerm1 extends IConcSyn{};
	public interface IRepTerm2 extends IConcSyn{};
	public interface ITerm2 extends IConcSyn{};
	public interface IRepTerm3 extends IConcSyn{};
	public interface ITerm3 extends IConcSyn{};
	public interface IRepFactor extends IConcSyn{};
	public interface IFactor extends IConcSyn{};
	public interface IAuxIdent extends IConcSyn{};
	public interface IExprList extends IConcSyn{};
	public interface IAuxExprList extends IConcSyn{};
	public interface IRepExpr extends IConcSyn{};
	public interface IMonadicOpr extends IConcSyn{};
	public interface IAuxMechMode extends IConcSyn{};
	public interface IAuxChangeMode extends IConcSyn{};
	public interface IAuxFlowMode extends IConcSyn{};
	public interface IAuxExprCmd extends IConcSyn{};
	
	//public String toString(int level);
}
