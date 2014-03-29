

/* First created by JCasGen Wed Mar 26 00:35:53 CST 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Fri Mar 28 19:27:15 CST 2014
 * XML source: /Users/IBAGNOG/Documents/workspace/hw3-139547/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Precision extends Annotation {
  /** @generated
   * @ordered 
   */
 // @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Precision.class);
  /** @generated
   * @ordered 
   */
  //@SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Precision() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Precision(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Precision(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Precision(JCas jcas, int begin, int end) {
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
  //* Feature: precision

  /** getter for precision - gets Saves precision value.

   * @generated
   * @return value of the feature 
   */
  public double getPrecision() {
    if (Precision_Type.featOkTst && ((Precision_Type)jcasType).casFeat_precision == null)
      jcasType.jcas.throwFeatMissing("precision", "edu.cmu.deiis.types.Precision");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Precision_Type)jcasType).casFeatCode_precision);}
    
  /** setter for precision - sets Saves precision value.
 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPrecision(double v) {
    if (Precision_Type.featOkTst && ((Precision_Type)jcasType).casFeat_precision == null)
      jcasType.jcas.throwFeatMissing("precision", "edu.cmu.deiis.types.Precision");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Precision_Type)jcasType).casFeatCode_precision, v);}    
  }

    