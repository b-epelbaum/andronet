using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NearVision
{
    public class ServerResponse
    {
        private int _opto;
        private String _dist;
        private String _rSymbols;
        private long _ptime;
        private int _test;
        private int _inv;
        private String _cmd;
        private String _vSymbols;
        private String _ac1;
        private String _ac2;
        private String _ac3;
        private int _rg;
        private int _mode;
        private int _maxRows;
        private int _nbCols;
        private int _maxCols;
        private int _nbRows;
        private int _err;
        private int _contrast;
        private int _orientation;
        private int _planche;
        private int _category;
        private String _langCode;
        private String _rowTextOne;
        private String _rowTextTwo;

        public ServerResponse()
        {

        }

        public void setLangCode(String langCode)
        {
            _langCode = langCode;
        }

        public void setTextOne(String text)
        {
            _rowTextOne = text;
        }

        public String getTextOne()
        {
            return _rowTextOne;
        }

        public void setTextTwo(String text)
        {
            _rowTextTwo = text;
        }

        public String getTextTwo()
        {
            return _rowTextTwo;
        }

        public String getLangCode()
        {
            return _langCode;
        }

        public int getCategory()
        {
            return _category;
        }

        public void setCategory(int category)
        {
            _category = category;
        }

        public void setPlanche(int planche)
        {
            _planche = planche;
        }

        public int getPlanche()
        {
            return _planche;
        }

        public void setOrientation(int orientation)
        {
            _orientation = orientation;
        }

        public int getOrientation()
        {
            return _orientation;
        }

        public int getOpto()
        {
            return _opto;
        }

        public void setOpto(int opto)
        {
            _opto = opto;
        }

        public String getDist()
        {
            return _dist;
        }

        public void setDist(String dist)
        {
            _dist = dist;
        }

        public String getRSymbols()
        {
            return _rSymbols;
        }

        public void setRSymbols(String rSymbols)
        {
            _rSymbols = rSymbols;
        }

        public long getPtime()
        {
            return _ptime;
        }

        public void setPtime(long ptime)
        {
            _ptime = ptime;
        }

        public int getTest()
        {
            return _test;
        }

        public void setTest(int test)
        {
            _test = test;
        }

        public int getInv()
        {
            return _inv;
        }

        public void setInv(int inv)
        {
            _inv = inv;
        }

        public String getCmd()
        {
            return _cmd;
        }

        public void setCmd(String cmd)
        {
            _cmd = cmd;
        }

        public String getVSymbols()
        {
            return _vSymbols;
        }

        public void setVSymbols(String vSymbols)
        {
            _vSymbols = vSymbols;
        }

        public String getAc1()
        {
            return _ac1;
        }

        public void setAc1(String ac1)
        {
            _ac1 = ac1;
        }

        public String getAc2()
        {
            return _ac2;
        }

        public void setAc2(String ac2)
        {
            _ac2 = ac2;
        }

        public String getAc3()
        {
            return _ac3;
        }

        public void setAc3(String ac3)
        {
            _ac3 = ac3;
        }

        public int getRg()
        {
            return _rg;
        }

        public void setRg(int rg)
        {
            _rg = rg;
        }

        public int getMode()
        {
            return _mode;
        }

        public void setMode(int mode)
        {
            _mode = mode;
        }

        public int getMaxRows()
        {
            return _maxRows;
        }

        public void setMaxRows(int maxRows)
        {
            _maxRows = maxRows;
        }

        public int getNbCols()
        {
            return _nbCols;
        }

        public void setNbCols(int nbCols)
        {
            _nbCols = nbCols;
        }

        public int getMaxCols()
        {
            return _maxCols;
        }

        public void setMaxCols(int maxCols)
        {
            _maxCols = maxCols;
        }

        public int getNbRows()
        {
            return _nbRows;
        }

        public void setNbRows(int nbRows)
        {
            _nbRows = nbRows;
        }

        public int getErr()
        {
            return _err;
        }

        public void setErr(int err)
        {
            _err = err;
        }

        public int getContrast()
        {
            return _contrast;
        }

        public void setContrast(int contrast)
        {
            _contrast = contrast;
        }

    }

}
