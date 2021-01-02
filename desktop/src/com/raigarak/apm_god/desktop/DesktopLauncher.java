package com.raigarak.apm_god.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.raigarak.apm_god.Apm;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "APM God v1.0";
		//config.foregroundFPS = 60;
		//config.useGL30 = true;
		//config.resizable = false;
		new LwjglApplication(new Apm(), config);
	}
}
