package parser;

import parser.concsyn.IConcSyn;
import parser.concsyn.IConcSyn.IAuxChangeMode;
import parser.concsyn.IConcSyn.IAuxExprCmd;
import parser.concsyn.IConcSyn.IAuxExprList;
import parser.concsyn.IConcSyn.IAuxFlowMode;
import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;
import parser.concsyn.IConcSyn.IAuxGlobImpList;
import parser.concsyn.IConcSyn.IAuxGlobInitList;
import parser.concsyn.IConcSyn.IAuxIdent;
import parser.concsyn.IConcSyn.IAuxLocCpsDecl;
import parser.concsyn.IConcSyn.IAuxMechMode;
import parser.concsyn.IConcSyn.IAuxParamList;
import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.ICpsDecl;
import parser.concsyn.IConcSyn.IDecl;
import parser.concsyn.IConcSyn.IExpr;
import parser.concsyn.IConcSyn.IExprList;
import parser.concsyn.IConcSyn.IFactor;
import parser.concsyn.IConcSyn.IFunDecl;
import parser.concsyn.IConcSyn.IGlobImp;
import parser.concsyn.IConcSyn.IGlobImpList;
import parser.concsyn.IConcSyn.IGlobInitList;
import parser.concsyn.IConcSyn.IMonadicOpr;
import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IProcDecl;
import parser.concsyn.IConcSyn.IProgram;
import parser.concsyn.IConcSyn.IRepCmd;
import parser.concsyn.IConcSyn.IRepDecl;
import parser.concsyn.IConcSyn.IRepExpr;
import parser.concsyn.IConcSyn.IRepFactor;
import parser.concsyn.IConcSyn.IRepGlobImp;
import parser.concsyn.IConcSyn.IRepIdent;
import parser.concsyn.IConcSyn.IRepParam;
import parser.concsyn.IConcSyn.IRepTerm1;
import parser.concsyn.IConcSyn.IRepTerm2;
import parser.concsyn.IConcSyn.IRepTerm3;
import parser.concsyn.IConcSyn.IStoreDecl;
import parser.concsyn.IConcSyn.ITerm1;
import parser.concsyn.IConcSyn.ITerm2;
import parser.concsyn.IConcSyn.ITerm3;
import parser.concsyn.implementation.AuxChangeMode;
import parser.concsyn.implementation.AuxChangeModeEps;
import parser.concsyn.implementation.AuxExprCmdBecomes;
import parser.concsyn.implementation.AuxExprCmdEps;
import parser.concsyn.implementation.AuxExprList;
import parser.concsyn.implementation.AuxExprListEps;
import parser.concsyn.implementation.AuxFlowMode;
import parser.concsyn.implementation.AuxFlowModeEps;
import parser.concsyn.implementation.AuxGlobCpsDecl;
import parser.concsyn.implementation.AuxGlobCpsDeclEps;
import parser.concsyn.implementation.AuxGlobImpList;
import parser.concsyn.implementation.AuxGlobImpListEps;
import parser.concsyn.implementation.AuxGlobInitList;
import parser.concsyn.implementation.AuxGlobInitListEps;
import parser.concsyn.implementation.AuxIdentEps;
import parser.concsyn.implementation.AuxIdentExprList;
import parser.concsyn.implementation.AuxIdentInit;
import parser.concsyn.implementation.AuxLocCpsDecl;
import parser.concsyn.implementation.AuxLocCpsDeclEps;
import parser.concsyn.implementation.AuxMechMode;
import parser.concsyn.implementation.AuxMechModeEps;
import parser.concsyn.implementation.AuxParamList;
import parser.concsyn.implementation.AuxParamListEps;
import parser.concsyn.implementation.BlockCmd;
import parser.concsyn.implementation.CmdExcl;
import parser.concsyn.implementation.CmdExpr;
import parser.concsyn.implementation.CmdIf;
import parser.concsyn.implementation.CmdQuest;
import parser.concsyn.implementation.CmdSkip;
import parser.concsyn.implementation.CmdWhile;
import parser.concsyn.implementation.CpsDecl;
import parser.concsyn.implementation.Expr;
import parser.concsyn.implementation.ExprList;
import parser.concsyn.implementation.FactorExpr;
import parser.concsyn.implementation.FactorIdent;
import parser.concsyn.implementation.FactorLiteral;
import parser.concsyn.implementation.FactorMonadicOpr;
import parser.concsyn.implementation.FunDecl;
import parser.concsyn.implementation.GlobImp;
import parser.concsyn.implementation.GlobImpList;
import parser.concsyn.implementation.GlobInitList;
import parser.concsyn.implementation.MonadicOpr;
import parser.concsyn.implementation.Param;
import parser.concsyn.implementation.ParamList;
import parser.concsyn.implementation.ProcDecl;
import parser.concsyn.implementation.Program;
import parser.concsyn.implementation.RepCmd;
import parser.concsyn.implementation.RepCmdEps;
import parser.concsyn.implementation.RepDecl;
import parser.concsyn.implementation.RepDeclEps;
import parser.concsyn.implementation.RepExpr;
import parser.concsyn.implementation.RepExprEps;
import parser.concsyn.implementation.RepFactor;
import parser.concsyn.implementation.RepFactorEps;
import parser.concsyn.implementation.RepGlobImp;
import parser.concsyn.implementation.RepGlobImpEps;
import parser.concsyn.implementation.RepIdent;
import parser.concsyn.implementation.RepIdentEps;
import parser.concsyn.implementation.RepParam;
import parser.concsyn.implementation.RepParamEps;
import parser.concsyn.implementation.RepTerm1;
import parser.concsyn.implementation.RepTerm1Eps;
import parser.concsyn.implementation.RepTerm2;
import parser.concsyn.implementation.RepTerm2Eps;
import parser.concsyn.implementation.RepTerm3;
import parser.concsyn.implementation.RepTerm3Eps;
import parser.concsyn.implementation.StoreDecl;
import parser.concsyn.implementation.Term1;
import parser.concsyn.implementation.Term2;
import parser.concsyn.implementation.Term3;
import token.ITokenList;
import token.classes.Base;
import token.classes.Ident;
import token.classes.Literal;
import token.classes.Mode;
import token.classes.Operator;
import token.classes.Type;
import token.enums.Terminals;

public class Parser {
	
	@SuppressWarnings("serial")
	public static class GrammarError extends Exception
	{
		private GrammarError(String errorMessage, int line)
		{
			super(errorMessage + "\n\tat line:" + line);
			
		}
	}
	
	private ITokenList tokenList;
	private Base token;
	private Terminals terminal;
	
	public Parser(ITokenList tokenList)
	{
		this.tokenList= tokenList;
		this.tokenList.reset();
		// precondition: token list contains at least the SENTINEL
		token= tokenList.nextToken();
		// establish class invariant
		terminal= token.getTerminal();
	}
	
	private Base consume(Terminals expectedTerminal) throws GrammarError
	{
		if (terminal == expectedTerminal)
		{
			Base consumedToken= token;
			if (terminal != Terminals.SENTINEL)
			{
				token= tokenList.nextToken();
				// maintain class invariant
				terminal= token.getTerminal();
			}
			return consumedToken;
		}
		else
		{
			throw new GrammarError("terminal expected: " + expectedTerminal +
								", terminal found: " + terminal, token.getLine());
		}
	}
	
	public IConcSyn.IProgram parse() throws GrammarError
	{
		// parsing the start symbol ...
		IConcSyn.IProgram program= program();
		// ... and then consuming the SENTINEL
		consume(Terminals.SENTINEL);
		return program;
	}
	
	private IProgram program() throws GrammarError {
		System.out.println("program ::= PROGRAM Ident auxGlobCpsDecl blockCmd");
		consume(Terminals.PROGRAM);
		Ident ident = (Ident)consume(Terminals.IDENT);
		IAuxGlobCpsDecl auxGlobCpsDecl = auxGlobCpsDecl();
		IBlockCmd blockCmd = blockCmd();
		return new Program(ident,auxGlobCpsDecl,blockCmd);
	}
	
	private IDecl decl() throws GrammarError {
		switch(terminal) {
			case FUN:
				System.out.println("decl ::= funDecl");
				return funDecl();
			case PROC:
				System.out.println("decl ::= procDecl");
				return procDecl();
			case CHANGEMODE:
			case IDENT:
				System.out.println("decl ::= storeDecl");
				return storeDecl();
			default:
				throw new GrammarError("decl got " + terminal, token.getLine());
		}
	}
	
	private IStoreDecl storeDecl() throws GrammarError {
		System.out.println("storeDecl ::= auxChangeMode IDENT COLON TYPE");
		IAuxChangeMode auxChangeMode = auxChangeMode();
		Ident ident = (Ident)consume(Terminals.IDENT);
		consume(Terminals.COLON);
		Type type = (Type)consume(Terminals.TYPE);
		return new StoreDecl(auxChangeMode, ident, type);
	}
	
	private IFunDecl funDecl() throws GrammarError {
		System.out.println("funDecl ::= FUN IDENT paramList RETURNS storeDecl" + 
						" auxGlobImpList auxLocCpsDecl blockCmd");
		consume(Terminals.FUN);
		Ident ident = (Ident)consume(Terminals.IDENT);
		IParamList paramList = paramList();
		consume(Terminals.RETURNS);
		IStoreDecl storeDecl = storeDecl();
		IAuxGlobImpList auxGlobImpList = auxGlobImpList();
		IAuxLocCpsDecl auxLocCpsDecl = auxLocCpsDecl();
		IBlockCmd blockCmd = blockCmd();
		return new FunDecl(ident, paramList, storeDecl, auxGlobImpList, auxLocCpsDecl, blockCmd);
	}
	
	private IProcDecl procDecl() throws GrammarError {
		System.out.println("procDecl ::= PROC IDENT paramList auxGlobImpList " +
						"auxLocCpsDecl blockCmd");
		consume(Terminals.PROC);
		Ident ident = (Ident)consume(Terminals.IDENT);
		IParamList paramList = paramList();
		IAuxGlobImpList auxGlobImpList = auxGlobImpList();
		IAuxLocCpsDecl auxLocCpsDecl = auxLocCpsDecl();
		IBlockCmd blockCmd = blockCmd();
		return new ProcDecl(ident, paramList, auxGlobImpList, auxLocCpsDecl, blockCmd);
	}
	
	private IAuxGlobCpsDecl auxGlobCpsDecl() throws GrammarError {
		if(terminal==Terminals.GLOBAL) {
			System.out.println("auxGlobCpsDecl ::= GLOBAL cpsDecl");
			consume(Terminals.GLOBAL);
			return new AuxGlobCpsDecl(cpsDecl());
		} else {
			System.out.println("auxGlobCpsDecl ::= epsilon");
			return new AuxGlobCpsDeclEps();
		}
	}
	
	private IAuxLocCpsDecl auxLocCpsDecl() throws GrammarError {
		if (terminal==Terminals.LOCAL) {
			System.out.println("auxLocCpsDecl ::= LOCAL cpsDecl");
			consume(Terminals.LOCAL);
			return new AuxLocCpsDecl(cpsDecl());
		} else {
			System.out.println("auxLocCpsDecl ::= epsilon");
			return new AuxLocCpsDeclEps();
		}
	}
	
	private ICpsDecl cpsDecl() throws GrammarError {
		System.out.println("cpsDecl := decl repDecl");
		IDecl decl = decl();
		IRepDecl repDecl = repDecl();
		return new CpsDecl(decl, repDecl);
	}
	
	private IRepDecl repDecl() throws GrammarError {
		if (terminal==Terminals.SEMICOLON){
			System.out.println("repDecl ::= SEMICOLON decl repDecl");
			consume(Terminals.SEMICOLON);
			IDecl decl = decl();
			IRepDecl repDecl = repDecl();
			return new RepDecl(decl, repDecl);
		} else {
			System.out.println("repDecl ::= epsilon");
			return new RepDeclEps();
		}
	}
	
	private IParamList paramList() throws GrammarError {
		System.out.println("paramList ::= LPAREN auxParamList RPAREN");
		consume(Terminals.LPAREN);
		IAuxParamList auxParamList = auxParamList();
		consume(Terminals.RPAREN);
		return new ParamList(auxParamList);
	}
	
	private IAuxParamList auxParamList() throws GrammarError {
		if(terminal!=Terminals.RPAREN) {
			System.out.println("auxParamList ::= param repParam");
			IParam param = param();
			IRepParam repParam = repParam();
			return new AuxParamList(param, repParam);
		} else {
			System.out.println("auxParamList ::= epsilon");
			return new AuxParamListEps();
		}
	}
	
	private IRepParam repParam() throws GrammarError {
		if (terminal==Terminals.COMMA) {
			System.out.println("repParam ::= COMMA param repParam");
			consume(Terminals.COMMA);
			IParam param = param();
			IRepParam repParam = repParam();
			return new RepParam(param, repParam);
		} else {
			System.out.println("repParam ::= epsilon");
			return new RepParamEps();
		}
	}
	
	private IParam param() throws GrammarError {
		System.out.println("param ::= auxFlowMode auxMechMode storeDecl");
		IAuxFlowMode auxFlowMode = auxFlowMode();
		IAuxMechMode auxMechMode = auxMechMode();
		IStoreDecl storeDecl = storeDecl();
		return new Param(auxFlowMode, auxMechMode, storeDecl);
	}
	
	private IAuxGlobImpList auxGlobImpList() throws GrammarError {
		if (terminal==Terminals.GLOBAL) {
			System.out.println("auxGlobImpList ::= GLOBAL globImpList");
			consume(Terminals.GLOBAL);
			return new AuxGlobImpList(globImpList());
		} else {
			System.out.println("auxGlobImpList ::= epsilon");
			return new AuxGlobImpListEps();
		}
	}
	
	private IGlobImpList globImpList() throws GrammarError {
		System.out.println("globImpList ::= globImp repGlobImp");
		IGlobImp globImp=globImp();
		IRepGlobImp repGlobImp=repGlobImp();
		return new GlobImpList(globImp, repGlobImp);
	}
	
	private IRepGlobImp repGlobImp() throws GrammarError {
		if (terminal==Terminals.COMMA) {
			System.out.println("repGlobImp ::= COMMA globImp repGlobImp");
			consume(Terminals.COMMA);
			IGlobImp globImp = globImp();
			IRepGlobImp repGlobImp = repGlobImp();
			return new RepGlobImp(globImp, repGlobImp);
		} else {
			System.out.println("repGlobImp ::= epsilon");
			return new RepGlobImpEps();
		}
	}
	
	private IGlobImp globImp() throws GrammarError {
		System.out.println("globImp ::= auxFlowMode auxChangeMode IDENT");
		IAuxFlowMode auxFlowMode = auxFlowMode();
		IAuxChangeMode auxChangeMode = auxChangeMode();
		Ident ident = (Ident)consume(Terminals.IDENT);
		return new GlobImp(auxFlowMode, auxChangeMode, ident);
	}
	
	private ICmd cmd() throws GrammarError {
		switch (terminal) {
			case SKIP:
				System.out.println("cmd ::= SKIP");
				consume(Terminals.SKIP);
				return new CmdSkip();
			case IF:
				System.out.println("cmd ::= IF LPAREN expr RPAREN blockCmd ELSE blockCmd");
				consume(Terminals.IF);
				consume(Terminals.LPAREN);
				IExpr ifExpr = expr();
				consume(Terminals.RPAREN);
				IBlockCmd ifCmd = blockCmd();
				consume(Terminals.ELSE);
				IBlockCmd elseCmd = blockCmd();
				return new CmdIf(ifExpr, ifCmd, elseCmd);
			case WHILE:
				System.out.println("cmd ::= WHILE LPAREN expr RPAREN blockCmd");
				consume(Terminals.WHILE);
				consume(Terminals.LPAREN);
				IExpr whileExpr = expr();
				consume(Terminals.RPAREN);
				IBlockCmd whileCmd = blockCmd();
				return new CmdWhile(whileExpr, whileCmd);
			case QUESTMARK:
				System.out.println("cmd ::= QUESTMARK expr");
				consume(Terminals.QUESTMARK);
				IExpr questExpr=expr();
				return new CmdQuest(questExpr);
			case EXCLMARK:
				System.out.println("cmd ::= EXCLMARK expr");
				consume(Terminals.EXCLMARK);
				IExpr exclExpr=expr();
				return new CmdExcl(exclExpr);
			default:
				System.out.println("cmd ::= expr auxExprCmd");
				IExpr expr = expr();
				IAuxExprCmd auxExprCmd = auxExprCmd();
				return new CmdExpr(expr, auxExprCmd);
		}
	}
	
	private IBlockCmd blockCmd() throws GrammarError {
		System.out.println("blockCmd ::= LBRACE cmd repCmd RBRACE");
		consume(Terminals.LBRACE);
		ICmd cmd = cmd();
		IRepCmd repCmd = repCmd();
		consume(Terminals.RBRACE);
		return new BlockCmd(cmd, repCmd);
	}
	
	private IRepCmd repCmd() throws GrammarError {
		if(terminal==Terminals.SEMICOLON) {
			System.out.println("repCmd ::= SEMICOLON cmd repCmd");
			consume(Terminals.SEMICOLON);
			ICmd cmd = cmd();
			IRepCmd repCmd = repCmd();
			return new RepCmd(cmd, repCmd);
		} else {
			System.out.println("repCmd ::= epsilon");
			return new RepCmdEps();
		}
	}
	
	private IAuxGlobInitList auxGlobInitList() throws GrammarError {
		if(terminal==Terminals.INIT) {
			System.out.println("auxGlobInitList ::= INIT LPAREN globInitList RPAREN");
			consume(Terminals.INIT);
			consume(Terminals.LPAREN);
			IGlobInitList globInitList = globInitList();
			consume(Terminals.RPAREN);
			return new AuxGlobInitList(globInitList);
		} else {
			System.out.println("auxGlobInitList ::= epsilon");
			return new AuxGlobInitListEps();
		}
	}
	
	private IGlobInitList globInitList() throws GrammarError {
		System.out.println("globInitList ::= IDENT repIdent");
		Ident ident = (Ident)consume(Terminals.IDENT);
		IRepIdent repIdent = repIdent();
		return new GlobInitList(ident, repIdent);
	}

	private IRepIdent repIdent() throws GrammarError {
		if (terminal!=Terminals.COMMA) {
			System.out.println("repIdent ::= epsilon");
			return new RepIdentEps();
		} else {
			System.out.println("repIdent ::= IDENT repIdent");
			Ident ident = (Ident)consume(Terminals.IDENT);
			IRepIdent repIdent = repIdent();
			return new RepIdent(ident, repIdent);
		}
	}
	
	private IExpr expr() throws GrammarError {
		System.out.println("expr ::= term1 repTerm1");
		ITerm1 term1 = term1();
		IRepTerm1 repTerm1 = repTerm1();
		return new Expr(term1, repTerm1);
	}
	
	private IRepTerm1 repTerm1() throws GrammarError {
		if (terminal==Terminals.BOOLOPR) {
			System.out.println("repTerm1 ::= BOOLOPR term1 repTerm1");
			Operator.BoolOpr boolOpr = (Operator.BoolOpr)consume(Terminals.BOOLOPR);
			ITerm1 term1 = term1();
			IRepTerm1 repTerm1 = repTerm1();
			return new RepTerm1(boolOpr, term1, repTerm1);
		} else {
			System.out.println("repTerm1 ::= epsilon");
			return new RepTerm1Eps();
		}
	}
	
	private ITerm1 term1() throws GrammarError {
		System.out.println("term1 ::= term2 repTerm2");
		ITerm2 term2 = term2();
		IRepTerm2 repTerm2 = repTerm2();
		return new Term1(term2, repTerm2);
	}
	
	private IRepTerm2 repTerm2() throws GrammarError {
		if (terminal==Terminals.RELOPR) {
			System.out.println("repTerm2 ::= RELOPR term2 repTerm2");
			Operator.RelOpr relOpr = (Operator.RelOpr)consume(Terminals.RELOPR);
			ITerm2 term2 = term2();
			IRepTerm2 repTerm2= repTerm2();
			return new RepTerm2(relOpr, term2, repTerm2);
		} else {
			System.out.println("repTerm2 ::= epsilon");
			return new RepTerm2Eps();
		}
	}
	
	private ITerm2 term2() throws GrammarError {
		System.out.println("term2 ::= term3 repTerm3");
		ITerm3 term3 = term3();
		IRepTerm3 repTerm3 = repTerm3();
		return new Term2(term3, repTerm3);
	}

	private IRepTerm3 repTerm3() throws GrammarError {
		if (terminal==Terminals.ADDOPR) {
			System.out.println("repTerm3 ::= RELOPR term3 repTerm3");
			Operator.AddOpr addOpr = (Operator.AddOpr)consume(Terminals.ADDOPR);
			ITerm3 term3 = term3();
			IRepTerm3 repTerm3= repTerm3();
			return new RepTerm3(addOpr, term3, repTerm3);
		} else {
			System.out.println("repTerm3 ::= epsilon");
			return new RepTerm3Eps();
		}
	}
	
	private ITerm3 term3() throws GrammarError {
		System.out.println("term3 ::= factor repFactor");
		IFactor factor = factor();
		IRepFactor repFactor = repFactor();
		return new Term3(factor, repFactor);
	}

	private IRepFactor repFactor() throws GrammarError {
		if (terminal==Terminals.MULTOPR) {
			System.out.println("repFactor ::= MULTOPR factor repFactor");
			Operator.MultOpr multOpr = (Operator.MultOpr)consume(Terminals.MULTOPR);
			IFactor factor = factor();
			IRepFactor repFactor= repFactor();
			return new RepFactor(multOpr, factor, repFactor);
		} else {
			System.out.println("repFactor ::= epsilon");
			return new RepFactorEps();
		}
	}

	private IFactor factor() throws GrammarError {
		switch (terminal) {
			case LITERAL:
				System.out.println("factor ::= LITERAL");
				return new FactorLiteral((Literal)consume(Terminals.LITERAL));
			case IDENT:
				System.out.println("factor ::= IDENT auxIdent");
				Ident ident = (Ident)consume(Terminals.IDENT);
				IAuxIdent auxIdent = auxIdent();
				return new FactorIdent(ident, auxIdent);
			case LPAREN:
				System.out.println("factor ::= LPAREN expr RPAREN");
				consume(Terminals.LPAREN);
				IExpr expr = expr();
				consume(Terminals.RPAREN);
				return new FactorExpr(expr);
			default:
				System.out.println("factor ::= monadicOpr factor");
				IMonadicOpr monadicOpr = monadicOpr();
				IFactor factor = factor();
				return new FactorMonadicOpr(monadicOpr, factor);
		}
	}
	
	private IAuxIdent auxIdent() throws GrammarError {
		switch (terminal) {
			case INIT:
				System.out.println("auxIdent ::= INIT");
				consume(Terminals.INIT);
				return new AuxIdentInit();
			case LPAREN:
				System.out.println("auxIdent ::= exprList auxGlobInitList");
				IExprList exprList=exprList();
				IAuxGlobInitList auxGlobInitList = auxGlobInitList();
				return new AuxIdentExprList(exprList, auxGlobInitList);
			default:
				System.out.println("auxIdent ::= epsilon");
				return new AuxIdentEps();
		}
	}
	
	private IExprList exprList() throws GrammarError {
		System.out.println("exprList ::= LPAREN auxExprList RPAREN");
		consume(Terminals.LPAREN);
		IAuxExprList auxExprList = auxExprList();
		consume(Terminals.RPAREN);
		return new ExprList(auxExprList);
	}
	
	private IAuxExprList auxExprList() throws GrammarError {
		if (terminal==Terminals.RPAREN) {
			System.out.println("auxExprList ::= epsilon");
			return new AuxExprListEps();
		} else {
			System.out.println("auxExprList ::= expr repExpr");
			IExpr expr=expr();
			IRepExpr repExpr=repExpr();
			return new AuxExprList(expr, repExpr);
		}
	}
	
	private IRepExpr repExpr() throws GrammarError {
		if (terminal!=Terminals.COMMA) {
			System.out.println("repExpr ::= epsilon");
			return new RepExprEps();
		} else {
			System.out.println("repExpr ::= COMMA expr repExpr");
			consume(Terminals.COMMA);
			IExpr expr = expr();
			IRepExpr repExpr = repExpr();
			return new RepExpr(expr, repExpr);
		}
	}
		
	private IMonadicOpr monadicOpr() throws GrammarError {
		switch (terminal) {
		case NOT:
			System.out.println("monadicOpr ::= NOT");
			return new MonadicOpr((Operator)consume(Terminals.NOT));
		case ADDOPR:
			System.out.println("monadicOpr ::= ADDOPR");
			return new MonadicOpr((Operator)consume(Terminals.ADDOPR));
		default:
			throw new GrammarError("terminal expected: NOT | ADDOPR "+
					", terminal found: " + terminal, token.getLine());
		}
	}
	
	
	
	
	
	private IAuxMechMode auxMechMode() throws GrammarError {
		if (terminal==Terminals.MECHMODE) {
			System.out.println("auxMechMode ::= MECHMODE");
			return new AuxMechMode((Mode.MechMode)consume(Terminals.MECHMODE));
		} else {
			System.out.println("auxMechMode ::= epsilon");
			return new AuxMechModeEps();
		}
	}
	
	private IAuxChangeMode auxChangeMode() throws GrammarError {
		if (terminal==Terminals.CHANGEMODE) {
			System.out.println("auxChangeMode ::= CHANGEMODE");
			return new AuxChangeMode((Mode.ChangeMode)consume(Terminals.CHANGEMODE));
		} else {
			System.out.println("auxChangeMode ::= epsilon");
			return new AuxChangeModeEps();
		}
	}
	
	private IAuxFlowMode auxFlowMode() throws GrammarError {
		if (terminal==Terminals.FLOWMODE) {
			System.out.println("auxFlowMode ::= FLOWMODE");
			return new AuxFlowMode((Mode.FlowMode)consume(Terminals.FLOWMODE));
		} else {
			System.out.println("auxFlowMode ::= epsilon");
			return new AuxFlowModeEps();
		}
	}
	
	private IAuxExprCmd auxExprCmd() throws GrammarError {
		if (terminal==Terminals.BECOMES) {
			System.out.println("auxExprCmd ::= BECOMES expr");
			consume(Terminals.BECOMES);
			return new AuxExprCmdBecomes(expr());
		} else{
			System.out.println("auxExprCmd ::= epsilon");
			return new AuxExprCmdEps();
		}
	}
	
}
