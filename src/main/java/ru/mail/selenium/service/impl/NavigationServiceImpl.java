package ru.mail.selenium.service.impl;

import ru.mail.selenium.service.NavigationService;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class NavigationServiceImpl extends DriverBasedService implements NavigationService {

  private String baseUrl;

  public NavigationServiceImpl(ApplicationManagerImpl manager) {
    super(manager.getWebDriver());
    this.baseUrl = manager.getBaseUrl();
  }
  
  @Override
  public void openMainPage() {
    driver.get(baseUrl);
  }
}
