/* Generated By:JJTree: Do not edit this line. ASTMultipleAssignment.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTMultipleAssignment extends JexlNode {
  public ASTMultipleAssignment(int id) {
    super(id);
  }

  public ASTMultipleAssignment(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=a67b38d7c560b72b2237018cc25b76d4 (do not edit this line) */
