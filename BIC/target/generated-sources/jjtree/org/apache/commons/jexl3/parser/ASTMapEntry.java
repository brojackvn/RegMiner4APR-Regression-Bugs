/* Generated By:JJTree: Do not edit this line. ASTMapEntry.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTMapEntry extends JexlNode {
  public ASTMapEntry(int id) {
    super(id);
  }

  public ASTMapEntry(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c0ebe707d0eb6ec7f03e8df87939fa8e (do not edit this line) */
