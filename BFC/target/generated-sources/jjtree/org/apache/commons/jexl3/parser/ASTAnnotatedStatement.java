/* Generated By:JJTree: Do not edit this line. ASTAnnotatedStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTAnnotatedStatement extends JexlNode {
  public ASTAnnotatedStatement(int id) {
    super(id);
  }

  public ASTAnnotatedStatement(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=79c1564de9023a8b89d153af50230f9f (do not edit this line) */
