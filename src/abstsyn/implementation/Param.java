package abstsyn.implementation;

import token.classes.Mode.FlowMode;
import token.classes.Mode.MechMode;
import abstsyn.IAbstSyn.IParam;

public class Param implements IParam {
	private FlowMode flowMode;
	private MechMode mechMode;
	private IStoreDecl storeDecl;
	private IParam param;
	
	public Param(FlowMode flowMode, MechMode mechMode, IStoreDecl storeDecl,
			IParam param) {
		this.flowMode = flowMode;
		this.mechMode = mechMode;
		this.storeDecl = storeDecl;
		this.param = param;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<Param>\n" +
				flowMode.toString(indent + '\t') +
				mechMode.toString(indent + '\t') +
				storeDecl.toString(indent + '\t') +
				param.toString(indent + '\t') +
				indent +
				"</Param>\n";
	}
}
