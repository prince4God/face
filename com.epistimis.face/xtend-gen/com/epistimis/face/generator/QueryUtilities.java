package com.epistimis.face.generator;

import com.epistimis.face.ConnectionProcessor;
import com.epistimis.face.exceptions.MissingRealizationException;
import com.epistimis.face.face.UopClientServerConnection;
import com.epistimis.face.face.UopCompositeTemplate;
import com.epistimis.face.face.UopConnection;
import com.epistimis.face.face.UopMessageType;
import com.epistimis.face.face.UopQueuingConnection;
import com.epistimis.face.face.UopSingleInstanceMessageConnection;
import com.epistimis.face.face.UopTemplate;
import com.epistimis.face.face.UopTemplateComposition;
import com.epistimis.face.face.UopUnitOfPortability;
import com.epistimis.uddl.ConceptualQueryProcessor;
import com.epistimis.uddl.PlatformQueryProcessor;
import com.epistimis.uddl.query.query.QueryStatement;
import com.epistimis.uddl.uddl.ConceptualCompositeQuery;
import com.epistimis.uddl.uddl.ConceptualEntity;
import com.epistimis.uddl.uddl.ConceptualQuery;
import com.epistimis.uddl.uddl.ConceptualQueryComposition;
import com.epistimis.uddl.uddl.LogicalQuery;
import com.epistimis.uddl.uddl.PlatformCompositeQuery;
import com.epistimis.uddl.uddl.PlatformEntity;
import com.epistimis.uddl.uddl.PlatformQuery;
import com.epistimis.uddl.uddl.PlatformQueryComposition;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * These are utilities that are used to handle the transition between Face -> Query -> Uddl
 */
@SuppressWarnings("all")
public class QueryUtilities {
  /**
   * NOTE: The qno is not protected because derived classes will have their own
   */
  @Inject
  @Extension
  private IQualifiedNameProvider qnp;

  @Inject
  @Extension
  protected PlatformQueryProcessor pqp;

  @Inject
  @Extension
  protected ConceptualQueryProcessor cqp;

  @Inject
  @Extension
  protected ConnectionProcessor cp;

  public Map<String, ConceptualEntity> getReferencedConceptualEntities(final UopUnitOfPortability comp) {
    Map<String, ConceptualEntity> entities = new HashMap<String, ConceptualEntity>();
    EList<UopConnection> _connection = comp.getConnection();
    for (final UopConnection conn : _connection) {
      entities.putAll(this.getReferencedConceptualEntities(conn));
    }
    return entities;
  }

  public Map<String, ConceptualEntity> getReferencedConceptualEntities(final UopConnection conn) {
    return this.cp.getReferencedConceptualEntities(conn);
  }

  protected Map<String, PlatformEntity> _getReferencedPlatformEntities(final UopUnitOfPortability comp) {
    Map<String, PlatformEntity> entities = new HashMap<String, PlatformEntity>();
    EList<UopConnection> _connection = comp.getConnection();
    for (final UopConnection conn : _connection) {
      entities.putAll(this.getReferencedPlatformEntities(conn));
    }
    return entities;
  }

  protected Map<String, PlatformEntity> _getReferencedPlatformEntities(final UopConnection conn) {
    Map<String, PlatformEntity> entities = new HashMap<String, PlatformEntity>();
    SortedMap<String, PlatformQuery> referencedQueries = this.platformQueriesMap(conn);
    Set<Map.Entry<String, PlatformQuery>> _entrySet = referencedQueries.entrySet();
    for (final Map.Entry<String, PlatformQuery> entry : _entrySet) {
      {
        final PlatformQuery query = entry.getValue();
        final QueryStatement spec = this.pqp.parseQuery(query);
        entities.putAll(this.pqp.matchQuerytoUDDL(query, spec));
      }
    }
    return entities;
  }

  /**
   * Get all the queries referenced by this Template/Connection. Recurses down through Composites to find everything, keeping only
   * a single reference, ordered by the FQN of the query. Note that this returns only PlatformQuery, not PlatformCompositeQuery -
   * effectively flattening the list.
   */
  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final UopTemplate templ) {
    TreeMap<String, PlatformQuery> result = new TreeMap<String, PlatformQuery>();
    result.put(this.qnp.getFullyQualifiedName(templ.getBoundQuery()).toString(), templ.getBoundQuery());
    return result;
  }

  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final UopCompositeTemplate templ) {
    TreeMap<String, PlatformQuery> result = new TreeMap<String, PlatformQuery>();
    EList<UopTemplateComposition> _composition = templ.getComposition();
    for (final UopTemplateComposition comp : _composition) {
      result.putAll(this.platformQueriesMap(comp.getType()));
    }
    return result;
  }

  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final UopQueuingConnection conn) {
    TreeMap<String, PlatformQuery> _xblockexpression = null;
    {
      UopMessageType _messageType = conn.getMessageType();
      SortedMap<String, PlatformQuery> _platformQueriesMap = null;
      if (_messageType!=null) {
        _platformQueriesMap=this.platformQueriesMap(_messageType);
      }
      final SortedMap<String, PlatformQuery> result = _platformQueriesMap;
      TreeMap<String, PlatformQuery> _xifexpression = null;
      if ((result != null)) {
        return result;
      } else {
        _xifexpression = new TreeMap<String, PlatformQuery>();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final UopSingleInstanceMessageConnection conn) {
    UopMessageType _messageType = conn.getMessageType();
    SortedMap<String, PlatformQuery> _platformQueriesMap = null;
    if (_messageType!=null) {
      _platformQueriesMap=this.platformQueriesMap(_messageType);
    }
    final SortedMap<String, PlatformQuery> result = _platformQueriesMap;
    if ((result != null)) {
      return result;
    } else {
      return new TreeMap<String, PlatformQuery>();
    }
  }

  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final UopClientServerConnection conn) {
    TreeMap<String, PlatformQuery> result = new TreeMap<String, PlatformQuery>();
    UopMessageType _requestType = conn.getRequestType();
    SortedMap<String, PlatformQuery> _platformQueriesMap = null;
    if (_requestType!=null) {
      _platformQueriesMap=this.platformQueriesMap(_requestType);
    }
    final SortedMap<String, PlatformQuery> reqs = _platformQueriesMap;
    if ((reqs != null)) {
      result.putAll(reqs);
    }
    UopMessageType _responseType = conn.getResponseType();
    SortedMap<String, PlatformQuery> _platformQueriesMap_1 = null;
    if (_responseType!=null) {
      _platformQueriesMap_1=this.platformQueriesMap(_responseType);
    }
    final SortedMap<String, PlatformQuery> resp = _platformQueriesMap_1;
    if ((resp != null)) {
      result.putAll(resp);
    }
    return result;
  }

  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final PlatformQuery query) {
    TreeMap<String, PlatformQuery> result = new TreeMap<String, PlatformQuery>();
    result.put(this.qnp.getFullyQualifiedName(query).toString(), query);
    return result;
  }

  protected SortedMap<String, PlatformQuery> _platformQueriesMap(final PlatformCompositeQuery query) {
    TreeMap<String, PlatformQuery> result = new TreeMap<String, PlatformQuery>();
    EList<PlatformQueryComposition> _composition = query.getComposition();
    for (final PlatformQueryComposition comp : _composition) {
      result.putAll(this.platformQueriesMap(comp.getType()));
    }
    return result;
  }

  /**
   * Get all the queries referenced by this Template/Connection. Recurses down through Composites to find everything, keeping only
   * a single reference, ordered by the FQN of the query. Note that this returns only ConceptualQuery, not ConceptualCompositeQuery -
   * effectively flattening the list.
   * 
   * TODO: this does not account for differences between Platform/Logical/Conceptual in terms of fields selected. So
   * the ConceptualQuery returned could contain more fields than the PlatformQuery actually uses.
   */
  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final UopTemplate templ) {
    TreeMap<String, ConceptualQuery> result = new TreeMap<String, ConceptualQuery>();
    PlatformQuery _boundQuery = templ.getBoundQuery();
    LogicalQuery _realizes = null;
    if (_boundQuery!=null) {
      _realizes=_boundQuery.getRealizes();
    }
    ConceptualQuery _realizes_1 = null;
    if (_realizes!=null) {
      _realizes_1=_realizes.getRealizes();
    }
    final ConceptualQuery cq = _realizes_1;
    if ((cq != null)) {
      result.put(this.qnp.getFullyQualifiedName(cq).toString(), cq);
    } else {
      final String msg = String.format(
        "Attempt to find ConceptualQuery associated with Template %s failed. Logical or Conceptual realization missing.", 
        this.qnp.getFullyQualifiedName(templ).toString());
      throw new MissingRealizationException(msg);
    }
    return result;
  }

  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final UopCompositeTemplate templ) {
    TreeMap<String, ConceptualQuery> result = new TreeMap<String, ConceptualQuery>();
    EList<UopTemplateComposition> _composition = templ.getComposition();
    for (final UopTemplateComposition comp : _composition) {
      result.putAll(this.conceptualQueriesMap(comp.getType()));
    }
    return result;
  }

  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final UopQueuingConnection conn) {
    return this.conceptualQueriesMap(conn.getMessageType());
  }

  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final UopSingleInstanceMessageConnection conn) {
    return this.conceptualQueriesMap(conn.getMessageType());
  }

  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final UopClientServerConnection conn) {
    SortedMap<String, ConceptualQuery> req = this.conceptualQueriesMap(conn.getRequestType());
    SortedMap<String, ConceptualQuery> resp = this.conceptualQueriesMap(conn.getResponseType());
    req.putAll(resp);
    return req;
  }

  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final ConceptualQuery query) {
    TreeMap<String, ConceptualQuery> result = new TreeMap<String, ConceptualQuery>();
    result.put(this.qnp.getFullyQualifiedName(query).toString(), query);
    return result;
  }

  protected SortedMap<String, ConceptualQuery> _conceptualQueriesMap(final ConceptualCompositeQuery query) {
    TreeMap<String, ConceptualQuery> result = new TreeMap<String, ConceptualQuery>();
    EList<ConceptualQueryComposition> _composition = query.getComposition();
    for (final ConceptualQueryComposition comp : _composition) {
      result.putAll(this.conceptualQueriesMap(comp.getType()));
    }
    return result;
  }

  public Map<String, PlatformEntity> getReferencedPlatformEntities(final EObject comp) {
    if (comp instanceof UopUnitOfPortability) {
      return _getReferencedPlatformEntities((UopUnitOfPortability)comp);
    } else if (comp instanceof UopConnection) {
      return _getReferencedPlatformEntities((UopConnection)comp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(comp).toString());
    }
  }

  public SortedMap<String, PlatformQuery> platformQueriesMap(final EObject templ) {
    if (templ instanceof UopCompositeTemplate) {
      return _platformQueriesMap((UopCompositeTemplate)templ);
    } else if (templ instanceof UopTemplate) {
      return _platformQueriesMap((UopTemplate)templ);
    } else if (templ instanceof PlatformCompositeQuery) {
      return _platformQueriesMap((PlatformCompositeQuery)templ);
    } else if (templ instanceof PlatformQuery) {
      return _platformQueriesMap((PlatformQuery)templ);
    } else if (templ instanceof UopQueuingConnection) {
      return _platformQueriesMap((UopQueuingConnection)templ);
    } else if (templ instanceof UopSingleInstanceMessageConnection) {
      return _platformQueriesMap((UopSingleInstanceMessageConnection)templ);
    } else if (templ instanceof UopClientServerConnection) {
      return _platformQueriesMap((UopClientServerConnection)templ);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(templ).toString());
    }
  }

  public SortedMap<String, ConceptualQuery> conceptualQueriesMap(final EObject templ) {
    if (templ instanceof UopCompositeTemplate) {
      return _conceptualQueriesMap((UopCompositeTemplate)templ);
    } else if (templ instanceof UopTemplate) {
      return _conceptualQueriesMap((UopTemplate)templ);
    } else if (templ instanceof ConceptualCompositeQuery) {
      return _conceptualQueriesMap((ConceptualCompositeQuery)templ);
    } else if (templ instanceof ConceptualQuery) {
      return _conceptualQueriesMap((ConceptualQuery)templ);
    } else if (templ instanceof UopQueuingConnection) {
      return _conceptualQueriesMap((UopQueuingConnection)templ);
    } else if (templ instanceof UopSingleInstanceMessageConnection) {
      return _conceptualQueriesMap((UopSingleInstanceMessageConnection)templ);
    } else if (templ instanceof UopClientServerConnection) {
      return _conceptualQueriesMap((UopClientServerConnection)templ);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(templ).toString());
    }
  }
}
