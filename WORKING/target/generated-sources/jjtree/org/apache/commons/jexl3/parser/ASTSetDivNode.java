/* Generated By:JJTree: Do not edit this line. ASTSetDivNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTSetDivNode extends JexlNode {
  public ASTSetDivNode(int id) {
    super(id);
  }

  public ASTSetDivNode(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=047d86ec79fa40c54b1ad861cc7e2479 (do not edit this line) */
