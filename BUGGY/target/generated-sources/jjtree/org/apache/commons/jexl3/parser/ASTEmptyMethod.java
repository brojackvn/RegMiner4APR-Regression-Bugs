/* Generated By:JJTree: Do not edit this line. ASTEmptyMethod.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTEmptyMethod extends JexlNode {
  public ASTEmptyMethod(int id) {
    super(id);
  }

  public ASTEmptyMethod(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=5a0d2fe3b16e1f4d2726b5133361f6d1 (do not edit this line) */
