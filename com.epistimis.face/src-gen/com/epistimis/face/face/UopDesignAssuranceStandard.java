/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.face;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Uop Design Assurance Standard</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.epistimis.face.face.FacePackage#getUopDesignAssuranceStandard()
 * @model
 * @generated
 */
public enum UopDesignAssuranceStandard implements Enumerator
{
  /**
   * The '<em><b>DO 178B ED 12B</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DO_178B_ED_12B_VALUE
   * @generated
   * @ordered
   */
  DO_178B_ED_12B(0, "DO_178B_ED_12B", "DO_178B_ED_12B"),

  /**
   * The '<em><b>DO 178C ED 12C</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DO_178C_ED_12C_VALUE
   * @generated
   * @ordered
   */
  DO_178C_ED_12C(1, "DO_178C_ED_12C", "DO_178C_ED_12C");

  /**
   * The '<em><b>DO 178B ED 12B</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DO_178B_ED_12B
   * @model
   * @generated
   * @ordered
   */
  public static final int DO_178B_ED_12B_VALUE = 0;

  /**
   * The '<em><b>DO 178C ED 12C</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DO_178C_ED_12C
   * @model
   * @generated
   * @ordered
   */
  public static final int DO_178C_ED_12C_VALUE = 1;

  /**
   * An array of all the '<em><b>Uop Design Assurance Standard</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final UopDesignAssuranceStandard[] VALUES_ARRAY =
    new UopDesignAssuranceStandard[]
    {
      DO_178B_ED_12B,
      DO_178C_ED_12C,
    };

  /**
   * A public read-only list of all the '<em><b>Uop Design Assurance Standard</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<UopDesignAssuranceStandard> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Uop Design Assurance Standard</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static UopDesignAssuranceStandard get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UopDesignAssuranceStandard result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Uop Design Assurance Standard</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static UopDesignAssuranceStandard getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UopDesignAssuranceStandard result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Uop Design Assurance Standard</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static UopDesignAssuranceStandard get(int value)
  {
    switch (value)
    {
      case DO_178B_ED_12B_VALUE: return DO_178B_ED_12B;
      case DO_178C_ED_12C_VALUE: return DO_178C_ED_12C;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private UopDesignAssuranceStandard(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //UopDesignAssuranceStandard
