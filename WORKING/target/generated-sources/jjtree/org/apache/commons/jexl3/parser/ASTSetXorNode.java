/* Generated By:JJTree: Do not edit this line. ASTSetXorNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTSetXorNode extends JexlNode {
  public ASTSetXorNode(int id) {
    super(id);
  }

  public ASTSetXorNode(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=24ba46f70e130b18306d73fecefc16b5 (do not edit this line) */
