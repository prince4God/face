/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face.impl;

import com.epistimis.face.face.FacePackage;
import com.epistimis.face.face.UopThread;
import com.epistimis.face.face.UopThreadType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uop Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.face.face.impl.UopThreadImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopThreadImpl#getTimeCapacity <em>Time Capacity</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopThreadImpl#getRelativePriority <em>Relative Priority</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopThreadImpl#getRelativeCoreAffinity <em>Relative Core Affinity</em>}</li>
 *   <li>{@link com.epistimis.face.face.impl.UopThreadImpl#getThreadType <em>Thread Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UopThreadImpl extends MinimalEObjectImpl.Container implements UopThread
{
  /**
   * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected static final float PERIOD_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected float period = PERIOD_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeCapacity() <em>Time Capacity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeCapacity()
   * @generated
   * @ordered
   */
  protected static final float TIME_CAPACITY_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getTimeCapacity() <em>Time Capacity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeCapacity()
   * @generated
   * @ordered
   */
  protected float timeCapacity = TIME_CAPACITY_EDEFAULT;

  /**
   * The default value of the '{@link #getRelativePriority() <em>Relative Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelativePriority()
   * @generated
   * @ordered
   */
  protected static final int RELATIVE_PRIORITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRelativePriority() <em>Relative Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelativePriority()
   * @generated
   * @ordered
   */
  protected int relativePriority = RELATIVE_PRIORITY_EDEFAULT;

  /**
   * The default value of the '{@link #getRelativeCoreAffinity() <em>Relative Core Affinity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelativeCoreAffinity()
   * @generated
   * @ordered
   */
  protected static final int RELATIVE_CORE_AFFINITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRelativeCoreAffinity() <em>Relative Core Affinity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelativeCoreAffinity()
   * @generated
   * @ordered
   */
  protected int relativeCoreAffinity = RELATIVE_CORE_AFFINITY_EDEFAULT;

  /**
   * The default value of the '{@link #getThreadType() <em>Thread Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThreadType()
   * @generated
   * @ordered
   */
  protected static final UopThreadType THREAD_TYPE_EDEFAULT = UopThreadType.FOREGROUND;

  /**
   * The cached value of the '{@link #getThreadType() <em>Thread Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThreadType()
   * @generated
   * @ordered
   */
  protected UopThreadType threadType = THREAD_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UopThreadImpl()
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
    return FacePackage.Literals.UOP_THREAD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public float getPeriod()
  {
    return period;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPeriod(float newPeriod)
  {
    float oldPeriod = period;
    period = newPeriod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_THREAD__PERIOD, oldPeriod, period));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public float getTimeCapacity()
  {
    return timeCapacity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTimeCapacity(float newTimeCapacity)
  {
    float oldTimeCapacity = timeCapacity;
    timeCapacity = newTimeCapacity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_THREAD__TIME_CAPACITY, oldTimeCapacity, timeCapacity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getRelativePriority()
  {
    return relativePriority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRelativePriority(int newRelativePriority)
  {
    int oldRelativePriority = relativePriority;
    relativePriority = newRelativePriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_THREAD__RELATIVE_PRIORITY, oldRelativePriority, relativePriority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getRelativeCoreAffinity()
  {
    return relativeCoreAffinity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRelativeCoreAffinity(int newRelativeCoreAffinity)
  {
    int oldRelativeCoreAffinity = relativeCoreAffinity;
    relativeCoreAffinity = newRelativeCoreAffinity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_THREAD__RELATIVE_CORE_AFFINITY, oldRelativeCoreAffinity, relativeCoreAffinity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UopThreadType getThreadType()
  {
    return threadType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setThreadType(UopThreadType newThreadType)
  {
    UopThreadType oldThreadType = threadType;
    threadType = newThreadType == null ? THREAD_TYPE_EDEFAULT : newThreadType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FacePackage.UOP_THREAD__THREAD_TYPE, oldThreadType, threadType));
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
      case FacePackage.UOP_THREAD__PERIOD:
        return getPeriod();
      case FacePackage.UOP_THREAD__TIME_CAPACITY:
        return getTimeCapacity();
      case FacePackage.UOP_THREAD__RELATIVE_PRIORITY:
        return getRelativePriority();
      case FacePackage.UOP_THREAD__RELATIVE_CORE_AFFINITY:
        return getRelativeCoreAffinity();
      case FacePackage.UOP_THREAD__THREAD_TYPE:
        return getThreadType();
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
      case FacePackage.UOP_THREAD__PERIOD:
        setPeriod((Float)newValue);
        return;
      case FacePackage.UOP_THREAD__TIME_CAPACITY:
        setTimeCapacity((Float)newValue);
        return;
      case FacePackage.UOP_THREAD__RELATIVE_PRIORITY:
        setRelativePriority((Integer)newValue);
        return;
      case FacePackage.UOP_THREAD__RELATIVE_CORE_AFFINITY:
        setRelativeCoreAffinity((Integer)newValue);
        return;
      case FacePackage.UOP_THREAD__THREAD_TYPE:
        setThreadType((UopThreadType)newValue);
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
      case FacePackage.UOP_THREAD__PERIOD:
        setPeriod(PERIOD_EDEFAULT);
        return;
      case FacePackage.UOP_THREAD__TIME_CAPACITY:
        setTimeCapacity(TIME_CAPACITY_EDEFAULT);
        return;
      case FacePackage.UOP_THREAD__RELATIVE_PRIORITY:
        setRelativePriority(RELATIVE_PRIORITY_EDEFAULT);
        return;
      case FacePackage.UOP_THREAD__RELATIVE_CORE_AFFINITY:
        setRelativeCoreAffinity(RELATIVE_CORE_AFFINITY_EDEFAULT);
        return;
      case FacePackage.UOP_THREAD__THREAD_TYPE:
        setThreadType(THREAD_TYPE_EDEFAULT);
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
      case FacePackage.UOP_THREAD__PERIOD:
        return period != PERIOD_EDEFAULT;
      case FacePackage.UOP_THREAD__TIME_CAPACITY:
        return timeCapacity != TIME_CAPACITY_EDEFAULT;
      case FacePackage.UOP_THREAD__RELATIVE_PRIORITY:
        return relativePriority != RELATIVE_PRIORITY_EDEFAULT;
      case FacePackage.UOP_THREAD__RELATIVE_CORE_AFFINITY:
        return relativeCoreAffinity != RELATIVE_CORE_AFFINITY_EDEFAULT;
      case FacePackage.UOP_THREAD__THREAD_TYPE:
        return threadType != THREAD_TYPE_EDEFAULT;
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
    result.append(" (period: ");
    result.append(period);
    result.append(", timeCapacity: ");
    result.append(timeCapacity);
    result.append(", relativePriority: ");
    result.append(relativePriority);
    result.append(", relativeCoreAffinity: ");
    result.append(relativeCoreAffinity);
    result.append(", threadType: ");
    result.append(threadType);
    result.append(')');
    return result.toString();
  }

} //UopThreadImpl
