package com.example.davids.minitabletapp.logics;

import android.os.Environment;

import com.example.davids.minitabletapp.NearVisionApplication;

public class Consts
{
	public static final int	SERVER_PORT						= 8070;
	public static final int	SERVER_TIMEOUT					= 3000;
	public static final int	HIDE_SOFT_KEYS_TIMEOUT			= 3000;

	public static final int	DEFAULT_UPDATED_LANGUAGES_DATE	= -1;	//for update the date when the application starts in the first time

	public static final int	NUMBER_TEXT_PARAGRAPHS			= 8;

	public static final String SELECTED_MANUAL_LANGUAGE_KEY = "SELECTED_MANUAL_LANGUAGE_KEY";

	public enum Languages
	{
		ENGLISH, FRENCH, GERMAN;

		public static Languages getLangugesByLangPrefix(String langPrefix)
		{
			if ("en".equals(langPrefix))
			{
				return ENGLISH;
			}
			else if ("de".equals(langPrefix))
			{
				return GERMAN;
			}
			else if ("fr".equals(langPrefix))
			{
				return FRENCH;
			}
			return ENGLISH;//DEFUALT
		}

	}

	public static final String	FILE_BASE_PATH	= Environment.getExternalStorageDirectory().getPath() + "/Android/data/"
			+ NearVisionApplication.getContext().getPackageName();
	public static final String	LANGUAGES_DIR	= "/languages/";

	public enum FIXATION_TESTS
	{
		REGULAR_LETTERS, BIGGER_LETTERS;
	}

	public class FUNCTIONALITIES
	{
		public static final String	DEFAULT		= "DEFAULT";
		public static final String	ADVANCED	= "ADVANCED";
	}

	public enum L40CmdFam
	{
		VISUAL_ACUITY, // Test d'acuit  : Tous les boutons pour le test d'acuit
		SPECIAL_TEST_NC, // Pas ce control : aucun bouton
		SPECIAL_TEST_ITYN, // Interactif Yes / No	: juste les boutons YES et NO
		SPECIAL_TEST_ETDRS, // ETDRS : Yes et No, Fleche Haut / Fleche Bas, Chg
		SPECIAL_TEST_PIC, // Image didactitielle : Fleche haut et bas
		SPECIAL_TEST_IC, // Inversion Couleur : Bouton pour inverser les couleurs (R/G)
		SPECIAL_TEST_ISH, // Ishiarha : Haut bas, gauche droite
		SPECIAL_TEST_WOR, // Worth haut bas gauche droite,
		SPECIAL_FUNCTION, // Bouton de fonction
		NV_TEST,
		JACKSON_CROSS,
		RED_AND_GREEN,AMSLER_GRID,
		CLOCK_ASTIGMATISM,
		NUMBER_IN_HORIZONTAL_LINE,
		NUMBER_IN_VERTICAL_LINE,
		FIXATION_DISPARITY,
		STEREO_ACUITY,
		WORTH,

		WESSON,
		SCHOBER,
		FIXATION_POINT,CROSS_PHORIA,OXO_HORIZONTAL,OXO_VERTICAL,BROWSER,METRO,RIGHT,LEFT


	};

	public enum L40Cmd
	{

		NV_QUICK_TEST(500, "QUICK_NV", L40CmdFam.NV_TEST, "near_vision_image"),
		NV_FIXATION_TEST(501, "NV_FIX", L40CmdFam.NV_TEST, "nv_fixation_target"),
		NV_TEXT_TEST(502, "NV_TEXT", L40CmdFam.NV_TEST, "text"),

		//nv actions for only scroll for NV_TEXT
		NV_TEXT_SCROLL_UP(503, "NV_SCROLL_UP", L40CmdFam.SPECIAL_FUNCTION, null),
		NV_TEXT_SCROLL_DOWN(504, "NV_SCROLL_DOWN", L40CmdFam.SPECIAL_FUNCTION, null),

		NV_JACKSON_CROSS(505, "NV_JACKSON_CROSS", L40CmdFam.JACKSON_CROSS, null),
		NV_RED_AND_GREEN(506, "NV_RED_AND_GREEN", L40CmdFam.RED_AND_GREEN, null),
		NV_AMSLER_GRID(507, "NV_AMSLER_GRID", L40CmdFam.AMSLER_GRID, null),

		NV_CLOCK_ASTIGMATISM(508, "NV_CLOCK_ASTIGMATISM", L40CmdFam.CLOCK_ASTIGMATISM, null),
		NV_NUMBER_IN_HORIZONTAL_LINE(509, "NV_NUMBER_IN_HORIZONTAL_LINE", L40CmdFam.NUMBER_IN_HORIZONTAL_LINE, null),

		NV_FIXATION_DISPARITY(510, "NV_FIXATION_DISPARITY ", L40CmdFam.FIXATION_DISPARITY, null),
		NV_STEREO_ACUITY(511, "NV_STEREO_ACUITY", L40CmdFam.STEREO_ACUITY, null),

		NV_WORTH(512, "NV_WORTH", L40CmdFam.WORTH, null),
		NV_NUMBER_IN_VERTICAL_LINE(513, "NV_NUMBER_IN_VERTICAL_LINE", L40CmdFam.NUMBER_IN_VERTICAL_LINE, null),
		NV_WESSON(514, "NV_WESSON", L40CmdFam.WESSON, null),
		NV_SCHOBER(515, "NV_SCHOBER", L40CmdFam.SCHOBER, null),
		NV_FIXATION_POINT(516, "NV_FIXATION_POINT", L40CmdFam.FIXATION_POINT, null),
		NV_CROSS_PHORIA (517, "NV_CROSS_PHORIA", L40CmdFam.CROSS_PHORIA, null),
		NV_OXO_HORIZONTAL (518, "NV_OXO_HORIZONTAL", L40CmdFam.OXO_HORIZONTAL, null),
		NV_OXO_VERTICAL (519, "NV_OXO_VERTICAL", L40CmdFam.OXO_VERTICAL, null),
		NV_BROWSER (520, "NV_BROWSER", L40CmdFam.BROWSER, null),
		NV_METRO (521,"NV_METRO", L40CmdFam.METRO, null),

		NV_RIGHT (522,"NV_RIGHT", L40CmdFam.RIGHT, null),
		NV_LEFT (523,"NV_LEFT", L40CmdFam.LEFT, null);
	 ;

		public String		mCmd;
		public L40CmdFam	mFamily;
		public int			mBgId;
		public int			mTestId;
		public String		mLargeName;

		private L40Cmd(int id, String cmd, L40CmdFam family, String largeName)
		{
			mTestId = id;
			mCmd = cmd;
			mFamily = family;
			mLargeName = largeName;
		}
	};
}
