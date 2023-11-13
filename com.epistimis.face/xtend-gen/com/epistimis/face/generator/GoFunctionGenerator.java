package com.epistimis.face.generator;

import com.epistimis.face.face.FaceElement;
import com.epistimis.face.face.UopConnection;
import com.epistimis.face.face.UopUnitOfPortability;
import com.epistimis.face.face.UopUoPModel;
import com.epistimis.uddl.generator.GoDataStructureGenerator;
import com.epistimis.uddl.uddl.PlatformDataModel;
import com.epistimis.uddl.uddl.PlatformEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class GoFunctionGenerator extends CommonFunctionGenerator implements IFaceLangGenerator {
  /**
   * Eventually this code generator can look at the version of language (look up SupportingComponents for runtimes and see
   * which version of the runtime is being used. The assumption is that the compiler must be at that version, so we can use
   * language features from that version if desired)
   */
  public GoFunctionGenerator(final QueryUtilities qu) {
    super(qu, new GoDataStructureGenerator());
  }

  @Override
  public String getSrcExtension() {
    return ".go";
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
    _builder.append("package ");
    EObject _eContainer = uop.eContainer();
    String _name = ((UopUoPModel) _eContainer).getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
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
    _builder.append("func ");
    String _name_1 = uop.getName();
    _builder.append(_name_1);
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
        String _typeString = this.getTypeString((((Map.Entry<String, PlatformEntity>[])Conversions.unwrapArray(this.qu.getReferencedPlatformEntities(conn).entrySet(), Map.Entry.class))[0]).getValue());
        _builder.append(_typeString);
        _builder.append(" ");
        String _name_2 = conn.getName();
        _builder.append(_name_2);
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
    _builder.append("bool hasConsent = checkConsents(");
    {
      EList<UopConnection> _connection_1 = uop.getConnection();
      boolean _hasElements_1 = false;
      for(final UopConnection conn_1 : _connection_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append(" ");
        String _name_3 = conn_1.getName();
        _builder.append(_name_3, "\t");
      }
    }
    _builder.append(");\t");
    _builder.newLineIfNotEmpty();
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
}
