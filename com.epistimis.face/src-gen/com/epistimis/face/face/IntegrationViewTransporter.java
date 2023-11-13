/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integration View Transporter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.IntegrationViewTransporter#getChannel <em>Channel</em>}</li>
 * </ul>
 *
 * @see com.epistimis.face.face.FacePackage#getIntegrationViewTransporter()
 * @model
 * @generated
 */
public interface IntegrationViewTransporter extends IntegrationTransportNode
{
  /**
   * Returns the value of the '<em><b>Channel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channel</em>' reference.
   * @see #setChannel(IntegrationTransportChannel)
   * @see com.epistimis.face.face.FacePackage#getIntegrationViewTransporter_Channel()
   * @model
   * @generated
   */
  IntegrationTransportChannel getChannel();

  /**
   * Sets the value of the '{@link com.epistimis.face.face.IntegrationViewTransporter#getChannel <em>Channel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channel</em>' reference.
   * @see #getChannel()
   * @generated
   */
  void setChannel(IntegrationTransportChannel value);

} // IntegrationViewTransporter