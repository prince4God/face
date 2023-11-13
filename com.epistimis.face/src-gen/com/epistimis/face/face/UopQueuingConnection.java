/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uop Queuing Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.UopQueuingConnection#getDepth <em>Depth</em>}</li>
 * </ul>
 *
 * @see com.epistimis.face.face.FacePackage#getUopQueuingConnection()
 * @model
 * @generated
 */
public interface UopQueuingConnection extends UopPubSubConnection
{
  /**
   * Returns the value of the '<em><b>Depth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Depth</em>' attribute.
   * @see #setDepth(int)
   * @see com.epistimis.face.face.FacePackage#getUopQueuingConnection_Depth()
   * @model
   * @generated
   */
  int getDepth();

  /**
   * Sets the value of the '{@link com.epistimis.face.face.UopQueuingConnection#getDepth <em>Depth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Depth</em>' attribute.
   * @see #getDepth()
   * @generated
   */
  void setDepth(int value);

} // UopQueuingConnection