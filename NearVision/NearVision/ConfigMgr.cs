using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NearVision
{

    public class General
    {
        public string ServerIP { get; set; }
        public int Port { get; set; }
        public bool IsSSL { get; set; }
    }

    public class BlockArray
    {
        public double FontSize { get; set; }
        public string ArrayUnit { get; set; }
        public string Paragraph { get; set; }
    }

    public class TextTestData
    {
        public string LangID { get; set; }
        public string LangName { get; set; }
        public List<BlockArray> BlockArray { get; set; }
    }

    public class RootObject
    {
        public General General { get; set; }
        public List<TextTestData> TextTestData { get; set; }
    }

    public class ConfigMgr
    {
        public delegate void LanguageChanged( string langID );

        //declare event of type delegate
        public event LanguageChanged languageChangedEvent;

        public ConfigMgr(RootObject rootObj)
        {
            _rootObject = rootObj;
            _general = _rootObject.General;
        }

        public static ConfigMgr Init()
        {
            ConfigMgr retVal =  new ConfigMgr(JsonConvert.DeserializeObject<RootObject>(File.ReadAllText(@"./NearVision.json")));
            retVal.InitLangIDs();
            return retVal;
        }

        public General General
        {
            get => _general;
        }

        public List<String> getLangIDs ()
        {
            return _rootObject.TextTestData.Select(l => l.LangID).ToList();
        }

        public List<String> getLangNames()
        {
            return _rootObject.TextTestData.Select(l => l.LangName).ToList();
        }

        public List<BlockArray> getBlocks ( string langID )
        {
            return _rootObject.TextTestData.Where(l => l.LangID == langID).Select(g => g.BlockArray).SingleOrDefault();
        }

       private RootObject _rootObject { get; set; }

        public string CurrentLangID {
            get => _currentLangID;
            set  {
                _currentLangID = value;
                Properties.Settings.Default.LanguageID = _currentLangID;
                Properties.Settings.Default.Save();
                languageChangedEvent?.Invoke(_currentLangID);
            }
        }
        public string CurrentLangName
        {
            get => _currentLangName;
            set
            {
                _currentLangName = value;
                CurrentLangID = _rootObject.TextTestData.Where(l => l.LangName == value).Select(g => g.LangID).Single();
            }
        }

        private void InitLangIDs ()
        {
            _currentLangID = Properties.Settings.Default.LanguageID;
            _currentLangName = _rootObject.TextTestData.Where(l => l.LangID == CurrentLangID).Select(g => g.LangName).Single();
        }

        private General _general;
        private string _currentLangID;
        private string _currentLangName;
    }
}
