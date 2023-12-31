/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.UopCompositeTemplate;
import com.epistimis.face.face.UopTemplateComposition;

import com.epistimis.uddl.uddl.LogicalCompositeQuery;

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
 * An implementation of the model object '<em><b>Uop Composite Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.UopCompositeTemplateImpl#getRealizes <em>Realizes</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopCompositeTemplateImpl#isIsUnion <em>Is Union</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopCompositeTemplateImpl#getComposition <em>Composition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UopCompositeTemplateImpl extends UopMessageTypeImpl implements UopCompositeTemplate
{
  /**
   * The cached value of the '{@link #getRealizes() <em>Realizes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealizes()
   * @generated
   * @ordered
   */
  protected LogicalCompositeQuery realizes;

  /**
   * The default value of the '{@link #isIsUnion() <em>Is Union</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsUnion()
   * @generated
   * @ordered
   */
  protected static final boolean IS_UNION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsUnion() <em>Is Union</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsUnion()
   * @generated
   * @ordered
   */
  protected boolean isUnion = IS_UNION_EDEFAULT;

  /**
   * The cached value of the '{@link #getComposition() <em>Composition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComposition()
   * @generated
   * @ordered
   */
  protected EList<UopTemplateComposition> composition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UopCompositeTemplateImpl()
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
    return FacePackage.Literals.UOP_COMPOSITE_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LogicalCompositeQuery getRealizes()
  {
    if (realizes != null && realizes.eIsProxy())
    {
      InternalEObject oldRealizes = (InternalEObject)realizes;
      realizes = (LogicalCompositeQuery)eResolveProxy(oldRealizes);
      if (realizes != oldRealizes)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacePackage.UOP_COMPOSITE_TEMPLATE__REALIZES, oldRealizes, realizes));
      }
    }
    return realizes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalCompositeQuery basicGetRealizes()
  {
    return realizes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRealizes(LogicalCompositeQuery newRealizes)
  {
    LogicalCompositeQuery oldRealizes = realizes;
    realizes = newRealizes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_COMPOSITE_TEMPLATE__REALIZES, oldRealizes, realizes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isIsUnion()
  {
    return isUnion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsUnion(boolean newIsUnion)
  {
    boolean oldIsUnion = isUnion;
    isUnion = newIsUnion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_COMPOSITE_TEMPLATE__IS_UNION, oldIsUnion, isUnion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<UopTemplateComposition> getComposition()
  {
    if (composition == null)
    {
      composition = new EObjectContainmentEList<UopTemplateComposition>(UopTemplateComposition.class, this, FacePackage.UOP_COMPOSITE_TEMPLATE__COMPOSITION);
    }
    return composition;
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
      case FacePackage.UOP_COMPOSITE_TEMPLATE__COMPOSITION:
        return ((InternalEList<?>)getComposition()).basicRemove(otherEnd, msgs);
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
      case FacePackage.UOP_COMPOSITE_TEMPLATE__REALIZES:
        if (resolve) return getRealizes();
        return basicGetRealizes();
      case FacePackage.UOP_COMPOSITE_TEMPLATE__IS_UNION:
        return isIsUnion();
      case FacePackage.UOP_COMPOSITE_TEMPLATE__COMPOSITION:
        return getComposition();
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
      case FacePackage.UOP_COMPOSITE_TEMPLATE__REALIZES:
        setRealizes((LogicalCompositeQuery)newValue);
        return;
      case FacePackage.UOP_COMPOSITE_TEMPLATE__IS_UNION:
        setIsUnion((Boolean)newValue);
        return;
      case FacePackage.UOP_COMPOSITE_TEMPLATE__COMPOSITION:
        getComposition().clear();
        getComposition().addAll((Collection<? extends UopTemplateComposition>)newValue);
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
      case FacePackage.UOP_COMPOSITE_TEMPLATE__REALIZES:
        setRealizes((LogicalCompositeQuery)null);
        return;
      case FacePackage.UOP_COMPOSITE_TEMPLATE__IS_UNION:
        setIsUnion(IS_UNION_EDEFAULT);
        return;
      case FacePackage.UOP_COMPOSITE_TEMPLATE__COMPOSITION:
        getComposition().clear();
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
      case FacePackage.UOP_COMPOSITE_TEMPLATE__REALIZES:
        return realizes != null;
      case FacePackage.UOP_COMPOSITE_TEMPLATE__IS_UNION:
        return isUnion != IS_UNION_EDEFAULT;
      case FacePackage.UOP_COMPOSITE_TEMPLATE__COMPOSITION:
        return composition != null && !composition.isEmpty();
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
    result.append(" (isUnion: ");
    result.append(isUnion);
    result.append(')');
    return result.toString();
  }

} //UopCompositeTemplateImpl
