/* Generated By:JJTree: Do not edit this line. ASTIncrementPostfixNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTIncrementPostfixNode extends JexlNode {
  public ASTIncrementPostfixNode(int id) {
    super(id);
  }

  public ASTIncrementPostfixNode(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6334a55995ba0f536df077aaf1e11d19 (do not edit this line) */
