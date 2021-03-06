package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;

public class TExtractDelimitedFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractDelimitedFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractDelimitedFieldsMainJava result = new TExtractDelimitedFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "try{" + NL + "" + NL + "\t";
  protected final String TEXT_5 = " = new ";
  protected final String TEXT_6 = "Struct();";
  protected final String TEXT_7 = NL + "\tString field_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";" + NL + "\tString[] newFields_";
  protected final String TEXT_11 = " = field_";
  protected final String TEXT_12 = ".split(";
  protected final String TEXT_13 = ",-1);" + NL + "\tint length_";
  protected final String TEXT_14 = " = newFields_";
  protected final String TEXT_15 = ".length;";
  protected final String TEXT_16 = NL + "\t\tfor(int i_";
  protected final String TEXT_17 = " = 0;i_";
  protected final String TEXT_18 = " < length_";
  protected final String TEXT_19 = ";i_";
  protected final String TEXT_20 = "++){" + NL + "\t\t\tnewFields_";
  protected final String TEXT_21 = "[i_";
  protected final String TEXT_22 = "] = newFields_";
  protected final String TEXT_23 = "[i_";
  protected final String TEXT_24 = "].trim();" + NL + "\t\t}";
  protected final String TEXT_25 = NL + "\t";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " ;";
  protected final String TEXT_30 = NL + "\tString temp_";
  protected final String TEXT_31 = " = null;";
  protected final String TEXT_32 = NL + "\t";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ">=length_";
  protected final String TEXT_36 = "?\"\":newFields_";
  protected final String TEXT_37 = "[";
  protected final String TEXT_38 = "];";
  protected final String TEXT_39 = NL + "\ttemp_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ">=length_";
  protected final String TEXT_42 = "?\"\":newFields_";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "];" + NL + "\tif(temp_";
  protected final String TEXT_45 = ".length() > 0) {";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = temp_";
  protected final String TEXT_49 = ".getBytes();";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", false);";
  protected final String TEXT_55 = NL + "\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = ParserUtils.parseTo_";
  protected final String TEXT_63 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = "));";
  protected final String TEXT_67 = NL + "\t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = ParserUtils.parseTo_";
  protected final String TEXT_70 = "(temp_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t} else {\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_74 = "' in '";
  protected final String TEXT_75 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_76 = NL + "\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "\t}";
  protected final String TEXT_81 = NL + "\t int filedsum_";
  protected final String TEXT_82 = " = newFields_";
  protected final String TEXT_83 = ".length;" + NL + "\t if(filedsum_";
  protected final String TEXT_84 = " < ";
  protected final String TEXT_85 = "){" + NL + "\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_86 = " > ";
  protected final String TEXT_87 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }     ";
  protected final String TEXT_88 = NL + "\t";
  protected final String TEXT_89 = " = null;";
  protected final String TEXT_90 = NL + "\tnb_line_";
  protected final String TEXT_91 = "++;" + NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_92 = "){";
  protected final String TEXT_93 = NL + "\tthrow(ex_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t";
  protected final String TEXT_96 = " = new ";
  protected final String TEXT_97 = "Struct();";
  protected final String TEXT_98 = NL + "    ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = "    ";
  protected final String TEXT_104 = NL + "    ";
  protected final String TEXT_105 = ".errorMessage = ex_";
  protected final String TEXT_106 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = NL + "    ";
  protected final String TEXT_109 = " = null;";
  protected final String TEXT_110 = NL + "    System.err.println(ex_";
  protected final String TEXT_111 = ".getMessage());";
  protected final String TEXT_112 = NL + "    ";
  protected final String TEXT_113 = " = null;";
  protected final String TEXT_114 = NL + "\t";
  protected final String TEXT_115 = ".errorMessage = ex_";
  protected final String TEXT_116 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_117 = ";";
  protected final String TEXT_118 = NL + "}";
  protected final String TEXT_119 = NL + NL;
  protected final String TEXT_120 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String field = ElementParameterParser.getValue(node, "__FIELD__");
String separator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

boolean trim = ("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
if(inConns!=null){
    for (IConnection conn : inConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		inConn = conn;
    		break;
    	}
    }
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName();
}

String firstConnName = "";
IConnection outConn = null;
List< ? extends IConnection> outConns = node.getOutgoingConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		outConn = conn;
    		firstConnName = outConn.getName();
    		break;
    	}
    }
}

if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    
    	}
    }
}

//get field column
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_6);
    
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
		if(inputCol.getLabel().equals(field)){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			if(trim){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			}
			break;
		}
	}


//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
IMetadataTable outputMetadataTable = outConn.getMetadataTable();

	for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
		boolean isOirginalColumn = false;
		for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
			if( outputCol.getLabel().equals( inputCol.getLabel()) ){
				isOirginalColumn = true;

    stringBuffer.append(TEXT_25);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_29);
    
				break;
			}
		}
		if(!isOirginalColumn){
			if(!("").equals(rejectConnName)&&rejectConnName.equals(firstConnName)
				&& (outputCol.getLabel().equals("errorMessage") || outputCol.getLabel().equals("errorCode"))){
			}else{
				newColumnList.add(outputCol);
			}
		}
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
	for(int i=0; i<newColumnList.size();i++){
		IMetadataColumn column = newColumnList.get(i);
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
		if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_38);
    
		}else{ 

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    
			if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_46);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
			}else if(javaType == JavaTypesManager.DATE) {
				if(checkNum || checkDate){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_54);
    
				}else{

    stringBuffer.append(TEXT_55);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_59);
    
				}
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_60);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_66);
    
			} else {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
			}

    stringBuffer.append(TEXT_72);
    
			String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
			if(defaultValue == null) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_75);
    
			} else {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_79);
    
			}

    stringBuffer.append(TEXT_80);
    
		}
	}
	
	if(checkNum) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_87);
    
	}
	
	if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_88);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_89);
    
	}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
	if(dieOnError){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_97);
    
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    
			}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_109);
    
		} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_113);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_117);
    
		}
	}

    stringBuffer.append(TEXT_118);
    
}

    stringBuffer.append(TEXT_119);
    stringBuffer.append(TEXT_120);
    return stringBuffer.toString();
  }
}
