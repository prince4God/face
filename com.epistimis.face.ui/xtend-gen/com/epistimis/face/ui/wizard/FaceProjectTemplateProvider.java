/**
 * generated by Xtext 2.31.0
 */
package com.epistimis.face.ui.wizard;

import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider;

/**
 * Create a list with all project templates to be shown in the template new project wizard.
 * 
 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
 */
@SuppressWarnings("all")
public class FaceProjectTemplateProvider implements IProjectTemplateProvider {
  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    HelloWorldProject _helloWorldProject = new HelloWorldProject();
    return new AbstractProjectTemplate[] { _helloWorldProject };
  }
}
