package de.nicolas.mygame.lwjgl3;

import de.nicolas.mygame.platform.PlatformServices;

public class DesktopServices implements PlatformServices {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
