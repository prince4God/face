/*
 * generated by Xtext 2.28.0
 */
package com.epistimis.face.scoping;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.util.IResourceScopeCache;

//import com.epistimis.face.face.FacePackage;
import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.google.inject.Provider;

// NOTE: Content generated from XTend based on https://blogs.itemis.com/en/in-five-minutes-to-transitive-imports-within-a-dsl-with-xtext

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class FaceGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	  private static final Splitter SPLITTER = Splitter.on(",");

	  @Inject
	  private IResourceDescription.Manager descriptionManager;

	  @Inject
	  private IResourceScopeCache cache;

	  @Override
	  protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		    abstract class __FaceGlobalScopeProvider_1 implements Provider<LinkedHashSet<URI>> {
		      final __FaceGlobalScopeProvider_1 _this__FaceGlobalScopeProvider_1 = this;

		      public abstract LinkedHashSet<URI> collectImportUris(final Resource resource, final LinkedHashSet<URI> uniqueImportURIs);
		    }

		    String _simpleName = FaceGlobalScopeProvider.class.getSimpleName();
		    __FaceGlobalScopeProvider_1 ___FaceGlobalScopeProvider_1 = new __FaceGlobalScopeProvider_1() {
		      @Override
		      public LinkedHashSet<URI> get() {
		        LinkedHashSet<URI> _linkedHashSet = new LinkedHashSet<URI>(5);
		        final LinkedHashSet<URI> uniqueImportURIs = this.collectImportUris(resource, _linkedHashSet);
		        final Iterator<URI> uriIter = uniqueImportURIs.iterator();
		        while (uriIter.hasNext()) {
		          boolean _isValidUri = EcoreUtil2.isValidUri(resource, uriIter.next());
		          boolean _not = (!_isValidUri);
		          if (_not) {
		            uriIter.remove();
		          }
		        }
		        return uniqueImportURIs;
		      }

		      public LinkedHashSet<URI> collectImportUris(final Resource resource, final LinkedHashSet<URI> uniqueImportURIs) {
		        final IResourceDescription resourceDescription = FaceGlobalScopeProvider.this.descriptionManager.getResourceDescription(resource);
		        //final Iterable<IEObjectDescription> models = resourceDescription.getExportedObjectsByType(FacePackage.Literals.MODEL_FILE);
		        final Consumer<IEObjectDescription> _function = (IEObjectDescription it) -> {
		          final String userData = it.getUserData(FaceResourceDescriptionsStrategy.INCLUDES);
		          if ((userData != null)) {
		            final Consumer<String> _function_1 = (String uri) -> {
		              URI includedUri = URI.createURI(uri);
		              includedUri = includedUri.resolve(resource.getURI());
		              boolean _add = uniqueImportURIs.add(includedUri);
		              if (_add) {
		                this.collectImportUris(resource.getResourceSet().getResource(includedUri, true), uniqueImportURIs);
		              }
		            };
		            FaceGlobalScopeProvider.SPLITTER.split(userData).forEach(_function_1);
		          }
		        };
		        //models.forEach(_function);
		        return uniqueImportURIs;
		      }
		    };
		    return this.cache.<LinkedHashSet<URI>>get(_simpleName, resource, ___FaceGlobalScopeProvider_1);
		  }
}