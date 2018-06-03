using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NearVision
{
    public class Constants
    {
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
            RED_AND_GREEN, AMSLER_GRID,
            CLOCK_ASTIGMATISM,
            NUMBER_IN_HORIZONTAL_LINE,
            NUMBER_IN_VERTICAL_LINE,
            FIXATION_DISPARITY,
            STEREO_ACUITY,
            WORTH,

            WESSON,
            SCHOBER,
            FIXATION_POINT, CROSS_PHORIA, OXO_HORIZONTAL, OXO_VERTICAL, BROWSER, METRO, RIGHT, LEFT
        };
        public class L40Cmd
        {

            public static readonly L40Cmd NV_QUICK_TEST = new L40Cmd(500, "QUICK_NV", L40CmdFam.NV_TEST, "near_vision_image");
            public static readonly L40Cmd NV_FIXATION_TEST = new L40Cmd(501, "NV_FIX", L40CmdFam.NV_TEST, "nv_fixation_target");
            public static readonly L40Cmd NV_TEXT_TEST = new L40Cmd(502, "NV_TEXT", L40CmdFam.NV_TEST, "text");

            public static readonly L40Cmd NV_TEXT_SCROLL_UP = new L40Cmd(503, "NV_SCROLL_UP", L40CmdFam.SPECIAL_FUNCTION, null);
            public static readonly L40Cmd NV_TEXT_SCROLL_DOWN = new L40Cmd(504, "NV_SCROLL_DOWN", L40CmdFam.SPECIAL_FUNCTION, null);

            public static readonly L40Cmd NV_JACKSON_CROSS = new L40Cmd(505, "NV_JACKSON_CROSS", L40CmdFam.JACKSON_CROSS, null);
            public static readonly L40Cmd NV_RED_AND_GREEN = new L40Cmd(506, "NV_RED_AND_GREEN", L40CmdFam.RED_AND_GREEN, null);
            public static readonly L40Cmd NV_AMSLER_GRID = new L40Cmd(507, "NV_AMSLER_GRID", L40CmdFam.AMSLER_GRID, null);

            public static readonly L40Cmd NV_CLOCK_ASTIGMATISM = new L40Cmd(508, "NV_CLOCK_ASTIGMATISM", L40CmdFam.CLOCK_ASTIGMATISM, null);
            public static readonly L40Cmd NV_NUMBER_IN_HORIZONTAL_LINE = new L40Cmd(509, "NV_NUMBER_IN_HORIZONTAL_LINE", L40CmdFam.NUMBER_IN_HORIZONTAL_LINE, null);

            public static readonly L40Cmd NV_FIXATION_DISPARITY = new L40Cmd(510, "NV_FIXATION_DISPARITY", L40CmdFam.FIXATION_DISPARITY, null);
            public static readonly L40Cmd NV_STEREO_ACUITY = new L40Cmd(511, "NV_STEREO_ACUITY", L40CmdFam.STEREO_ACUITY, null);

            public static readonly L40Cmd NV_WORTH = new L40Cmd(512, "NV_WORTH", L40CmdFam.WORTH, null);
            public static readonly L40Cmd NV_NUMBER_IN_VERTICAL_LINE = new L40Cmd(513, "NV_NUMBER_IN_VERTICAL_LINE", L40CmdFam.NUMBER_IN_VERTICAL_LINE, null);
            public static readonly L40Cmd NV_WESSON = new L40Cmd(514, "NV_WESSON", L40CmdFam.WESSON, null);
            public static readonly L40Cmd NV_SCHOBER = new L40Cmd(515, "NV_SCHOBER", L40CmdFam.SCHOBER, null);
            public static readonly L40Cmd NV_FIXATION_POINT = new L40Cmd(516, "NV_FIXATION_POINT", L40CmdFam.FIXATION_POINT, null);
            public static readonly L40Cmd NV_CROSS_PHORIA = new L40Cmd(517, "NV_CROSS_PHORIA", L40CmdFam.CROSS_PHORIA, null);
            public static readonly L40Cmd NV_OXO_HORIZONTAL = new L40Cmd(518, "NV_OXO_HORIZONTAL", L40CmdFam.OXO_HORIZONTAL, null);
            public static readonly L40Cmd NV_OXO_VERTICAL = new L40Cmd(519, "NV_OXO_VERTICAL", L40CmdFam.OXO_VERTICAL, null);
            public static readonly L40Cmd NV_BROWSER = new L40Cmd(520, "NV_BROWSER", L40CmdFam.BROWSER, null);
            public static readonly L40Cmd NV_METRO = new L40Cmd(521, "NV_METRO", L40CmdFam.METRO, null);

            public static readonly L40Cmd NV_RIGHT = new L40Cmd(522, "NV_RIGHT", L40CmdFam.RIGHT, null);
            public static readonly L40Cmd NV_LEFT = new L40Cmd(523, "NV_LEFT", L40CmdFam.LEFT, null);

            public static IEnumerable<L40Cmd> Values
            {
                get
                {
                    yield return NV_QUICK_TEST;
                    yield return NV_FIXATION_TEST;
                    yield return NV_TEXT_TEST;
                    yield return NV_TEXT_SCROLL_UP;
                    yield return NV_TEXT_SCROLL_DOWN;
                    yield return NV_JACKSON_CROSS;
                    yield return NV_RED_AND_GREEN;
                    yield return NV_AMSLER_GRID;
                    yield return NV_CLOCK_ASTIGMATISM;
                    yield return NV_NUMBER_IN_HORIZONTAL_LINE;
                    yield return NV_FIXATION_DISPARITY;
                    yield return NV_STEREO_ACUITY;
                    yield return NV_WORTH;
                    yield return NV_NUMBER_IN_VERTICAL_LINE;
                    yield return NV_WESSON;
                    yield return NV_SCHOBER;
                    yield return NV_FIXATION_POINT;
                    yield return NV_CROSS_PHORIA;
                    yield return NV_OXO_HORIZONTAL;
                    yield return NV_OXO_VERTICAL;
                    yield return NV_BROWSER;
                    yield return NV_METRO;
                    yield return NV_RIGHT;
                    yield return NV_LEFT;
                }
            }


            public String mCmd;
            public L40CmdFam mFamily;
            public int mBgId;
            public int mTestId;
            public String mLargeName;

            private L40Cmd(int id, String cmd, L40CmdFam family, String largeName)
            {
                mTestId = id;
                mCmd = cmd;
                mFamily = family;
                mLargeName = largeName;
            }
        };
        public static readonly string[] Paragraphs = {
                   "The sun warmed my face as I gazed about in wonder and awe at the day unfolding before me.",
        "All around me the sound of nature was alive and new.\r\nThe beauty of this morning overwhelmed me.",
        "Above the trees, the birds circled in flight, calling out to one\r\nanother in the sweetest of nature’s melodies",
        "The sky had the slightest of clouds, a subtle streak\r\nof white here and there against the magnificent\r\nexpanse of blue",
        "Never had there been such a marvellous\r\nmorning in all my life",
        "Out across the meadow there were deer\r\ngrazing on the grass which was\r\ncovered in the morning dew",
        "The tiny waves seemed to go on\r\nfor miles and miles",
        "The soft breeze made\r\nsmall impressions on the\r\nsurface of the water",
 "In a beautiful\r\nmeadow near\r\nthe lake"
        };

        public static readonly string[] Unit = {
                       "N5",
            "N6",
            "N8",
            "N10",
            "N12",
            "N14",
            "N18",
            "N24",
"N36",
        };

        public static readonly int[] FontSize = {
                          13,
        15,
        20,
        25,
        31,
        36,
        46,
        61,
 92,
        };
    }

}
