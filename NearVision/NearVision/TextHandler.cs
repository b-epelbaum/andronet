using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NearVision
{
    public class TextData
    {
        public TextData(BlockArray ba)
        {
            UnitText = ba.ArrayUnit;
            FontSize = ba.FontSize;
            Text = ba.Paragraph;
        }

        public string UnitText { get; set; }
        public double FontSize { get; set; }
        public string Text { get; set; }
    }

    public class TextHandler
    {
        public delegate void UpdateTextBlock(TextData textData);

        //declare event of type delegate
        public event UpdateTextBlock UpdateTextBlockEvent;

        public TextHandler(ConfigMgr config )
        {
            _config = config;
            _config.LanguageChangedEvent += onLanguageChangedEvent;
            initTextBlocks(_config.CurrentLangId);
            _textIndex = _currentBlockArrayList.Count - 1;
        }

        private void onLanguageChangedEvent(string langID)
        {
            initTextBlocks(langID);
            UpdateTextBlockEvent?.Invoke(getCurrentTextData());
        }

        private void initTextBlocks ( string langID )
        {
            _currentBlockArrayList = _config.GetBlocks(_config.CurrentLangId);
        }

        public TextData getCurrentTextData ()
        {
            if (_textIndex < 0)
                _textIndex = 0;
            if (_textIndex > _currentBlockArrayList.Count)
                _textIndex = _currentBlockArrayList.Count - 1;
            return new TextData(_currentBlockArrayList[_textIndex]);
        }

        public TextData next()
        {
            if (_textIndex < _currentBlockArrayList.Count - 1)
                _textIndex++;

            return getCurrentTextData();
        }

        public TextData previous()
        {
            if (_textIndex > 0)
                _textIndex--;

            return getCurrentTextData();
        }

        private ConfigMgr _config;
        private int _textIndex;
        List<BlockArray> _currentBlockArrayList;
    }
}
