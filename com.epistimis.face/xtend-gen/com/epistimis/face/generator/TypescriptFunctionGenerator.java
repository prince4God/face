package com.epistimis.face.generator;

import com.epistimis.face.face.FaceElement;
import com.epistimis.face.face.UopConnection;
import com.epistimis.face.face.UopUnitOfPortability;
import com.epistimis.uddl.generator.TypescriptDataStructureGenerator;
import com.epistimis.uddl.uddl.PlatformDataModel;
import com.epistimis.uddl.uddl.PlatformEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class TypescriptFunctionGenerator extends CommonFunctionGenerator implements IFaceLangGenerator {
  private static Logger logger = Logger.getLogger(TypescriptFunctionGenerator.class);

  /**
   * Eventually this code generator can look at the version of language (look up SupportingComponents for runtimes and see
   * which version of the runtime is being used. The assumption is that the compiler must be at that version, so we can use
   * language features from that version if desired)
   */
  public TypescriptFunctionGenerator(final QueryUtilities qu) {
    super(qu, new TypescriptDataStructureGenerator());
  }

  @Override
  public String getSrcExtension() {
    return ".ts";
  }

  /**
   * Only UopUnitOfPortability will have CPP files
   */
  @Override
  public String generateFileName(final FaceElement obj) {
    String _generateDirectories = this.generateDirectories(obj);
    String _dirDelimiter = this.getDirDelimiter();
    String _plus = (_generateDirectories + _dirDelimiter);
    String _name = obj.getName();
    String _plus_1 = (_plus + _name);
    String _srcExtension = this.getSrcExtension();
    return (_plus_1 + _srcExtension);
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
  @Override
  public String compileUopCommon(final UopUnitOfPortability uop, final Collection<PlatformEntity> entities) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/** Include all needed headers */");
    _builder.newLine();
    ArrayList<PlatformEntity> entityIncludes = new ArrayList<PlatformEntity>();
    _builder.newLineIfNotEmpty();
    List<PlatformDataModel> pdmIncludes = new ArrayList<PlatformDataModel>();
    _builder.newLineIfNotEmpty();
    {
      for(final PlatformEntity ent : entities) {
        String _generateInclude = this.generateInclude(ent, uop, pdmIncludes, entityIncludes);
        _builder.append(_generateInclude);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("export default function ");
    String _name = uop.getName();
    _builder.append(_name);
    _builder.append("(");
    {
      EList<UopConnection> _connection = uop.getConnection();
      boolean _hasElements = false;
      for(final UopConnection conn : _connection) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append(" ");
        String _genParameter = this.genParameter(conn);
        _builder.append(_genParameter);
        _builder.append(" ");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** The first step in this function must be a check for runtime privacy issues (e.g. where individual choices matter like Consent).");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*  This might be a null function");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var hasConsent: boolean = true;");
    _builder.newLine();
    {
      EList<UopConnection> _connection_1 = uop.getConnection();
      for(final UopConnection conn_1 : _connection_1) {
        _builder.append("\t");
        _builder.append("hasConsent = hasConsent && check_consents(");
        String _genParameterName = this.genParameterName(conn_1);
        _builder.append(_genParameterName, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!hasConsent) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* The remainder of this function body should be manually filled in");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public String genFunctionName(final UopUnitOfPortability uop) {
    return uop.getName();
  }

  public String genParameterName(final UopConnection conn) {
    return conn.getName();
  }

  public String genParameter(final UopConnection conn) {
    final Map<String, PlatformEntity> pes = this.qu.getReferencedPlatformEntities(conn);
    boolean _isEmpty = pes.isEmpty();
    if (_isEmpty) {
      QualifiedName _fullyQualifiedName = this.qnp.getFullyQualifiedName(conn);
      String _plus = ("Connection " + _fullyQualifiedName);
      String _plus_1 = (_plus + " references missing type");
      TypescriptFunctionGenerator.logger.error(_plus_1);
      return "<Missing parameter>";
    }
    String _genParameterName = this.genParameterName(conn);
    String _plus_2 = (_genParameterName + ": ");
    String _typeString = this.getTypeString((((Map.Entry<String, PlatformEntity>[])Conversions.unwrapArray(pes.entrySet(), Map.Entry.class))[0]).getValue());
    return (_plus_2 + _typeString);
  }
}
