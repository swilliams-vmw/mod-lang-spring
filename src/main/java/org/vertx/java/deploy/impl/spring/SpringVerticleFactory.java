package org.vertx.java.deploy.impl.spring;

import org.vertx.java.deploy.Verticle;
import org.vertx.java.deploy.VerticleFactory;
import org.vertx.java.deploy.impl.VerticleManager;


public class SpringVerticleFactory implements VerticleFactory {

  private static final String LANGUAGE = "spring";

  private static final String PREFIX = "spring:";

  @Override
  public void init(VerticleManager manager) {
    // NO-OP
  }

  @Override
  public String getLanguage() {
    return LANGUAGE;
  }

  @Override
  public boolean isFactoryFor(String main) {

    if (main == null) {
      return false;
    }

    return main.startsWith(PREFIX);
  }

  @Override
  public Verticle createVerticle(String main, ClassLoader parent)
      throws Exception {

    String springConfig = main.replaceFirst(PREFIX, "");
    return new SpringVerticle(parent, springConfig);
  }

  @Override
  public void reportException(Throwable t) {
    // TODO Auto-generated method stub
    t.printStackTrace();
  }

}