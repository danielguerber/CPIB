package ch.fhnw.cpib.dgu.parser;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxChangeMode;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxExprCmd;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxExprList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxFlowMode;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobCpsDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobImpList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobInitList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxIdent;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxLocCpsDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxMechMode;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxParamList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IBlockCmd;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICmd;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICpsDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IExpr;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IExprList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFactor;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFunDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IGlobImp;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IGlobImpList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IGlobInitList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IMonadicOpr;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IParam;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IParamList;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IProcDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IProgram;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepCmd;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepExpr;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepFactor;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepGlobImp;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepIdent;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepParam;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm1;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm2;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm3;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IStoreDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ITerm1;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ITerm2;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ITerm3;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxChangeMode;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxChangeModeEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxExprCmdBecomes;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxExprCmdEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxExprList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxExprListEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxFlowMode;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxFlowModeEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxGlobCpsDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxGlobCpsDeclEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxGlobImpList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxGlobImpListEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxGlobInitList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxGlobInitListEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxIdentEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxIdentExprList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxIdentInit;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxLocCpsDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxLocCpsDeclEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxMechMode;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxMechModeEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxParamList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.AuxParamListEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.BlockCmd;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CmdExcl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CmdExpr;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CmdIf;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CmdQuest;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CmdSkip;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CmdWhile;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.CpsDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.Expr;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.ExprList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.FactorExpr;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.FactorIdent;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.FactorLiteral;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.FactorMonadicOpr;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.FunDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.GlobImp;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.GlobImpList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.GlobInitList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.MonadicOpr;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.Param;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.ParamList;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.ProcDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.Program;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepCmd;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepCmdEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepDeclEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepExpr;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepExprEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepFactor;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepFactorEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepGlobImp;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepGlobImpEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepIdent;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepIdentEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepParam;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepParamEps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepTerm1;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepTerm1Eps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepTerm2;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepTerm2Eps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepTerm3;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.RepTerm3Eps;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.StoreDecl;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.Term1;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.Term2;
import ch.fhnw.cpib.dgu.parser.concsyn.implementation.Term3;
import ch.fhnw.cpib.dgu.token.ITokenList;
import ch.fhnw.cpib.dgu.token.classes.Base;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.classes.Literal;
import ch.fhnw.cpib.dgu.token.classes.Mode;
import ch.fhnw.cpib.dgu.token.classes.Operator;
import ch.fhnw.cpib.dgu.token.classes.Type;
import ch.fhnw.cpib.dgu.token.enums.Terminals;

public final class Parser {
	
	@SuppressWarnings("serial")
    public static final class GrammarError extends Exception {
		private GrammarError(final String errorMessage, final int line) {
			super(errorMessage + "\n\tat line:" + line);
			
		}
	}
	
	private final ITokenList tokenList;
	private Base token;
	private Terminals terminal;
	
	public Parser(final ITokenList tokenList) {
		this.tokenList = tokenList;
		this.tokenList.reset();
		// precondition: token list contains at least the SENTINEL
		token = tokenList.nextToken();
		// establish class invariant
		terminal = token.getTerminal();
	}
	
	private Base consume(final Terminals expectedTerminal) throws GrammarError {
		if (terminal == expectedTerminal) {
			final Base consumedToken = token;
			if (terminal != Terminals.SENTINEL) {
				token = tokenList.nextToken();
				// maintain class invariant
				terminal = token.getTerminal();
			}
			return consumedToken;
		} else {
			throw new GrammarError("terminal expected: " + expectedTerminal
				+ ", terminal found: " + terminal, token.getLine());
		}
	}
	
	public IConcSyn.IProgram parse() throws GrammarError {
		// parsing the start symbol ...
		final IConcSyn.IProgram program = program();
		// ... and then consuming the SENTINEL
		consume(Terminals.SENTINEL);
		return program;
	}
	
	private IProgram program() throws GrammarError {
		System.out.println("program ::= PROGRAM Ident auxGlobCpsDecl blockCmd");
		consume(Terminals.PROGRAM);
		final Ident ident = (Ident) consume(Terminals.IDENT);
		final IAuxGlobCpsDecl auxGlobCpsDecl = auxGlobCpsDecl();
		final IBlockCmd blockCmd = blockCmd();
		return new Program(ident, auxGlobCpsDecl, blockCmd);
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
		final IAuxChangeMode auxChangeMode = auxChangeMode();
		final Ident ident = (Ident) consume(Terminals.IDENT);
		consume(Terminals.COLON);
		final Type type = (Type) consume(Terminals.TYPE);
		return new StoreDecl(auxChangeMode, ident, type);
	}
	
	private IFunDecl funDecl() throws GrammarError {
		System.out.println("funDecl ::= FUN IDENT paramList RETURNS storeDecl"
				+ 		" auxGlobImpList auxLocCpsDecl blockCmd");
		consume(Terminals.FUN);
		final Ident ident = (Ident) consume(Terminals.IDENT);
		final IParamList paramList = paramList();
		consume(Terminals.RETURNS);
		final IStoreDecl storeDecl = storeDecl();
		final IAuxGlobImpList auxGlobImpList = auxGlobImpList();
		final IAuxLocCpsDecl auxLocCpsDecl = auxLocCpsDecl();
		final IBlockCmd blockCmd = blockCmd();
		return new FunDecl(
		        ident, 
		        paramList, 
		        storeDecl, 
		        auxGlobImpList, 
		        auxLocCpsDecl, 
		        blockCmd);
	}
	
	private IProcDecl procDecl() throws GrammarError {
		System.out.println("procDecl ::= PROC IDENT paramList auxGlobImpList "
				+ 		"auxLocCpsDecl blockCmd");
		consume(Terminals.PROC);
		final Ident ident = (Ident) consume(Terminals.IDENT);
		final IParamList paramList = paramList();
		final IAuxGlobImpList auxGlobImpList = auxGlobImpList();
		final IAuxLocCpsDecl auxLocCpsDecl = auxLocCpsDecl();
		final IBlockCmd blockCmd = blockCmd();
		return new ProcDecl(
		        ident, 
		        paramList, 
		        auxGlobImpList, 
		        auxLocCpsDecl, 
		        blockCmd);
	}
	
	private IAuxGlobCpsDecl auxGlobCpsDecl() throws GrammarError {
		if (terminal == Terminals.GLOBAL) {
			System.out.println("auxGlobCpsDecl ::= GLOBAL cpsDecl");
			consume(Terminals.GLOBAL);
			return new AuxGlobCpsDecl(cpsDecl());
		} else {
			System.out.println("auxGlobCpsDecl ::= epsilon");
			return new AuxGlobCpsDeclEps();
		}
	}
	
	private IAuxLocCpsDecl auxLocCpsDecl() throws GrammarError {
		if (terminal == Terminals.LOCAL) {
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
		final IDecl decl = decl();
		final IRepDecl repDecl = repDecl();
		return new CpsDecl(decl, repDecl);
	}
	
	private IRepDecl repDecl() throws GrammarError {
		if (terminal == Terminals.SEMICOLON) {
			System.out.println("repDecl ::= SEMICOLON decl repDecl");
			consume(Terminals.SEMICOLON);
			final IDecl decl = decl();
			final IRepDecl repDecl = repDecl();
			return new RepDecl(decl, repDecl);
		} else {
			System.out.println("repDecl ::= epsilon");
			return new RepDeclEps();
		}
	}
	
	private IParamList paramList() throws GrammarError {
		System.out.println("paramList ::= LPAREN auxParamList RPAREN");
		consume(Terminals.LPAREN);
		final IAuxParamList auxParamList = auxParamList();
		consume(Terminals.RPAREN);
		return new ParamList(auxParamList);
	}
	
	private IAuxParamList auxParamList() throws GrammarError {
		if (terminal != Terminals.RPAREN) {
			System.out.println("auxParamList ::= param repParam");
			final IParam param = param();
			final IRepParam repParam = repParam();
			return new AuxParamList(param, repParam);
		} else {
			System.out.println("auxParamList ::= epsilon");
			return new AuxParamListEps();
		}
	}
	
	private IRepParam repParam() throws GrammarError {
		if (terminal == Terminals.COMMA) {
			System.out.println("repParam ::= COMMA param repParam");
			consume(Terminals.COMMA);
			final IParam param = param();
			final IRepParam repParam = repParam();
			return new RepParam(param, repParam);
		} else {
			System.out.println("repParam ::= epsilon");
			return new RepParamEps();
		}
	}
	
	private IParam param() throws GrammarError {
		System.out.println("param ::= auxFlowMode auxMechMode storeDecl");
		final IAuxFlowMode auxFlowMode = auxFlowMode();
		final IAuxMechMode auxMechMode = auxMechMode();
		final IStoreDecl storeDecl = storeDecl();
		return new Param(auxFlowMode, auxMechMode, storeDecl);
	}
	
	private IAuxGlobImpList auxGlobImpList() throws GrammarError {
		if (terminal == Terminals.GLOBAL) {
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
		final IGlobImp globImp = globImp();
		final IRepGlobImp repGlobImp = repGlobImp();
		return new GlobImpList(globImp, repGlobImp);
	}
	
	private IRepGlobImp repGlobImp() throws GrammarError {
		if (terminal == Terminals.COMMA) {
			System.out.println("repGlobImp ::= COMMA globImp repGlobImp");
			consume(Terminals.COMMA);
			final IGlobImp globImp = globImp();
			final IRepGlobImp repGlobImp = repGlobImp();
			return new RepGlobImp(globImp, repGlobImp);
		} else {
			System.out.println("repGlobImp ::= epsilon");
			return new RepGlobImpEps();
		}
	}
	
	private IGlobImp globImp() throws GrammarError {
		System.out.println("globImp ::= auxFlowMode auxChangeMode IDENT");
		final IAuxFlowMode auxFlowMode = auxFlowMode();
		final IAuxChangeMode auxChangeMode = auxChangeMode();
		final Ident ident = (Ident) consume(Terminals.IDENT);
		return new GlobImp(auxFlowMode, auxChangeMode, ident);
	}
	
	private ICmd cmd() throws GrammarError {
		switch (terminal) {
			case SKIP:
				System.out.println("cmd ::= SKIP");
				consume(Terminals.SKIP);
				return new CmdSkip();
			case IF:
				System.out.println(
				        "cmd ::= IF LPAREN expr RPAREN blockCmd ELSE blockCmd");
				consume(Terminals.IF);
				consume(Terminals.LPAREN);
				final IExpr ifExpr = expr();
				consume(Terminals.RPAREN);
				final IBlockCmd ifCmd = blockCmd();
				consume(Terminals.ELSE);
				final IBlockCmd elseCmd = blockCmd();
				return new CmdIf(ifExpr, ifCmd, elseCmd);
			case WHILE:
				System.out.println("cmd ::= WHILE LPAREN expr RPAREN blockCmd");
				consume(Terminals.WHILE);
				consume(Terminals.LPAREN);
				final IExpr whileExpr = expr();
				consume(Terminals.RPAREN);
				final IBlockCmd whileCmd = blockCmd();
				return new CmdWhile(whileExpr, whileCmd);
			case QUESTMARK:
				System.out.println("cmd ::= QUESTMARK expr");
				consume(Terminals.QUESTMARK);
				final IExpr questExpr = expr();
				return new CmdQuest(questExpr);
			case EXCLMARK:
				System.out.println("cmd ::= EXCLMARK expr");
				consume(Terminals.EXCLMARK);
				final IExpr exclExpr = expr();
				return new CmdExcl(exclExpr);
			default:
				System.out.println("cmd ::= expr auxExprCmd");
				final IExpr expr = expr();
				final IAuxExprCmd auxExprCmd = auxExprCmd();
				return new CmdExpr(expr, auxExprCmd);
		}
	}
	
	private IBlockCmd blockCmd() throws GrammarError {
		System.out.println("blockCmd ::= LBRACE cmd repCmd RBRACE");
		consume(Terminals.LBRACE);
		final ICmd cmd = cmd();
		final IRepCmd repCmd = repCmd();
		consume(Terminals.RBRACE);
		return new BlockCmd(cmd, repCmd);
	}
	
	private IRepCmd repCmd() throws GrammarError {
		if (terminal == Terminals.SEMICOLON) {
			System.out.println("repCmd ::= SEMICOLON cmd repCmd");
			consume(Terminals.SEMICOLON);
			final ICmd cmd = cmd();
			final IRepCmd repCmd = repCmd();
			return new RepCmd(cmd, repCmd);
		} else {
			System.out.println("repCmd ::= epsilon");
			return new RepCmdEps();
		}
	}
	
	private IAuxGlobInitList auxGlobInitList() throws GrammarError {
		if (terminal == Terminals.INIT) {
			System.out.println(
			        "auxGlobInitList ::= INIT LPAREN globInitList RPAREN");
			consume(Terminals.INIT);
			consume(Terminals.LPAREN);
			final IGlobInitList globInitList = globInitList();
			consume(Terminals.RPAREN);
			return new AuxGlobInitList(globInitList);
		} else {
			System.out.println("auxGlobInitList ::= epsilon");
			return new AuxGlobInitListEps();
		}
	}
	
	private IGlobInitList globInitList() throws GrammarError {
		System.out.println("globInitList ::= IDENT repIdent");
		final Ident ident = (Ident) consume(Terminals.IDENT);
		final IRepIdent repIdent = repIdent();
		return new GlobInitList(ident, repIdent);
	}

	private IRepIdent repIdent() throws GrammarError {
		if (terminal != Terminals.COMMA) {
			System.out.println("repIdent ::= epsilon");
			return new RepIdentEps();
		} else {
			System.out.println("repIdent ::= IDENT repIdent");
			final Ident ident = (Ident) consume(Terminals.IDENT);
			final IRepIdent repIdent = repIdent();
			return new RepIdent(ident, repIdent);
		}
	}
	
	private IExpr expr() throws GrammarError {
		System.out.println("expr ::= term1 repTerm1");
		final ITerm1 term1 = term1();
		final IRepTerm1 repTerm1 = repTerm1();
		return new Expr(term1, repTerm1);
	}
	
	private IRepTerm1 repTerm1() throws GrammarError {
		if (terminal == Terminals.BOOLOPR) {
			System.out.println("repTerm1 ::= BOOLOPR term1 repTerm1");
			final Operator.BoolOpr boolOpr 
			    = (Operator.BoolOpr) consume(Terminals.BOOLOPR);
			final ITerm1 term1 = term1();
			final IRepTerm1 repTerm1 = repTerm1();
			return new RepTerm1(boolOpr, term1, repTerm1);
		} else {
			System.out.println("repTerm1 ::= epsilon");
			return new RepTerm1Eps();
		}
	}
	
	private ITerm1 term1() throws GrammarError {
		System.out.println("term1 ::= term2 repTerm2");
		final ITerm2 term2 = term2();
		final IRepTerm2 repTerm2 = repTerm2();
		return new Term1(term2, repTerm2);
	}
	
	private IRepTerm2 repTerm2() throws GrammarError {
		if (terminal == Terminals.RELOPR) {
			System.out.println("repTerm2 ::= RELOPR term2 repTerm2");
			final Operator.RelOpr relOpr 
			= (Operator.RelOpr) consume(Terminals.RELOPR);
			final ITerm2 term2 = term2();
			final IRepTerm2 repTerm2 = repTerm2();
			return new RepTerm2(relOpr, term2, repTerm2);
		} else {
			System.out.println("repTerm2 ::= epsilon");
			return new RepTerm2Eps();
		}
	}
	
	private ITerm2 term2() throws GrammarError {
		System.out.println("term2 ::= term3 repTerm3");
		final ITerm3 term3 = term3();
		final IRepTerm3 repTerm3 = repTerm3();
		return new Term2(term3, repTerm3);
	}

	private IRepTerm3 repTerm3() throws GrammarError {
		if (terminal == Terminals.ADDOPR) {
			System.out.println("repTerm3 ::= RELOPR term3 repTerm3");
			final Operator.AddOpr addOpr 
			    = (Operator.AddOpr) consume(Terminals.ADDOPR);
			final ITerm3 term3 = term3();
			final IRepTerm3 repTerm3 = repTerm3();
			return new RepTerm3(addOpr, term3, repTerm3);
		} else {
			System.out.println("repTerm3 ::= epsilon");
			return new RepTerm3Eps();
		}
	}
	
	private ITerm3 term3() throws GrammarError {
		System.out.println("term3 ::= factor repFactor");
		final IFactor factor = factor();
		final IRepFactor repFactor = repFactor();
		return new Term3(factor, repFactor);
	}

	private IRepFactor repFactor() throws GrammarError {
		if (terminal == Terminals.MULTOPR) {
			System.out.println("repFactor ::= MULTOPR factor repFactor");
			final Operator.MultOpr multOpr 
			    = (Operator.MultOpr) consume(Terminals.MULTOPR);
			final IFactor factor = factor();
			final IRepFactor repFactor = repFactor();
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
				return new FactorLiteral((Literal) consume(Terminals.LITERAL));
			case IDENT:
				System.out.println("factor ::= IDENT auxIdent");
				final Ident ident = (Ident) consume(Terminals.IDENT);
				final IAuxIdent auxIdent = auxIdent();
				return new FactorIdent(ident, auxIdent);
			case LPAREN:
				System.out.println("factor ::= LPAREN expr RPAREN");
				consume(Terminals.LPAREN);
				final IExpr expr = expr();
				consume(Terminals.RPAREN);
				return new FactorExpr(expr);
			default:
				System.out.println("factor ::= monadicOpr factor");
				final IMonadicOpr monadicOpr = monadicOpr();
				final IFactor factor = factor();
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
				final IExprList exprList = exprList();
				final IAuxGlobInitList auxGlobInitList = auxGlobInitList();
				return new AuxIdentExprList(exprList, auxGlobInitList);
			default:
				System.out.println("auxIdent ::= epsilon");
				return new AuxIdentEps();
		}
	}
	
	private IExprList exprList() throws GrammarError {
		System.out.println("exprList ::= LPAREN auxExprList RPAREN");
		consume(Terminals.LPAREN);
		final IAuxExprList auxExprList = auxExprList();
		consume(Terminals.RPAREN);
		return new ExprList(auxExprList);
	}
	
	private IAuxExprList auxExprList() throws GrammarError {
		if (terminal == Terminals.RPAREN) {
			System.out.println("auxExprList ::= epsilon");
			return new AuxExprListEps();
		} else {
			System.out.println("auxExprList ::= expr repExpr");
			final IExpr expr = expr();
			final IRepExpr repExpr = repExpr();
			return new AuxExprList(expr, repExpr);
		}
	}
	
	private IRepExpr repExpr() throws GrammarError {
		if (terminal != Terminals.COMMA) {
			System.out.println("repExpr ::= epsilon");
			return new RepExprEps();
		} else {
			System.out.println("repExpr ::= COMMA expr repExpr");
			consume(Terminals.COMMA);
			final IExpr expr = expr();
			final IRepExpr repExpr = repExpr();
			return new RepExpr(expr, repExpr);
		}
	}
		
	private IMonadicOpr monadicOpr() throws GrammarError {
		switch (terminal) {
		case NOT:
			System.out.println("monadicOpr ::= NOT");
			return new MonadicOpr(consume(Terminals.NOT));
		case ADDOPR:
			System.out.println("monadicOpr ::= ADDOPR");
			return new MonadicOpr(consume(Terminals.ADDOPR));
		default:
			throw new GrammarError("terminal expected: NOT | ADDOPR "
					+ ", terminal found: " + terminal, token.getLine());
		}
	}
	
	
	
	
	
	private IAuxMechMode auxMechMode() throws GrammarError {
		if (terminal == Terminals.MECHMODE) {
			System.out.println("auxMechMode ::= MECHMODE");
			return new AuxMechMode((Mode.MechMode) consume(Terminals.MECHMODE));
		} else {
			System.out.println("auxMechMode ::= epsilon");
			return new AuxMechModeEps();
		}
	}
	
	private IAuxChangeMode auxChangeMode() throws GrammarError {
		if (terminal == Terminals.CHANGEMODE) {
			System.out.println("auxChangeMode ::= CHANGEMODE");
			return new AuxChangeMode(
			        (Mode.ChangeMode) consume(Terminals.CHANGEMODE));
		} else {
			System.out.println("auxChangeMode ::= epsilon");
			return new AuxChangeModeEps();
		}
	}
	
	private IAuxFlowMode auxFlowMode() throws GrammarError {
		if (terminal == Terminals.FLOWMODE) {
			System.out.println("auxFlowMode ::= FLOWMODE");
			return new AuxFlowMode((Mode.FlowMode) consume(Terminals.FLOWMODE));
		} else {
			System.out.println("auxFlowMode ::= epsilon");
			return new AuxFlowModeEps();
		}
	}
	
	private IAuxExprCmd auxExprCmd() throws GrammarError {
		if (terminal == Terminals.BECOMES) {
			System.out.println("auxExprCmd ::= BECOMES expr");
			consume(Terminals.BECOMES);
			return new AuxExprCmdBecomes(expr());
		} else {
			System.out.println("auxExprCmd ::= epsilon");
			return new AuxExprCmdEps();
		}
	}
	
}
