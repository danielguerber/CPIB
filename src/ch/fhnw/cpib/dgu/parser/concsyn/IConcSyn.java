package ch.fhnw.cpib.dgu.parser.concsyn;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.token.classes.Base;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.classes.Mode.ChangeMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.FlowMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.MechMode;

public interface IConcSyn {
	
	public interface IProgram extends IConcSyn {
		IAbstSyn.IProgram toAbstrSyntax();
	};
	public interface IDecl extends IConcSyn {
		IAbstSyn.IDecl toAbstrSyntax();
	};
	public interface IStoreDecl extends IDecl {
		@Override
		IAbstSyn.IStoreDecl toAbstrSyntax();
	};
	public interface IFunDecl extends IDecl { };
	public interface IProcDecl extends IDecl { };
	public interface IAuxGlobCpsDecl extends IConcSyn {
		IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface IAuxLocCpsDecl extends IConcSyn {
		IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface ICpsDecl extends IConcSyn {
		IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface IRepDecl extends IConcSyn {
		IAbstSyn.ICpsDecl toAbstrSyntax();
	};
	public interface IParamList extends IConcSyn {
		IAbstSyn.IParam toAbstrSyntax();
	};
	public interface IAuxParamList extends IConcSyn {
		IAbstSyn.IParam toAbstrSyntax();
	};
	public interface IRepParam extends IConcSyn {
		IAbstSyn.IParam toAbstrSyntax();
	};
	public interface IParam extends IConcSyn {
		IAbstSyn.IParam toAbstrSyntax(IRepParam repParam);
	};
	public interface IAuxGlobImpList extends IConcSyn {
		IAbstSyn.IGlobImp toAbstrSyntax();
	};
	public interface IGlobImpList extends IConcSyn {
		IAbstSyn.IGlobImp toAbstrSyntax();
	};
	public interface IRepGlobImp extends IConcSyn {
		IAbstSyn.IGlobImp toAbstrSyntax();
	};
	public interface IGlobImp extends IConcSyn {
		IAbstSyn.IGlobImp toAbstrSyntax(IRepGlobImp repGlobImp);
	};
	public interface ICmd extends IConcSyn {
		IAbstSyn.ICmd toAbstrSyntax(IAbstSyn.ICmd repCmd);
	};
	public interface IBlockCmd extends IConcSyn {
		IAbstSyn.ICmd toAbstrSyntax();
	};
	public interface IAuxGlobInitList extends IConcSyn {
		IAbstSyn.IGlobInit toAbstrSyntax();
	};
	public interface IGlobInitList extends IConcSyn {
		IAbstSyn.IGlobInit toAbstrSyntax();
	};
	public interface IRepCmd extends IConcSyn {
		IAbstSyn.ICmd toAbstrSyntax();
	};
	public interface IRepIdent extends IConcSyn {
		IAbstSyn.IGlobInit toAbstrSyntax();
	};
	public interface IExpr extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepTerm1 extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface ITerm1 extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepTerm2 extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax(
		        IAbstSyn.IExpr relExpr, 
		        IAbstSyn.IExpr boolExpr);
	};
	public interface ITerm2 extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepTerm3 extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface ITerm3 extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IRepFactor extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax(IAbstSyn.IExpr expr);
	};
	public interface IFactor extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax();
	};
	public interface IAuxIdent extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax(Ident ident);
	};
	public interface IExprList extends IConcSyn {
		IAbstSyn.IExprList toAbstrSyntax();
	};
	public interface IAuxExprList extends IConcSyn {
		IAbstSyn.IExprList toAbstrSyntax();
	};
	public interface IRepExpr extends IConcSyn {
		IAbstSyn.IExprList toAbstrSyntax();
	};
	public interface IMonadicOpr extends IConcSyn {
		Base toAbstrSyntax();
	};
	public interface IAuxMechMode extends IConcSyn {
		MechMode toAbstrSyntax();
	};
	public interface IAuxChangeMode extends IConcSyn {
		ChangeMode toAbstrSyntax();
	};
	public interface IAuxFlowMode extends IConcSyn {
		FlowMode toAbstrSyntax();
	};
	public interface IAuxExprCmd extends IConcSyn {
		IAbstSyn.IExpr toAbstrSyntax();
	};
	
	String toString(String indent);
	//public IAbstSyn toAbstrSyntax();
}
