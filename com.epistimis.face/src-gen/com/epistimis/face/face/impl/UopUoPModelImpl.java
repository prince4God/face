/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.UopElement;
import com.epistimis.face.face.UopUoPModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uop Uo PModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.UopUoPModelImpl#getUm <em>Um</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopUoPModelImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UopUoPModelImpl extends FaceElementImpl implements UopUoPModel
{
  /**
   * The cached value of the '{@link #getUm() <em>Um</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUm()
   * @generated
   * @ordered
   */
  protected EList<UopUoPModel> um;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected EList<UopElement> element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UopUoPModelImpl()
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
    return FacePackage.Literals.UOP_UO_PMODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<UopUoPModel> getUm()
  {
    if (um == null)
    {
      um = new EObjectContainmentEList<UopUoPModel>(UopUoPModel.class, this, FacePackage.UOP_UO_PMODEL__UM);
    }
    return um;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<UopElement> getElement()
  {
    if (element == null)
    {
      element = new EObjectContainmentEList<UopElement>(UopElement.class, this, FacePackage.UOP_UO_PMODEL__ELEMENT);
    }
    return element;
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
      case FacePackage.UOP_UO_PMODEL__UM:
        return ((InternalEList<?>)getUm()).basicRemove(otherEnd, msgs);
      case FacePackage.UOP_UO_PMODEL__ELEMENT:
        return ((InternalEList<?>)getElement()).basicRemove(otherEnd, msgs);
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
      case FacePackage.UOP_UO_PMODEL__UM:
        return getUm();
      case FacePackage.UOP_UO_PMODEL__ELEMENT:
        return getElement();
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
      case FacePackage.UOP_UO_PMODEL__UM:
        getUm().clear();
        getUm().addAll((Collection<? extends UopUoPModel>)newValue);
        return;
      case FacePackage.UOP_UO_PMODEL__ELEMENT:
        getElement().clear();
        getElement().addAll((Collection<? extends UopElement>)newValue);
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
      case FacePackage.UOP_UO_PMODEL__UM:
        getUm().clear();
        return;
      case FacePackage.UOP_UO_PMODEL__ELEMENT:
        getElement().clear();
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
      case FacePackage.UOP_UO_PMODEL__UM:
        return um != null && !um.isEmpty();
      case FacePackage.UOP_UO_PMODEL__ELEMENT:
        return element != null && !element.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UopUoPModelImpl
