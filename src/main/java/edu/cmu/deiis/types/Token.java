

/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;




/** 
 * Updated by JCasGen Fri Mar 28 19:27:15 CST 2014
 * XML source: /Users/IBAGNOG/Documents/workspace/hw3-139547/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Token extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Token.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Token(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
  //*--------------*
  //* Feature: token_type

  /** getter for token_type - gets Identifier for the token. If it comes from an Answer it will contain an "A", else it will contain a "Q".
   * @generated
   * @return value of the feature 
   */
  public String getToken_type() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_token_type == null)
      jcasType.jcas.throwFeatMissing("token_type", "edu.cmu.deiis.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_token_type);}
    
  /** setter for token_type - sets Identifier for the token. If it comes from an Answer it will contain an "A", else it will contain a "Q". 
   * @generated
   * @param v value to set into the feature 
   */
  public void setToken_type(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_token_type == null)
      jcasType.jcas.throwFeatMissing("token_type", "edu.cmu.deiis.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_token_type, v);}    
   
    
  //*--------------*
  //* Feature: line_doc

  /** getter for line_doc - gets Identifier for the token, to which line in the document the token corresponds to.
   * @generated
   * @return value of the feature 
   */
  public int getLine_doc() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_line_doc == null)
      jcasType.jcas.throwFeatMissing("line_doc", "edu.cmu.deiis.types.Token");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Token_Type)jcasType).casFeatCode_line_doc);}
    
  /** setter for line_doc - sets Identifier for the token, to which line in the document the token corresponds to. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLine_doc(int v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_line_doc == null)
      jcasType.jcas.throwFeatMissing("line_doc", "edu.cmu.deiis.types.Token");
    jcasType.ll_cas.ll_setIntValue(addr, ((Token_Type)jcasType).casFeatCode_line_doc, v);}    
  }

    