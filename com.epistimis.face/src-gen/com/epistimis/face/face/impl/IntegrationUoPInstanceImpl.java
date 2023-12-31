/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.IntegrationUoPInputEndPoint;
import com.epistimis.face.face.IntegrationUoPInstance;
import com.epistimis.face.face.IntegrationUoPOutputEndPoint;
import com.epistimis.face.face.UopUnitOfPortability;

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
 * An implementation of the model object '<em><b>Integration Uo PInstance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationUoPInstanceImpl#getRealizes <em>Realizes</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationUoPInstanceImpl#getConfigurationURI <em>Configuration URI</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationUoPInstanceImpl#getInput <em>Input</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.IntegrationUoPInstanceImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegrationUoPInstanceImpl extends IntegrationElementImpl implements IntegrationUoPInstance
{
  /**
   * The cached value of the '{@link #getRealizes() <em>Realizes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealizes()
   * @generated
   * @ordered
   */
  protected UopUnitOfPortability realizes;

  /**
   * The default value of the '{@link #getConfigurationURI() <em>Configuration URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfigurationURI()
   * @generated
   * @ordered
   */
  protected static final String CONFIGURATION_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConfigurationURI() <em>Configuration URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfigurationURI()
   * @generated
   * @ordered
   */
  protected String configurationURI = CONFIGURATION_URI_EDEFAULT;

  /**
   * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInput()
   * @generated
   * @ordered
   */
  protected EList<IntegrationUoPInputEndPoint> input;

  /**
   * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected EList<IntegrationUoPOutputEndPoint> output;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrationUoPInstanceImpl()
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
    return FacePackage.Literals.INTEGRATION_UO_PINSTANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UopUnitOfPortability getRealizes()
  {
    if (realizes != null && realizes.eIsProxy())
    {
      InternalEObject oldRealizes = (InternalEObject)realizes;
      realizes = (UopUnitOfPortability)eResolveProxy(oldRealizes);
      if (realizes != oldRealizes)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacePackage.INTEGRATION_UO_PINSTANCE__REALIZES, oldRealizes, realizes));
      }
    }
    return realizes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UopUnitOfPortability basicGetRealizes()
  {
    return realizes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRealizes(UopUnitOfPortability newRealizes)
  {
    UopUnitOfPortability oldRealizes = realizes;
    realizes = newRealizes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.INTEGRATION_UO_PINSTANCE__REALIZES, oldRealizes, realizes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getConfigurationURI()
  {
    return configurationURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConfigurationURI(String newConfigurationURI)
  {
    String oldConfigurationURI = configurationURI;
    configurationURI = newConfigurationURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.INTEGRATION_UO_PINSTANCE__CONFIGURATION_URI, oldConfigurationURI, configurationURI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegrationUoPInputEndPoint> getInput()
  {
    if (input == null)
    {
      input = new EObjectContainmentEList<IntegrationUoPInputEndPoint>(IntegrationUoPInputEndPoint.class, this, FacePackage.INTEGRATION_UO_PINSTANCE__INPUT);
    }
    return input;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegrationUoPOutputEndPoint> getOutput()
  {
    if (output == null)
    {
      output = new EObjectContainmentEList<IntegrationUoPOutputEndPoint>(IntegrationUoPOutputEndPoint.class, this, FacePackage.INTEGRATION_UO_PINSTANCE__OUTPUT);
    }
    return output;
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
      case FacePackage.INTEGRATION_UO_PINSTANCE__INPUT:
        return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
      case FacePackage.INTEGRATION_UO_PINSTANCE__OUTPUT:
        return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
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
      case FacePackage.INTEGRATION_UO_PINSTANCE__REALIZES:
        if (resolve) return getRealizes();
        return basicGetRealizes();
      case FacePackage.INTEGRATION_UO_PINSTANCE__CONFIGURATION_URI:
        return getConfigurationURI();
      case FacePackage.INTEGRATION_UO_PINSTANCE__INPUT:
        return getInput();
      case FacePackage.INTEGRATION_UO_PINSTANCE__OUTPUT:
        return getOutput();
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
      case FacePackage.INTEGRATION_UO_PINSTANCE__REALIZES:
        setRealizes((UopUnitOfPortability)newValue);
        return;
      case FacePackage.INTEGRATION_UO_PINSTANCE__CONFIGURATION_URI:
        setConfigurationURI((String)newValue);
        return;
      case FacePackage.INTEGRATION_UO_PINSTANCE__INPUT:
        getInput().clear();
        getInput().addAll((Collection<? extends IntegrationUoPInputEndPoint>)newValue);
        return;
      case FacePackage.INTEGRATION_UO_PINSTANCE__OUTPUT:
        getOutput().clear();
        getOutput().addAll((Collection<? extends IntegrationUoPOutputEndPoint>)newValue);
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
      case FacePackage.INTEGRATION_UO_PINSTANCE__REALIZES:
        setRealizes((UopUnitOfPortability)null);
        return;
      case FacePackage.INTEGRATION_UO_PINSTANCE__CONFIGURATION_URI:
        setConfigurationURI(CONFIGURATION_URI_EDEFAULT);
        return;
      case FacePackage.INTEGRATION_UO_PINSTANCE__INPUT:
        getInput().clear();
        return;
      case FacePackage.INTEGRATION_UO_PINSTANCE__OUTPUT:
        getOutput().clear();
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
      case FacePackage.INTEGRATION_UO_PINSTANCE__REALIZES:
        return realizes != null;
      case FacePackage.INTEGRATION_UO_PINSTANCE__CONFIGURATION_URI:
        return CONFIGURATION_URI_EDEFAULT == null ? configurationURI != null : !CONFIGURATION_URI_EDEFAULT.equals(configurationURI);
      case FacePackage.INTEGRATION_UO_PINSTANCE__INPUT:
        return input != null && !input.isEmpty();
      case FacePackage.INTEGRATION_UO_PINSTANCE__OUTPUT:
        return output != null && !output.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (configurationURI: ");
    result.append(configurationURI);
    result.append(')');
    return result.toString();
  }

} //IntegrationUoPInstanceImpl
