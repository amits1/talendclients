package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TSalesforceGetUpdatedEndJava
{
  protected static String nl;
  public static synchronized TSalesforceGetUpdatedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceGetUpdatedEndJava result = new TSalesforceGetUpdatedEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t}" + NL + "\t\t\t  }\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\tsfMgr_";
  protected final String TEXT_2 = ".logout();";
  protected final String TEXT_3 = NL + "globalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\", nb_line_";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) {		
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		IConnection outgoingConn = outgoingConns.get(0);
		if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
		}
	}
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
