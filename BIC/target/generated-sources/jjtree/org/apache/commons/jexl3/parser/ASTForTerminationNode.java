/* Generated By:JJTree: Do not edit this line. ASTForTerminationNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.commons.jexl3.parser;

public
class ASTForTerminationNode extends JexlNode {
  public ASTForTerminationNode(int id) {
    super(id);
  }

  public ASTForTerminationNode(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=4853c426a64da45366b6e2f0f5db6282 (do not edit this line) */
