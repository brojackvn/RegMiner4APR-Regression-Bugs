/* Generated By:JJTree: Do not edit this line. ASTEnumerationReference.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTEnumerationReference extends JexlNode {
  public ASTEnumerationReference(int id) {
    super(id);
  }

  public ASTEnumerationReference(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=dc349d0776fc16ab84e09e3af3b0151d (do not edit this line) */
