/**
 * generated by Xtext 2.28.0
 */
package com.epistimis.face.generator;

import com.epistimis.face.face.UopProgrammingLanguage;
import com.epistimis.face.face.UopUnitOfPortability;
import com.epistimis.uddl.exceptions.QueryMatchException;
import com.epistimis.uddl.uddl.PlatformEntity;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class FaceGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider qnp;

  @Inject
  @Extension
  private QueryUtilities qu;

  private static Logger logger = Logger.getLogger(FaceGenerator.class);

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Map<UopProgrammingLanguage, IFaceLangGenerator> languageSpecificGenerators = new HashMap<UopProgrammingLanguage, IFaceLangGenerator>();
    CPPFunctionGenerator _cPPFunctionGenerator = new CPPFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.CPP, _cPPFunctionGenerator);
    GoFunctionGenerator _goFunctionGenerator = new GoFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.GO, _goFunctionGenerator);
    PythonFunctionGenerator _pythonFunctionGenerator = new PythonFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.PYTHON, _pythonFunctionGenerator);
    ScalaFunctionGenerator _scalaFunctionGenerator = new ScalaFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.SCALA, _scalaFunctionGenerator);
    RDBMSFunctionGenerator _rDBMSFunctionGenerator = new RDBMSFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.SQL, _rDBMSFunctionGenerator);
    TypescriptFunctionGenerator _typescriptFunctionGenerator = new TypescriptFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.TS, _typescriptFunctionGenerator);
    TypescriptFunctionGenerator _typescriptFunctionGenerator_1 = new TypescriptFunctionGenerator(this.qu);
    languageSpecificGenerators.put(UopProgrammingLanguage.JS, _typescriptFunctionGenerator_1);
    Iterable<UopUnitOfPortability> _filter = Iterables.<UopUnitOfPortability>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), UopUnitOfPortability.class);
    for (final UopUnitOfPortability comp : _filter) {
      try {
        final Map<String, PlatformEntity> entities = this.qu.getReferencedPlatformEntities(comp);
        UopProgrammingLanguage _transportAPILanguage = comp.getTransportAPILanguage();
        boolean _notEquals = (!Objects.equal(_transportAPILanguage, UopProgrammingLanguage.UNSPECIFIED));
        if (_notEquals) {
          final IFaceLangGenerator generator = languageSpecificGenerators.get(comp.getTransportAPILanguage());
          if ((generator == null)) {
            final String fmttedMessage = MessageFormat.format(
              "Component {0} is supposed to be generated in {1} but no generator yet available for that language", 
              this.qnp.getFullyQualifiedName(comp).toString(), comp.getTransportAPILanguage().toString());
            FaceGenerator.logger.info(fmttedMessage);
          } else {
            generator.processEntities(entities.values(), fsa, context);
            generator.processAComponent(comp, entities.values(), fsa, context);
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof QueryMatchException) {
          final QueryMatchException excp = (QueryMatchException)_t;
          String _string = excp.toString();
          String fmttedMessage_1 = ("Unable to generate code: " + _string);
          Throwable[] _suppressed = excp.getSuppressed();
          for (final Throwable t : _suppressed) {
            String _fmttedMessage = fmttedMessage_1;
            String _string_1 = t.toString();
            String _plus = ("\n" + _string_1);
            fmttedMessage_1 = (_fmttedMessage + _plus);
          }
          FaceGenerator.logger.info(fmttedMessage_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
}
