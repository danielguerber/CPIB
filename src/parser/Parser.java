package parser;

import parser.concsyn.IConcSyn;
import parser.concsyn.IConcSyn.IRepIdent;
import parser.concsyn.IConcSyn.*;
import parser.concsyn.implementation.*;
import token.ITokenList;
import token.classes.Base;
import token.classes.Ident;
import token.classes.Literal;
import token.classes.Mode;
import token.classes.Operator;
import token.classes.Operator.AddOpr;
import token.classes.Type;
import token.enums.Modes;
import token.enums.Terminals;

public class Parser {
	
	@SuppressWarnings("serial")
	public static class GrammarError extends Exception
	{
		GrammarError(String errorMessage, int line)
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
		System.out.println("program ::= PROGRAM Ident [GLOBAL cpsDecl] blockCmd");
		consume(Terminals.PROGRAM);
		Ident ident = (Ident)consume(Terminals.IDENT);
		ICpsDecl cpsDecl;
		if(terminal==Terminals.GLOBAL) {
			consume(Terminals.GLOBAL);
			cpsDecl=cpsDecl();
		} else {
			cpsDecl=cpsDeclEps();
		}
		IBlockCmd blockCmd = blockCmd();
		return new Program(ident,cpsDecl,blockCmd);
	}
	
	private ICpsDecl cpsDeclEps() {
		System.out.println("cpsDecl := epsilon");
		return new CpsDeclEps();
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
	
	private IFunDecl funDecl() throws GrammarError {
		System.out.println("funDecl ::= FUN IDENT paramList RETURNS storeDecl" + 
						" [GLOBAL globImpList] [LOCAL cpsDecl] blockCmd");
		consume(Terminals.FUN);
		Ident ident = (Ident)consume(Terminals.IDENT);
		IParamList paramList = paramList();
		consume(Terminals.RETURNS);
		IStoreDecl storeDecl = storeDecl();
		IGlobImpList globImpList;
		if (terminal==Terminals.GLOBAL) {
			consume(Terminals.GLOBAL);
			globImpList = globImpList();
		} else {
			globImpList = globImpListEps();
		}
		ICpsDecl cpsDecl;
		if (terminal==Terminals.LOCAL) {
			consume(Terminals.LOCAL);
			cpsDecl = cpsDecl();
		} else {
			cpsDecl = cpsDeclEps();
		}
		IBlockCmd blockCmd = blockCmd();
		return new FunDecl(ident, paramList, storeDecl, globImpList, cpsDecl, blockCmd);
	}
	
	private IProcDecl procDecl() throws GrammarError {
		System.out.println("procDecl ::= PROC IDENT paramList [GLOBAL globImpList] " +
						"[LOCAL cpsDecl] blockCmd");
		consume(Terminals.PROC);
		
		Ident ident = (Ident)consume(Terminals.IDENT);
		IParamList paramList = paramList();
		IGlobImpList globImpList;
		if (terminal==Terminals.GLOBAL) {
			consume(Terminals.GLOBAL);
			globImpList = globImpList();
		} else {
			globImpList = globImpListEps();
		}
		ICpsDecl cpsDecl;
		if (terminal==Terminals.LOCAL) {
			consume(Terminals.LOCAL);
			cpsDecl = cpsDecl();
		} else {
			cpsDecl = cpsDeclEps();
		}
		IBlockCmd blockCmd = blockCmd();
		return new ProcDecl(ident, paramList, globImpList, cpsDecl, blockCmd);
	}
	
	private IStoreDecl storeDecl() throws GrammarError {
		System.out.println("storeDecl ::= [CHANGEMODE] IDENT COLON TYPE");
		Mode.ChangeMode changeMode;
		if (terminal==Terminals.CHANGEMODE)
			changeMode=(Mode.ChangeMode)consume(Terminals.CHANGEMODE);
		else
			changeMode = new Mode.ChangeMode(Modes.VAR);//TODO:Check default ChangeMode
		Ident ident = (Ident)consume(Terminals.IDENT);
		consume(Terminals.COLON);
		Type type = (Type)consume(Terminals.TYPE);
		return new StoreDecl(changeMode, ident, type);
	}
	
	private IParamList paramList() throws GrammarError {
		System.out.println("paramList ::= LPAREN [param repParam] RPAREN");
		consume(Terminals.LPAREN);
		IParam param;
		IRepParam repParam;
		if(terminal!=Terminals.RPAREN) {
			param = param();
			repParam = repParam();
		} else {
			param = new ParamEps();
			repParam = new RepParamEps();
		}
		consume(Terminals.RPAREN);
		return new ParamList(param, repParam);
	}
	
	private IParam param() throws GrammarError {
		System.out.println("param ::= [FLOWMODE] [MECHMODE] storeDecl");
		Mode.FlowMode flowMode;
		if (terminal==Terminals.FLOWMODE) 
			flowMode=(Mode.FlowMode)consume(Terminals.FLOWMODE);
		else 
			flowMode=new Mode.FlowMode(Modes.INOUT);//TODO:Check for default FlowMode
		Mode.MechMode mechMode;
		if (terminal==Terminals.MECHMODE) 
			mechMode = (Mode.MechMode)consume(Terminals.MECHMODE);
		else 
			mechMode = new Mode.MechMode(Modes.COPY);//TODO:Check for default MechMode
		IStoreDecl storeDecl = storeDecl();
		return new Param(flowMode, mechMode, storeDecl);
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
	
	private IGlobImpList globImpListEps() {
		System.out.println("globImpList ::= epsilon");
		return new GlobImpListEps();
	}
	
	private IGlobImpList globImpList() throws GrammarError {
		System.out.println("globImpList ::= globImp repGlobImp");
		IGlobImp globImp=globImp();
		IRepGlobImp repGlobImp=repGlobImp();
		return new GlobImpList(globImp, repGlobImp);
	}
	
	private IGlobImp globImp() throws GrammarError {
		System.out.println("globImp ::= [FLOWMODE] [CHANGEMODE] IDENT");
		Mode.FlowMode flowMode;
		if (terminal==Terminals.FLOWMODE) 
			flowMode=(Mode.FlowMode)consume(Terminals.FLOWMODE);
		else 
			flowMode=new Mode.FlowMode(Modes.INOUT);//TODO:Check for default FlowMode
		
		Mode.ChangeMode changeMode;
		if (terminal==Terminals.CHANGEMODE) 
			changeMode = (Mode.ChangeMode)consume(Terminals.CHANGEMODE);
		else 
			changeMode = new Mode.ChangeMode(Modes.VAR);//TODO:Check for default ChangeMode
		
		Ident ident = (Ident)consume(Terminals.IDENT);
		return new GlobImp(flowMode, changeMode, ident);
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
	
	private IBlockCmd blockCmd() throws GrammarError {
		System.out.println("blockCmd ::= LBRACE cmd repCmd RBRACE");
		consume(Terminals.LBRACE);
		ICmd cmd = cmd();
		IRepCmd repCmd = repCmd();
		consume(Terminals.RBRACE);
		return new BlockCmd(cmd, repCmd);
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
				System.out.println("cmd ::= expr [BECOMES expr]");
				IExpr targetExpr = expr();
				IExpr sourceExpr;
				if(terminal==Terminals.BECOMES) {
					consume(Terminals.BECOMES);
					sourceExpr = expr();
				} else {
					sourceExpr = new ExprEps();
				}
				return new CmdExpr(targetExpr, sourceExpr);
		}
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
	
	private IExpr expr() throws GrammarError {
		System.out.println("expr ::= term1 repTerm1");
		ITerm1 term1 = term1();
		IRepTerm1 repTerm1 = repTerm1();
		return new Expr(term1, repTerm1);
	}
	
	private ITerm1 term1() throws GrammarError {
		System.out.println("term1 ::= term2 repTerm2");
		ITerm2 term2 = term2();
		IRepTerm2 repTerm2 = repTerm2();
		return new Term1(term2, repTerm2);
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
	
	private ITerm2 term2() throws GrammarError {
		System.out.println("term2 ::= term3 repTerm3");
		ITerm3 term3 = term3();
		IRepTerm3 repTerm3 = repTerm3();
		return new Term2(term3, repTerm3);
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
	
	private ITerm3 term3() throws GrammarError {
		System.out.println("term3 ::= factor repFactor");
		IFactor factor = factor();
		IRepFactor repFactor = repFactor();
		return new Term3(factor, repFactor);
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
	
	private IRepFactor repFactor() throws GrammarError {
		if (terminal==Terminals.MULTOPR) {
			System.out.println("repFactor ::= MULTOPR factor repFactor");
			Operator.MultOpr multOpr = (Operator.MultOpr)consume(Terminals.MULTOPR);
			IFactor factor = factor();
			IRepFactor repFactor= repFactor();
			return new RepFactor(multOpr, factor, repFactor);
		} else {
			System.out.println("repTerm3 ::= epsilon");
			return new RepFactorEps();
		}
	}

	private IFactor factor() throws GrammarError {
		switch (terminal) {
			case LITERAL:
				System.out.println("factor ::= LITERAL");
				return new FactorLiteral((Literal)consume(Terminals.LITERAL));
			case IDENT:
				System.out.println("factor ::= IDENT identSpec");
				Ident ident = (Ident)consume(Terminals.IDENT);
				IIdentSpec identSpec = identSpec();
				return new FactorIdent(ident, identSpec);
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
	
	private IIdentSpec identSpec() throws GrammarError {
		switch (terminal) {
			case INIT:
				System.out.println("identSpec ::= INIT");
				consume(Terminals.INIT);
				return new IdentSpecInit();
			case LPAREN:
				System.out.println("identSpec ::= exprList");
				IExprList exprList=exprList();
				return new IdentSpecExprList(exprList);
			default:
				System.out.println("identSpec ::= epsilon");
				return new IdentSpecEps();
		}
	}
		
	private IMonadicOpr monadicOpr() throws GrammarError {
		switch (terminal) {
		case NOT:
			System.out.println("monadicOpr ::= NOT");
			consume(Terminals.NOT);
			return new MonadicOprNot();
		case ADDOPR:
			System.out.println("monadicOpr ::= ADDOPR");
			AddOpr addOpr = (AddOpr)consume(Terminals.ADDOPR);
			return new MonadicOprAddOpr(addOpr);
		default:
			throw new GrammarError("terminal expected: NOT | ADDOPR "+
					", terminal found: " + terminal, token.getLine());
		}
	}
	
	private IExprList exprList() throws GrammarError {
		System.out.println("LPAREN [expr repExpr] RPAREN");
		consume(Terminals.LPAREN);
		IExpr expr;
		IRepExpr repExpr;
		if (terminal==Terminals.RPAREN) {
			expr=new ExprEps();
			repExpr=new RepExprEps();
		} else {
			expr=expr();
			repExpr=repExpr();
		}
		consume(Terminals.RPAREN);
		return new ExprList(expr, repExpr);
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
	
	
}
