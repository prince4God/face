/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.IntegrationTSNodeInputPort;
import com.epistimis.face.face.UopMessageType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integration TS Node Input Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationTSNodeInputPortImpl#getView <em>View</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegrationTSNodeInputPortImpl extends IntegrationTSNodePortBaseImpl implements IntegrationTSNodeInputPort
{
  /**
   * The cached value of the '{@link #getView() <em>View</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getView()
   * @generated
   * @ordered
   */
  protected UopMessageType view;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrationTSNodeInputPortImpl()
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
    return FacePackage.Literals.INTEGRATION_TS_NODE_INPUT_PORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UopMessageType getView()
  {
    if (view != null && view.eIsProxy())
    {
      InternalEObject oldView = (InternalEObject)view;
      view = (UopMessageType)eResolveProxy(oldView);
      if (view != oldView)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacePackage.INTEGRATION_TS_NODE_INPUT_PORT__VIEW, oldView, view));
      }
    }
    return view;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UopMessageType basicGetView()
  {
    return view;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setView(UopMessageType newView)
  {
    UopMessageType oldView = view;
    view = newView;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.INTEGRATION_TS_NODE_INPUT_PORT__VIEW, oldView, view));
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
      case FacePackage.INTEGRATION_TS_NODE_INPUT_PORT__VIEW:
        if (resolve) return getView();
        return basicGetView();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FacePackage.INTEGRATION_TS_NODE_INPUT_PORT__VIEW:
        setView((UopMessageType)newValue);
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
      case FacePackage.INTEGRATION_TS_NODE_INPUT_PORT__VIEW:
        setView((UopMessageType)null);
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
      case FacePackage.INTEGRATION_TS_NODE_INPUT_PORT__VIEW:
        return view != null;
    }
    return super.eIsSet(featureID);
  }

} //IntegrationTSNodeInputPortImpl