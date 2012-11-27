package parser.concsyn;

import token.classes.Ident;
import token.classes.Mode.ChangeMode;
import token.classes.Mode.FlowMode;
import token.classes.Mode.MechMode;
import token.classes.Operator;
import abstsyn.IAbstSyn;

public interface IConcSyn {
	
	public interface IProgram extends IConcSyn{
		public IAbstSyn.IProgram toAbstrSyntax();
	};
	public interface IDecl extends IConcSyn{
		public IAbstSyn.IDecl toAbstrSyntax();
	};
	public interface IStoreDecl extends IDecl{
		public IAbstSyn.IStoreDecl toAbstrSyntax();
	};
	public interface IFunDecl extends IDecl{};
	public interface IProcDecl extends IDecl{};
	public interface IAuxGlobCpsDecl extends IConcSyn{
		public IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface IAuxLocCpsDecl extends IConcSyn{
		public IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface ICpsDecl extends IConcSyn{
		public IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface IRepDecl extends IConcSyn{
		public IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface IParamList extends IConcSyn{
		public IAbstSyn.IParam toAbstrSyntax();
	};
	public interface IAuxParamList extends IConcSyn{
		public IAbstSyn.IParam toAbstrSyntax();
	};
	public interface IRepParam extends IConcSyn{
		public IAbstSyn.IParam toAbstrSyntax();
	};
	public interface IParam extends IConcSyn{
		public IAbstSyn.IParam toAbstrSyntax(IRepParam repParam);
	};
	public interface IAuxGlobImpList extends IConcSyn{
		public IAbstSyn.IGlobImp toAbstrSyntax();
	};
	public interface IGlobImpList extends IConcSyn{
		public IAbstSyn.IGlobImp toAbstrSyntax();
	};
	public interface IRepGlobImp extends IConcSyn{
		public IAbstSyn.IGlobImp toAbstrSyntax();
	};
	public interface IGlobImp extends IConcSyn{
		public IAbstSyn.IGlobImp toAbstrSyntax(IRepGlobImp repGlobImp);
	};
	public interface ICmd extends IConcSyn{
		public IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd);
	};
	public interface IBlockCmd extends IConcSyn{
		public IAbstSyn.ICmd toAbstrSyntax();
	};
	public interface IAuxGlobInitList extends IConcSyn{
		public IAbstSyn.IGlobInit toAbstrSyntax();
	};
	public interface IGlobInitList extends IConcSyn{
		public IAbstSyn.IGlobInit toAbstrSyntax();
	};
	public interface IRepCmd extends IConcSyn{
		public IAbstSyn.ICmd toAbstrSyntax();
	};
	public interface IRepIdent extends IConcSyn{
		public IAbstSyn.IGlobInit toAbstrSyntax();
	};
	public interface IExpr extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepTerm1 extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface ITerm1 extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepTerm2 extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface ITerm2 extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepTerm3 extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface ITerm3 extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepFactor extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface IFactor extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IAuxIdent extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax(Ident ident);
	};
	public interface IExprList extends IConcSyn{
		public IAbstSyn.IExprList toAbstrSyntax();
	};
	public interface IAuxExprList extends IConcSyn{
		public IAbstSyn.IExprList toAbstrSyntax();
	};
	public interface IRepExpr extends IConcSyn{
		public IAbstSyn.IExprList toAbstrSyntax();
	};
	public interface IMonadicOpr extends IConcSyn{
		public Operator toAbstrSyntax();
	};
	public interface IAuxMechMode extends IConcSyn{
		public MechMode toAbstrSyntax();
	};
	public interface IAuxChangeMode extends IConcSyn{
		public ChangeMode toAbstrSyntax();
	};
	public interface IAuxFlowMode extends IConcSyn{
		public FlowMode toAbstrSyntax();
	};
	public interface IAuxExprCmd extends IConcSyn{
		public IAbstSyn.IExpr toAbstrSyntax();
	};
	
	public String toString(String indent);
	//public IAbstSyn toAbstrSyntax();
}
