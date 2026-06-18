package de.nicolas.mygame.gwt;

import de.nicolas.mygame.platform.PlatformServices;

public class HtmlService implements PlatformServices {
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
