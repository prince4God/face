/*
 * generated by Xtext 2.30.0
 */
/*
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.face.ui;

import com.epistimis.face.ui.internal.FaceActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class FaceExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(FaceActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		FaceActivator activator = FaceActivator.getInstance();
		return activator != null ? activator.getInjector(FaceActivator.COM_EPISTIMIS_FACE_FACE) : null;
	}

}
