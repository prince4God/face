package com.epistimis.face;

import com.epistimis.face.face.UoPClientServerRole;
import com.epistimis.face.face.UopClientServerConnection;
import com.epistimis.face.face.UopCompositeTemplate;
import com.epistimis.face.face.UopQueuingConnection;
import com.epistimis.face.face.UopSingleInstanceMessageConnection;
import com.epistimis.face.face.UopTemplate;
import com.epistimis.face.face.UopTemplateComposition;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * General methods for extracting info from various FACE derived classes - so we don't have to worry about the exact derived class we're dealing with.
 */
@SuppressWarnings("all")
public class FaceExtractor {
  protected List<UopTemplate> _inputTemplList(final UopTemplate templ) {
    List<UopTemplate> result = new ArrayList<UopTemplate>();
    result.add(templ);
    return result;
  }

  protected List<UopTemplate> _inputTemplList(final UopCompositeTemplate templ) {
    List<UopTemplate> result = new ArrayList<UopTemplate>();
    EList<UopTemplateComposition> _composition = templ.getComposition();
    for (final UopTemplateComposition comp : _composition) {
      {
        final List<UopTemplate> compRes = this.inputTemplList(comp.getType());
        result.addAll(compRes);
      }
    }
    return result;
  }

  protected List<UopTemplate> _inputTemplList(final UopClientServerConnection conn) {
    UoPClientServerRole _role = conn.getRole();
    boolean _equals = Objects.equal(_role, UoPClientServerRole.CLIENT);
    if (_equals) {
      return this.inputTemplList(conn.getRequestType());
    } else {
      return this.inputTemplList(conn.getResponseType());
    }
  }

  /**
   * QueueingConnections
   */
  protected List<UopTemplate> _inputTemplList(final UopQueuingConnection conn) {
    return this.inputTemplList(conn.getMessageType());
  }

  protected List<UopTemplate> _inputTemplList(final UopSingleInstanceMessageConnection conn) {
    return this.inputTemplList(conn.getMessageType());
  }

  public List<UopTemplate> inputTemplList(final EObject templ) {
    if (templ instanceof UopCompositeTemplate) {
      return _inputTemplList((UopCompositeTemplate)templ);
    } else if (templ instanceof UopTemplate) {
      return _inputTemplList((UopTemplate)templ);
    } else if (templ instanceof UopQueuingConnection) {
      return _inputTemplList((UopQueuingConnection)templ);
    } else if (templ instanceof UopSingleInstanceMessageConnection) {
      return _inputTemplList((UopSingleInstanceMessageConnection)templ);
    } else if (templ instanceof UopClientServerConnection) {
      return _inputTemplList((UopClientServerConnection)templ);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(templ).toString());
    }
  }
}
