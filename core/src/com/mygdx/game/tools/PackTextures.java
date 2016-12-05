package com.mygdx.game.tools;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class PackTextures {
	public static void packImage(String inputdir, String outputdir, boolean stripWhitespace,String packName) {
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.paddingX = 2;
		settings.paddingY = 2;
		settings.minWidth = 8;
		settings.minHeight = 8;
        settings.combineSubdirectories = true;
		settings.ignoreBlankImages = false;
		settings.stripWhitespaceX = stripWhitespace;
		settings.stripWhitespaceY = stripWhitespace;
		settings.filterMag = TextureFilter.Linear;
		settings.filterMin = TextureFilter.Linear;
		TexturePacker.process(settings, inputdir, outputdir, packName);
	}

	public static void main(String[] args) {
		packImage("GameScreen", "packedImages/", true, "GameScreen");
		packImage("SplashScreen", "packedImages/", true, "SplashScreen");

		System.out.println("done");
	}
}
