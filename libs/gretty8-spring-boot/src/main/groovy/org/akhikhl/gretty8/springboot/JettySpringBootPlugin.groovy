/*
 * gretty
 *
 * Copyright 2013  Andrey Hihlovskiy.
 *
 * See the file "license.txt" for copying and usage permission.
 */
package org.akhikhl.gretty8.springboot

import org.akhikhl.gretty.springboot.JettySpringBootPluginBase
import org.akhikhl.gretty.ScannerManagerFactory
import org.akhikhl.gretty8.ScannerManagerFactoryImpl
import org.gradle.api.Project

/**
 *
 * @author akhikhl
 */
class JettySpringBootPlugin extends JettySpringBootPluginBase {

  static final ScannerManagerFactory scannerManagerFactory = new ScannerManagerFactoryImpl(true)

  @Override
  protected String getJettyVersion() {
    Messages.getString('jettyVersion')
  }

  @Override
  protected String getPluginName() {
    Messages.getString('jettySpringBootPluginName')
  }

  @Override
  protected ScannerManagerFactory getScannerManagerFactory() {
    scannerManagerFactory
  }

  @Override
  protected void injectDependencies(Project project) {
    super.injectDependencies(project)
    project.dependencies {
      providedCompile 'javax.servlet:javax.servlet-api:3.0.1'
      grettyHelperConfig 'org.akhikhl.gretty:gretty8-spring-boot-helper:0.0.26'
    }
  }
}
