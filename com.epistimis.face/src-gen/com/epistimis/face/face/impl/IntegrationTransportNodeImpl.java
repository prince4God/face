/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.IntegrationTSNodeInputPort;
import com.epistimis.face.face.IntegrationTSNodeOutputPort;
import com.epistimis.face.face.IntegrationTransportNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integration Transport Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationTransportNodeImpl#getInPort <em>In Port</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationTransportNodeImpl#getOutPort <em>Out Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegrationTransportNodeImpl extends FaceElementImpl implements IntegrationTransportNode
{
  /**
   * The cached value of the '{@link #getInPort() <em>In Port</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInPort()
   * @generated
   * @ordered
   */
  protected EList<IntegrationTSNodeInputPort> inPort;

  /**
   * The cached value of the '{@link #getOutPort() <em>Out Port</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutPort()
   * @generated
   * @ordered
   */
  protected IntegrationTSNodeOutputPort outPort;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrationTransportNodeImpl()
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
    return FacePackage.Literals.INTEGRATION_TRANSPORT_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegrationTSNodeInputPort> getInPort()
  {
    if (inPort == null)
    {
      inPort = new EObjectContainmentEList<IntegrationTSNodeInputPort>(IntegrationTSNodeInputPort.class, this, FacePackage.INTEGRATION_TRANSPORT_NODE__IN_PORT);
    }
    return inPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegrationTSNodeOutputPort getOutPort()
  {
    return outPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutPort(IntegrationTSNodeOutputPort newOutPort, NotificationChain msgs)
  {
    IntegrationTSNodeOutputPort oldOutPort = outPort;
    outPort = newOutPort;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT, oldOutPort, newOutPort);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOutPort(IntegrationTSNodeOutputPort newOutPort)
  {
    if (newOutPort != outPort)
    {
      NotificationChain msgs = null;
      if (outPort != null)
        msgs = ((InternalEObject)outPort).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT, null, msgs);
      if (newOutPort != null)
        msgs = ((InternalEObject)newOutPort).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT, null, msgs);
      msgs = basicSetOutPort(newOutPort, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT, newOutPort, newOutPort));
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
      case FacePackage.INTEGRATION_TRANSPORT_NODE__IN_PORT:
        return ((InternalEList<?>)getInPort()).basicRemove(otherEnd, msgs);
      case FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT:
        return basicSetOutPort(null, msgs);
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
      case FacePackage.INTEGRATION_TRANSPORT_NODE__IN_PORT:
        return getInPort();
      case FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT:
        return getOutPort();
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
      case FacePackage.INTEGRATION_TRANSPORT_NODE__IN_PORT:
        getInPort().clear();
        getInPort().addAll((Collection<? extends IntegrationTSNodeInputPort>)newValue);
        return;
      case FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT:
        setOutPort((IntegrationTSNodeOutputPort)newValue);
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
      case FacePackage.INTEGRATION_TRANSPORT_NODE__IN_PORT:
        getInPort().clear();
        return;
      case FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT:
        setOutPort((IntegrationTSNodeOutputPort)null);
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
      case FacePackage.INTEGRATION_TRANSPORT_NODE__IN_PORT:
        return inPort != null && !inPort.isEmpty();
      case FacePackage.INTEGRATION_TRANSPORT_NODE__OUT_PORT:
        return outPort != null;
    }
    return super.eIsSet(featureID);
  }

} //IntegrationTransportNodeImpl