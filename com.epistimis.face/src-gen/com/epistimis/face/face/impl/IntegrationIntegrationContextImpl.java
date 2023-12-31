/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.IntegrationIntegrationContext;
import com.epistimis.face.face.IntegrationTSNodeConnection;
import com.epistimis.face.face.IntegrationTransportNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integration Integration Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationIntegrationContextImpl#getNode <em>Node</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationIntegrationContextImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegrationIntegrationContextImpl extends IntegrationElementImpl implements IntegrationIntegrationContext
{
  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected EList<IntegrationTransportNode> node;

  /**
   * The cached value of the '{@link #getConnection() <em>Connection</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnection()
   * @generated
   * @ordered
   */
  protected EList<IntegrationTSNodeConnection> connection;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrationIntegrationContextImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FacePackage.Literals.INTEGRATION_INTEGRATION_CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegrationTransportNode> getNode()
  {
    if (node == null)
    {
      node = new EObjectContainmentEList<IntegrationTransportNode>(IntegrationTransportNode.class, this, FacePackage.INTEGRATION_INTEGRATION_CONTEXT__NODE);
    }
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegrationTSNodeConnection> getConnection()
  {
    if (connection == null)
    {
      connection = new EObjectContainmentEList<IntegrationTSNodeConnection>(IntegrationTSNodeConnection.class, this, FacePackage.INTEGRATION_INTEGRATION_CONTEXT__CONNECTION);
    }
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__NODE:
        return ((InternalEList<?>)getNode()).basicRemove(otherEnd, msgs);
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__CONNECTION:
        return ((InternalEList<?>)getConnection()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__NODE:
        return getNode();
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__CONNECTION:
        return getConnection();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__NODE:
        getNode().clear();
        getNode().addAll((Collection<? extends IntegrationTransportNode>)newValue);
        return;
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__CONNECTION:
        getConnection().clear();
        getConnection().addAll((Collection<? extends IntegrationTSNodeConnection>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__NODE:
        getNode().clear();
        return;
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__CONNECTION:
        getConnection().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__NODE:
        return node != null && !node.isEmpty();
      case FacePackage.INTEGRATION_INTEGRATION_CONTEXT__CONNECTION:
        return connection != null && !connection.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IntegrationIntegrationContextImpl
