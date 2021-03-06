package org.talend.designer.codegen.translators.business.microsoft_crm;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputBeginJava result = new TMicrosoftCrmOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tint nb_line_";
  protected final String TEXT_2 = " = 0;\t" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_7 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_9 = " = service_";
  protected final String TEXT_10 = "._getServiceClient().getOptions();" + NL + "\t\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_11 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "\t\t\t\t" + NL + "\t\t\t\tList<String> authSchemes_";
  protected final String TEXT_12 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\tauthSchemes_";
  protected final String TEXT_13 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\t\tauth_";
  protected final String TEXT_14 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t" + NL + "\t            auth_";
  protected final String TEXT_16 = " .setUsername(";
  protected final String TEXT_17 = ");" + NL + "\t            auth_";
  protected final String TEXT_18 = " .setPassword(";
  protected final String TEXT_19 = ");" + NL + "\t            auth_";
  protected final String TEXT_20 = " .setHost(";
  protected final String TEXT_21 = ");" + NL + "\t            auth_";
  protected final String TEXT_22 = " .setPort(";
  protected final String TEXT_23 = ");" + NL + "\t            auth_";
  protected final String TEXT_24 = " .setDomain(";
  protected final String TEXT_25 = ");" + NL + "\t            auth_";
  protected final String TEXT_26 = " .setPreemptiveAuthentication(false);" + NL + "\t            " + NL + "\t            options_";
  protected final String TEXT_27 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_28 = ");" + NL + "\t            options_";
  protected final String TEXT_29 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_30 = "\");" + NL + "\t            " + NL + "\t            options_";
  protected final String TEXT_31 = " .setUserName(";
  protected final String TEXT_32 = ");" + NL + "\t            options_";
  protected final String TEXT_33 = " .setPassword(";
  protected final String TEXT_34 = ");" + NL + "\t            options_";
  protected final String TEXT_35 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_36 = "));" + NL + "\t            " + NL + "\t            options_";
  protected final String TEXT_37 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_38 = "));" + NL + "\t            options_";
  protected final String TEXT_39 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_40 = "));" + NL + "\t            " + NL + "\t            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_41 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_42 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t            token_";
  protected final String TEXT_43 = ".setAuthenticationType(0);" + NL + "\t            token_";
  protected final String TEXT_44 = ".setOrganizationName(";
  protected final String TEXT_45 = ");" + NL + "\t            catd_";
  protected final String TEXT_46 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_47 = ");" + NL + "\t        ";
  protected final String TEXT_48 = NL + "\t        \tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_49 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(\"https://\" + ";
  protected final String TEXT_50 = " + \"/MSCrmServices/2007/CrmService.asmx\");" + NL + "\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_51 = " = service_";
  protected final String TEXT_52 = "._getServiceClient().getOptions();" + NL + "\t        \torg.talend.mscrm.login.passport.MsDynamicsWrapper msDynamicsWrapper_";
  protected final String TEXT_53 = " = new org.talend.mscrm.login.passport.MsDynamicsWrapper(";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = ",";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\tmsDynamicsWrapper_";
  protected final String TEXT_58 = ".connect();" + NL + "\t\t\t\tString crmTicket_";
  protected final String TEXT_59 = " = msDynamicsWrapper_";
  protected final String TEXT_60 = ".getCrmTicket();" + NL + "\t        \t" + NL + "\t        \toptions_";
  protected final String TEXT_61 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_62 = "\");" + NL + "\t        \toptions_";
  protected final String TEXT_63 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_64 = "));" + NL + "\t            " + NL + "\t            options_";
  protected final String TEXT_65 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_66 = "));" + NL + "\t            options_";
  protected final String TEXT_67 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_68 = "));" + NL + "\t        \t" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_69 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_70 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t            token_";
  protected final String TEXT_71 = ".setAuthenticationType(1);" + NL + "\t            token_";
  protected final String TEXT_72 = ".setOrganizationName(";
  protected final String TEXT_73 = ");" + NL + "\t            token_";
  protected final String TEXT_74 = ".setCrmTicket(crmTicket_";
  protected final String TEXT_75 = ");" + NL + "\t            catd_";
  protected final String TEXT_76 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_77 = ");" + NL + "\t        ";
  protected final String TEXT_78 = NL + "            " + NL + "     \t" + NL + "" + NL + "  \t\t" + NL + "        \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

			String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
			String endpointURL = ElementParameterParser.getValue(node, "__ENDPOINTURL__");
			String orgName = ElementParameterParser.getValue(node, "__ORGNAME__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
			String host = ElementParameterParser.getValue(node, "__HOST__");
			String port = ElementParameterParser.getValue(node, "__PORT__");
			String timeoutSecTemp = ElementParameterParser.getValue(node, "__TIMEOUT__");
			String timeoutSec = (timeoutSecTemp!=null&&!("").equals(timeoutSecTemp))?timeoutSecTemp:"2";
			int timeout = (int)(Double.valueOf(timeoutSec) * 1000);
			boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
			boolean debug = ("true").equals(ElementParameterParser.getValue(node,"__DEBUG__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    if(debug){
    stringBuffer.append(TEXT_3);
    }else{
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    if(("ON_PREMISE").equals(authType)){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(endpointURL);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }else if(("ONLINE").equals(authType)){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}
