package org.talend.designer.codegen.translators.elt.map.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import java.util.List;
import java.util.LinkedList;

public class TELTTeradataOutputMainJava
{
  protected static String nl;
  public static synchronized TELTTeradataOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTTeradataOutputMainJava result = new TELTTeradataOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString select_query = null;" + NL + "\tString selectQueryColumnsName = null;" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tselect_query = (String) globalMap.get(\"";
  protected final String TEXT_4 = "\"+\"QUERY\"+\"";
  protected final String TEXT_5 = "\");" + NL + "\t\tselectQueryColumnsName = (String) globalMap.get(\"";
  protected final String TEXT_6 = "\"+\"QUERY_COLUMNS_NAME\"+\"";
  protected final String TEXT_7 = "\");" + NL + "\t\t";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_11 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "    java.lang.Class.forName(\"com.teradata.jdbc.TeraDriver\");" + NL + "    String url_";
  protected final String TEXT_14 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_15 = "+ \"/DATABASE=\" + ";
  protected final String TEXT_16 = ";" + NL + "    String dbUser_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "    String dbPwd_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ";" + NL + "    java.sql.Connection conn_";
  protected final String TEXT_21 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_22 = ",dbUser_";
  protected final String TEXT_23 = ",dbPwd_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_26 = " =null;" + NL + "\t";
  protected final String TEXT_27 = NL + NL + "\tString tableName_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = "\t" + NL + "\t" + NL + "\t" + NL + "String insertQuery = \"INSERT INTO \"+tableName_";
  protected final String TEXT_31 = "+\" (";
  protected final String TEXT_32 = ") \"+select_query;" + NL + "pstmt_";
  protected final String TEXT_33 = " = conn_";
  protected final String TEXT_34 = ".prepareStatement(insertQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_35 = NL + NL + "String updateQuery = \"UPDATE \"+tableName_";
  protected final String TEXT_36 = "+\" FROM (\" + select_query + \") src SET ";
  protected final String TEXT_37 = " \"";
  protected final String TEXT_38 = NL + "+\"  WHERE \" + ";
  protected final String TEXT_39 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_40 = " = conn_";
  protected final String TEXT_41 = ".prepareStatement(updateQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_42 = NL + "\t" + NL + "String deleteQuery = \"DELETE  FROM \"+ tableName_";
  protected final String TEXT_43 = "+\" WHERE EXISTS (\"+select_query+\") \" ";
  protected final String TEXT_44 = NL + "+\"  AND \" + ";
  protected final String TEXT_45 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_46 = " = conn_";
  protected final String TEXT_47 = ".prepareStatement(deleteQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_48 = NL + "int nb_line_";
  protected final String TEXT_49 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_50 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_51 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_52 = " = 0;" + NL + "\t";
  protected final String TEXT_53 = NL + NL + "System.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");" + NL + "nb_line_inserted_";
  protected final String TEXT_54 = " = pstmt_";
  protected final String TEXT_55 = ".executeUpdate();" + NL + "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_56 = " + \" rows inserted. \\n\");" + NL + "" + NL + "\t";
  protected final String TEXT_57 = NL + "System.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");" + NL + "nb_line_update_";
  protected final String TEXT_58 = " = pstmt_";
  protected final String TEXT_59 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_60 = " + \" rows updated. \\n\");" + NL + "\t";
  protected final String TEXT_61 = NL + "\tSystem.out.println(\"Deleting with : \\n\" + deleteQuery +\"\\n\");" + NL + "\t\tnb_line_deleted_";
  protected final String TEXT_62 = " = pstmt_";
  protected final String TEXT_63 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_64 = " + \" rows deleted. \\n\");" + NL + "\t\t";
  protected final String TEXT_65 = NL + NL + "pstmt_";
  protected final String TEXT_66 = ".close();" + NL;
  protected final String TEXT_67 = NL + "    if(conn_";
  protected final String TEXT_68 = " != null && !conn_";
  protected final String TEXT_69 = ".isClosed()) {" + NL + "        conn_";
  protected final String TEXT_70 = " .close();" + NL + "    }";
  protected final String TEXT_71 = NL + "nb_line_";
  protected final String TEXT_72 = " = nb_line_update_";
  protected final String TEXT_73 = " + nb_line_inserted_";
  protected final String TEXT_74 = " + nb_line_deleted_";
  protected final String TEXT_75 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_76 = "_NB_LINE\",nb_line_";
  protected final String TEXT_77 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_78 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_79 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_80 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_81 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_82 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();

	String dbtable = null;
	String uniqueNameConnection = null;
	INode previousNode = null;

	String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
	boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));
	
	
    stringBuffer.append(TEXT_2);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_7);
    
	}
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

        String dbhost = null;
        String dbname = null;
        String dbuser = null;
        String dbpwd = null;
        boolean useExistingConn = false;
        if(previousNode != null) {
	        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	        dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
	        useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
        }

        String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");


    stringBuffer.append(TEXT_8);
    
List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_9);
    
if(useExistingConn) {
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    String conn = "conn_" + connection;
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_12);
    
} else {
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    

class Column{

	
	String name;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	public Column(IMetadataColumn column){
		String columname = column.getOriginalDbColumnName();
		if(columname!=null && columname.trim().length()>0){
			this.name = columname;
		}else{
			this.name = column.getLabel();
		}
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public String getValue(){
		return this.value;
	}
}

if(columnList != null && columnList.size()>0){


StringBuilder insertColName = new StringBuilder();

StringBuilder insertValueStmt = new StringBuilder();

StringBuilder updateSetStmt = new StringBuilder();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}

int counterOuter =0;

for(Column colStmt:stmtStructure){
	String suffix = ",";
	
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append(colStmt.getName());
			updateSetStmt.append(colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			updateSetStmt.append(colStmt.getName()+"= src\"+ selectQueryColumnsName.split(\",\")[ "+ counterOuter + "].substring(selectQueryColumnsName.split(\",\")["+ counterOuter + "].indexOf(\".\"))+\"" +suffix);
		}
		counterOuter ++;
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_29);
    

	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	}else if (("UPDATE").equals(dataAction)){
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_37);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    		
	}else if (("DELETE").equals(dataAction)){
	
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    		
	}
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	
}

if(dbtable != null && columnList != null){
	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
	}else if(("UPDATE").equals(dataAction)){

	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
	}else if (("DELETE").equals(dataAction)){
		
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	}
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
}

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
