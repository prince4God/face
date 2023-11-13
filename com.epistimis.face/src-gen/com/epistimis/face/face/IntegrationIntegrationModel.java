/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integration Integration Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.IntegrationIntegrationModel#getIm <em>Im</em>}</li>
 *   <li>{@link com.epistimis.face.face.IntegrationIntegrationModel#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see com.epistimis.face.face.FacePackage#getIntegrationIntegrationModel()
 * @model
 * @generated
 */
public interface IntegrationIntegrationModel extends FaceElement
{
  /**
   * Returns the value of the '<em><b>Im</b></em>' containment reference list.
   * The list contents are of type {@link com.epistimis.face.face.IntegrationIntegrationModel}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Im</em>' containment reference list.
   * @see com.epistimis.face.face.FacePackage#getIntegrationIntegrationModel_Im()
   * @model containment="true"
   * @generated
   */
  EList<IntegrationIntegrationModel> getIm();

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference list.
   * The list contents are of type {@link com.epistimis.face.face.IntegrationElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference list.
   * @see com.epistimis.face.face.FacePackage#getIntegrationIntegrationModel_Element()
   * @model containment="true"
   * @generated
   */
  EList<IntegrationElement> getElement();

} // IntegrationIntegrationModel