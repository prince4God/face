package com.epistimis.face.generator;

import com.epistimis.face.face.FaceElement;
import com.epistimis.face.face.IntegrationUoPInstance;
import com.epistimis.face.face.UoPClientServerRole;
import com.epistimis.face.face.UopClientServerConnection;
import com.epistimis.face.face.UopCompositeTemplate;
import com.epistimis.face.face.UopConnection;
import com.epistimis.face.face.UopMessageType;
import com.epistimis.face.face.UopPlatformSpecificComponent;
import com.epistimis.face.face.UopPortableComponent;
import com.epistimis.face.face.UopProgrammingLanguage;
import com.epistimis.face.face.UopQueuingConnection;
import com.epistimis.face.face.UopSingleInstanceMessageConnection;
import com.epistimis.face.face.UopSynchronizationStyle;
import com.epistimis.face.face.UopTemplate;
import com.epistimis.face.face.UopUnitOfPortability;
import com.epistimis.uddl.generator.CommonDataStructureGenerator;
import com.epistimis.uddl.uddl.PlatformComposableElement;
import com.epistimis.uddl.uddl.PlatformComposition;
import com.epistimis.uddl.uddl.PlatformDataModel;
import com.epistimis.uddl.uddl.PlatformDataType;
import com.epistimis.uddl.uddl.PlatformEntity;
import com.epistimis.uddl.uddl.PlatformParticipant;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public abstract class CommonFunctionGenerator extends CommonDataStructureGenerator implements IFaceLangGenerator {
  private static Logger logger = Logger.getLogger(CommonFunctionGenerator.class);

  private List<UopUnitOfPortability> processedComponents;

  protected IGenerator2 fg;

  protected QueryUtilities qu;

  private CommonDataStructureGenerator dsg;

  public abstract String getSrcExtension();

  /**
   * Eventually this code generator can look at the version of language (look up SupportingComponents for runtimes and see
   * which version of the runtime is being used. The assumption is that the compiler must be at that version, so we can use
   * language features from that version if desired)
   */
  public CommonFunctionGenerator(final QueryUtilities qu, final CommonDataStructureGenerator dsg) {
    this.initialize();
    this.qu = qu;
    this.dsg = dsg;
  }

  @Override
  public void initialize() {
    super.initialize();
    if ((this.processedComponents == null)) {
      ArrayList<UopUnitOfPortability> _arrayList = new ArrayList<UopUnitOfPortability>();
      this.processedComponents = _arrayList;
    }
  }

  @Override
  public void cleanup() {
    super.cleanup();
    this.processedComponents.clear();
  }

  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
  }

  @Override
  public void beforeGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
  }

  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Function1<IntegrationUoPInstance, Boolean> _function = (IntegrationUoPInstance it) -> {
      UopProgrammingLanguage _transportAPILanguage = it.getRealizes().getTransportAPILanguage();
      return Boolean.valueOf((_transportAPILanguage == UopProgrammingLanguage.CPP));
    };
    Iterable<IntegrationUoPInstance> _filter = IterableExtensions.<IntegrationUoPInstance>filter(Iterables.<IntegrationUoPInstance>filter(IteratorExtensions.<EObject>toIterable(input.getAllContents()), IntegrationUoPInstance.class), _function);
    for (final IntegrationUoPInstance inst : _filter) {
    }
  }

  /**
   * Only UopUnitOfPortability will have  files
   */
  public abstract String generateFileName(final FaceElement obj);

  @Override
  public void processAnInstance(final IntegrationUoPInstance inst, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    UopUnitOfPortability _realizes = inst.getRealizes();
    boolean _tripleEquals = (_realizes == null);
    if (_tripleEquals) {
      String _string = this.qnp.getFullyQualifiedName(inst).toString();
      String _plus = ("No realized component for instance " + _string);
      CommonFunctionGenerator.logger.warn(_plus);
      return;
    }
    final Map<String, PlatformEntity> entities = this.qu.getReferencedPlatformEntities(inst.getRealizes());
    this.processAComponent(inst.getRealizes(), entities.values(), fsa, context);
  }

  /**
   * Check connection for platform level detail - need this to do code gen
   */
  protected boolean _missingPlatformDetail(final UopClientServerConnection conn) {
    return ((conn.getRequestType() == null) || (conn.getResponseType() == null));
  }

  protected boolean _missingPlatformDetail(final UopQueuingConnection conn) {
    UopMessageType _messageType = conn.getMessageType();
    return (_messageType == null);
  }

  protected boolean _missingPlatformDetail(final UopSingleInstanceMessageConnection conn) {
    UopMessageType _messageType = conn.getMessageType();
    return (_messageType == null);
  }

  @Override
  public void processAComponent(final UopUnitOfPortability comp, final Collection<PlatformEntity> entities, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _contains = this.processedComponents.contains(comp);
    boolean _not = (!_contains);
    if (_not) {
      this.processedComponents.add(comp);
      boolean missingInfo = false;
      EList<UopConnection> _connection = comp.getConnection();
      for (final UopConnection conn : _connection) {
        boolean _missingPlatformDetail = this.missingPlatformDetail(conn);
        if (_missingPlatformDetail) {
          QualifiedName _fullyQualifiedName = this.qnp.getFullyQualifiedName(conn);
          String _plus = ("Platform detail missing for connection " + _fullyQualifiedName);
          String _plus_1 = (_plus + ". Cannot generate code for component ");
          QualifiedName _fullyQualifiedName_1 = this.qnp.getFullyQualifiedName(comp);
          String _plus_2 = (_plus_1 + _fullyQualifiedName_1);
          CommonFunctionGenerator.logger.info(_plus_2);
          missingInfo = true;
        }
      }
      if ((!missingInfo)) {
        final CharSequence content = this.compile(comp, entities);
        int _length = content.toString().trim().length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          String _rootDirectory = this.getRootDirectory();
          String _name = comp.getName();
          String _plus_3 = (_rootDirectory + _name);
          String _srcExtension = this.getSrcExtension();
          String _plus_4 = (_plus_3 + _srcExtension);
          fsa.generateFile(_plus_4, content);
        }
      }
    }
  }

  /**
   * Do Portable specific code gen here
   */
  protected CharSequence _compile(final UopPortableComponent uop, final Collection<PlatformEntity> entities) {
    StringConcatenation _builder = new StringConcatenation();
    String _compileUopCommon = this.compileUopCommon(uop, entities);
    _builder.append(_compileUopCommon);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Do PlatformSpecific codegen here
   */
  protected CharSequence _compile(final UopPlatformSpecificComponent uop, final Collection<PlatformEntity> entities) {
    StringConcatenation _builder = new StringConcatenation();
    String _compileUopCommon = this.compileUopCommon(uop, entities);
    _builder.append(_compileUopCommon);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Do common code generation for both Portable and PlatformSpecific Components.
   * 
   * Commonalities:
   * 1) All the input ports define input parameters to the generated function.
   * 2) The output port(s) define outputs from the generated function. If there is more than one output port
   * then we must create either a Tuple or have in/out parameters (References in CPP)
   * 3) Every function starts with a call to standard code to do dynamic checks (for consent) followed by
   * an assertion that whatever makes it past that point is OK.
   * 
   * For each port, we need to make sure the data structure has been generated and the header for that structure
   * included in this file.
   * 
   * TODO: parameter list doesn't properly address the possibility of multiple entities matching a connection
   */
  public abstract String compileUopCommon(final UopUnitOfPortability uop, final Collection<PlatformEntity> entities);

  protected CharSequence _parmList(final UopTemplate templ) {
    CharSequence _xblockexpression = null;
    {
      boolean _isEmpty = templ.getSpecification().isEmpty();
      if (_isEmpty) {
        templ.getBoundQuery();
      }
      StringConcatenation _builder = new StringConcatenation();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  protected CharSequence _parmList(final UopCompositeTemplate templ) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }

  protected CharSequence _parmList(final UopClientServerConnection conn) {
    Object _xifexpression = null;
    UoPClientServerRole _role = conn.getRole();
    boolean _equals = Objects.equal(_role, UoPClientServerRole.CLIENT);
    if (_equals) {
      _xifexpression = null;
    } else {
      _xifexpression = null;
    }
    return ((CharSequence)_xifexpression);
  }

  /**
   * QueueingConnections
   */
  protected CharSequence _parmList(final UopQueuingConnection conn) {
    Object _xifexpression = null;
    UopSynchronizationStyle _synchronizationStyle = conn.getSynchronizationStyle();
    boolean _equals = Objects.equal(_synchronizationStyle, UopSynchronizationStyle.BLOCKING);
    if (_equals) {
      _xifexpression = null;
    } else {
      _xifexpression = null;
    }
    return ((CharSequence)_xifexpression);
  }

  protected CharSequence _parmList(final UopSingleInstanceMessageConnection conn) {
    Object _xifexpression = null;
    UopSynchronizationStyle _synchronizationStyle = conn.getSynchronizationStyle();
    boolean _equals = Objects.equal(_synchronizationStyle, UopSynchronizationStyle.BLOCKING);
    if (_equals) {
      _xifexpression = null;
    } else {
      _xifexpression = null;
    }
    return ((CharSequence)_xifexpression);
  }

  public CharSequence compile(final IntegrationUoPInstance inst) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }

  /**
   * These methods reroute the call to the specified data structure generator
   */
  @Override
  public String getRootDirectory() {
    return this.dsg.getRootDirectory();
  }

  @Override
  public String getWriteFileExtension() {
    return this.dsg.getWriteFileExtension();
  }

  @Override
  public String getReadFileExtension() {
    return this.dsg.getReadFileExtension();
  }

  @Override
  public String getImportPrefix() {
    return this.dsg.getImportPrefix();
  }

  @Override
  public String getImportSuffix() {
    return this.dsg.getImportSuffix();
  }

  @Override
  public String getTypeDefPrefix() {
    return this.dsg.getTypeDefPrefix();
  }

  @Override
  public String getNamespaceKwd() {
    return this.dsg.getNamespaceKwd();
  }

  @Override
  public String getClazzKwd() {
    return this.dsg.getClazzKwd();
  }

  @Override
  public String getSpecializesKwd() {
    return this.dsg.getSpecializesKwd();
  }

  @Override
  public String getCompositionVisibility() {
    return this.dsg.getCompositionVisibility();
  }

  @Override
  public String getPDTTypeString(final PlatformDataType pdt) {
    return this.dsg.getPDTTypeString(pdt);
  }

  @Override
  public String defNewType(final PlatformDataType pdt) {
    return this.dsg.defNewType(pdt);
  }

  @Override
  public String pdmHeader(final PlatformDataModel pdm) {
    return this.dsg.pdmHeader(pdm);
  }

  @Override
  public String generateImportStatement(final PlatformDataModel pdm, final EObject ctx) {
    return this.dsg.generateImportStatement(pdm, ctx);
  }

  @Override
  public String generateImportStatement(final PlatformEntity entType, final EObject ctx) {
    return this.dsg.generateImportStatement(entType, ctx);
  }

  @Override
  public String getFileHeader(final PlatformEntity entType) {
    return this.dsg.getFileHeader(entType);
  }

  @Override
  public String compositionElement(final PlatformComposition composition, final int ndx) {
    return this.dsg.compositionElement(composition, ndx);
  }

  @Override
  public String participantElement(final PlatformParticipant participant, final int ndx) {
    return this.dsg.participantElement(participant, ndx);
  }

  @Override
  public String clazzDecl(final PlatformEntity entity) {
    return this.dsg.clazzDecl(entity);
  }

  @Override
  public String clazzEndDecl(final PlatformEntity entity) {
    return this.dsg.clazzEndDecl(entity);
  }

  @Override
  public String genTypeName(final PlatformComposableElement pce) {
    return this.dsg.genTypeName(pce);
  }

  public boolean missingPlatformDetail(final UopConnection conn) {
    if (conn instanceof UopQueuingConnection) {
      return _missingPlatformDetail((UopQueuingConnection)conn);
    } else if (conn instanceof UopSingleInstanceMessageConnection) {
      return _missingPlatformDetail((UopSingleInstanceMessageConnection)conn);
    } else if (conn instanceof UopClientServerConnection) {
      return _missingPlatformDetail((UopClientServerConnection)conn);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(conn).toString());
    }
  }

  public CharSequence compile(final UopUnitOfPortability uop, final Collection<PlatformEntity> entities) {
    if (uop instanceof UopPlatformSpecificComponent) {
      return _compile((UopPlatformSpecificComponent)uop, entities);
    } else if (uop instanceof UopPortableComponent) {
      return _compile((UopPortableComponent)uop, entities);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(uop, entities).toString());
    }
  }

  public CharSequence parmList(final EObject templ) {
    if (templ instanceof UopCompositeTemplate) {
      return _parmList((UopCompositeTemplate)templ);
    } else if (templ instanceof UopTemplate) {
      return _parmList((UopTemplate)templ);
    } else if (templ instanceof UopQueuingConnection) {
      return _parmList((UopQueuingConnection)templ);
    } else if (templ instanceof UopSingleInstanceMessageConnection) {
      return _parmList((UopSingleInstanceMessageConnection)templ);
    } else if (templ instanceof UopClientServerConnection) {
      return _parmList((UopClientServerConnection)templ);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(templ).toString());
    }
  }
}
