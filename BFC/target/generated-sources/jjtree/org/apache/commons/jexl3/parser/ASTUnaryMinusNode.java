/* Generated By:JJTree: Do not edit this line. ASTUnaryMinusNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTUnaryMinusNode extends JexlNode {
  public ASTUnaryMinusNode(int id) {
    super(id);
  }

  public ASTUnaryMinusNode(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=269301a1240eee4bfd28937c46be2199 (do not edit this line) */
