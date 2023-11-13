/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uop Pub Sub Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.UopPubSubConnection#getMessageExchangeType <em>Message Exchange Type</em>}</li>
 *   <li>{@link com.epistimis.face.face.UopPubSubConnection#getMessageType <em>Message Type</em>}</li>
 * </ul>
 *
 * @see com.epistimis.face.face.FacePackage#getUopPubSubConnection()
 * @model
 * @generated
 */
public interface UopPubSubConnection extends UopConnection
{
  /**
   * Returns the value of the '<em><b>Message Exchange Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.epistimis.face.face.UopMessageExchangeType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Exchange Type</em>' attribute.
   * @see com.epistimis.face.face.UopMessageExchangeType
   * @see #setMessageExchangeType(UopMessageExchangeType)
   * @see com.epistimis.face.face.FacePackage#getUopPubSubConnection_MessageExchangeType()
   * @model
   * @generated
   */
  UopMessageExchangeType getMessageExchangeType();

  /**
   * Sets the value of the '{@link com.epistimis.face.face.UopPubSubConnection#getMessageExchangeType <em>Message Exchange Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Exchange Type</em>' attribute.
   * @see com.epistimis.face.face.UopMessageExchangeType
   * @see #getMessageExchangeType()
   * @generated
   */
  void setMessageExchangeType(UopMessageExchangeType value);

  /**
   * Returns the value of the '<em><b>Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Type</em>' reference.
   * @see #setMessageType(UopMessageType)
   * @see com.epistimis.face.face.FacePackage#getUopPubSubConnection_MessageType()
   * @model
   * @generated
   */
  UopMessageType getMessageType();

  /**
   * Sets the value of the '{@link com.epistimis.face.face.UopPubSubConnection#getMessageType <em>Message Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Type</em>' reference.
   * @see #getMessageType()
   * @generated
   */
  void setMessageType(UopMessageType value);

} // UopPubSubConnection